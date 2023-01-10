package com.didi.unifiedPay.sdk.internal;

import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.unifiedPay.sdk.internal.api.IUnifiedPayApi;
import com.didi.unifiedPay.sdk.model.PrepayInfo;
import com.didi.unifiedPay.sdk.model.SignObj;
import com.didi.unifiedPay.sdk.net.C15308Util;
import com.didi.unifiedPay.sdk.net.service.IUnipayService;
import com.didi.unifiedPay.util.LogUtil;
import com.taxis99.R;

public abstract class PayMethod {
    public static final int REQUEST_CODE_BANK_PAY = 104;
    public static final int REQUEST_CODE_BIND_PAYPAL = 106;
    public static final int REQUEST_CODE_BIND_VISA_CARD = 100;
    public static final int REQUEST_CODE_SIGN_DDCREDIT = 102;
    public static final int REQUEST_CODE_SIGN_ZFT = 103;

    /* renamed from: d */
    private static final String f47202d = "PayMethod";

    /* renamed from: a */
    private IUnifiedPayApi f47203a;

    /* renamed from: b */
    private int f47204b;

    /* renamed from: c */
    private boolean f47205c = true;
    public FragmentActivity mActivity;
    protected String mAppId = "";
    /* access modifiers changed from: protected */
    public PayCallback mCallback;
    public IUnipayService mPayService;
    public PayServiceCallback<PrepayInfo> mPrepayCallback;

    /* access modifiers changed from: protected */
    public abstract <T> boolean checkDataValid(T t);

    /* access modifiers changed from: protected */
    public abstract <T> boolean checkPaySupport(T t);

    /* access modifiers changed from: protected */
    public boolean passwordCheck(PrepayInfo prepayInfo) {
        return false;
    }

    public boolean supportSign() {
        return false;
    }

    public void setCallbackListener(PayCallback payCallback) {
        this.mCallback = payCallback;
    }

    public void setNeedCheckResult(boolean z) {
        this.f47205c = z;
    }

    public void setUnifiedPayApi(IUnifiedPayApi iUnifiedPayApi) {
        this.f47203a = iUnifiedPayApi;
    }

    public PayCallback getCallbackLisenter() {
        return this.mCallback;
    }

    public void createPay(FragmentActivity fragmentActivity, IUnipayService iUnipayService, String str, PayServiceCallback<PrepayInfo> payServiceCallback) {
        this.mActivity = fragmentActivity;
        this.mPayService = iUnipayService;
        this.mPrepayCallback = payServiceCallback;
        this.mAppId = str;
        m35145a(str);
    }

    public void removeListener() {
        LogUtil.m35172fi(f47202d, "removeListener");
        this.mCallback = null;
        this.mPrepayCallback = null;
        this.f47203a = null;
        UnifiedPayCallback.getInstance().unRegisterAllPayCallback();
    }

    /* renamed from: a */
    private void m35145a(String str) {
        PayCallback payCallback = this.mCallback;
        if (payCallback != null) {
            payCallback.onStartPrepayRequest();
        }
        this.mPayService.prepay(str, (String) null, this.mPrepayCallback);
    }

    public void startSignPage(FragmentActivity fragmentActivity, SignObj signObj) {
        this.mActivity = fragmentActivity;
    }

    /* access modifiers changed from: protected */
    public boolean adyenThreeDSCheck(PrepayInfo prepayInfo) {
        return (prepayInfo == null || prepayInfo.adyen3DSModel == null || prepayInfo.adyen3DSModel.action == null) ? false : true;
    }

    /* access modifiers changed from: protected */
    public boolean cybsThreeDSCheck(PrepayInfo prepayInfo) {
        return (prepayInfo == null || prepayInfo.cybs3DSModel == null || prepayInfo.cybs3DSModel.sessionId == null) ? false : true;
    }

