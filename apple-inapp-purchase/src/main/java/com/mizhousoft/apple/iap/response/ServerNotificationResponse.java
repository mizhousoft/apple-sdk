package com.mizhousoft.apple.iap.response;

/**
 * 通知
 *
 */
public class ServerNotificationResponse
{
	/**
	 * 签名内容
	 */
	private String signedPayload;

	/**
	 * 获取signedPayload
	 * 
	 * @return
	 */
	public String getSignedPayload()
	{
		return signedPayload;
	}

	/**
	 * 设置signedPayload
	 * 
	 * @param signedPayload
	 */
	public void setSignedPayload(String signedPayload)
	{
		this.signedPayload = signedPayload;
	}
}
