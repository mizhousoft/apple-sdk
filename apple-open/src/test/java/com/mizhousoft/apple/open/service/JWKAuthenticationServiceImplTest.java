package com.mizhousoft.apple.open.service;

import com.mizhousoft.apple.open.result.AppleVerifyResult;
import com.mizhousoft.apple.open.service.impl.JWKAuthenticationServiceImpl;

/**
 * JWKAuthenticationServiceImpl Test
 *
 * @version
 */
public class JWKAuthenticationServiceImplTest
{
	public static void main(String[] args) throws Exception
	{
		JWKAuthenticationServiceImpl jwkAuthenticationService = new JWKAuthenticationServiceImpl();

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
