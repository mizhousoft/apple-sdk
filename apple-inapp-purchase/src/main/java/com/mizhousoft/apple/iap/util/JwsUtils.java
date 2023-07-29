package com.mizhousoft.apple.iap.util;

import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.List;

import com.mizhousoft.apple.common.AppleException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

/**
 * JwsUtils
 *
 */
public abstract class JwsUtils
{
	public static Jws<Claims> verifyJWT(List<String> x5c, String jws) throws AppleException
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

	public static X509Certificate getX509Certificate(String x5c) throws CertificateException
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
