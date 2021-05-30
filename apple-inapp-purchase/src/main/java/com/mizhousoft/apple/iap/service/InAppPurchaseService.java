package com.mizhousoft.apple.iap.service;

import com.mizhousoft.apple.common.AppleException;
import com.mizhousoft.apple.iap.result.VerifyReceiptResult;

/**
 * 苹果内购服务
 *
 * @version
 */
public interface InAppPurchaseService
{
	// 生产环境
	String PRODUCTION_VERIFY_ENDPOINT = "https://buy.itunes.apple.com/verifyReceipt";

	// 沙箱环境
	String SANDBOX_VERIFY_ENDPOINT = "https://sandbox.itunes.apple.com/verifyReceipt";

	/**
	 * 校验凭证
	 * 
	 * @param receiptData
	 * @throws AppleException
	 */
	VerifyReceiptResult verifyReceipt(String receiptData) throws AppleException;
}
