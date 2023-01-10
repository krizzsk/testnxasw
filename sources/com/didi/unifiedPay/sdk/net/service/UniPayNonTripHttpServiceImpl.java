package com.didi.unifiedPay.sdk.net.service;

import android.content.Context;
import android.text.TextUtils;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.unifiedPay.sdk.internal.PayConstant;
import com.didi.unifiedPay.sdk.internal.PayServiceCallback;
import com.didi.unifiedPay.sdk.model.PayInfo;
import com.didi.unifiedPay.sdk.model.PayStatus;
import com.didi.unifiedPay.sdk.model.PrepayInfo;
import com.didi.unifiedPay.sdk.net.C15308Util;
import com.didi.unifiedPay.sdk.net.Error;
import com.didi.unifiedPay.sdk.net.Helper;
import com.didi.unifiedPay.sdk.net.api.nontrip.NonTripGetPayInfo;
import com.didi.unifiedPay.sdk.net.api.trip.ChangePayInfo;
import com.didi.unifiedPay.sdk.net.api.trip.GetPayStatus;
import com.didi.unifiedPay.sdk.net.api.trip.Prepay;
import com.didi.unifiedPay.sdk.net.config.Config;
import com.didi.unifiedPay.sdk.net.service.IUnipayService;
import com.didi.unifiedPay.util.DeviceUtil;
import com.didi.unifiedPay.util.LogUtil;
import com.didi.unifiedPay.util.UnipayAppUtil;
import com.taxis99.R;
import global.didi.pay.threeds.utils.ThreeDSUtils;

public class UniPayNonTripHttpServiceImpl extends UniPayTripHttpServiceImpl {

    /* renamed from: a */
    private static final String f47244a = UniPayNonTripHttpServiceImpl.class.getSimpleName();

    /* renamed from: b */
    private String f47245b;

    /* renamed from: c */
    private String f47246c;

    /* renamed from: d */
    private String f47247d;

    /* renamed from: e */
    private String f47248e;

    public UniPayNonTripHttpServiceImpl(Context context) {
        super(context);
    }

    public void init(PayParam payParam) {
        this.f47245b = payParam.sign;
        this.f47246c = payParam.signType;
        this.f47247d = payParam.bizContent;
        this.f47248e = payParam.outTradeId;
        this.mHelper = new Helper();
        this.mConfig = new Config(PayConstant.PayBillType.NoneTrip);
        this.mClient = this.mHelper.getHttpClient(this.mContext);
    }

    public void getPayInfo(PayServiceCallback<PayInfo> payServiceCallback) {
        if (!TextUtils.isEmpty(this.f47245b) || !TextUtils.isEmpty(this.f47247d) || !TextUtils.isEmpty(this.f47248e)) {
            NonTripGetPayInfo nonTripGetPayInfo = new NonTripGetPayInfo();
            nonTripGetPayInfo.sign = this.f47245b;
            nonTripGetPayInfo.sign_type = this.f47246c;
            nonTripGetPayInfo.biz_content = this.f47247d;
            nonTripGetPayInfo.out_trade_id = this.f47248e;
            request(nonTripGetPayInfo, payServiceCallback, new IUnipayService.Interceptor<PayInfo>() {
                public void onSuccess(PayInfo payInfo) {
                    if (payInfo != null) {
                        UniPayNonTripHttpServiceImpl.this.interceptPayInfo(payInfo);
                    }
                }
            }, PayInfo.class);
            return;
        }
        LogUtil.m35171d(f47244a, "sign or bizContent is null");
        if (payServiceCallback != null) {
            payServiceCallback.onFail(new Error(-1, this.mContext.getString(R.string.oc_pay_net_failed)));
        }
    }

    /* access modifiers changed from: protected */
    public void interceptPayInfo(PayInfo payInfo) {
        super.interceptPayInfo(payInfo);
        if (!TextUtils.isEmpty(payInfo.outTradeId)) {
            this.f47248e = payInfo.outTradeId;
        }
    }

    public void prepay(String str, String str2, PayServiceCallback<PrepayInfo> payServiceCallback) {
        Prepay prepay = new Prepay();
        prepay.biz_pay_type = this.mPayType;
        prepay.coupon_id = this.mCouponId;
        prepay.activity_id = this.mActivityId;
        prepay.out_trade_id = this.f47248e;
        if (this.arrSelectedPayChannels == null || this.arrSelectedPayChannels.size() <= 0) {
            prepay.pay_channel = this.mPayChannelType;
        } else {
            prepay.pay_channels = getPayChannels();
        }
        if (!TextUtils.isEmpty(this.mInstallmentNumber)) {
            prepay.installment_number = this.mInstallmentNumber;
        }
        if (!TextUtils.isEmpty(this.mPassword)) {
            prepay.password_token = this.mPassword;
        }
        this.mPassword = null;
        prepay.threeds_callback_scheme = ThreeDSUtils.getCallbackUrl(DeviceUtil.getPackageName(this.mContext));
        if (this.mCybsDataResponse != null) {
            prepay.three_ds_v2 = C15308Util.jsonFromObject(this.mCybsDataResponse);
        }
        this.mCybsDataResponse = null;
        if (!TextUtils.isEmpty(UnipayAppUtil.getMetaDataByKey(this.mContext, "paypayScheme"))) {
            prepay.redirect_scheme = UnipayAppUtil.getMetaDataByKey(this.mContext, "paypayScheme");
        }
        request(prepay, payServiceCallback, new IUnipayService.Interceptor<PrepayInfo>() {
            public void onSuccess(PrepayInfo prepayInfo) {
            }
        }, PrepayInfo.class);
    }

    public void getPayStatus(PayServiceCallback<PayStatus> payServiceCallback) {
        GetPayStatus getPayStatus = new GetPayStatus();
        getPayStatus.out_trade_id = this.f47248e;
        request(getPayStatus, payServiceCallback, new IUnipayService.Interceptor<PayStatus>() {
            public void onSuccess(PayStatus payStatus) {
            }
        }, PayStatus.class);
    }

    public void changePayInfo(int i, PayServiceCallback<PayInfo> payServiceCallback) {
        ChangePayInfo changePayInfo = new ChangePayInfo();
        changePayInfo.biz_pay_type = this.mPayType;
        changePayInfo.coupon_id = this.mCouponId;
        changePayInfo.activity_id = this.mActivityId;
        changePayInfo.user_select = this.mUserLastSelectType;
        changePayInfo.change_type = i;
        changePayInfo.out_trade_id = this.f47248e;
        if (this.arrSelectedPayChannels == null || this.arrSelectedPayChannels.size() <= 0) {
            changePayInfo.pay_channel = this.mPayChannelType;
        } else {
            changePayInfo.pay_channels = getPayChannels();
        }
        if (!TextUtils.isEmpty(this.mInstallmentNumber)) {
            changePayInfo.installment_number = this.mInstallmentNumber;
        }
        request(changePayInfo, payServiceCallback, new IUnipayService.Interceptor<PayInfo>() {
            public void onSuccess(PayInfo payInfo) {
                UniPayNonTripHttpServiceImpl.this.interceptPayInfo(payInfo);
            }
        }, PayInfo.class);
    }
}
