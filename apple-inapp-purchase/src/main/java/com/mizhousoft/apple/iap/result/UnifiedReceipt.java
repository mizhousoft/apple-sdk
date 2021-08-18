package com.mizhousoft.apple.iap.result;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 统一凭证
 *
 * @version
 */
public class UnifiedReceipt
{
	// 环境， 值可能是Sandbox, Production
	@JsonProperty("environment")
	private String environment;

	// The latest Base64-encoded app receipt.
	@JsonProperty("latest_receipt")
	private String latestReceipt;

	// An array that contains the latest 100 in-app purchase transactions of the decoded value in
	// latest_receipt
	@JsonProperty("latest_receipt_info")
	private List<LatestReceiptInfo> latestReceiptInfos;

	// 状态，0表示有效
	@JsonProperty("status")
	private int status;

	/**
	 * 获取environment
	 * 
	 * @return
	 */
	public String getEnvironment()
	{
		return environment;
	}

	/**
	 * 设置environment
	 * 
	 * @param environment
	 */
	public void setEnvironment(String environment)
	{
		this.environment = environment;
	}

	/**
	 * 获取latestReceipt
	 * 
	 * @return
	 */
	public String getLatestReceipt()
	{
		return latestReceipt;
	}

	/**
	 * 设置latestReceipt
	 * 
	 * @param latestReceipt
	 */
	public void setLatestReceipt(String latestReceipt)
	{
		this.latestReceipt = latestReceipt;
	}

	/**
	 * 获取latestReceiptInfos
	 * 
	 * @return
	 */
	public List<LatestReceiptInfo> getLatestReceiptInfos()
	{
		return latestReceiptInfos;
	}

	/**
	 * 设置latestReceiptInfos
	 * 
	 * @param latestReceiptInfos
	 */
	public void setLatestReceiptInfos(List<LatestReceiptInfo> latestReceiptInfos)
	{
		this.latestReceiptInfos = latestReceiptInfos;
	}

	/**
	 * 获取status
	 * 
	 * @return
	 */
	public int getStatus()
	{
		return status;
	}

	/**
	 * 设置status
	 * 
	 * @param status
	 */
	public void setStatus(int status)
	{
		this.status = status;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("{\"");
		if (environment != null)
		{
			builder.append("environment\":\"");
			builder.append(environment);
			builder.append("\", \"");
		}
		if (latestReceipt != null)
		{
			builder.append("latestReceipt\":\"");
			builder.append(latestReceipt);
			builder.append("\", \"");
		}
		if (latestReceiptInfos != null)
		{
			builder.append("latestReceiptInfos\":\"");
			builder.append(latestReceiptInfos);
			builder.append("\", \"");
		}
		builder.append("status\":\"");
		builder.append(status);
		builder.append("\"}");
		return builder.toString();
	}
}
