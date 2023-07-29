package com.mizhousoft.apple.iap.service;

import com.mizhousoft.apple.common.AppleException;
import com.mizhousoft.apple.iap.response.TransactionDecodedPayload;

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

	/**
	 * 获取订单历史
	 * 
	 * @param transactionId
	 * @throws AppleException
	 */
	TransactionDecodedPayload getTransactionHistory(String transactionId) throws AppleException;
}
