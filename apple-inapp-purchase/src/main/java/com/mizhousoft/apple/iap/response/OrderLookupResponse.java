package com.mizhousoft.apple.iap.response;

/**
 * 订单查询响应
 *
 */
public class OrderLookupResponse
{
	/**
	 * 状态
	 */
	private int status;

	/**
	 * 交易信息
	 */
	private String signedTransactions;

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
	 * 获取signedTransactions
	 * 
	 * @return
	 */
	public String getSignedTransactions()
	{
		return signedTransactions;
	}

	/**
	 * 设置signedTransactions
	 * 
	 * @param signedTransactions
	 */
	public void setSignedTransactions(String signedTransactions)
	{
		this.signedTransactions = signedTransactions;
	}
}
