package com.mizhousoft.apple.open.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * playload
 *
 * @version
 */
public class AppleJWTPlayload
{
	// jwt签发者，The issuer-registered claim key, which has the value https://appleid.apple.com.
	@JsonProperty("iss")
	private String iss;

	// jwt所面向的用户，The unique identifier for the user.
	@JsonProperty("sub")
	private String sub;

	// 接收jwt的一方，Your client_id in your Apple Developer account.
	@JsonProperty("aud")
	private String aud;

	// jwt的过期时间，The expiry time for the token. This value is typically set to five minutes.
	@JsonProperty("exp")
	private String exp;

	// jwt的签发时间，The time the token was issued.
	@JsonProperty("iat")
	private String iat;

	// email，The user's email address.
	@JsonProperty("email")
	private String email;

	// 邮箱是否校验，
	// A Boolean value that indicates whether the service has verified the email. The value of this
	// claim is always true because the servers only return verified email addresses.
	@JsonProperty("email_verified")
	private String emailVerified;

	// 认证时间
	@JsonProperty("auth_time")
	private String authTime;

	/**
	 * 获取iss
	 * 
	 * @return
	 */
	public String getIss()
	{
		return iss;
	}

	/**
	 * 设置iss
	 * 
	 * @param iss
	 */
	public void setIss(String iss)
	{
		this.iss = iss;
	}

	/**
	 * 获取sub
	 * 
	 * @return
	 */
	public String getSub()
	{
		return sub;
	}

	/**
	 * 设置sub
	 * 
	 * @param sub
	 */
	public void setSub(String sub)
	{
		this.sub = sub;
	}

	/**
	 * 获取aud
	 * 
	 * @return
	 */
	public String getAud()
	{
		return aud;
	}

	/**
	 * 设置aud
	 * 
	 * @param aud
	 */
	public void setAud(String aud)
	{
		this.aud = aud;
	}

	/**
	 * 获取exp
	 * 
	 * @return
	 */
	public String getExp()
	{
		return exp;
	}

	/**
	 * 设置exp
	 * 
	 * @param exp
	 */
	public void setExp(String exp)
	{
		this.exp = exp;
	}

	/**
	 * 获取iat
	 * 
	 * @return
	 */
	public String getIat()
	{
		return iat;
	}

	/**
	 * 设置iat
	 * 
	 * @param iat
	 */
	public void setIat(String iat)
	{
		this.iat = iat;
	}

	/**
	 * 获取email
	 * 
	 * @return
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * 设置email
	 * 
	 * @param email
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * 获取emailVerified
	 * 
	 * @return
	 */
	public String getEmailVerified()
	{
		return emailVerified;
	}

	/**
	 * 设置emailVerified
	 * 
	 * @param emailVerified
	 */
	public void setEmailVerified(String emailVerified)
	{
		this.emailVerified = emailVerified;
	}

	/**
	 * 获取authTime
	 * 
	 * @return
	 */
	public String getAuthTime()
	{
		return authTime;
	}

	/**
	 * 设置authTime
	 * 
	 * @param authTime
	 */
	public void setAuthTime(String authTime)
	{
		this.authTime = authTime;
	}
}
