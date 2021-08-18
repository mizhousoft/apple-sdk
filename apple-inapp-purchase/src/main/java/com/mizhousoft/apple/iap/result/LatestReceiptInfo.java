package com.mizhousoft.apple.iap.result;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 最新凭证信息
 *
 * @version
 */
public class LatestReceiptInfo
{
	// The appAccountToken associated with this transaction. This field is only present if your app
	// supplied an appAccountToken(_:) when the user made the purchase; it's only present in the
	// sandbox environment.
	@JsonProperty("app_account_token")
	private String appAccountToken;

	// The time the App Store refunded a transaction or revoked it from family sharing, in a
	// date-time format similar to the ISO 8601. This field is present only for refunded or revoked
	// transactions.
	@JsonProperty("cancellation_date")
	private String cancellationDate;

	// The time the App Store refunded a transaction or revoked it from family sharing, in UNIX
	// epoch time format, in milliseconds. This field is present only for refunded or revoked
	// transactions. Use this time format for processing dates. For more information, see
	// cancellation_date_ms.
	@JsonProperty("cancellation_date_ms")
	private String cancellationDateMs;

	// The time the App Store refunded a transaction or revoked it from family sharing, in Pacific
	// Standard Time. This field is present only for refunded or revoked transactions.
	@JsonProperty("cancellation_date_pst")
	private String cancellationDatePst;

	// The reason for a refunded or revoked transaction. A value of “1” indicates that the customer
	// canceled their transaction due to an actual or perceived issue within your app. A value of
	// “0” indicates that the transaction was canceled for another reason; for example, if the
	// customer made the purchase accidentally.
	// Possible values: 1, 0
	@JsonProperty("cancellation_reason")
	private String cancellationReason;

	// The time when a subscription expires or when it will renew, in UNIX epoch time format, in
	// milliseconds. Use this time format for processing dates. Note that this field is called
	// expires_date_ms in the receipt.
	@JsonProperty("expires_date")
	private String expiresDate;

	// The time when a subscription expires or when it will renew, in UNIX epoch time format, in
	// milliseconds. Use this time format for processing dates. For more information, see
	// expires_date_ms.
	@JsonProperty("expires_date_ms")
	private String expiresDateMs;

	// The time when a subscription expires or when it will renew, in Pacific Standard Time.
	@JsonProperty("expires_date_pst")
	private String expiresDatePst;

	// A value that indicates whether the user is the purchaser of the product, or is a family
	// member with access to the product through Family Sharing. See in_app_ownership_type for more
	// information.
	// Possible values: FAMILY_SHARED, PURCHASED
	@JsonProperty("in_app_ownership_type")
	private String inAppOwnershipType;

	// An indicator of whether an auto-renewable subscription is in the introductory price period.
	// For more information
	// Possible values: true, false
	@JsonProperty("is_in_intro_offer_period")
	private String isInIntroOfferPeriod;

	// An indicator of whether a subscription is in the free trial period. For more information,
	// Possible values: true, false
	@JsonProperty("is_trial_period")
	private String isTrialPeriod;

	// An indicator that the system canceled a subscription because the user upgraded. This field is
	// only present for upgrade transactions.
	@JsonProperty("is_upgraded")
	private String isUpgraded;

	// The reference name of a subscription offer you configured in App Store Connect. This field is
	// present when a customer redeemed a subscription offer code.
	@JsonProperty("offer_code_ref_name")
	private String offerCodeRefName;

	// The time of the original app purchase, in a date-time format similar to the ISO 8601
	// standard.
	@JsonProperty("original_purchase_date")
	private String originalPurchaseDate;

	// The time of the original app purchase, in UNIX epoch time format, in milliseconds. Use this
	// time format for processing dates. This value indicates the date of the subscription’s initial
	// purchase. The original purchase date applies to all product types and remains the same in all
	// transactions for the same product ID. This value corresponds to the original transaction’s
	// transactionDate property in StoreKit.
	@JsonProperty("original_purchase_date_ms")
	private String originalPurchaseDateMs;

	// The time of the original app purchase, in Pacific Standard Time.
	@JsonProperty("original_purchase_date_pst")
	private String originalPurchaseDatePst;

	// The transaction identifier of the original purchase.
	@JsonProperty("original_transaction_id")
	private String originalTransactionId;

