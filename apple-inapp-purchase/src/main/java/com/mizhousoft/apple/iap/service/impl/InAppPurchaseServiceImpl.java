package com.mizhousoft.apple.iap.service.impl;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mizhousoft.apple.common.AppleException;
import com.mizhousoft.apple.iap.constant.OrderLookupStatus;
import com.mizhousoft.apple.iap.profile.InAppProfile;
import com.mizhousoft.apple.iap.request.NotificationHistoryRequest;
import com.mizhousoft.apple.iap.response.HistoryResponse;
import com.mizhousoft.apple.iap.response.JWSDecodedHeader;
import com.mizhousoft.apple.iap.response.NotificationDecodedPayload;
import com.mizhousoft.apple.iap.response.NotificationHistory;
import com.mizhousoft.apple.iap.response.NotificationHistoryResponse;
import com.mizhousoft.apple.iap.response.NotificationHistoryResponseItem;
import com.mizhousoft.apple.iap.response.OrderLookupResponse;
import com.mizhousoft.apple.iap.response.SendTestNotificationResponse;
import com.mizhousoft.apple.iap.response.ServerNotificationResponse;
import com.mizhousoft.apple.iap.response.TransactionDecodedPayload;
import com.mizhousoft.apple.iap.service.InAppPurchaseService;
import com.mizhousoft.apple.iap.util.JwsUtils;
import com.mizhousoft.apple.iap.util.NotificationDecodedUtils;
import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.lang.CharEncoding;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.SignatureAlgorithm;
import kong.unirest.core.HttpMethod;
import kong.unirest.core.HttpResponse;
import kong.unirest.core.HttpStatus;
import kong.unirest.core.Unirest;
import kong.unirest.core.UnirestException;

/**
 * 苹果内购服务
 *
 * @version
 */
public class InAppPurchaseServiceImpl implements InAppPurchaseService
{
	private InAppProfile inAppProfile;

