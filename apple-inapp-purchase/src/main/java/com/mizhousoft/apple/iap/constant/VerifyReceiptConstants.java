package com.mizhousoft.apple.iap.constant;

/**
 * 常量
 *
 * @version
 */
public interface VerifyReceiptConstants
{
	// 成功
	int VERIFY_SUCCESS = 0;

	// This receipt is from the test environment, but it was sent to the production environment for
	// verification.
	int VERIFY_FAIL_TRY_TEST_ENV = 21007;

	// Internal data access error. Try again later.
	int VERIFY_FAIL_TRY_AGAIN = 21009;
}
