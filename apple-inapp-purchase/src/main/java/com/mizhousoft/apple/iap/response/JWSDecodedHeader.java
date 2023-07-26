package com.mizhousoft.apple.iap.response;

import java.util.List;

/**
 * JWSDecodedHeader
 *
 */
public class JWSDecodedHeader
{
	/**
	 * 算法
	 */
	private String alg;

	/**
	 * 证书
	 */
	private List<String> x5c;

	/**
	 * 获取alg
	 * 
	 * @return
	 */
	public String getAlg()
	{
		return alg;
	}

	/**
	 * 设置alg
	 * 
	 * @param alg
	 */
	public void setAlg(String alg)
	{
		this.alg = alg;
	}

	/**
	 * 获取x5c
	 * 
	 * @return
	 */
	public List<String> getX5c()
	{
		return x5c;
	}

	/**
	 * 设置x5c
	 * 
	 * @param x5c
	 */
	public void setX5c(List<String> x5c)
	{
		this.x5c = x5c;
	}
}
