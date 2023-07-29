package com.mizhousoft.apple.iap.request;

/**
 * 通知历史请求
 *
 */
public class NotificationHistoryRequest
{
	/**
	 * 开始日期，单位是毫秒，必须值，必须是半年内
	 */
	private Long startDate;

	/**
	 * 结束日期，单位是毫秒，必须值
	 */
	private Long endDate;

	/**
	 * 通知类型，可选
	 */
	private String notificationType;

	/**
	 * 通知类型，可选
	 */
	private String notificationSubtype;

	/**
	 * 可选
	 */
	private boolean onlyFailures;

	/**
	 * 可选
	 */
	private String transactionId;

	/**
	 * 获取startDate
	 * 
	 * @return
	 */
	public Long getStartDate()
	{
		return startDate;
	}

	/**
	 * 设置startDate
	 * 
	 * @param startDate
	 */
	public void setStartDate(Long startDate)
	{
		this.startDate = startDate;
	}

	/**
	 * 获取endDate
	 * 
	 * @return
	 */
	public Long getEndDate()
	{
		return endDate;
	}

	/**
	 * 设置endDate
	 * 
	 * @param endDate
	 */
	public void setEndDate(Long endDate)
	{
		this.endDate = endDate;
	}

	/**
	 * 获取notificationType
	 * 
	 * @return
	 */
	public String getNotificationType()
	{
		return notificationType;
	}

	/**
	 * 设置notificationType
	 * 
	 * @param notificationType
	 */
	public void setNotificationType(String notificationType)
	{
		this.notificationType = notificationType;
	}

	/**
	 * 获取notificationSubtype
	 * 
	 * @return
	 */
	public String getNotificationSubtype()
	{
		return notificationSubtype;
	}

	/**
	 * 设置notificationSubtype
	 * 
	 * @param notificationSubtype
	 */
	public void setNotificationSubtype(String notificationSubtype)
	{
		this.notificationSubtype = notificationSubtype;
	}

	/**
	 * 获取onlyFailures
	 * 
	 * @return
	 */
	public boolean isOnlyFailures()
	{
		return onlyFailures;
	}

	/**
	 * 设置onlyFailures
	 * 
	 * @param onlyFailures
	 */
	public void setOnlyFailures(boolean onlyFailures)
	{
		this.onlyFailures = onlyFailures;
	}

	/**
	 * 获取transactionId
	 * 
	 * @return
	 */
	public String getTransactionId()
	{
		return transactionId;
	}

	/**
	 * 设置transactionId
	 * 
	 * @param transactionId
	 */
	public void setTransactionId(String transactionId)
	{
		this.transactionId = transactionId;
	}
}
