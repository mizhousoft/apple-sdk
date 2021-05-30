package com.mizhousoft.apple.open.model;

/**
 * JSON Web Key
 *
 * @version
 */
public class AppleJWKKey
{
	// The encryption algorithm used to encrypt the token.
	private String alg;

	// The exponent value for the RSA public key.
	private String e;

	// A 10-character identifier key, obtained from your developer account.
	private String kid;

	// The key type parameter setting. This must be set to "RSA".
	private String kty;

	// The modulus value for the RSA public key.
	private String n;

	// The intended use for the public key.
	private String use;

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
	 * 获取e
	 * 
	 * @return
	 */
	public String getE()
	{
		return e;
	}

	/**
	 * 设置e
	 * 
	 * @param e
	 */
	public void setE(String e)
	{
		this.e = e;
	}

	/**
	 * 获取kid
	 * 
	 * @return
	 */
	public String getKid()
	{
		return kid;
	}

	/**
	 * 设置kid
	 * 
	 * @param kid
	 */
	public void setKid(String kid)
	{
		this.kid = kid;
	}

	/**
	 * 获取kty
	 * 
	 * @return
	 */
	public String getKty()
	{
		return kty;
	}

	/**
	 * 设置kty
	 * 
	 * @param kty
	 */
	public void setKty(String kty)
	{
		this.kty = kty;
	}

	/**
	 * 获取n
	 * 
	 * @return
	 */
	public String getN()
	{
		return n;
	}

	/**
	 * 设置n
	 * 
	 * @param n
	 */
	public void setN(String n)
	{
		this.n = n;
	}

	/**
	 * 获取use
	 * 
	 * @return
	 */
	public String getUse()
	{
		return use;
	}

	/**
	 * 设置use
	 * 
	 * @param use
	 */
	public void setUse(String use)
	{
		this.use = use;
	}
}
