package com.mizhousoft.apple.iap.result;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 服务通知
 *
 * @version
 */
public class ServerNotificationBody
{
	// 自动续订参数
	@JsonProperty("auto_renew_adam_id")
	private String autoRenewAdamId;

	// 自动续订参数
	@JsonProperty("auto_renew_product_id")
	private String autoRenewProductId;

	// 自动续订参数
	@JsonProperty("auto_renew_status")
	private String autoRenewStatus;

	// 自动续订参数
	@JsonProperty("auto_renew_status_change_date")
	private String autoRenewStatusChangeDate;

	// 自动续订参数
	@JsonProperty("auto_renew_status_change_date_ms")
	private String autoRenewStatusChangeDateMs;

	// 自动续订参数
	@JsonProperty("auto_renew_status_change_date_pst")
	private String autoRenewStatusChangeDatePst;

	// app bundle id
	@JsonProperty("bid")
	private String bid;

	// app bundle version
	@JsonProperty("bvrs")
	private String bvrs;

	// 收据生成的环境， values: Sandbox, PROD
	@JsonProperty("environment")
	private String environment;

	// 过期原因
	@JsonProperty("expiration_intent")
	private int expirationIntent;

	// 通知类型
	@JsonProperty("notification_type")
	private String notificationType;

	// 苹果订单的唯一标识 transaction_id
	@JsonProperty("original_transaction_id")
	private long originalTransactionId;

	// 密码
	@JsonProperty("password")
	private String password;

	// 统一凭证
	@JsonProperty("unified_receipt")
	private UnifiedReceipt unifiedReceipt;

	/**
	 * 获取autoRenewAdamId
	 * 
	 * @return
	 */
	public String getAutoRenewAdamId()
	{
		return autoRenewAdamId;
	}

	/**
	 * 设置autoRenewAdamId
	 * 
	 * @param autoRenewAdamId
	 */
	public void setAutoRenewAdamId(String autoRenewAdamId)
	{
		this.autoRenewAdamId = autoRenewAdamId;
	}

	/**
	 * 获取autoRenewProductId
	 * 
	 * @return
	 */
	public String getAutoRenewProductId()
	{
		return autoRenewProductId;
	}

	/**
	 * 设置autoRenewProductId
	 * 
	 * @param autoRenewProductId
	 */
	public void setAutoRenewProductId(String autoRenewProductId)
	{
		this.autoRenewProductId = autoRenewProductId;
	}

	/**
	 * 获取autoRenewStatus
	 * 
	 * @return
	 */
	public String getAutoRenewStatus()
	{
		return autoRenewStatus;
	}

	/**
	 * 设置autoRenewStatus
	 * 
	 * @param autoRenewStatus
	 */
	public void setAutoRenewStatus(String autoRenewStatus)
	{
		this.autoRenewStatus = autoRenewStatus;
	}

	/**
	 * 获取autoRenewStatusChangeDate
	 * 
	 * @return
	 */
	public String getAutoRenewStatusChangeDate()
	{
		return autoRenewStatusChangeDate;
	}

	/**
	 * 设置autoRenewStatusChangeDate
	 * 
	 * @param autoRenewStatusChangeDate
	 */
	public void setAutoRenewStatusChangeDate(String autoRenewStatusChangeDate)
	{
		this.autoRenewStatusChangeDate = autoRenewStatusChangeDate;
	}

	/**
	 * 获取autoRenewStatusChangeDateMs
	 * 
	 * @return
	 */
	public String getAutoRenewStatusChangeDateMs()
	{
		return autoRenewStatusChangeDateMs;
	}

	/**
	 * 设置autoRenewStatusChangeDateMs
	 * 
	 * @param autoRenewStatusChangeDateMs
	 */
	public void setAutoRenewStatusChangeDateMs(String autoRenewStatusChangeDateMs)
	{
		this.autoRenewStatusChangeDateMs = autoRenewStatusChangeDateMs;
	}

