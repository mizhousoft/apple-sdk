package com.mizhousoft.apple.iap.result;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * receipt
 *
 * @version
 */
public class ReceiptBody
{
	@JsonProperty("in_app")
	private List<PurchaseReceipt> purchaseReceipts;

	@JsonProperty("bundle_id")
	private String bundleId;

	/**
	 * 获取purchaseReceipts
	 * 
	 * @return
	 */
	public List<PurchaseReceipt> getPurchaseReceipts()
	{
		return purchaseReceipts;
	}

	/**
	 * 设置purchaseReceipts
	 * 
	 * @param purchaseReceipts
	 */
	public void setPurchaseReceipts(List<PurchaseReceipt> purchaseReceipts)
	{
		this.purchaseReceipts = purchaseReceipts;
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
}
