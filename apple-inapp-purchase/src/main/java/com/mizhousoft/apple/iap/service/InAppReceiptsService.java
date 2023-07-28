package com.mizhousoft.apple.iap.service;

import java.time.LocalDateTime;

import com.mizhousoft.apple.common.AppleException;
import com.mizhousoft.apple.iap.result.PurchaseReceipt;
import com.mizhousoft.apple.iap.result.VerifyReceiptResult;

/**
 * 苹果内购服务
 *
 * @version
 */
public interface InAppReceiptsService
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

	/**
	 * 获取凭证
	 * 
	 * @param result
	 * @param goodsId
	 * @param orderTime
	 * @return
	 */
	PurchaseReceipt getPurchaseReceipt(VerifyReceiptResult result, String goodsId, LocalDateTime orderTime);
}
