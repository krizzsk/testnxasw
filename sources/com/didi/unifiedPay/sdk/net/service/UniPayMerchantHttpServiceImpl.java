package com.didi.unifiedPay.sdk.net.service;

import android.content.Context;
import android.text.TextUtils;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.unifiedPay.component.presenter.PayInfoManager;
import com.didi.unifiedPay.sdk.internal.PayConstant;
import com.didi.unifiedPay.sdk.internal.PayServiceCallback;
import com.didi.unifiedPay.sdk.model.PayInfo;
import com.didi.unifiedPay.sdk.model.PayStatus;
import com.didi.unifiedPay.sdk.model.PrepayInfo;
import com.didi.unifiedPay.sdk.net.C15308Util;
import com.didi.unifiedPay.sdk.net.Helper;
import com.didi.unifiedPay.sdk.net.api.merchant.MerchantGetPayInfo;
import com.didi.unifiedPay.sdk.net.api.merchant.MerchantPrepay;
import com.didi.unifiedPay.sdk.net.api.trip.ChangePayInfo;
import com.didi.unifiedPay.sdk.net.api.trip.GetPayStatus;
import com.didi.unifiedPay.sdk.net.config.Config;
import com.didi.unifiedPay.sdk.net.service.IUnipayService;
import com.didi.unifiedPay.util.DeviceUtil;
import com.didi.unifiedPay.util.UniPayParamUtil;
import global.didi.pay.merchant.processor.model.MerchantRequestType;
import global.didi.pay.merchantcore.model.DPayRequest;
import global.didi.pay.threeds.utils.ThreeDSUtils;
import org.json.JSONObject;

public class UniPayMerchantHttpServiceImpl extends UniPayTripHttpServiceImpl {

    /* renamed from: a */
    private static final String f47238a = UniPayMerchantHttpServiceImpl.class.getSimpleName();

    /* renamed from: b */
    private DPayRequest f47239b;

    /* renamed from: c */
    private String f47240c;

    /* renamed from: d */
    private JSONObject f47241d;

    /* renamed from: e */
    private MerchantRequestType f47242e;

    public UniPayMerchantHttpServiceImpl(Context context) {
        super(context);
    }

    public void init(PayParam payParam, MerchantRequestType merchantRequestType, DPayRequest dPayRequest, JSONObject jSONObject) {
        this.f47242e = merchantRequestType;
        this.f47239b = dPayRequest;
        this.f47241d = jSONObject;
        this.f47240c = payParam.outTradeId;
        this.mHelper = new Helper();
        this.mConfig = new Config(PayConstant.PayBillType.NoneTrip);
        this.mClient = this.mHelper.getHttpClient(this.mContext);
    }

    public void getPayInfo(PayServiceCallback<PayInfo> payServiceCallback) {
        MerchantGetPayInfo merchantGetPayInfo = new MerchantGetPayInfo();
        DPayRequest dPayRequest = this.f47239b;
        if (dPayRequest != null) {
            merchantGetPayInfo.merchant_order_id = dPayRequest.getMerchantOrderId();
            merchantGetPayInfo.pay_order_id = this.f47239b.getPayOrderId();
            merchantGetPayInfo.merchant_id = this.f47239b.getMerchantId();
            merchantGetPayInfo.app_id = this.f47239b.getAppId();
            merchantGetPayInfo.timestamp = this.f47239b.getTimestamp();
            merchantGetPayInfo.nonce_str = this.f47239b.getNonceStr();
            merchantGetPayInfo.version = this.f47239b.getVersion();
            merchantGetPayInfo.sign = this.f47239b.getSign();
        }
        if (!TextUtils.isEmpty(this.f47240c)) {
            merchantGetPayInfo.out_trade_id = this.f47240c;
        }
        if (this.f47242e != null) {
            int i = C153165.f47243xbda6abad[this.f47242e.ordinal()];
            if (i == 1) {
                merchantGetPayInfo.from_type = "MERCHANT_SDK";
            } else if (i == 2) {
                merchantGetPayInfo.from_type = "H5";
            } else if (i == 3) {
                merchantGetPayInfo.from_type = "PC";
            }
        }
        request(merchantGetPayInfo, payServiceCallback, new IUnipayService.Interceptor<PayInfo>() {
            public void onSuccess(PayInfo payInfo) {
                if (payInfo != null) {
                    UniPayMerchantHttpServiceImpl.this.interceptPayInfo(payInfo);
                }
            }
        }, PayInfo.class);
    }

