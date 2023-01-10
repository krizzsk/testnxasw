package com.didi.component.service;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseConstants;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.util.CarNotifyManager;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NotificationUtils;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.push.CommonPushManager;
import com.didi.component.common.util.GLog;
import com.didi.component.config.BusinessRegistry;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.core.listener.DefaultDiDiCoreCallback;
import com.didi.travel.psnger.model.event.PayResultEvent;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.IMOrNOSecurity;
import com.didi.travel.psnger.model.response.NextPayResult;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class EndServicePresenter extends AbsServicePresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f17487a = LoggerFactory.getLogger(getClass());

    /* renamed from: b */
    private int f17488b = 0;

    /* renamed from: c */
    private boolean f17489c = false;

    /* renamed from: d */
    private long f17490d;

    /* renamed from: e */
    private final DefaultDiDiCoreCallback f17491e = new DefaultDiDiCoreCallback() {
        public void onPayResultReceive(NextPayResult nextPayResult) {
            super.onPayResultReceive(nextPayResult);
            EndServicePresenter.this.f17487a.info("push callback : payResult Received", new Object[0]);
            CarOrder order = CarOrderHelper.getOrder();
            if (!(order == null || nextPayResult == null)) {
                order.status = 3;
                NotificationUtils.getInstance(EndServicePresenter.this.mContext).hideNotification();
                PayResultEvent payResultEvent = new PayResultEvent();
                payResultEvent.payResultStatus = 10;
                EndServicePresenter.this.doPublish(BaseEventKeys.Service.EndService.EVENT_PAY_RESULT_GOT, payResultEvent);
                EndServicePresenter.this.doPublish(BaseEventKeys.C5174IM.KEY_CATEGORY_IM_CLOSE_SESSION);
                new HashMap().put("oid", order.oid);
            }
            EndServicePresenter.this.f17487a.info("lmf >>>payResult>>push callback", new Object[0]);
            EndServicePresenter.this.processPaySuccess();
        }
    };

    /* renamed from: f */
    private BaseEventPublisher.OnEventListener<String> f17492f = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            if (TextUtils.equals(str, BaseEventKeys.Pay.CATEGORY) && TextUtils.equals(str2, BaseEventKeys.Pay.EVENT_PAYMENT_PAY_SUCCESS)) {
                EndServicePresenter.this.f17487a.info("lmf >>>EVENT_PAYMENT_PAY_SUCCESS>>", new Object[0]);
                EndServicePresenter.this.processPaySuccess();
            }
        }
    };
    protected boolean isDriverAllowContact = GlobalApolloUtil.isDriverAllowContact();

    public EndServicePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        OmegaSDK.putGlobalAttr("g_PageId", GPageIdConstant.G_PAGE_ID_ENDS);
        this.f17488b = bundle.getInt(BaseExtras.Common.EXTRA_ORDER_SOURCE, 0);
        this.f17489c = bundle.getBoolean(BaseExtras.EndService.EXTRA_CANCEL_INTERCEPT_JUMP, false);
        setTitle(ResourcesHelper.getString(this.mContext, R.string.car_title_endservice));
        m14806b();
        if (this.isDriverAllowContact) {
            m14809e();
        }
        GlobalOmegaUtils.trackEvent("Global_endTrip_sw", "g_OrderId", CarOrderHelper.getOrder() == null ? "" : CarOrderHelper.getOrder().oid);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        m14807c();
        if (this.f17488b == 0) {
            CarOrderHelper.saveOrder((CarOrder) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onSubscribeEventReceiver() {
        super.onSubscribeEventReceiver();
        subscribe(BaseEventKeys.Pay.CATEGORY, this.f17492f);
    }

    /* access modifiers changed from: protected */
    public void onUnsubscribeEventReceiver() {
        super.onUnsubscribeEventReceiver();
        unsubscribe(BaseEventKeys.Pay.CATEGORY, this.f17492f);
    }

    public boolean onBackPressed(IPresenter.BackType backType) {
        String str;
        if (this.f17489c) {
            goBackRoot();
            return true;
        }
        if (CarOrderHelper.getOrder() == null) {
            str = "";
        } else {
            str = CarOrderHelper.getOrder().getOid();
        }
        GlobalOmegaUtils.trackEvent(LoginOmegaUtil.PAS_RETURN_CK, "g_OrderId", str);
        if (this.f17488b != 0) {
            CarOrderHelper.saveOrder((CarOrder) null);
            goBack();
        } else {
            goBackRootWithTag();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void goBackRootWithTag() {
        Bundle bundle = new Bundle();
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            bundle.putString(BaseConstants.NormalFinishTrip.LAST_ORDER_PARENT_SID, BusinessRegistry.bid2ParentSid(order.productid));
        }
        bundle.putBoolean(BaseConstants.NormalFinishTrip.NORMAL_FINISH_THE_TRIP, true);
        goBackRoot(bundle);
    }

    /* renamed from: b */
    private void m14806b() {
        CommonPushManager.getInstance().registerDidiPushCoreBack(this.f17491e);
    }

    /* renamed from: c */
    private void m14807c() {
        CommonPushManager.getInstance().unregisterDidiPushCoreBack(this.f17491e);
        CommonPushManager.getInstance().stopPushOrderService();
    }

    /* access modifiers changed from: protected */
    public void processPaySuccess() {
        this.f17487a.info("payEventListener event=BaseEventKeys.Pay.EVENT_PAYMENT_PAY_SUCCESS", new Object[0]);
        CarOrder order = CarOrderHelper.getOrder();
        if (!(order == null || order.status == 6 || order.payResult == null)) {
            if (order.payType == 1024) {
                CarNotifyManager.endServiceWithCashNotification(this.mBusinessContext, this.mContext, order.payResult.actual_pay_money, order.payResult.actual_pay_money_display, order.payResult.actual_deduction, order.payResult.actual_deduction_display);
            } else {
                CarNotifyManager.buildPaySuccessNotify(this.mBusinessContext, this.mContext, order.payResult.actual_pay_money, order.payResult.actual_pay_money_display, order.payResult.actual_deduction, order.payResult.actual_deduction_display, order.isEnterprise());
            }
        }
        refreshOrderStatusOnPaySuccess();
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
        if (this.isDriverAllowContact) {
            m14809e();
        }
        this.f17490d = System.currentTimeMillis();
        m14804a(this.mContext);
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        super.onPagePause();
        m14808d();
    }

    /* renamed from: a */
    private void m14804a(Context context) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("status", Integer.valueOf(order.status));
            hashMap.put("substatus", Integer.valueOf(order.substatus));
            GLog.m11355d("ibt_gp_orderstatus_sw", "status:" + order.status + "....substatus:" + order.substatus, new Exception());
            OmegaSDKAdapter.trackEvent("ibt_gp_orderstatus_sw", (Map<String, Object>) hashMap);
        }
    }

    /* renamed from: d */
    private void m14808d() {
        HashMap hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis() - this.f17490d;
        this.f17490d = currentTimeMillis;
        hashMap.put("time", Long.valueOf(currentTimeMillis));
        GlobalOmegaUtils.trackEvent("ibt_gp_orderstatus_time_sw", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: protected */
    public void refreshOrderStatusOnPaySuccess() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            if (order.status == 5 && (order.substatus == 5002 || order.substatus == 5003)) {
                order.status = 6;
                order.substatus = 6002;
            } else if (order.status == 6) {
                order.substatus = 6002;
            } else {
                order.status = 3;
                order.substatus = 0;
            }
        }
    }

    /* renamed from: e */
    private void m14809e() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && order.oid != null && this.mContext != null) {
            CarRequest.getSecurityConfig(this.mContext, order.oid, new ResponseListener<IMOrNOSecurity>() {
                public void onSuccess(IMOrNOSecurity iMOrNOSecurity) {
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Phone.EVENT_ALLOW_CONTACT_DRIVER, Boolean.valueOf(iMOrNOSecurity != null && iMOrNOSecurity.allowContactDriver));
                }
            });
        }
    }
}
