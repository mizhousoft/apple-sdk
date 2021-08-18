package com.mizhousoft.apple.iap.constant;

/**
 * 服务通知类型
 * 参考 https://developer.apple.com/documentation/appstoreservernotifications/notification_type
 *
 * @version
 */
public interface ServerNotificationType
{
	String CANCEL = "CANCEL";

	String DID_CHANGE_RENEWAL_PREF = "DID_CHANGE_RENEWAL_PREF";

	String DID_CHANGE_RENEWAL_STATUS = "DID_CHANGE_RENEWAL_STATUS";

	String DID_FAIL_TO_RENEW = "DID_FAIL_TO_RENEW";

	String DID_RECOVER = "DID_RECOVER";

	String DID_RENEW = "DID_RENEW";

	String INITIAL_BUY = "INITIAL_BUY";

	String INTERACTIVE_RENEWAL = "INTERACTIVE_RENEWAL";

	String PRICE_INCREASE_CONSENT = "PRICE_INCREASE_CONSENT";

	// Indicates that the App Store successfully refunded a transaction for a consumable in-app
	// purchase,
	// a non-consumable in-app purchase, or a non-renewing subscription.
	// The cancellation_date_ms contains the timestamp of the refunded transaction.
	// The original_transaction_id and product_id identify the original transaction and product.
	// The cancellation_reason contains the reason.
	String REFUND = "REFUND";

	String REVOKE = "REVOKE";

	String RENEWAL = "RENEWAL";
}
