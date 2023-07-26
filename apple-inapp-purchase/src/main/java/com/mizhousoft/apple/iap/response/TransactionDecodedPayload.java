package com.mizhousoft.apple.iap.response;

/**
 * 交易信息数据体
 *
 */
public class TransactionDecodedPayload
{
	/**
	 * 
	 */
	private String appAccountToken;

	/**
	 * 
	 */
	private String bundleId;

	/**
	 * 
	 */
	private String environment;

	/**
	 * 过期日期，单位毫秒
	 */
	private long expiresDate;

	/**
	 * 
	 */
	private String inAppOwnershipType;

	/**
	 * 
	 */
	private String isUpgraded;

	/**
	 * 
	 */
	private String offerIdentifier;

	/**
	 * 
	 */
	private String offerType;

	/**
	 * 购买日期，单位毫秒
	 */
	private long originalPurchaseDate;

	/**
	 * 
	 */
	private String originalTransactionId;

	/**
	 * 
	 */
	private String productId;

	/**
	 * 购买日期，单位毫秒
	 */
	private long purchaseDate;

	/**
	 * 
	 */
	private int quantity;

	/**
	 * 日期，单位毫秒
	 */
	private long revocationDate;

	/**
	 * 
	 */
	private String revocationReason;

	/**
	 * 日期，单位毫秒
	 */
	private long signedDate;

	/**
	 * 
	 */
	private String transactionId;

	/**
	 * 
	 */
	private String transactionReason;

	/**
	 * 
	 */
	private String type;

	/**
	 * 
	 */
	private String webOrderLineItemId;

	/**
	 * 获取appAccountToken
	 * 
	 * @return
	 */
	public String getAppAccountToken()
	{
		return appAccountToken;
	}

