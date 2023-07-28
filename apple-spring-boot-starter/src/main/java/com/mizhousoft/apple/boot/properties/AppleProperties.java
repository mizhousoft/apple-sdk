package com.mizhousoft.apple.boot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置
 *
 * @version
 */
@Component
@ConfigurationProperties(prefix = "apple.appstore")
public class AppleProperties
{
	/**
	 * bundleId
	 */
	private String bundleId;

	/**
	 * issuerId
	 */
	private volatile String issuerId;

	/**
	 * secretId
	 */
	private volatile String secretId;

	/**
	 * 私钥
	 */
	private volatile String privateKey;

	/**
	 * endpoint
	 */
	private String endpoint;

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
	 * 获取issuerId
	 * 
	 * @return
	 */
	public String getIssuerId()
	{
		return issuerId;
	}

	/**
	 * 设置issuerId
	 * 
	 * @param issuerId
	 */
	public void setIssuerId(String issuerId)
	{
		this.issuerId = issuerId;
	}

	/**
	 * 获取secretId
	 * 
	 * @return
	 */
	public String getSecretId()
	{
		return secretId;
	}

	/**
	 * 设置secretId
	 * 
	 * @param secretId
	 */
	public void setSecretId(String secretId)
	{
		this.secretId = secretId;
	}

	/**
	 * 获取privateKey
	 * 
	 * @return
	 */
	public String getPrivateKey()
	{
		return privateKey;
	}

	/**
	 * 设置privateKey
	 * 
	 * @param privateKey
	 */
	public void setPrivateKey(String privateKey)
	{
		this.privateKey = privateKey;
	}

	/**
	 * 获取endpoint
	 * 
	 * @return
	 */
	public String getEndpoint()
	{
		return endpoint;
	}

	/**
	 * 设置endpoint
	 * 
	 * @param endpoint
	 */
	public void setEndpoint(String endpoint)
	{
		this.endpoint = endpoint;
	}
}
