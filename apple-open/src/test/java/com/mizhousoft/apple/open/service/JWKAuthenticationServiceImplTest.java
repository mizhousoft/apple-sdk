package com.mizhousoft.apple.open.service;

import com.mizhousoft.apple.open.result.AppleVerifyResult;
import com.mizhousoft.apple.open.service.impl.JWKAuthenticationServiceImpl;
import com.mizhousoft.commons.restclient.TruststoreLoader;
import com.mizhousoft.commons.restclient.service.impl.HttpsRestClientServiceImpl;

/**
 * JWKAuthenticationServiceImpl Test
 *
 * @version
 */
public class JWKAuthenticationServiceImplTest
{
	public static void main(String[] args) throws Exception
	{
		HttpsTruststoreLoader truststoreLoader = new HttpsTruststoreLoader();
		truststoreLoader.loadTrustStore();

		TruststoreLoader[] truststoreLoaders = { truststoreLoader };

		HttpsRestClientServiceImpl restClientService = new HttpsRestClientServiceImpl();
		restClientService.setTruststoreLoaders(truststoreLoaders);
		restClientService.init();

		JWKAuthenticationServiceImpl jwkAuthenticationService = new JWKAuthenticationServiceImpl();
		jwkAuthenticationService.setRestClientService(restClientService);

		String audience = "";

		String identityToken = "";
		String subject = "";
		AppleVerifyResult result = jwkAuthenticationService.verify(audience, subject, identityToken);
		System.out.println(result.toString());

		identityToken = "";
		subject = "";
		result = jwkAuthenticationService.verify(audience, subject, identityToken);
		System.out.println(result.toString());
	}
}
