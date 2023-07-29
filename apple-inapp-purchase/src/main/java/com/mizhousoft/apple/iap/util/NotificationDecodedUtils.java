package com.mizhousoft.apple.iap.util;

import java.util.Base64;

import com.mizhousoft.apple.common.AppleException;
import com.mizhousoft.apple.iap.response.JWSDecodedHeader;
import com.mizhousoft.apple.iap.response.NotificationDecodedPayload;
import com.mizhousoft.apple.iap.response.TransactionDecodedPayload;
import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.lang.CharEncoding;

/**
 * 工具类
 *
 */
public abstract class NotificationDecodedUtils
{
	public static NotificationDecodedPayload decode(String signedPayload) throws AppleException
	{
		try
		{
			String[] signedPayloadValues = signedPayload.split("\\.");
			String header = new String(Base64.getDecoder().decode(signedPayloadValues[0]), CharEncoding.UTF8);
			String payload = new String(Base64.getDecoder().decode(signedPayloadValues[1]), CharEncoding.UTF8);

			JWSDecodedHeader jwsHeader = JSONUtils.parse(header, JWSDecodedHeader.class);
			JwsUtils.verifyJWT(jwsHeader.getX5c(), signedPayload);

			NotificationDecodedPayload decodedPayload = JSONUtils.parse(payload, NotificationDecodedPayload.class);

			String signedTransactionInfo = decodedPayload.getData().getSignedTransactionInfo();
			if (null != signedTransactionInfo)
			{
				String[] transactionInfoValues = signedTransactionInfo.split("\\.");
				JwsUtils.verifyJWT(jwsHeader.getX5c(), signedTransactionInfo);

				payload = new String(Base64.getDecoder().decode(transactionInfoValues[1]), CharEncoding.UTF8);
				TransactionDecodedPayload transactionPayload = JSONUtils.parse(payload, TransactionDecodedPayload.class);

				decodedPayload.setTransactionPayload(transactionPayload);
			}

			return decodedPayload;
		}
		catch (JSONException e)
		{
			throw new AppleException("String to object failed.", e);
		}
	}
}
