package com.mizhousoft.apple.iap.service.impl;

import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.mizhousoft.apple.common.AppleException;
import com.mizhousoft.apple.iap.profile.InAppProfile;
import com.mizhousoft.apple.iap.response.SendTestNotificationResponse;
import com.mizhousoft.apple.iap.service.InAppPurchaseService;
import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.restclient.RestException;
import com.mizhousoft.commons.restclient.RestResponse;
import com.mizhousoft.commons.restclient.service.RestClientService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.InvalidKeyException;

/**
 * 苹果内购服务
 *
 * @version
 */
public class InAppPurchaseServiceImpl implements InAppPurchaseService
{
	// REST服务
	private RestClientService restClientService;

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

			RestResponse restResponse = executeRequest(requestUrl, null, null, 1);

			SendTestNotificationResponse response = JSONUtils.parse(restResponse.getBody(), SendTestNotificationResponse.class);

			return response.getTestNotificationToken();
		}
		catch (JSONException e)
		{
			throw new AppleException(e.getErrorCode(), e.getCodeParams(), e.getMessage(), e);
		}
	}

	private RestResponse executeRequest(String requestUrl, String requestBody, Map<String, String> headerMap, int retry)
	        throws AppleException
	{
		String token = getAppleJwtToken(inAppProfile);

		Map<String, String> requestHeaderMap = new HashMap<>(2);
		requestHeaderMap.put("Authorization", "Bearer" + " " + token);
		if (null != headerMap)
		{
			requestHeaderMap.putAll(headerMap);
		}

		RestResponse restResp = null;

		try
		{
			restResp = restClientService.postJSON(requestUrl, requestBody, headerMap);
		}
		catch (RestException e)
		{
			if (HttpStatus.UNAUTHORIZED.value() == e.getStatusCode())
			{
				this.token = null;

				if (retry <= 0)
				{
					throw new AppleException("Request failed.",
					        "Response status code is " + restResp.getStatusCode() + ", body is " + restResp.getBody());
				}

				return executeRequest(requestUrl, requestBody, requestHeaderMap, retry - 1);
			}

			throw new AppleException("Request failed.", e);
		}

		if (HttpStatus.OK.value() == restResp.getStatusCode())
		{
			return restResp;
		}
		else
		{
			throw new AppleException("Request failed.",
			        "Response status code is " + restResp.getStatusCode() + ", body is " + restResp.getBody());
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

			this.token = Jwts.builder().setHeader(header).setClaims(claims).signWith(privateKey, SignatureAlgorithm.ES256).compact();

			return token;
		}
		catch (InvalidKeyException e)
		{
			throw new AppleException("PrivateKey is invalid.", e);
		}
	}

	/**
	 * 设置restClientService
	 * 
	 * @param restClientService
	 */
	public void setRestClientService(RestClientService restClientService)
	{
		this.restClientService = restClientService;
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