	// The identifier of the subscription offer redeemed by the user.
	@JsonProperty("promotional_offer_id")
	private String promotionalOfferId;

	// The unique identifier of the product purchased. You provide this value when creating the
	// product in App Store Connect, and it corresponds to the productIdentifier property of the
	// SKPayment object stored in the transaction’s payment property.
	@JsonProperty("product_id")
	private String productId;

	// The time when the App Store charged the user’s account for a subscription purchase or renewal
	// after a lapse, in a date-time format similar to the ISO 8601 standard.
	@JsonProperty("purchase_date")
	private String purchaseDate;

	// The time when the App Store charged the user’s account for a subscription purchase or renewal
	// after a lapse, in the UNIX epoch time format, in milliseconds. Use this time format for
	// processing dates.
	@JsonProperty("purchase_date_ms")
	private String purchaseDateMs;

	// The time when the App Store charged the user’s account for a subscription purchase or renewal
	// after a lapse, in Pacific Standard Time.
	@JsonProperty("purchase_date_pst")
	private String purchaseDatePst;

	// The number of consumable products purchased. This value corresponds to the quantity property
	// of the SKPayment object stored in the transaction’s payment property. The value is usually
	// “1” unless modified with a mutable payment. The maximum value is “10”.
	@JsonProperty("quantity")
	private String quantity;

	// The identifier of the subscription group to which the subscription belongs. The value for
	// this field is identical to the subscriptionGroupIdentifier property in SKProduct.
	@JsonProperty("subscription_group_identifier")
	private String subscriptionGroupIdentifier;

	// A unique identifier for a transaction such as a purchase, restore, or renewal.
	@JsonProperty("transaction_id")
	private String transactionId;

	// A unique identifier for purchase events across devices, including subscription-renewal
	// events. This value is the primary key to identify subscription purchases.
	@JsonProperty("web_order_line_item_id")
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
	 * 获取cancellationDate
	 * 
	 * @return
	 */
	public String getCancellationDate()
	{
		return cancellationDate;
	}

	/**
	 * 设置cancellationDate
	 * 
	 * @param cancellationDate
	 */
	public void setCancellationDate(String cancellationDate)
	{
		this.cancellationDate = cancellationDate;
	}

	/**
	 * 获取cancellationDateMs
	 * 
	 * @return
	 */
	public String getCancellationDateMs()
	{
		return cancellationDateMs;
	}

	/**
	 * 设置cancellationDateMs
	 * 
	 * @param cancellationDateMs
	 */
	public void setCancellationDateMs(String cancellationDateMs)
	{
		this.cancellationDateMs = cancellationDateMs;
	}

	/**
	 * 获取cancellationDatePst
	 * 
	 * @return
	 */
	public String getCancellationDatePst()
	{
		return cancellationDatePst;
	}

	/**
	 * 设置cancellationDatePst
	 * 
	 * @param cancellationDatePst
	 */
	public void setCancellationDatePst(String cancellationDatePst)
	{
		this.cancellationDatePst = cancellationDatePst;
	}

	/**
	 * 获取cancellationReason
	 * 
	 * @return
	 */
	public String getCancellationReason()
	{
		return cancellationReason;
	}

	/**
	 * 设置cancellationReason
	 * 
	 * @param cancellationReason
	 */
	public void setCancellationReason(String cancellationReason)
	{
		this.cancellationReason = cancellationReason;
	}

	/**
	 * 获取expiresDate
	 * 
	 * @return
	 */
	public String getExpiresDate()
	{
		return expiresDate;
	}

	/**
	 * 设置expiresDate
	 * 
	 * @param expiresDate
	 */
	public void setExpiresDate(String expiresDate)
	{
		this.expiresDate = expiresDate;
	}

	/**
	 * 获取expiresDateMs
	 * 
	 * @return
	 */
	public String getExpiresDateMs()
	{
		return expiresDateMs;
	}

	/**
	 * 设置expiresDateMs
	 * 
	 * @param expiresDateMs
	 */
	public void setExpiresDateMs(String expiresDateMs)
	{
		this.expiresDateMs = expiresDateMs;
	}

	/**
	 * 获取expiresDatePst
	 * 
	 * @return
	 */
	public String getExpiresDatePst()
	{
		return expiresDatePst;
	}

