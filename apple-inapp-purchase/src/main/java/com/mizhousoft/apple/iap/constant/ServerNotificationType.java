package com.mizhousoft.apple.iap.constant;

/**
 * 服务通知类型
 * 参考 https://developer.apple.com/documentation/appstoreservernotifications/notification_type
 *
 * @version
 */
public interface ServerNotificationType
{
	// 表示客户对消耗品内购发起退款申请，App Store 要求您提供消费数据。
	String CONSUMPTION_REQUEST = "CONSUMPTION_REQUEST";

	String DID_CHANGE_RENEWAL_PREF = "DID_CHANGE_RENEWAL_PREF";

	// 指示用户对订阅续订状态进行了更改
	String DID_CHANGE_RENEWAL_STATUS = "DID_CHANGE_RENEWAL_STATUS";

	// 由于计费问题而未能续订。订阅进入计费重试期。
	String DID_FAIL_TO_RENEW = "DID_FAIL_TO_RENEW";

	// 指示订阅成功续订
	String DID_RENEW = "DID_RENEW";

	// 订阅已过期
	String EXPIRED = "EXPIRED";

	// 示计费宽限期已结束，无需续订，因此您可以关闭对服务或内容的访问。
	String GRACE_PERIOD_EXPIRED = "GRACE_PERIOD_EXPIRED";

	String OFFER_REDEEMED = "OFFER_REDEEMED";

	// 系统已通知用户订阅价格上涨
	String PRICE_INCREASE = "PRICE_INCREASE";

	// 表示 App Store 成功为消耗性应用内购买、非消耗性应用内购买、自动续订订阅或非续订订阅的交易退款。
	String REFUND = "REFUND";

	// 表示 App Store 拒绝了应用开发者发起的退款请求。
	String REFUND_DECLINED = "REFUND_DECLINED";

	String REFUND_REVERSED = "REFUND_REVERSED";

	// 表示 App Store 延长了开发者要求的订阅续订日期。
	String RENEWAL_EXTENDED = "RENEWAL_EXTENDED";

	String RENEWAL_EXTENSION = "RENEWAL_EXTENSION";

	String REVOKE = "REVOKE";

	String SUBSCRIBED = "SUBSCRIBED";

	String TEST = "TEST";
}
