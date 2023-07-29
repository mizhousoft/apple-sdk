package com.mizhousoft.apple.iap.response;

import java.util.List;

/**
 * NotificationHistory
 *
 */
public class NotificationHistory
{
	/**
	 * 是否有更多
	 */
	private boolean hasMore;

	/**
	 * 分页Token
	 */
	private String paginationToken;

	/**
	 * 
	 */
	private List<NotificationDecodedPayload> payloads;

	/**
	 * 获取hasMore
	 * 
	 * @return
	 */
	public boolean isHasMore()
	{
		return hasMore;
	}

	/**
	 * 设置hasMore
	 * 
	 * @param hasMore
	 */
	public void setHasMore(boolean hasMore)
	{
		this.hasMore = hasMore;
	}

	/**
	 * 获取paginationToken
	 * 
	 * @return
	 */
	public String getPaginationToken()
	{
		return paginationToken;
	}

	/**
	 * 设置paginationToken
	 * 
	 * @param paginationToken
	 */
	public void setPaginationToken(String paginationToken)
	{
		this.paginationToken = paginationToken;
	}

	/**
	 * 获取payloads
	 * 
	 * @return
	 */
	public List<NotificationDecodedPayload> getPayloads()
	{
		return payloads;
	}

	/**
	 * 设置payloads
	 * 
	 * @param payloads
	 */
	public void setPayloads(List<NotificationDecodedPayload> payloads)
	{
		this.payloads = payloads;
	}
}
