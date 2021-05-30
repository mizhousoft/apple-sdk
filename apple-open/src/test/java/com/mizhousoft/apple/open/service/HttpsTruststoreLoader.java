package com.mizhousoft.apple.open.service;


import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

import com.mizhousoft.commons.restclient.TruststoreLoader;

/**
 * Https信任证书加载器
 *
 * @version
 */
public class HttpsTruststoreLoader implements TruststoreLoader
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	public KeyStore loadTrustStore() throws GeneralSecurityException
	{
		KeyStore keyStore = KeyStore.getInstance("JKS");

		try
		{
			InputStream instream = HttpsTruststoreLoader.class.getClassLoader()
			        .getResourceAsStream("trust-keystore.jks");

			try
			{
				// 添加证书
				keyStore.load(instream, "changeit".toCharArray());
			}
			finally
			{
				instream.close();
			}
		}
		catch (IOException e)
		{
			throw new GeneralSecurityException("Load https trust store failed.");
		}

		return keyStore;
	}
}
