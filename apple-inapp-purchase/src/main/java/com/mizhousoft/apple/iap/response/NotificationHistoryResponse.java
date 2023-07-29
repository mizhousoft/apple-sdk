package com.mizhousoft.apple.iap.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * NotificationHistoryResponse
 *
 */
public class NotificationHistoryResponse
{
	/**
	 * 
	 */
	@JsonProperty(value = "notificationHistory")
	private List<NotificationHistoryResponseItem> items;

	/**
	 * 是否有更多
	 */
	private boolean hasMore;

	/**
	 * 分页Token
	 */
	private String paginationToken;

	/**
	 * 获取items
	 * 
	 * @return
	 */
	public List<NotificationHistoryResponseItem> getItems()
	{
		return items;
	}

	/**
	 * 设置items
	 * 
	 * @param items
	 */
	public void setItems(List<NotificationHistoryResponseItem> items)
	{
		this.items = items;
	}

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
}
