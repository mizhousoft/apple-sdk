package com.mizhousoft.apple.boot.configuration;

import java.io.IOException;
import java.security.PrivateKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mizhousoft.apple.boot.properties.AppleProperties;
import com.mizhousoft.apple.common.AppleException;
import com.mizhousoft.apple.iap.profile.InAppProfile;
import com.mizhousoft.apple.iap.service.InAppPurchaseService;
import com.mizhousoft.apple.iap.service.InAppReceiptsService;
import com.mizhousoft.apple.iap.service.impl.InAppPurchaseServiceImpl;
import com.mizhousoft.apple.iap.service.impl.InAppReceiptsServiceImpl;
import com.mizhousoft.apple.iap.util.P8Loader;
import com.mizhousoft.apple.open.service.JWKAuthenticationService;
import com.mizhousoft.apple.open.service.impl.JWKAuthenticationServiceImpl;
import com.mizhousoft.commons.restclient.service.RestClientService;

/**
 * AppleConfiguration
 *
 * @version
 */
@Configuration
public class AppleConfiguration
{
	@Autowired
	private AppleProperties appleProperties;

	@Autowired
	private RestClientService restClientService;

	private InAppProfile profile;

	@Bean
	public InAppPurchaseService getInAppPurchaseService() throws AppleException, IOException
	{
		InAppProfile profile = getProfile();

		InAppPurchaseServiceImpl inAppPurchaseService = new InAppPurchaseServiceImpl();
		inAppPurchaseService.setInAppProfile(profile);
		inAppPurchaseService.setRestClientService(restClientService);

		return inAppPurchaseService;
	}

	@Bean
	public InAppReceiptsService getInAppReceiptsService() throws AppleException, IOException
	{
		InAppProfile profile = getProfile();

		InAppReceiptsServiceImpl inAppReceiptsService = new InAppReceiptsServiceImpl();
		inAppReceiptsService.setRestClientService(restClientService);
		inAppReceiptsService.setInAppProfile(profile);

		return inAppReceiptsService;
	}

	@Bean
	public JWKAuthenticationService getJWKAuthenticationService()
	{
		JWKAuthenticationServiceImpl authcService = new JWKAuthenticationServiceImpl();
		authcService.setRestClientService(restClientService);

		return authcService;
	}

	public synchronized InAppProfile getProfile() throws IOException, AppleException
	{
		if (null == this.profile)
		{
			InAppProfile profile = new InAppProfile();
			profile.setBundleId(appleProperties.getBundleId());
			profile.setEndpoint(appleProperties.getEndpoint());
			profile.setIssuerId(appleProperties.getIssuerId());
			profile.setSecretId(appleProperties.getSecretId());

			PrivateKey privateKey = P8Loader.loadPrivateKey(appleProperties.getPrivateKey());
			profile.setPrivateKey(privateKey);

			this.profile = profile;
		}

		return profile;
	}
}