	/**
	 * 设置appAccountToken
	 * 
	 * @param appAccountToken
	 */
	public void setAppAccountToken(String appAccountToken)
	{
		this.appAccountToken = appAccountToken;
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
	 * 获取expiresDate
	 * 
	 * @return
	 */
	public long getExpiresDate()
	{
		return expiresDate;
	}

	/**
	 * 设置expiresDate
	 * 
	 * @param expiresDate
	 */
	public void setExpiresDate(long expiresDate)
	{
		this.expiresDate = expiresDate;
	}

	/**
	 * 获取inAppOwnershipType
	 * 
	 * @return
	 */
	public String getInAppOwnershipType()
	{
		return inAppOwnershipType;
	}

	/**
	 * 设置inAppOwnershipType
	 * 
	 * @param inAppOwnershipType
	 */
	public void setInAppOwnershipType(String inAppOwnershipType)
	{
		this.inAppOwnershipType = inAppOwnershipType;
	}

	/**
	 * 获取isUpgraded
	 * 
	 * @return
	 */
	public String getIsUpgraded()
	{
		return isUpgraded;
	}

	/**
	 * 设置isUpgraded
	 * 
	 * @param isUpgraded
	 */
	public void setIsUpgraded(String isUpgraded)
	{
		this.isUpgraded = isUpgraded;
	}

	/**
	 * 获取offerIdentifier
	 * 
	 * @return
	 */
	public String getOfferIdentifier()
	{
		return offerIdentifier;
	}

	/**
	 * 设置offerIdentifier
	 * 
	 * @param offerIdentifier
	 */
	public void setOfferIdentifier(String offerIdentifier)
	{
		this.offerIdentifier = offerIdentifier;
	}

	/**
	 * 获取offerType
	 * 
	 * @return
	 */
	public String getOfferType()
	{
		return offerType;
	}

	/**
	 * 设置offerType
	 * 
	 * @param offerType
	 */
	public void setOfferType(String offerType)
	{
		this.offerType = offerType;
	}

	/**
	 * 获取originalPurchaseDate
	 * 
	 * @return
	 */
	public long getOriginalPurchaseDate()
	{
		return originalPurchaseDate;
	}

	/**
	 * 设置originalPurchaseDate
	 * 
	 * @param originalPurchaseDate
	 */
	public void setOriginalPurchaseDate(long originalPurchaseDate)
	{
		this.originalPurchaseDate = originalPurchaseDate;
	}

	/**
	 * 获取originalTransactionId
	 * 
	 * @return
	 */
	public String getOriginalTransactionId()
	{
		return originalTransactionId;
	}

	/**
	 * 设置originalTransactionId
	 * 
	 * @param originalTransactionId
	 */
	public void setOriginalTransactionId(String originalTransactionId)
	{
		this.originalTransactionId = originalTransactionId;
	}

	/**
	 * 获取productId
	 * 
	 * @return
	 */
	public String getProductId()
	{
		return productId;
	}

	/**
	 * 设置productId
	 * 
	 * @param productId
	 */
	public void setProductId(String productId)
	{
		this.productId = productId;
	}

	/**
	 * 获取purchaseDate
	 * 
	 * @return
	 */
	public long getPurchaseDate()
	{
		return purchaseDate;
	}

	/**
	 * 设置purchaseDate
	 * 
	 * @param purchaseDate
	 */
	public void setPurchaseDate(long purchaseDate)
	{
		this.purchaseDate = purchaseDate;
	}

	/**
	 * 获取quantity
	 * 
	 * @return
	 */
	public int getQuantity()
	{
		return quantity;
	}

	/**
	 * 设置quantity
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	/**
	 * 获取revocationDate
	 * 
	 * @return
	 */
	public long getRevocationDate()
	{
		return revocationDate;
	}

	/**
	 * 设置revocationDate
	 * 
	 * @param revocationDate
	 */
	public void setRevocationDate(long revocationDate)
	{
		this.revocationDate = revocationDate;
	}

	/**
	 * 获取revocationReason
	 * 
	 * @return
	 */
	public String getRevocationReason()
	{
		return revocationReason;
	}

	/**
	 * 设置revocationReason
	 * 
	 * @param revocationReason
	 */
	public void setRevocationReason(String revocationReason)
	{
		this.revocationReason = revocationReason;
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
	 * 获取transactionId
	 * 
	 * @return
	 */
	public String getTransactionId()
	{
		return transactionId;
	}

	/**
	 * 设置transactionId
	 * 
	 * @param transactionId
	 */
	public void setTransactionId(String transactionId)
	{
		this.transactionId = transactionId;
	}

	/**
	 * 获取transactionReason
	 * 
	 * @return
	 */
	public String getTransactionReason()
	{
		return transactionReason;
	}

	/**
	 * 设置transactionReason
	 * 
	 * @param transactionReason
	 */
	public void setTransactionReason(String transactionReason)
	{
		this.transactionReason = transactionReason;
	}

	/**
	 * 获取type
	 * 
	 * @return
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * 设置type
	 * 
	 * @param type
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * 获取webOrderLineItemId
	 * 
	 * @return
	 */
	public String getWebOrderLineItemId()
	{
		return webOrderLineItemId;
	}

	/**
	 * 设置webOrderLineItemId
	 * 
	 * @param webOrderLineItemId
	 */
	public void setWebOrderLineItemId(String webOrderLineItemId)
	{
		this.webOrderLineItemId = webOrderLineItemId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("{\"");
		if (appAccountToken != null)
		{
			builder.append("appAccountToken\":\"");
			builder.append(appAccountToken);
			builder.append("\", \"");
		}
		if (bundleId != null)
		{
			builder.append("bundleId\":\"");
			builder.append(bundleId);
			builder.append("\", \"");
		}
		if (environment != null)
		{
			builder.append("environment\":\"");
			builder.append(environment);
			builder.append("\", \"");
		}
		builder.append("expiresDate\":\"");
		builder.append(expiresDate);
		builder.append("\", \"");
		if (inAppOwnershipType != null)
		{
			builder.append("inAppOwnershipType\":\"");
			builder.append(inAppOwnershipType);
			builder.append("\", \"");
		}
		if (isUpgraded != null)
		{
			builder.append("isUpgraded\":\"");
			builder.append(isUpgraded);
			builder.append("\", \"");
		}
		if (offerIdentifier != null)
		{
			builder.append("offerIdentifier\":\"");
			builder.append(offerIdentifier);
			builder.append("\", \"");
		}
		if (offerType != null)
		{
			builder.append("offerType\":\"");
			builder.append(offerType);
			builder.append("\", \"");
		}
		builder.append("originalPurchaseDate\":\"");
		builder.append(originalPurchaseDate);
		builder.append("\", \"");
		if (originalTransactionId != null)
		{
			builder.append("originalTransactionId\":\"");
			builder.append(originalTransactionId);
			builder.append("\", \"");
		}
		if (productId != null)
		{
			builder.append("productId\":\"");
			builder.append(productId);
			builder.append("\", \"");
		}
		builder.append("purchaseDate\":\"");
		builder.append(purchaseDate);
		builder.append("\", \"quantity\":\"");
		builder.append(quantity);
		builder.append("\", \"revocationDate\":\"");
		builder.append(revocationDate);
		builder.append("\", \"");
		if (revocationReason != null)
		{
			builder.append("revocationReason\":\"");
			builder.append(revocationReason);
			builder.append("\", \"");
		}
		builder.append("signedDate\":\"");
		builder.append(signedDate);
		builder.append("\", \"");
		if (transactionId != null)
		{
			builder.append("transactionId\":\"");
			builder.append(transactionId);
			builder.append("\", \"");
		}
		if (transactionReason != null)
		{
			builder.append("transactionReason\":\"");
			builder.append(transactionReason);
			builder.append("\", \"");
		}
		if (type != null)
		{
			builder.append("type\":\"");
			builder.append(type);
			builder.append("\", \"");
		}
		if (webOrderLineItemId != null)
		{
			builder.append("webOrderLineItemId\":\"");
			builder.append(webOrderLineItemId);
		}
		builder.append("\"}");
		return builder.toString();
	}
}
