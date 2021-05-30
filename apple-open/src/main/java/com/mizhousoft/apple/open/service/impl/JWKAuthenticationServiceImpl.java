package com.mizhousoft.apple.open.service.impl;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mizhousoft.apple.common.AppleException;
import com.mizhousoft.apple.open.model.AppleJWKKey;
import com.mizhousoft.apple.open.model.AppleJWTPlayload;
import com.mizhousoft.apple.open.model.ApplePublicKeys;
import com.mizhousoft.apple.open.result.AppleVerifyResult;
import com.mizhousoft.apple.open.service.JWKAuthenticationService;
import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.lang.CharEncoding;
import com.mizhousoft.commons.restclient.RestException;
import com.mizhousoft.commons.restclient.service.RestClientService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

/**
 * 苹果认证服务
 *
 * @version
 */
public class JWKAuthenticationServiceImpl implements JWKAuthenticationService
{
	private static final Logger LOG = LoggerFactory.getLogger(JWKAuthenticationServiceImpl.class);

	// REST服务
	private RestClientService restClientService;

	private ApplePublicKeys applePublicKeys;

	/**
	 * {@inheritDoc}
	 * 
	 * @throws AppleException
	 */
	@Override
	public AppleVerifyResult verify(String audience, String subject, String identityToken) throws AppleException
	{
		ApplePublicKeys applePubKeys = getApplePublicKeys();
		List<AppleJWKKey> keys = applePubKeys.getKeys();

		AppleException exception = null;

		String jwt = new String(Base64.decodeBase64(identityToken), CharEncoding.UTF8);
		AppleJWTPlayload playload = parseJWTPlayload(jwt);

		for (AppleJWKKey key : keys)
		{
			String n = key.getN();
			String e = key.getE();
			PublicKey pk = getPublicKey(n, e);

			try
			{
				Claims claims = verify(pk, jwt, audience, subject);

				AppleVerifyResult result = new AppleVerifyResult();
				result.setSubject(claims.getSubject());
				result.setEmail(playload.getEmail());

				return result;
			}
			catch (AppleException ex)
			{
				exception = ex;
			}
		}

		if (null == exception)
		{
			exception = new AppleException("Subject verify failed.");
		}

		// 防止公钥失效
		this.applePublicKeys = null;

		throw exception;
	}

	private synchronized ApplePublicKeys getApplePublicKeys() throws AppleException
	{
		if (null != applePublicKeys)
		{
			return applePublicKeys;
		}

		ApplePublicKeys applePubKeys = null;
		AppleException exception = null;

		for (int i = 0; i < 3; i++)
		{
			LOG.info("Start to fetch apple public key.");

			try
			{
				applePubKeys = restClientService.getForObject(FETCH_PUBLIC_KEY_URL, ApplePublicKeys.class);
				if (null != applePubKeys && !CollectionUtils.isEmpty(applePubKeys.getKeys()))
				{
					LOG.info("Fetch apple public key successfully.");

					break;
				}
			}
			catch (RestException e)
			{
				exception = new AppleException("Fetch public key failed.", e);
			}
		}

		if (null == applePubKeys)
		{
			if (null == exception)
			{
				exception = new AppleException("AppleJWKKey is null.");
			}

			throw exception;
		}

		applePublicKeys = applePubKeys;

		return applePubKeys;
	}

	private PublicKey getPublicKey(String n, String e) throws AppleException
	{
		try
		{
			BigInteger bigIntModulus = new BigInteger(1, Base64.decodeBase64(n));
			BigInteger bigIntPrivateExponent = new BigInteger(1, Base64.decodeBase64(e));
			RSAPublicKeySpec keySpec = new RSAPublicKeySpec(bigIntModulus, bigIntPrivateExponent);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PublicKey publicKey = keyFactory.generatePublic(keySpec);
			return publicKey;
		}
		catch (NoSuchAlgorithmException ex)
		{
			throw new AppleException("no such algorithm.", ex);
		}
		catch (InvalidKeySpecException ex)
		{
			throw new AppleException("invalid key.", ex);
		}
	}

	private Claims verify(PublicKey key, String jwt, String audience, String subject) throws AppleException
	{
		try
		{
			JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(key).requireAudience(audience).requireSubject(subject)
			        .requireIssuer(ISSUER).build();

			Jws<Claims> claim = jwtParser.parseClaimsJws(jwt);
			if (claim != null && claim.getBody().containsKey("auth_time"))
			{
				return claim.getBody();
			}

			throw new AppleException("Jwt verify failed.");
		}
		catch (ExpiredJwtException e)
		{
			throw new AppleException("Jwt expired.", e);
		}
		catch (Exception e)
		{
			throw new AppleException("Jwt verify failed.", e);
		}
	}

	private AppleJWTPlayload parseJWTPlayload(String jwt) throws AppleException
	{
		try
		{
			int index1 = jwt.indexOf(".");
			int index2 = jwt.indexOf(".", index1 + 1);
			if (index1 < 0 || index2 < 0)
			{
				throw new AppleException("jwt data is invalid, data:" + jwt);
			}

			String str = jwt.substring(index1 + 1, index2);
			String body = new String(Base64.decodeBase64(str), CharEncoding.UTF8);

			AppleJWTPlayload playload = JSONUtils.parse(body, AppleJWTPlayload.class);
			return playload;
		}
		catch (JSONException e)
		{
			throw new AppleException("jwt data is invalid, data:" + jwt, e);
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
