package com.didi.component.payment.presenter.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.util.CarNotifyManager;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.UniPayManager;
import com.didi.component.common.util.GLog;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.unifiedPay.component.IViewCallback;
import com.didi.unifiedPay.component.model.DDCreditParam;
import com.didi.unifiedPay.component.model.PayState;
import com.didi.unifiedPay.sdk.internal.PayError;
import com.didi.unifiedPay.sdk.model.PayInfo;
import com.didi.unifiedPay.sdk.model.PaySuccessMessage;
import com.taxis99.R;
import global.didi.pay.IGlobalPayView;
import global.didi.pay.presenter.GlobalAbsPaymentPresenter;

public class GlobalBridgePaymentPresenter extends GlobalAbsPaymentPresenter {

    /* renamed from: a */
    private static final String f16942a = GlobalBridgePaymentPresenter.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Logger f16943b = LoggerFactory.getLogger(getClass());

    /* renamed from: c */
    private UniPayManager f16944c;

    /* renamed from: d */
    private boolean f16945d = false;

    /* renamed from: e */
    private String f16946e;

    /* renamed from: f */
    private String f16947f;

    /* access modifiers changed from: protected */
    public void gotoCostObjectionActivity(PayInfo payInfo, int i) {
    }

    /* access modifiers changed from: protected */
    public void gotoDDCreditSignActivity(DDCreditParam dDCreditParam, int i) {
    }

    public GlobalBridgePaymentPresenter(Context context, FragmentManager fragmentManager, String str, String str2, String str3, IViewCallback iViewCallback) {
        super(context, fragmentManager, str, iViewCallback);
        this.f16946e = str2;
        this.f16947f = str3;
        this.f16944c = new UniPayManager();
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.f16944c.registerPushListener(this.mContext, f16942a);
        boolean z = false;
        if (bundle.getInt(BaseExtras.EndService.EXTRA_FIRST_VIEW, 0) == 2) {
            z = true;
        }
        this.f16945d = z;
    }

    /* access modifiers changed from: protected */
    public void requestPayInfoResult(boolean z, PayInfo payInfo, String str, int i) {
        ((IGlobalPayView) this.mView).hideLoadingPop(true);
        if (z) {
            int i2 = payInfo.payStatus;
            m14186a(i2);
            if (i2 == 6) {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Pay.CATEGORY, BaseEventKeys.Pay.EVENT_PAYMENT_PAY_FAIL_RISK);
            } else {
                super.requestPayInfoResult(z, payInfo, str, i);
            }
        } else {
            GLog.m11354d(f16942a, "getPayinfo接口获取失败，展示errorview");
            ((IGlobalPayView) this.mView).setTitle(true, this.mContext.getResources().getString(R.string.pay_fail), str);
            showRetryView();
        }
    }

    /* renamed from: a */
    private void m14186a(int i) {
        if (i != 3 && i != 5 && i != 7) {
            CarNotifyManager.autoPayFailNotification(this.mContext);
        }
    }

    public void onPaySuccessMessageCreated(PaySuccessMessage paySuccessMessage) {
        CarOrder order;
        super.onPaySuccessMessageCreated(paySuccessMessage);
        if (paySuccessMessage != null && paySuccessMessage.voucherValue > 0 && (order = CarOrderHelper.getOrder()) != null && order.payResult != null) {
            order.payResult.actual_deduction = String.valueOf(paySuccessMessage.voucherValue / 100);
        }
    }

    /* access modifiers changed from: protected */
    public void onPaySuccessed(int i, String str) {
        this.f16943b.info(" onPaySuccessed", new Object[0]);
        PayState payState = this.mCurrentState;
        super.onPaySuccessed(i, str);
        if (payState != PayState.PaySuccess && this.mCurrentState == PayState.PaySuccess) {
            m14185a();
        }
    }

    /* renamed from: a */
    private void m14185a() {
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                if (GlobalBridgePaymentPresenter.this.mView != null) {
                    ((IGlobalPayView) GlobalBridgePaymentPresenter.this.mView).hideLoadingPop(false);
                }
                GlobalBridgePaymentPresenter.this.f16943b.info("lmf >>>sendPaySuccessedEvent>>", new Object[0]);
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Pay.CATEGORY, BaseEventKeys.Pay.EVENT_PAYMENT_PAY_SUCCESS);
            }
        }, 1000);
    }

    /* access modifiers changed from: protected */
    public void onPrePayFailed(int i, String str) {
        GLog.m11354d(f16942a, "onPrePayFailed");
        ((IGlobalPayView) this.mView).hideLoadingPop(true);
        super.onPrePayFailed(i, str);
    }

    public void onPayFailed(PayError payError, String str) {
        String str2 = f16942a;
        GLog.m11354d(str2, "onPayFailed" + payError.errorCode);
        ((IGlobalPayView) this.mView).hideLoadingPop(true);
        int i = payError.errorCode;
        if (i == 3) {
            String str3 = f16942a;
            GLog.m11354d(str3, "onPayFailed isPayMentShow:" + this.f16945d);
            if (this.f16945d) {
                m14188b();
                this.f16945d = false;
                return;
            }
            super.onPayFailed(payError, str);
        } else if (i != 500101) {
            super.onPayFailed(payError, str);
        } else {
            ((IGlobalPayView) this.mView).setTitle(true, this.mContext.getResources().getString(R.string.pay_fail), str);
        }
    }

    /* renamed from: b */
    private void m14188b() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Pay.CATEGORY, BaseEventKeys.Pay.EVENT_PAYMENT_PAY_WAIT);
    }

    public void onRemove() {
        super.onRemove();
        this.f16944c.unregisterPushListener();
        if (this.mView != null) {
            ((IGlobalPayView) this.mView).hideLoadingPop(false);
        }
    }

    public void onShowFeeDetailClick() {
        super.onShowFeeDetailClick();
    }

    /* access modifiers changed from: protected */
    public void onViewFilled() {
        GLog.m11354d(f16942a, "onViewFilled");
    }

    public boolean onClose() {
        super.onClose();
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Pay.CATEGORY, BaseEventKeys.Pay.EVENT_PAYMENT_CLOSE);
        return false;
    }

    /* access modifiers changed from: protected */
    public int getBid() {
        try {
            return Integer.parseInt(this.f16946e);
        } catch (Exception unused) {
            return 256;
        }
    }

    /* access modifiers changed from: protected */
    public String getOrderId() {
        SystemUtils.log(6, "OidNullCheck", "oid:" + this.f16947f, new Exception(), "com.didi.component.payment.presenter.impl.GlobalBridgePaymentPresenter", 228);
        return !TextUtils.isEmpty(this.f16947f) ? this.f16947f : "";
    }
}
