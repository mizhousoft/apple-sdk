package com.mizhousoft.apple.iap.service;

import com.mizhousoft.apple.common.AppleException;
import com.mizhousoft.apple.iap.response.NotificationDecodedPayload;

/**
 * 内购通知服务
 *
 */
public interface InAppNotificationService
{
	/**
	 * 解析通知
	 * 
	 * @param input
	 * @return
	 * @throws AppleException
	 */
	NotificationDecodedPayload parseNotification(String input) throws AppleException;
}
