package com.mizhousoft.apple.iap.response;

/**
 * 数据体
 *
 */
public class NotificationDecodedPayload
{
	/**
	 * 通知类型
	 */
	private String notificationType;

	/**
	 * 子类型
	 */
	private String subtype;

	/**
	 * 数据
	 */
	private NotificationDecodedPayloadData data;

	/**
	 * 
	 */
	private String summary;

	/**
	 * 版本号
	 */
	private String version;

	/**
	 * 签名日期，单位是毫秒
	 */
	private long signedDate;

	/**
	 * UUID
	 */
	private String notificationUUID;

	/**
	 * 数据
	 */
	private TransactionDecodedPayload transactionPayload;

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
	 * 获取subtype
	 * 
	 * @return
	 */
	public String getSubtype()
	{
		return subtype;
	}

	/**
	 * 设置subtype
	 * 
	 * @param subtype
	 */
	public void setSubtype(String subtype)
	{
		this.subtype = subtype;
	}

	/**
	 * 获取data
	 * 
	 * @return
	 */
	public NotificationDecodedPayloadData getData()
	{
		return data;
	}

	/**
	 * 设置data
	 * 
	 * @param data
	 */
	public void setData(NotificationDecodedPayloadData data)
	{
		this.data = data;
	}

	/**
	 * 获取summary
	 * 
	 * @return
	 */
	public String getSummary()
	{
		return summary;
	}

	/**
	 * 设置summary
	 * 
	 * @param summary
	 */
	public void setSummary(String summary)
	{
		this.summary = summary;
	}

	/**
	 * 获取version
	 * 
	 * @return
	 */
	public String getVersion()
	{
		return version;
	}

	/**
	 * 设置version
	 * 
	 * @param version
	 */
	public void setVersion(String version)
	{
		this.version = version;
	}

	/**
	 * 获取signedDate
	 * 
	 * @return
	 */
	public long getSignedDate()
	{
		return signedDate;
	}

	/**
	 * 设置signedDate
	 * 
	 * @param signedDate
	 */
	public void setSignedDate(long signedDate)
	{
		this.signedDate = signedDate;
	}

	/**
	 * 获取notificationUUID
	 * 
	 * @return
	 */
	public String getNotificationUUID()
	{
		return notificationUUID;
	}

	/**
	 * 设置notificationUUID
	 * 
	 * @param notificationUUID
	 */
	public void setNotificationUUID(String notificationUUID)
	{
		this.notificationUUID = notificationUUID;
	}

	/**
	 * 获取transactionPayload
	 * 
	 * @return
	 */
	public TransactionDecodedPayload getTransactionPayload()
	{
		return transactionPayload;
	}

	/**
	 * 设置transactionPayload
	 * 
	 * @param transactionPayload
	 */
	public void setTransactionPayload(TransactionDecodedPayload transactionPayload)
	{
		this.transactionPayload = transactionPayload;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("{\"");
		if (notificationType != null)
		{
			builder.append("notificationType\":\"");
			builder.append(notificationType);
			builder.append("\", \"");
		}
		if (subtype != null)
		{
			builder.append("subtype\":\"");
			builder.append(subtype);
			builder.append("\", \"");
		}
		if (data != null)
		{
			builder.append("data\":\"");
			builder.append(data);
			builder.append("\", \"");
		}
		if (summary != null)
		{
			builder.append("summary\":\"");
			builder.append(summary);
			builder.append("\", \"");
		}
		if (version != null)
		{
			builder.append("version\":\"");
			builder.append(version);
			builder.append("\", \"");
		}
		builder.append("signedDate\":\"");
		builder.append(signedDate);
		builder.append("\", \"");
		if (notificationUUID != null)
		{
			builder.append("notificationUUID\":\"");
			builder.append(notificationUUID);
		}
		builder.append("\"}");
		return builder.toString();
	}
}
