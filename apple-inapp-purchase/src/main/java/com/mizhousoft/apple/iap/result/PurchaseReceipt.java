package com.mizhousoft.apple.iap.result;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 购买凭证
 *
 * @version
 */
public class PurchaseReceipt
{
	@JsonProperty("transaction_id")
	private String transactionId;

	@JsonProperty("quantity")
	private String quantity;

	@JsonProperty("product_id")
	private String productId;

	@JsonProperty("purchase_date_ms")
	private String purchaseDateMs;

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
	 * 获取quantity
	 * 
	 * @return
	 */
	public String getQuantity()
	{
		return quantity;
	}

	/**
	 * 设置quantity
	 * 
	 * @param quantity
	 */
	public void setQuantity(String quantity)
	{
		this.quantity = quantity;
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
	 * 获取purchaseDateMs
	 * 
	 * @return
	 */
	public String getPurchaseDateMs()
	{
		return purchaseDateMs;
	}

	/**
	 * 设置purchaseDateMs
	 * 
	 * @param purchaseDateMs
	 */
	public void setPurchaseDateMs(String purchaseDateMs)
	{
		this.purchaseDateMs = purchaseDateMs;
	}
}
