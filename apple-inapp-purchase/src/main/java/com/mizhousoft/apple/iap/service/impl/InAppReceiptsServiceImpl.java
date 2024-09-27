package com.mizhousoft.apple.iap.service.impl;

import java.net.http.HttpConnectTimeoutException;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mizhousoft.apple.common.AppleConnectTimeoutException;
import com.mizhousoft.apple.common.AppleException;
import com.mizhousoft.apple.iap.constant.VerifyReceiptConstants;
import com.mizhousoft.apple.iap.profile.InAppProfile;
import com.mizhousoft.apple.iap.result.PurchaseReceipt;
import com.mizhousoft.apple.iap.result.ReceiptBody;
import com.mizhousoft.apple.iap.result.VerifyReceiptResult;
import com.mizhousoft.apple.iap.service.InAppReceiptsService;
import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.lang.LocalDateTimeUtils;

import kong.unirest.core.Unirest;
import kong.unirest.core.UnirestException;

/**
 * 苹果内购服务
 *
 * @version
 */
public class InAppReceiptsServiceImpl implements InAppReceiptsService
{
	private static final Logger LOG = LoggerFactory.getLogger(InAppReceiptsServiceImpl.class);

	private static final int MAX_TRY_NUMBER = 3;

	private InAppProfile inAppProfile;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public VerifyReceiptResult verifyReceipt(String receiptData) throws AppleException
	{
		return doVerifyReceipt(receiptData, PRODUCTION_VERIFY_ENDPOINT, 1);
	}

	private VerifyReceiptResult doVerifyReceipt(String receiptData, String endpoint, int tryNumber) throws AppleException
	{
		String body = "{\"receipt-data\":\"" + receiptData + "\"}";

		LOG.info("Start to verify apple receipt data.");

		try
		{
			String response = Unirest.post(endpoint).body(body).asString().getBody();
			if (null == response)
			{
				LOG.warn("Response result is null, receipt data is {}, endpoint is {}.", receiptData, endpoint);
				throw new AppleException("Response result is null, receipt data is " + receiptData + ", endpoint is " + endpoint);
			}

			LOG.debug("Apple verify receipt response data is {}.", response);

			VerifyReceiptResult result = JSONUtils.parse(response, VerifyReceiptResult.class);
			if (result.getStatus() == VerifyReceiptConstants.VERIFY_SUCCESS)
			{
				LOG.info("Verify apple receipt data successfully.");
				return result;
			}
			else if (result.getStatus() == VerifyReceiptConstants.VERIFY_FAIL_TRY_AGAIN)
			{
				if (tryNumber < MAX_TRY_NUMBER && result.isRetryable())
				{
					LOG.info("Start to verify apple receipt data again, try number is {}.", tryNumber);
					return doVerifyReceipt(receiptData, endpoint, tryNumber + 1);
				}
				else
				{
					throw new AppleException("Verify receipt failed, result is " + response);
				}
			}
			else if (result.getStatus() == VerifyReceiptConstants.VERIFY_FAIL_TRY_TEST_ENV)
			{
				LOG.warn("Product environment verify failed, switch to test environment to verify receipt.");

				return doVerifyReceipt(receiptData, SANDBOX_VERIFY_ENDPOINT, 1);
			}
			else
			{
				throw new AppleException("Verify receipt failed, result is " + response);
			}
		}
		catch (UnirestException e)
		{
			if (e.getCause() instanceof HttpConnectTimeoutException)
			{
				throw new AppleConnectTimeoutException(e.getMessage(), e);
			}

			throw new AppleException(e.getMessage(), e);
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
	public PurchaseReceipt getPurchaseReceipt(VerifyReceiptResult result, String goodsId, LocalDateTime orderTime)
	{
		ReceiptBody receiptBody = result.getReceipt();
		if (null == receiptBody)
		{
			LOG.error("ReceiptBody is null.");
			return null;
		}

		if (!StringUtils.equals(inAppProfile.getBundleId(), receiptBody.getBundleId()))
		{
			LOG.error("Receipt bundle id is invalid, value is {}.", receiptBody.getBundleId());
			return null;
		}

		List<PurchaseReceipt> receipts = receiptBody.getPurchaseReceipts();
		if (null == receipts)
		{
			LOG.error("PurchaseReceipt list is null.");
			return null;
		}

		long orderTimeTs = LocalDateTimeUtils.toTimestamp(orderTime);

		for (PurchaseReceipt receipt : receipts)
		{
			if (!goodsId.equals(receipt.getProductId()))
			{
				continue;
			}

			long purchaseDate = Long.valueOf(receipt.getPurchaseDateMs()).longValue();
			if (purchaseDate >= orderTimeTs)
			{
				return receipt;
			}
		}

		return null;
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
