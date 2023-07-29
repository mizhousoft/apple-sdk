package com.mizhousoft.apple.iap.response;

/**
 * NotificationHistoryResponseItem
 *
 */
public class NotificationHistoryResponseItem
{
	/**
	 * signedPayload
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
