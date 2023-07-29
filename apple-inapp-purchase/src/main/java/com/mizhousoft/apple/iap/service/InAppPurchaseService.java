package com.mizhousoft.apple.iap.service;

import com.mizhousoft.apple.common.AppleException;

/**
 * 苹果内购服务
 *
 * @version
 */
public interface InAppPurchaseService
{
	/**
	 * 测试通知
	 * 
	 * @return
	 * @throws AppleException
	 */
	String testNotification() throws AppleException;

	/**
	 * 查询订单
	 * 
	 * @param orderId
	 * @throws AppleException
	 */
	String lookupOrder(String orderId) throws AppleException;
}