    /* renamed from: com.didi.unifiedPay.sdk.net.service.UniPayMerchantHttpServiceImpl$5 */
    static /* synthetic */ class C153165 {

        /* renamed from: $SwitchMap$global$didi$pay$merchant$processor$model$MerchantRequestType */
        static final /* synthetic */ int[] f47243xbda6abad;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                global.didi.pay.merchant.processor.model.MerchantRequestType[] r0 = global.didi.pay.merchant.processor.model.MerchantRequestType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f47243xbda6abad = r0
                global.didi.pay.merchant.processor.model.MerchantRequestType r1 = global.didi.pay.merchant.processor.model.MerchantRequestType.TYPE_MERCHANT_SDK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f47243xbda6abad     // Catch:{ NoSuchFieldError -> 0x001d }
                global.didi.pay.merchant.processor.model.MerchantRequestType r1 = global.didi.pay.merchant.processor.model.MerchantRequestType.TYPE_H5     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f47243xbda6abad     // Catch:{ NoSuchFieldError -> 0x0028 }
                global.didi.pay.merchant.processor.model.MerchantRequestType r1 = global.didi.pay.merchant.processor.model.MerchantRequestType.TYPE_PC     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.unifiedPay.sdk.net.service.UniPayMerchantHttpServiceImpl.C153165.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void interceptPayInfo(PayInfo payInfo) {
        super.interceptPayInfo(payInfo);
        if (!TextUtils.isEmpty(payInfo.outTradeId)) {
            this.f47240c = payInfo.outTradeId;
        }
    }

    public void prepay(String str, String str2, PayServiceCallback<PrepayInfo> payServiceCallback) {
        MerchantPrepay merchantPrepay = new MerchantPrepay();
        merchantPrepay.coupon_id = this.mCouponId;
        merchantPrepay.activity_id = this.mActivityId;
        merchantPrepay.out_trade_id = this.f47240c;
        JSONObject jSONObject = this.f47241d;
        if (jSONObject != null) {
            merchantPrepay.merchant_wsgenv = jSONObject.optString("wsgenv");
        }
        if (this.arrSelectedPayChannels == null || this.arrSelectedPayChannels.size() <= 0) {
            merchantPrepay.pay_channel = this.mPayChannelType;
        } else {
            merchantPrepay.pay_channels = getPayChannels();
        }
        if (!TextUtils.isEmpty(this.mInstallmentNumber)) {
            merchantPrepay.installment_number = this.mInstallmentNumber;
        }
        if (!TextUtils.isEmpty(this.mPassword)) {
            merchantPrepay.password_token = this.mPassword;
        }
        this.mPassword = null;
        if (this.mCybsDataResponse != null) {
            merchantPrepay.three_ds_v2 = C15308Util.jsonFromObject(this.mCybsDataResponse);
        }
        this.mCybsDataResponse = null;
        merchantPrepay.threeds_callback_scheme = ThreeDSUtils.getCallbackUrl(DeviceUtil.getPackageName(this.mContext));
        request(merchantPrepay, payServiceCallback, new IUnipayService.Interceptor<PrepayInfo>() {
            public void onSuccess(PrepayInfo prepayInfo) {
            }
        }, PrepayInfo.class);
    }

    public void getPayStatus(PayServiceCallback<PayStatus> payServiceCallback) {
        GetPayStatus getPayStatus = new GetPayStatus();
        getPayStatus.out_trade_id = this.f47240c;
        request(getPayStatus, payServiceCallback, new IUnipayService.Interceptor<PayStatus>() {
            public void onSuccess(PayStatus payStatus) {
                PayInfoManager.getInstance(UniPayParamUtil.getLang()).setPayStatus("MerchantOidPlaceHolder", payStatus);
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
        changePayInfo.out_trade_id = this.f47240c;
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
                UniPayMerchantHttpServiceImpl.this.interceptPayInfo(payInfo);
            }
        }, PayInfo.class);
    }
}
