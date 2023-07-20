package com.mizhousoft.apple.iap.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mizhousoft.apple.common.AppleException;
import com.mizhousoft.apple.iap.constant.VerifyReceiptConstants;
import com.mizhousoft.apple.iap.result.VerifyReceiptResult;
import com.mizhousoft.apple.iap.service.InAppPurchaseService;
import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.restclient.RestException;
import com.mizhousoft.commons.restclient.service.RestClientService;

/**
 * 苹果内购服务
 *
 * @version
 */
public class InAppPurchaseServiceImpl implements InAppPurchaseService
{
	private static final Logger LOG = LoggerFactory.getLogger(InAppPurchaseServiceImpl.class);

	private static final int MAX_TRY_NUMBER = 3;

	// REST服务
	private RestClientService restClientService;

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
		LOG.debug("Apple verify receipt request data is {}.", body);

		try
		{
			String response = restClientService.postForObject(endpoint, body, String.class);
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
		catch (RestException e)
		{
			throw new AppleException(e.getErrorCode(), e.getCodeParams(), e.getMessage(), e);
		}
		catch (JSONException e)
		{
			throw new AppleException(e.getErrorCode(), e.getCodeParams(), e.getMessage(), e);
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

}
