package com.mizhousoft.apple.boot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mizhousoft.apple.common.AppleException;
import com.mizhousoft.apple.iap.service.InAppPurchaseService;

/**
 * InAppPurchaseService Test
 *
 * @version
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class InAppPurchaseServiceTest
{
	@Autowired
	private InAppPurchaseService inAppPurchaseService;

	@Test
	public void testNotification()
	{
		try
		{
			String token = inAppPurchaseService.testNotification();

			Assertions.assertNotNull(token);
		}
		catch (AppleException e)
		{
			Assertions.fail(e);
		}
	}
}
