package com.mizhousoft.apple.iap.result;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 校验凭证结果
 *
 * @version
 */
public class VerifyReceiptResult
{
	// 状态
	@JsonProperty("status")
	private int status;

	// 环境，Sandbox, Production
	@JsonProperty("environment")
	private String environment;

	@JsonProperty("is-retryable")
	private boolean retryable;

	@JsonProperty("receipt")
	private ReceiptBody receipt;

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
	 * 获取retryable
	 * 
	 * @return
	 */
	public boolean isRetryable()
	{
		return retryable;
	}

	/**
	 * 设置retryable
	 * 
	 * @param retryable
	 */
	public void setRetryable(boolean retryable)
	{
		this.retryable = retryable;
	}

	/**
	 * 获取receipt
	 * 
	 * @return
	 */
	public ReceiptBody getReceipt()
	{
		return receipt;
	}

	/**
	 * 设置receipt
	 * 
	 * @param receipt
	 */
	public void setReceipt(ReceiptBody receipt)
	{
		this.receipt = receipt;
	}

}
