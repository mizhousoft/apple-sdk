package com.mizhousoft.apple.open.model;

import java.util.List;

/**
 * 公钥
 *
 * @version
 */
public class ApplePublicKeys
{
	// Apple’s public key.
	private List<AppleJWKKey> keys;

	/**
	 * 获取keys
	 * 
	 * @return
	 */
	public List<AppleJWKKey> getKeys()
	{
		return keys;
	}

	/**
	 * 设置keys
	 * 
	 * @param keys
	 */
	public void setKeys(List<AppleJWKKey> keys)
	{
		this.keys = keys;
	}
}