	/**
	 * 设置expiresDatePst
	 * 
	 * @param expiresDatePst
	 */
	public void setExpiresDatePst(String expiresDatePst)
	{
		this.expiresDatePst = expiresDatePst;
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
	 * 获取isInIntroOfferPeriod
	 * 
	 * @return
	 */
	public String getIsInIntroOfferPeriod()
	{
		return isInIntroOfferPeriod;
	}

	/**
	 * 设置isInIntroOfferPeriod
	 * 
	 * @param isInIntroOfferPeriod
	 */
	public void setIsInIntroOfferPeriod(String isInIntroOfferPeriod)
	{
		this.isInIntroOfferPeriod = isInIntroOfferPeriod;
	}

	/**
	 * 获取isTrialPeriod
	 * 
	 * @return
	 */
	public String getIsTrialPeriod()
	{
		return isTrialPeriod;
	}

	/**
	 * 设置isTrialPeriod
	 * 
	 * @param isTrialPeriod
	 */
	public void setIsTrialPeriod(String isTrialPeriod)
	{
		this.isTrialPeriod = isTrialPeriod;
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
	 * 获取offerCodeRefName
	 * 
	 * @return
	 */
	public String getOfferCodeRefName()
	{
		return offerCodeRefName;
	}

	/**
	 * 设置offerCodeRefName
	 * 
	 * @param offerCodeRefName
	 */
	public void setOfferCodeRefName(String offerCodeRefName)
	{
		this.offerCodeRefName = offerCodeRefName;
	}

	/**
	 * 获取originalPurchaseDate
	 * 
	 * @return
	 */
	public String getOriginalPurchaseDate()
	{
		return originalPurchaseDate;
	}

	/**
	 * 设置originalPurchaseDate
	 * 
	 * @param originalPurchaseDate
	 */
	public void setOriginalPurchaseDate(String originalPurchaseDate)
	{
		this.originalPurchaseDate = originalPurchaseDate;
	}

	/**
	 * 获取originalPurchaseDateMs
	 * 
	 * @return
	 */
	public String getOriginalPurchaseDateMs()
	{
		return originalPurchaseDateMs;
	}

	/**
	 * 设置originalPurchaseDateMs
	 * 
	 * @param originalPurchaseDateMs
	 */
	public void setOriginalPurchaseDateMs(String originalPurchaseDateMs)
	{
		this.originalPurchaseDateMs = originalPurchaseDateMs;
	}

	/**
	 * 获取originalPurchaseDatePst
	 * 
	 * @return
	 */
	public String getOriginalPurchaseDatePst()
	{
		return originalPurchaseDatePst;
	}

	/**
	 * 设置originalPurchaseDatePst
	 * 
	 * @param originalPurchaseDatePst
	 */
	public void setOriginalPurchaseDatePst(String originalPurchaseDatePst)
	{
		this.originalPurchaseDatePst = originalPurchaseDatePst;
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
	 * 获取promotionalOfferId
	 * 
	 * @return
	 */
	public String getPromotionalOfferId()
	{
		return promotionalOfferId;
	}

	/**
	 * 设置promotionalOfferId
	 * 
	 * @param promotionalOfferId
	 */
	public void setPromotionalOfferId(String promotionalOfferId)
	{
		this.promotionalOfferId = promotionalOfferId;
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
	public String getPurchaseDate()
	{
		return purchaseDate;
	}

	/**
	 * 设置purchaseDate
	 * 
	 * @param purchaseDate
	 */
	public void setPurchaseDate(String purchaseDate)
	{
		this.purchaseDate = purchaseDate;
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

	/**
	 * 获取purchaseDatePst
	 * 
	 * @return
	 */
	public String getPurchaseDatePst()
	{
		return purchaseDatePst;
	}

	/**
	 * 设置purchaseDatePst
	 * 
	 * @param purchaseDatePst
	 */
	public void setPurchaseDatePst(String purchaseDatePst)
	{
		this.purchaseDatePst = purchaseDatePst;
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
	 * 获取subscriptionGroupIdentifier
	 * 
	 * @return
	 */
	public String getSubscriptionGroupIdentifier()
	{
		return subscriptionGroupIdentifier;
	}

	/**
	 * 设置subscriptionGroupIdentifier
	 * 
	 * @param subscriptionGroupIdentifier
	 */
	public void setSubscriptionGroupIdentifier(String subscriptionGroupIdentifier)
	{
		this.subscriptionGroupIdentifier = subscriptionGroupIdentifier;
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
}
