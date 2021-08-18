package com.mizhousoft.apple.iap.constant;

/**
 * 过期原因
 *
 * @version
 */
public interface ExpirationIntent
{
	// The customer voluntarily canceled their subscription.
	int CUSTOMER_CANCELED = 1;

	// Billing error; for example, the customer's payment information was no longer valid.
	int BILLING_ERROR = 2;

	// The customer did not agree to a recent price increase.
	int CUSTOMER_DENIED_PRICE_INCREASE = 3;

	// The product was not available for purchase at the time of renewal.
	int PRODUCT_NOT_AVAILABLE = 4;

	// Unknown error.
	int UNKNOWN = 5;
}
