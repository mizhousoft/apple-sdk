package com.mizhousoft.apple.boot;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mizhousoft.apple.common.AppleException;
import com.mizhousoft.apple.iap.request.NotificationHistoryRequest;
import com.mizhousoft.apple.iap.response.NotificationDecodedPayload;
import com.mizhousoft.apple.iap.response.NotificationHistory;
import com.mizhousoft.apple.iap.response.TransactionDecodedPayload;
import com.mizhousoft.apple.iap.service.InAppPurchaseService;
import com.mizhousoft.commons.httpclient.unirest.UnirestLogInterceptor;
import com.mizhousoft.commons.lang.LocalDateTimeUtils;

import kong.unirest.core.Unirest;

/**
 * InAppPurchaseService Test
 *
 * @version
 */
@SpringBootTest(classes = DemoApplication.class)
public class InAppPurchaseServiceTest
{
	@Autowired
	private InAppPurchaseService inAppPurchaseService;

	@BeforeAll
	public static void init()
	{
		Unirest.config().interceptor(new UnirestLogInterceptor());
		Unirest.config().connectTimeout(60 * 1000);
	}

	@Test
	public void parseNotification()
	{
		String body = null;

		try
		{
			NotificationDecodedPayload payload = inAppPurchaseService.parseNotification(body);

			Assertions.assertNotNull(payload);
		}
		catch (AppleException e)
		{
			Assertions.fail(e);
		}
	}

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

	@Test
	public void lookupOrder()
	{
		try
		{
			String orderId = "4200001836202305142600959916";
			inAppPurchaseService.lookupOrder(orderId);
		}
		catch (AppleException e)
		{
			Assertions.fail(e);
		}
	}

	@Test
	public void getTransactionHistory()
	{
		try
		{
			String transactionId = "260001513300413";
			TransactionDecodedPayload payload = inAppPurchaseService.getTransactionHistory(transactionId);
			Assertions.assertNotNull(payload);
		}
		catch (AppleException e)
		{
			Assertions.fail(e);
		}
	}

	@Test
	public void getNotificationHistory()
	{
		try
		{
			NotificationHistoryRequest request = new NotificationHistoryRequest();
			request.setStartDate(LocalDateTimeUtils.toTimestamp(LocalDateTime.now().minusDays(180)));
			request.setEndDate(LocalDateTimeUtils.toTimestamp(LocalDateTime.now()));

			NotificationHistory history = inAppPurchaseService.getNotificationHistory(request);

			Assertions.assertNotNull(history.getPayloads());
		}
		catch (AppleException e)
		{
			Assertions.fail(e);
		}
	}
}