	private volatile String token;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String testNotification() throws AppleException
	{
		try
		{
			String requestUrl = inAppProfile.getEndpoint() + "/inApps/v1/notifications/test";

			HttpResponse<String> httpResponse = executeRequest(requestUrl, null, null, HttpMethod.POST, 1);

			SendTestNotificationResponse response = JSONUtils.parse(httpResponse.getBody(), SendTestNotificationResponse.class);

			return response.getTestNotificationToken();
		}
		catch (JSONException e)
		{
			throw new AppleException(e.getErrorCode(), e.getCodeParams(), e.getMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NotificationHistory getNotificationHistory(NotificationHistoryRequest request) throws AppleException
	{
		try
		{
			String requestUrl = inAppProfile.getEndpoint() + "/inApps/v1/notifications/history";

			String requestBody = JSONUtils.toJSONString(request);

			HttpResponse<String> httpResponse = executeRequest(requestUrl, requestBody, null, HttpMethod.POST, 1);

			NotificationHistoryResponse response = JSONUtils.parse(httpResponse.getBody(), NotificationHistoryResponse.class);

			List<NotificationDecodedPayload> payloads = new ArrayList<>(10);

			List<NotificationHistoryResponseItem> items = response.getItems();
			if (null != items)
			{
				for (NotificationHistoryResponseItem item : items)
				{
					String signedPayload = item.getSignedPayload();
					NotificationDecodedPayload payload = NotificationDecodedUtils.decode(signedPayload);
					payloads.add(payload);
				}
			}

			NotificationHistory history = new NotificationHistory();
			history.setHasMore(response.isHasMore());
			history.setPaginationToken(response.getPaginationToken());
			history.setPayloads(payloads);

			return history;
		}
		catch (JSONException e)
		{
			throw new AppleException(e.getErrorCode(), e.getCodeParams(), e.getMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NotificationHistory getNotificationHistory(String paginationToken, NotificationHistoryRequest request) throws AppleException
	{
		try
		{
			String requestUrl = inAppProfile.getEndpoint() + "/inApps/v1/notifications/history?paginationToken=" + paginationToken;

			String requestBody = JSONUtils.toJSONString(request);

			HttpResponse<String> httpResponse = executeRequest(requestUrl, requestBody, null, HttpMethod.POST, 1);

			NotificationHistoryResponse response = JSONUtils.parse(httpResponse.getBody(), NotificationHistoryResponse.class);

			List<NotificationDecodedPayload> payloads = new ArrayList<>(10);

			List<NotificationHistoryResponseItem> items = response.getItems();
			if (null != items)
			{
				for (NotificationHistoryResponseItem item : items)
				{
					String signedPayload = item.getSignedPayload();
					NotificationDecodedPayload payload = NotificationDecodedUtils.decode(signedPayload);
					payloads.add(payload);
				}
			}

			NotificationHistory history = new NotificationHistory();
			history.setHasMore(response.isHasMore());
			history.setPaginationToken(response.getPaginationToken());
			history.setPayloads(payloads);

			return history;
		}
		catch (JSONException e)
		{
			throw new AppleException(e.getErrorCode(), e.getCodeParams(), e.getMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NotificationDecodedPayload parseNotification(String input) throws AppleException
	{
		try
		{
			ServerNotificationResponse response = JSONUtils.parse(input, ServerNotificationResponse.class);

			return NotificationDecodedUtils.decode(response.getSignedPayload());
		}
		catch (JSONException e)
		{
			throw new AppleException("String to object failed.", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String lookupOrder(String orderId) throws AppleException
	{
		try
		{
			String requestUrl = inAppProfile.getEndpoint() + "/inApps/v1/lookup/" + orderId;

			HttpResponse<String> httpResponse = executeRequest(requestUrl, null, null, HttpMethod.GET, 1);

			OrderLookupResponse response = JSONUtils.parse(httpResponse.getBody(), OrderLookupResponse.class);

			if (OrderLookupStatus.ORDER_ID_VALID == response.getStatus())
			{
				String signedTransactions = response.getSignedTransactions();

				return signedTransactions;
			}

			return null;
		}
		catch (JSONException e)
		{
			throw new AppleException(e.getErrorCode(), e.getCodeParams(), e.getMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TransactionDecodedPayload getTransactionHistory(String transactionId) throws AppleException
	{
		try
		{
			String requestUrl = inAppProfile.getEndpoint() + "/inApps/v1/history/" + transactionId;

			HttpResponse<String> httpResponse = executeRequest(requestUrl, null, null, HttpMethod.GET, 1);

			HistoryResponse response = JSONUtils.parse(httpResponse.getBody(), HistoryResponse.class);
			List<String> list = response.getSignedTransactions();
			if (list.isEmpty())
			{
				return null;
			}

			String signedTransaction = list.get(0);

			String[] signedPayloadValues = signedTransaction.split("\\.");
			String header = new String(Base64.getDecoder().decode(signedPayloadValues[0]), CharEncoding.UTF8);
			String payload = new String(Base64.getDecoder().decode(signedPayloadValues[1]), CharEncoding.UTF8);

			JWSDecodedHeader jwsHeader = JSONUtils.parse(header, JWSDecodedHeader.class);
			JwsUtils.verifyJWT(jwsHeader.getX5c(), signedTransaction);

			TransactionDecodedPayload decodedPayload = JSONUtils.parse(payload, TransactionDecodedPayload.class);

			return decodedPayload;
		}
		catch (JSONException e)
		{
			throw new AppleException(e.getErrorCode(), e.getCodeParams(), e.getMessage(), e);
		}
	}

	private HttpResponse<String> executeRequest(String requestUrl, String requestBody, Map<String, String> headerMap, HttpMethod httpMethod,
	        int retry) throws AppleException
	{
		String token = getAppleJwtToken(inAppProfile);

		Map<String, String> requestHeaderMap = new HashMap<>(2);
		requestHeaderMap.put("Authorization", "Bearer" + " " + token);
		if (null != headerMap)
		{
			requestHeaderMap.putAll(headerMap);
		}

		HttpResponse<String> httpResp = null;

		try
		{
			if (HttpMethod.POST.equals(httpMethod))
			{
				headerMap = null != headerMap ? headerMap : new HashMap<>(01);
				headerMap.put("Content-Type", "application/json; charset=UTF-8");

				if (null == requestBody)
				{
					httpResp = Unirest.post(requestUrl).headers(headerMap).asString();
				}
				else
				{
					httpResp = Unirest.post(requestUrl).body(requestBody).headers(headerMap).asString();
				}
			}
			else
			{
				httpResp = Unirest.get(requestUrl).headers(headerMap).asString();
			}
		}
		catch (UnirestException e)
		{
			throw new AppleException("Request failed.", e);
		}

		if (HttpStatus.UNAUTHORIZED == httpResp.getStatus())
		{
			this.token = null;

			if (retry <= 0)
			{
				throw new AppleException("Request failed.",
				        "Response status code is " + httpResp.getStatus() + ", body is " + httpResp.getBody());
			}

			return executeRequest(requestUrl, requestBody, requestHeaderMap, httpMethod, retry - 1);
		}

		if (HttpStatus.OK == httpResp.getStatus())
		{
			return httpResp;
		}
		else
		{
			throw new AppleException("Request failed.",
			        "Response status code is " + httpResp.getStatus() + ", body is " + httpResp.getBody());
		}
	}

	private synchronized String getAppleJwtToken(InAppProfile profile) throws AppleException
	{
		try
		{
			if (null != token)
			{
				return token;
			}

			Map<String, Object> header = new HashMap<>(3);
			header.put("alg", "ES256");
			header.put("kid", profile.getSecretId());
			header.put("typ", "JWT");

			Map<String, Object> claims = new HashMap<>(5);
			claims.put("iss", profile.getIssuerId());
			claims.put("iat", System.currentTimeMillis() / 1000);
			long exp = System.currentTimeMillis() + 60 * 60 * 1000;
			claims.put("exp", exp / 1000);
			claims.put("aud", "appstoreconnect-v1");
			claims.put("bid", profile.getBundleId());

			PrivateKey privateKey = profile.getPrivateKey();

			SignatureAlgorithm alg = Jwts.SIG.ES256;

			this.token = Jwts.builder().header().empty().add(header).and().claims().empty().add(claims).and().signWith(privateKey, alg)
			        .compact();

			return token;
		}
		catch (InvalidKeyException e)
		{
			throw new AppleException("PrivateKey is invalid.", e);
		}
	}

	/**
	 * 设置inAppProfile
	 * 
	 * @param inAppProfile
	 */
	public void setInAppProfile(InAppProfile inAppProfile)
	{
		this.inAppProfile = inAppProfile;
	}

}
