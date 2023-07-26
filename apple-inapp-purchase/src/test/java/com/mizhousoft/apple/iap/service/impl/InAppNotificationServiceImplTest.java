package com.mizhousoft.apple.iap.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mizhousoft.apple.common.AppleException;
import com.mizhousoft.apple.iap.response.NotificationDecodedPayload;
import com.mizhousoft.apple.iap.service.InAppNotificationService;

/**
 * InAppNotificationServiceImpl Test
 *
 */
public class InAppNotificationServiceImplTest
{
	InAppNotificationService inAppNotificationService;

	@BeforeEach
	public void before()
	{
		this.inAppNotificationService = new InAppNotificationServiceImpl();
	}

	@Test
	public void parseNotification()
	{
		String body = null;

		try
		{
			NotificationDecodedPayload payload = inAppNotificationService.parseNotification(body);

			Assertions.assertNotNull(payload);
		}
		catch (AppleException e)
		{
			Assertions.fail(e);
		}
	}
}
