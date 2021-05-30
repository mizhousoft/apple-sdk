package com.mizhousoft.apple.open.result;

/**
 * 苹果认证结果
 *
 * @version
 */
public class AppleVerifyResult
{
	// 主体
	private String subject;

	// 邮箱
	private String email;

	/**
	 * 获取subject
	 * 
	 * @return
	 */
	public String getSubject()
	{
		return subject;
	}

	/**
	 * 设置subject
	 * 
	 * @param subject
	 */
	public void setSubject(String subject)
	{
		this.subject = subject;
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
	 * 
	 * @return
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("{\"subject\":\"");
		builder.append(subject);
		builder.append("\", \"email\":\"");
		builder.append(email);
		builder.append("\"}");
		return builder.toString();
	}
}
