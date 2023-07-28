package com.mizhousoft.apple.iap.profile;

import java.security.PrivateKey;

/**
 * 内购配置
 *
 */
public class InAppProfile
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
	 * privateKey
	 */
	private volatile PrivateKey privateKey;

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
	public PrivateKey getPrivateKey()
	{
		return privateKey;
	}

	/**
	 * 设置privateKey
	 * 
	 * @param privateKey
	 */
	public void setPrivateKey(PrivateKey privateKey)
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