    public boolean onPay(PrepayInfo prepayInfo) {
        if (prepayInfo == null) {
            PayCallback payCallback = this.mCallback;
            if (payCallback != null) {
                payCallback.onPayFail(new PayError(5), this.mActivity.getString(R.string.pay_fail));
            }
            return false;
        }
        this.f47204b = prepayInfo.pay_channel;
        LogUtil.m35172fi(f47202d, "unified pre pay " + C15308Util.jsonFromObject(prepayInfo));
        if (adyenThreeDSCheck(prepayInfo)) {
            prepayInfo.adyen3DSModel.channel = this.f47204b;
            this.mCallback.onAdyenThreeDSActionHandle(prepayInfo.adyen3DSModel);
            return false;
        } else if (cybsThreeDSCheck(prepayInfo)) {
            this.mCallback.onCybsThreeDSActionHandle(prepayInfo.cybs3DSModel);
            return false;
        } else if (passwordCheck(prepayInfo)) {
            PayCallback payCallback2 = this.mCallback;
            if (payCallback2 != null) {
                payCallback2.onPasswordHandle(prepayInfo.mPasswordModel);
            }
            return false;
        } else if (m35146a(prepayInfo)) {
            initPayResultCheckAlarm(prepayInfo);
            return false;
        } else if (m35147b(prepayInfo)) {
            PayCallback payCallback3 = this.mCallback;
            if (payCallback3 != null) {
                payCallback3.onPayFail(new PayError(6), ResourcesHelper.getString(this.mActivity, R.string.oc_pay_closed));
            }
            return false;
        } else if (checkDataValid(prepayInfo)) {
            try {
                if (!checkPaySupport(prepayInfo)) {
                    if (this.mCallback != null) {
                        this.mCallback.onPayFail(new PayError(2), this.mActivity.getString(R.string.oc_uni_pay_not_support));
                    }
                    return false;
                }
                PayCallback payCallback4 = this.mCallback;
                if (payCallback4 == null) {
                    return true;
                }
                payCallback4.onStartPayRequest(getPayChannel(), getAppId());
                return true;
            } catch (Exception unused) {
                PayCallback payCallback5 = this.mCallback;
                if (payCallback5 != null) {
                    payCallback5.onPayFail(new PayError(2), this.mActivity.getString(R.string.oc_uni_pay_not_support));
                }
                return false;
            }
        } else {
            PayCallback payCallback6 = this.mCallback;
            if (payCallback6 != null) {
                payCallback6.onPayFail(new PayError(5), "");
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void initPayResultCheckAlarm(PrepayInfo prepayInfo) {
        LogUtil.m35172fi(f47202d, "initPayResultCheckAlarm mNeedCheckPayResult:" + this.f47205c);
        if (this.f47205c) {
            IUnifiedPayApi iUnifiedPayApi = this.f47203a;
            if (iUnifiedPayApi == null) {
                return;
            }
            if (prepayInfo == null) {
                iUnifiedPayApi.startSyncPayResult(15, 1000);
            } else {
                iUnifiedPayApi.startSyncPayResult(prepayInfo.mPollingTimes, (long) (prepayInfo.mPollingInterval * 1000));
            }
        } else {
            PayCallback payCallback = this.mCallback;
            if (payCallback != null) {
                payCallback.startQueryPayStatus();
            }
        }
    }

    public int getPayChannel() {
        return this.f47204b;
    }

    public void setPayChannel(int i) {
        this.f47204b = i;
    }

    /* access modifiers changed from: protected */
    public String getAppId() {
        return this.mAppId;
    }

    /* renamed from: a */
    private boolean m35146a(PrepayInfo prepayInfo) {
        if (prepayInfo == null) {
            return false;
        }
        return prepayInfo.resultType == 4 || prepayInfo.resultType == 2;
    }

    /* renamed from: b */
    private boolean m35147b(PrepayInfo prepayInfo) {
        return prepayInfo != null && prepayInfo.resultType == 5;
    }
}
