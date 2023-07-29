package com.mizhousoft.apple.iap.response;

import java.util.List;

/**
 * HistoryResponse
 *
 */
public class HistoryResponse
{
	/**
	 * revision
	 */
	private String revision;

	/**
	 * bundleId
	 */
	private String bundleId;

	/**
	 * appAppleId
	 */
	private long appAppleId;

	/**
	 * environment
	 */
	private String environment;

	/**
	 * hasMore
	 */
	private boolean hasMore;

	/**
	 * signedTransactions
	 */
	private List<String> signedTransactions;

	/**
	 * 获取revision
	 * @return
	 */
	public String getRevision()
	{
		return revision;
	}

	/**
	 * 设置revision
	 * @param revision
	 */
	public void setRevision(String revision)
	{
		this.revision = revision;
	}

	/**
	 * 获取bundleId
	 * @return
	 */
	public String getBundleId()
	{
		return bundleId;
	}

	/**
	 * 设置bundleId
	 * @param bundleId
	 */
	public void setBundleId(String bundleId)
	{
		this.bundleId = bundleId;
	}

	/**
	 * 获取appAppleId
	 * @return
	 */
	public long getAppAppleId()
	{
		return appAppleId;
	}

	/**
	 * 设置appAppleId
	 * @param appAppleId
	 */
	public void setAppAppleId(long appAppleId)
	{
		this.appAppleId = appAppleId;
	}

	/**
	 * 获取environment
	 * @return
	 */
	public String getEnvironment()
	{
		return environment;
	}

	/**
	 * 设置environment
	 * @param environment
	 */
	public void setEnvironment(String environment)
	{
		this.environment = environment;
	}

	/**
	 * 获取hasMore
	 * @return
	 */
	public boolean isHasMore()
	{
		return hasMore;
	}

	/**
	 * 设置hasMore
	 * @param hasMore
	 */
	public void setHasMore(boolean hasMore)
	{
		this.hasMore = hasMore;
	}

	/**
	 * 获取signedTransactions
	 * @return
	 */
	public List<String> getSignedTransactions()
	{
		return signedTransactions;
	}

	/**
	 * 设置signedTransactions
	 * @param signedTransactions
	 */
	public void setSignedTransactions(List<String> signedTransactions)
	{
		this.signedTransactions = signedTransactions;
	}
}
