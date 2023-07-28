package com.mizhousoft.apple.iap.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import com.mizhousoft.apple.common.AppleException;
import com.mizhousoft.commons.lang.CharEncoding;

/**
 * P8Loader
 *
 */
public abstract class P8Loader
{
	public static PrivateKey loadPrivateKeyFile(String filePath) throws AppleException
	{
		return loadPrivateKey(filePath, "EC");
	}

	public static PrivateKey loadPrivateKeyFile(String filePath, String algorithm) throws AppleException
	{
		try
		{
			String content = new String(Files.readAllBytes(Paths.get(filePath)), CharEncoding.UTF8);

			String privateKey = content.replace("-----BEGIN PRIVATE KEY-----", "").replace("-----END PRIVATE KEY-----", "")
			        .replaceAll("\\s+", "");

			return loadPrivateKey(privateKey, algorithm);
		}
		catch (IOException e)
		{
			throw new AppleException("File read failed.", e);
		}
	}

	public static PrivateKey loadPrivateKey(String privateKey) throws AppleException
	{
		return loadPrivateKey(privateKey, "EC");
	}

	public static PrivateKey loadPrivateKey(String privateKey, String algorithm) throws AppleException
	{
		try
		{
			KeyFactory kf = KeyFactory.getInstance(algorithm);

			return kf.generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey)));
		}
		catch (NoSuchAlgorithmException e)
		{
			throw new AppleException("Java did not support the algorithm:" + algorithm, e);
		}
		catch (InvalidKeySpecException e)
		{
			throw new AppleException("Invalid key format.");
		}
	}
}
