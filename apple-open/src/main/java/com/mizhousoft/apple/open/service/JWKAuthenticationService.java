package com.mizhousoft.apple.open.service;

import com.mizhousoft.apple.common.AppleException;
import com.mizhousoft.apple.open.result.AppleVerifyResult;

/**
 * 苹果认证服务
 *
 * @version
 */
public interface JWKAuthenticationService
{
	// 获取公钥
	String FETCH_PUBLIC_KEY_URL = "https://appleid.apple.com/auth/keys";

	// 发行人
	String ISSUER = "https://appleid.apple.com";

	/**
	 * 验证用户
	 * 
	 * @param audience
	 * @param subject
	 * @param identityToken
	 * @throws AppleException
	 */
	AppleVerifyResult verify(String audience, String subject, String identityToken) throws AppleException;
}
