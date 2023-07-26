package com.mizhousoft.apple.iap.response;

/**
 * 数据体
 *
 */
public class NotificationDecodedPayloadData
{
	/**
	 * appAppleId
	 */
	private long appAppleId;

	/**
	 * bundleId
	 */
	private String bundleId;

	/**
	 * 版本号
	 */
	private String bundleVersion;

	/**
	 * 环境
	 */
	private String environment;

	/**
	 * 签名数据
	 */
	private String signedRenewalInfo;

	/**
	 * 签名数据
	 */
	private String signedTransactionInfo;

	/**
	 * 状态
	 */
	private String status;

	/**
	 * 获取appAppleId
	 * 
	 * @return
	 */
	public long getAppAppleId()
	{
		return appAppleId;
	}

	/**
	 * 设置appAppleId
	 * 
	 * @param appAppleId
	 */
	public void setAppAppleId(long appAppleId)
	{
		this.appAppleId = appAppleId;
	}

	/**
	 * 获取bundleId
	 * 
	 * @return
	 */
	public String getBundleId()
	{
		return bundleId;
	}

	/**
	 * 设置bundleId
	 * 
	 * @param bundleId
	 */
	public void setBundleId(String bundleId)
	{
		this.bundleId = bundleId;
	}

	/**
	 * 获取bundleVersion
	 * 
	 * @return
	 */
	public String getBundleVersion()
	{
		return bundleVersion;
	}

	/**
	 * 设置bundleVersion
	 * 
	 * @param bundleVersion
	 */
	public void setBundleVersion(String bundleVersion)
	{
		this.bundleVersion = bundleVersion;
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
	 * 获取signedRenewalInfo
	 * 
	 * @return
	 */
	public String getSignedRenewalInfo()
	{
		return signedRenewalInfo;
	}

	/**
	 * 设置signedRenewalInfo
	 * 
	 * @param signedRenewalInfo
	 */
	public void setSignedRenewalInfo(String signedRenewalInfo)
	{
		this.signedRenewalInfo = signedRenewalInfo;
	}

	/**
	 * 获取signedTransactionInfo
	 * 
	 * @return
	 */
	public String getSignedTransactionInfo()
	{
		return signedTransactionInfo;
	}

	/**
	 * 设置signedTransactionInfo
	 * 
	 * @param signedTransactionInfo
	 */
	public void setSignedTransactionInfo(String signedTransactionInfo)
	{
		this.signedTransactionInfo = signedTransactionInfo;
	}

	/**
	 * 获取status
	 * 
	 * @return
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * 设置status
	 * 
	 * @param status
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("{\"appAppleId\":\"");
		builder.append(appAppleId);
		builder.append("\", \"");
		if (bundleId != null)
		{
			builder.append("bundleId\":\"");
			builder.append(bundleId);
			builder.append("\", \"");
		}
		if (bundleVersion != null)
		{
			builder.append("bundleVersion\":\"");
			builder.append(bundleVersion);
			builder.append("\", \"");
		}
		if (environment != null)
		{
			builder.append("environment\":\"");
			builder.append(environment);
			builder.append("\", \"");
		}
		if (signedRenewalInfo != null)
		{
			builder.append("signedRenewalInfo\":\"");
			builder.append(signedRenewalInfo);
			builder.append("\", \"");
		}
		if (signedTransactionInfo != null)
		{
			builder.append("signedTransactionInfo\":\"");
			builder.append(signedTransactionInfo);
			builder.append("\", \"");
		}
		if (status != null)
		{
			builder.append("status\":\"");
			builder.append(status);
		}
		builder.append("\"}");
		return builder.toString();
	}
}
