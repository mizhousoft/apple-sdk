package com.mizhousoft.apple.iap.service.impl;

import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.List;

import com.mizhousoft.apple.common.AppleException;
import com.mizhousoft.apple.iap.response.JWSDecodedHeader;
import com.mizhousoft.apple.iap.response.NotificationDecodedPayload;
import com.mizhousoft.apple.iap.response.ServerNotificationResponse;
import com.mizhousoft.apple.iap.response.TransactionDecodedPayload;
import com.mizhousoft.apple.iap.service.InAppNotificationService;
import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.lang.CharEncoding;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

/**
 * 内购通知服务
 *
 */
public class InAppNotificationServiceImpl implements InAppNotificationService
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	public NotificationDecodedPayload parseNotification(String input) throws AppleException
	{
		try
		{
			ServerNotificationResponse response = JSONUtils.parse(input, ServerNotificationResponse.class);

			String[] signedPayloadValues = response.getSignedPayload().split("\\.");
			String header = new String(Base64.getDecoder().decode(signedPayloadValues[0]), CharEncoding.UTF8);
			String payload = new String(Base64.getDecoder().decode(signedPayloadValues[1]), CharEncoding.UTF8);

			JWSDecodedHeader jwsHeader = JSONUtils.parse(header, JWSDecodedHeader.class);
			verifyJWT(jwsHeader.getX5c(), response.getSignedPayload());

			NotificationDecodedPayload decodedPayload = JSONUtils.parse(payload, NotificationDecodedPayload.class);

			String signedTransactionInfo = decodedPayload.getData().getSignedTransactionInfo();
			if (null != signedTransactionInfo)
			{
				String[] transactionInfoValues = signedTransactionInfo.split("\\.");
				verifyJWT(jwsHeader.getX5c(), signedTransactionInfo);

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

	public Jws<Claims> verifyJWT(List<String> x5c, String jws) throws AppleException
	{
		try
		{
			X509Certificate cert = getX509Certificate(x5c.get(0));
			if (!cert.getSubjectX500Principal().getName().contains("Apple Inc"))
			{
				throw new AppleException("SubjectX500Principal is invalid, value is " + cert.getSubjectX500Principal().getName());
			}

			return Jwts.parserBuilder().setSigningKey(cert.getPublicKey()).build().parseClaimsJws(jws);
		}
		catch (JwtException e)
		{
			throw new AppleException("Sign verify failed.", e);
		}
		catch (CertificateException e)
		{
			throw new AppleException("Sign verify failed.", e);
		}
	}

	public X509Certificate getX509Certificate(String x5c) throws CertificateException
	{
		String stripped = x5c.replaceAll("-----BEGIN (.*)-----", "");
		stripped = stripped.replaceAll("-----END (.*)----", "");
		stripped = stripped.replaceAll("\r\n", "");
		stripped = stripped.replaceAll("\n", "");
		stripped = stripped.trim();

		byte[] keyBytes = Base64.getDecoder().decode(stripped);
		CertificateFactory fact = CertificateFactory.getInstance("X.509");

		return (X509Certificate) fact.generateCertificate(new ByteArrayInputStream(keyBytes));
	}
}