	/**
	 * 获取autoRenewStatusChangeDatePst
	 * 
	 * @return
	 */
	public String getAutoRenewStatusChangeDatePst()
	{
		return autoRenewStatusChangeDatePst;
	}

	/**
	 * 设置autoRenewStatusChangeDatePst
	 * 
	 * @param autoRenewStatusChangeDatePst
	 */
	public void setAutoRenewStatusChangeDatePst(String autoRenewStatusChangeDatePst)
	{
		this.autoRenewStatusChangeDatePst = autoRenewStatusChangeDatePst;
	}

	/**
	 * 获取bid
	 * 
	 * @return
	 */
	public String getBid()
	{
		return bid;
	}

	/**
	 * 设置bid
	 * 
	 * @param bid
	 */
	public void setBid(String bid)
	{
		this.bid = bid;
	}

	/**
	 * 获取bvrs
	 * 
	 * @return
	 */
	public String getBvrs()
	{
		return bvrs;
	}

	/**
	 * 设置bvrs
	 * 
	 * @param bvrs
	 */
	public void setBvrs(String bvrs)
	{
		this.bvrs = bvrs;
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
	 * 获取expirationIntent
	 * 
	 * @return
	 */
	public int getExpirationIntent()
	{
		return expirationIntent;
	}

	/**
	 * 设置expirationIntent
	 * 
	 * @param expirationIntent
	 */
	public void setExpirationIntent(int expirationIntent)
	{
		this.expirationIntent = expirationIntent;
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
	 * 获取originalTransactionId
	 * 
	 * @return
	 */
	public long getOriginalTransactionId()
	{
		return originalTransactionId;
	}

	/**
	 * 设置originalTransactionId
	 * 
	 * @param originalTransactionId
	 */
	public void setOriginalTransactionId(long originalTransactionId)
	{
		this.originalTransactionId = originalTransactionId;
	}

	/**
	 * 获取password
	 * 
	 * @return
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * 设置password
	 * 
	 * @param password
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * 获取unifiedReceipt
	 * 
	 * @return
	 */
	public UnifiedReceipt getUnifiedReceipt()
	{
		return unifiedReceipt;
	}

	/**
	 * 设置unifiedReceipt
	 * 
	 * @param unifiedReceipt
	 */
	public void setUnifiedReceipt(UnifiedReceipt unifiedReceipt)
	{
		this.unifiedReceipt = unifiedReceipt;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("{\"autoRenewAdamId\":\"");
		builder.append(autoRenewAdamId);
		builder.append("\", \"autoRenewProductId\":\"");
		builder.append(autoRenewProductId);
		builder.append("\", \"autoRenewStatus\":\"");
		builder.append(autoRenewStatus);
		builder.append("\", \"autoRenewStatusChangeDate\":\"");
		builder.append(autoRenewStatusChangeDate);
		builder.append("\", \"autoRenewStatusChangeDateMs\":\"");
		builder.append(autoRenewStatusChangeDateMs);
		builder.append("\", \"autoRenewStatusChangeDatePst\":\"");
		builder.append(autoRenewStatusChangeDatePst);
		builder.append("\", \"bid\":\"");
		builder.append(bid);
		builder.append("\", \"bvrs\":\"");
		builder.append(bvrs);
		builder.append("\", \"environment\":\"");
		builder.append(environment);
		builder.append("\", \"expirationIntent\":\"");
		builder.append(expirationIntent);
		builder.append("\", \"notificationType\":\"");
		builder.append(notificationType);
		builder.append("\", \"originalTransactionId\":\"");
		builder.append(originalTransactionId);
		builder.append("\", \"password\":\"");
		builder.append(password);
		builder.append("\", \"unifiedReceipt\":\"");
		builder.append(unifiedReceipt);
		builder.append("\"}");
		return builder.toString();
	}
}
