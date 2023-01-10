package com.didi.component.payentrance.newui.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.app.SchemeDispatcherImpl;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.business.xpanelnew.IXpCardBindDataReady;
import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.base.ComponentWrap;
import com.didi.component.common.util.DebugUtilsKt;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.payentrance.activity.confirmfare.ConfirmFareActivity;
import com.didi.component.payentrance.newui.view.NewUiIPayEntranceViewContainer;
import com.didi.component.payentrance.presenter.AbsUnifiedPayEntrancePresenter;
import com.didi.component.payentrance.view.IPayEntranceView;
import com.didi.component.payentrance.view.IPayEntranceViewContainer;
import com.didi.component.payentrance.view.Mode;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.utils.UIThreadHandler;
import com.didi.unifiedPay.sdk.internal.PayServiceCallback;
import com.didi.unifiedPay.sdk.model.BasicBill;
import com.didi.unifiedPay.sdk.model.BasicPayInfo;
import com.didi.unifiedPay.sdk.model.PayInfo;
import com.didi.unifiedPay.sdk.model.PayStatus;
import com.didi.unifiedPay.sdk.net.Error;
import com.didi.unifiedPay.sdk.net.service.IUnipayService;
import com.didi.unifiedPay.util.UnipayTextUtil;
import com.didiglobal.ddmirror.reporter.MReporter;
import com.taxis99.R;
import global.didi.pay.GlobalUniPayService;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class NewUIUnifiedPayEntrancePresenter extends AbsUnifiedPayEntrancePresenter implements IXpCardBindDataReady, IPayEntranceView.OnBindCardClickListener {

    /* renamed from: a */
    private static final String f16761a = NewUIUnifiedPayEntrancePresenter.class.getSimpleName();

    /* renamed from: i */
    private static final int f16762i = 5000;

    /* renamed from: j */
    private static final int f16763j = 101;

    /* renamed from: b */
    private IXpCardBindDataReadyCallback f16764b;

    /* renamed from: c */
    private boolean f16765c = false;

    /* renamed from: d */
    private boolean f16766d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f16767e = false;

    /* renamed from: f */
    private GlobalUniPayService f16768f = new GlobalUniPayService();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IUnipayService f16769g;

    /* renamed from: h */
    private LoopHandler f16770h;

    /* renamed from: k */
    private boolean f16771k;

    /* renamed from: l */
    private boolean f16772l;

    /* renamed from: m */
    private boolean f16773m;

    /* renamed from: n */
    private boolean f16774n = false;

    /* renamed from: p */
    private boolean f16775p = false;

    /* renamed from: q */
    private BaseEventPublisher.OnEventListener f16776q = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            if (TextUtils.equals(BaseEventKeys.Pay.CATEGORY, str) && TextUtils.equals(BaseEventKeys.Pay.EVENT_PAYENTANCE_REFRESH, str2)) {
                NewUIUnifiedPayEntrancePresenter.this.refreshOrderBill();
            }
        }
    };

    /* access modifiers changed from: protected */
    public void initOrderBill() {
    }

    public NewUIUnifiedPayEntrancePresenter(ComponentParams componentParams) {
        super("", componentParams, ((FragmentActivity) componentParams.bizCtx.getContext()).getSupportFragmentManager(), componentParams.extras);
    }

    /* access modifiers changed from: protected */
    public int getBid() {
        try {
            return Integer.parseInt(BusinessDataUtil.getProductId());
        } catch (Exception unused) {
            return 256;
        }
    }

    /* access modifiers changed from: protected */
    public String getOrderId() {
        CarOrder order = CarOrderHelper.getOrder();
        return order != null ? order.oid : "";
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        ((IPayEntranceViewContainer) this.mView).setMode((Mode) null);
        subscribe(BaseEventKeys.Pay.CATEGORY, this.f16776q);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Pay.CATEGORY, this.f16776q);
    }

    /* access modifiers changed from: protected */
    public void setupOrderCanceledNoFeeView(CarOrder carOrder) {
        super.setupOrderCanceledNoFeeView(carOrder);
        onViewReady(false);
    }

    /* access modifiers changed from: protected */
    public void whenAddedWithNoOrderId() {
        this.f16765c = true;
    }

    /* access modifiers changed from: protected */
    public void handlePayInfo(BasicPayInfo basicPayInfo) {
        boolean z;
        if (basicPayInfo != null && basicPayInfo.payStatus == 6) {
            doPublish(BaseEventKeys.Pay.CATEGORY, BaseEventKeys.Pay.EVENT_PAYMENT_PAY_FAIL_RISK);
        }
        this.mBasicPayInfo = basicPayInfo;
        if (this.mBasicPayInfo == null) {
            ((IPayEntranceViewContainer) this.mView).showError((CharSequence) null);
            onViewReady(false);
            return;
        }
        if (!handleBlockStep(this.mBasicPayInfo)) {
            handlePayState(basicPayInfo);
            if (basicPayInfo.payStatus == 4 || basicPayInfo.payStatus == 1) {
                setupView(basicPayInfo, false, false);
            }
        }
        doPublish(BaseEventKeys.Service.EndService.EVENT_BASIC_PAY_INFO, basicPayInfo);
        if (this.isViewReady != null && (z = this.f16772l) != this.f16771k) {
            this.f16771k = z;
            XEngineReq.pageRequest(XERequestKey.SCENE_TRIP);
        }
    }

    /* access modifiers changed from: protected */
    public void handleWhenPaySuccess() {
        ((NewUiIPayEntranceViewContainer) this.mView).setBtnClickable(false);
        if (m14110c()) {
            XEngineReq.pageRequest(XERequestKey.SCENE_TRIP);
        }
    }

    /* renamed from: c */
    private boolean m14110c() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null || order.orderSource == 1 || order.orderSource == 2 || order.orderSource == 3) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void handlePayState(BasicPayInfo basicPayInfo) {
        switch (basicPayInfo.payStatus) {
            case 0:
                ((IPayEntranceViewContainer) this.mView).showError(ResourcesHelper.getString(this.mContext, R.string.oc_pay_bill_refresh_failed));
                onViewReady(false);
                return;
            case 1:
            case 4:
                if (this.mIsFromPayView) {
                    setupView(basicPayInfo, false, false);
                    return;
                } else if (this.f16767e) {
                    this.f16767e = false;
                    goPayPage();
                    return;
                } else {
                    return;
                }
            case 2:
                if (!this.mIsPayMentShow) {
                    handlePayWait(basicPayInfo);
                    return;
                }
                return;
            case 3:
                onViewReady(false);
                ((NewUiIPayEntranceViewContainer) this.mView).setBtnClickable(false);
                return;
            case 5:
            case 7:
                onViewReady(false);
                return;
            case 6:
                setupView(basicPayInfo, false, false);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void setupView(BasicPayInfo basicPayInfo, boolean z, boolean z2) {
        super.setupView(basicPayInfo, z, z2);
        ((NewUiIPayEntranceViewContainer) this.mView).setTitle(basicPayInfo.payTitle);
        if (!this.f16774n) {
            ((IPayEntranceViewContainer) this.mView).setFeeDescribe(basicPayInfo.statusMsg);
        }
        if (!TextUtils.isEmpty(basicPayInfo.payStatusSubtitle)) {
            ((IPayEntranceViewContainer) this.mView).setFeeDescribe(basicPayInfo.payStatusSubtitle);
            ((NewUiIPayEntranceViewContainer) this.mView).setPayInfo(basicPayInfo);
        }
        this.isViewReady = true;
        onViewReady(this.isViewReady.booleanValue());
    }

    /* access modifiers changed from: protected */
    public boolean handleBlockStep(BasicPayInfo basicPayInfo) {
        ((IPayEntranceViewContainer) this.mView).showBindCard(false);
        boolean z = true;
        if (basicPayInfo.payStatus != 6 || basicPayInfo.riskInfo == null) {
            int i = basicPayInfo.blockType;
            if (i == 1) {
                return false;
            }
            if (i != 2) {
                if (i == 3) {
                    if (basicPayInfo.confirmInfo == null) {
                        z = false;
                    } else if (!this.f16775p) {
                        this.f16775p = true;
                        Intent intent = new Intent(this.mContext, ConfirmFareActivity.class);
                        intent.putExtra(AbsUnifiedPayEntrancePresenter.EXTRA_PIN_ERR_KEY, basicPayInfo.confirmInfo);
                        if (basicPayInfo.billBasic != null) {
                            intent.putExtra(AbsUnifiedPayEntrancePresenter.EXTRA_PIN_CURRENCY_KEY, basicPayInfo.billBasic.currencySymbol);
                        }
                        startActivityForResult(intent, 101);
                    }
                    onViewReady(false);
                    return z;
                } else if (i != 5 || basicPayInfo.statusMsg == null) {
                    return false;
                } else {
                    m14108b(basicPayInfo);
                }
            } else if (basicPayInfo.riskInfo == null) {
                return false;
            } else {
                m14104a(basicPayInfo);
            }
            return true;
        }
        m14104a(basicPayInfo);
        return true;
    }

    /* renamed from: a */
    private void m14105a(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(SchemeDispatcherImpl.HOST_PAY, Integer.valueOf(z ? 1 : 2));
        GlobalOmegaUtils.trackEvent("Brazil_endTrip_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private void m14104a(BasicPayInfo basicPayInfo) {
        if (basicPayInfo != null && basicPayInfo.billBasic != null) {
            m14105a(false);
            BasicBill basicBill = basicPayInfo.billBasic;
            ((IPayEntranceViewContainer) this.mView).setActionButtonEnable(false);
            doPublish(BaseEventKeys.Pay.CATEGORY, BaseEventKeys.Pay.EVENT_PAYMENT_PAY_FAIL_RISK);
            if (basicPayInfo.riskInfo != null && !TextUtil.isEmpty(basicPayInfo.riskInfo.riskMessage)) {
                this.f16774n = true;
                ((IPayEntranceViewContainer) this.mView).setFeeDescribe(UnipayTextUtil.handleString(basicPayInfo.riskInfo.riskMessage));
            } else if (!TextUtil.isEmpty(basicBill.billText)) {
                this.f16774n = true;
                ((IPayEntranceViewContainer) this.mView).setFeeDescribe(UnipayTextUtil.handleString(basicBill.billText));
            } else if (!(CarOrderHelper.getOrder() == null || CarOrderHelper.getOrder().couponInfo == null || TextUtils.isEmpty(CarOrderHelper.getOrder().couponInfo.couponText))) {
                this.f16774n = true;
                ((IPayEntranceViewContainer) this.mView).setFeeDescribe(CarOrderHelper.getOrder().couponInfo.couponText);
            }
            m14103a(basicBill);
            if (isFeeObjection()) {
                ((IPayEntranceViewContainer) this.mView).setActionText(this.mContext.getString(R.string.pe_car_pay_entrance_title));
            } else {
                ((IPayEntranceViewContainer) this.mView).setActionText(this.mContext.getString(R.string.pe_car_pay_entrance_title_4cancel));
            }
            this.f16766d = true;
            onViewReady(true);
        }
    }

    /* renamed from: b */
    private void m14108b(BasicPayInfo basicPayInfo) {
        if (basicPayInfo != null && basicPayInfo.billBasic != null) {
            m14103a(basicPayInfo.billBasic);
            ((NewUiIPayEntranceViewContainer) this.mView).setTitle(basicPayInfo.payTitle);
            ((IPayEntranceViewContainer) this.mView).setFeeDescribe(basicPayInfo.statusMsg);
            ((IPayEntranceViewContainer) this.mView).setOnBindCardClickListener(this);
            ((IPayEntranceViewContainer) this.mView).showBindCard(true);
            onViewReady(true);
        }
    }

    /* renamed from: a */
    private void m14103a(BasicBill basicBill) {
        String str = "";
        if (!TextUtils.isEmpty(basicBill.leftDes)) {
            str = str + basicBill.leftDes + " ";
        }
        if (!TextUtil.isEmpty(basicBill.totalFeeText)) {
            str = str + basicBill.totalFeeText;
        }
        if (!TextUtil.isEmpty(basicBill.rightDes)) {
            str = str + basicBill.rightDes;
        }
        ((IPayEntranceViewContainer) this.mView).setPrice(str);
    }

    public void onPayClick(Mode mode, double d, double d2) {
        if (!checkObjection()) {
            doPublish(BaseEventKeys.Template.EVENT_SHOW_POPUP_COMPONENT, new ComponentWrap("payment"));
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
        addCardParam.bindType = 15;
        DidiGlobalPayApiFactory.createDidiPay().startAddCreditCardActivity(getHost(), 103, addCardParam);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Bundle extras;
        super.onActivityResult(i, i2, intent);
        if (intent != null && (extras = intent.getExtras()) != null && 101 == i) {
            this.f16775p = false;
            if (i2 == -1) {
                int i3 = extras.getInt(AbsUnifiedPayEntrancePresenter.EXTRA_CONFIRM_RESULT_KEY);
                ((IPayEntranceViewContainer) this.mView).showLoading();
                if (i3 == 1) {
                    this.mUnifiedPaySystem.billConfirm(1, new ConfirmBillCallBack(1));
                    XEngineReq.pageRequest(XERequestKey.SCENE_TRIP);
                    return;
                }
                this.mUnifiedPaySystem.billConfirm(2, new ConfirmBillCallBack(2));
            }
        }
    }

    public void viewBindBizDataReady(IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback) {
        this.f16764b = iXpCardBindDataReadyCallback;
        if (this.isViewReady == null) {
            if (this.f16765c) {
                lazyInit();
            }
            m14111d();
            return;
        }
        iXpCardBindDataReadyCallback.ready(this.isViewReady.booleanValue());
        this.f16772l = this.isViewReady.booleanValue();
        ((NewUiIPayEntranceViewContainer) this.mView).setBtnClickable(!this.f16766d && this.isViewReady.booleanValue());
        DebugUtilsKt.dumpDebugStack4J(ComponentType.PAY_ENTRANCE_NEW_UI, "pay-entrance view ready: " + this.isViewReady);
    }

    /* access modifiers changed from: protected */
    public void onViewReady(boolean z) {
        this.isViewReady = Boolean.valueOf(z);
        ((NewUiIPayEntranceViewContainer) this.mView).setBtnClickable(!this.f16766d && z);
        IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback = this.f16764b;
        if (iXpCardBindDataReadyCallback != null) {
            this.f16772l = z;
            iXpCardBindDataReadyCallback.ready(z);
            DebugUtilsKt.dumpDebugStack4J(ComponentType.PAY_ENTRANCE_NEW_UI, "pay-entrance view ready: " + z);
        }
    }

    class ConfirmBillCallBack implements PayServiceCallback<Object> {
        private int actionType;

        public ConfirmBillCallBack(int i) {
            this.actionType = i;
        }

        public void onSuccess(Object obj) {
            ((IPayEntranceViewContainer) NewUIUnifiedPayEntrancePresenter.this.mView).hideLoading();
            if (this.actionType == 1) {
                NewUIUnifiedPayEntrancePresenter.this.goPayPage();
            } else {
                NewUIUnifiedPayEntrancePresenter.this.refreshOrderBill();
            }
        }

        public void onFail(Error error) {
            ((IPayEntranceViewContainer) NewUIUnifiedPayEntrancePresenter.this.mView).showError(error.msg);
            NewUIUnifiedPayEntrancePresenter.this.onViewReady(false);
        }
    }

    /* renamed from: d */
    private void m14111d() {
        if (m14114e()) {
            this.f16770h = new LoopHandler(this);
            m14102a(this.mContext, getPayServiceParams());
            m14116f();
            return;
        }
        setupOrderCanceledNoFeeView(CarOrderHelper.getOrder());
    }

    /* renamed from: e */
    private boolean m14114e() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null) {
            return false;
        }
        if (order.status == 6) {
            if (order.substatus == 6002) {
                return false;
            }
            return !BusinessDataUtil.isTripCanceledWithoutFee(order);
        } else if (order.status == 5 || order.status == 4) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: f */
    private void m14116f() {
        UIThreadHandler.post(new Runnable() {
            public void run() {
                NewUIUnifiedPayEntrancePresenter.this.doPublish(BaseEventKeys.Trip.EVENT_GLOBAL_NO_PSD_PROCESSING_SHOWING);
            }
        }, 500);
    }

    /* access modifiers changed from: protected */
    public void hideLoadingWithNewUI() {
        doPublish(BaseEventKeys.Trip.EVENT_GLOBAL_NO_PSD_PROCESSING_HIDE);
    }

    /* access modifiers changed from: protected */
    public GlobalUniPayService.PayServiceParam getPayServiceParams() {
        GlobalUniPayService.PayServiceParam payServiceParam = new GlobalUniPayService.PayServiceParam();
        payServiceParam.isOnline = isOnlineEnv();
        payServiceParam.isTripScene = true;
        payServiceParam.productId = getBid();
        payServiceParam.token = NationComponentDataUtil.getToken();
        payServiceParam.oid = getOrderId();
        return payServiceParam;
    }

    /* renamed from: a */
    private void m14102a(Context context, GlobalUniPayService.PayServiceParam payServiceParam) {
        IUnipayService service = this.f16768f.getService(context, payServiceParam);
        this.f16769g = service;
        service.getPayInfo(new PayServiceCallback<PayInfo>() {
            public void onSuccess(PayInfo payInfo) {
                if (payInfo.payStatus == 2 || payInfo.payStatus == 3) {
                    NewUIUnifiedPayEntrancePresenter.this.m14118h();
                } else {
                    NewUIUnifiedPayEntrancePresenter.this.m14117g();
                }
                boolean unused = NewUIUnifiedPayEntrancePresenter.this.f16767e = payInfo.billDetail != null && !TextUtils.isEmpty(payInfo.billDetail.pixCode);
            }

            public void onFail(Error error) {
                NewUIUnifiedPayEntrancePresenter.this.refreshOrderBill();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m14117g() {
        IUnipayService iUnipayService = this.f16769g;
        if (iUnipayService != null) {
            iUnipayService.getBasicPayInfo(this.mPayinfoCallback);
            hideLoadingWithNewUI();
        }
    }

    /* access modifiers changed from: protected */
    public void refreshOrderBill() {
        super.refreshOrderBill();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m14118h() {
        LoopHandler loopHandler = this.f16770h;
        if (loopHandler != null) {
            loopHandler.sendEmptyMessage(101);
        }
    }

    private static class LoopHandler extends Handler {
        private final WeakReference<NewUIUnifiedPayEntrancePresenter> ref;

        public LoopHandler(NewUIUnifiedPayEntrancePresenter newUIUnifiedPayEntrancePresenter) {
            this.ref = new WeakReference<>(newUIUnifiedPayEntrancePresenter);
        }

        public void handleMessage(Message message) {
            getPayStatus();
        }

        private void getPayStatus() {
            NewUIUnifiedPayEntrancePresenter newUIUnifiedPayEntrancePresenter = (NewUIUnifiedPayEntrancePresenter) this.ref.get();
            if (newUIUnifiedPayEntrancePresenter != null && newUIUnifiedPayEntrancePresenter.f16769g != null) {
                newUIUnifiedPayEntrancePresenter.f16769g.getPayStatus(new PayServiceCallback<PayStatus>() {
                    public void onSuccess(PayStatus payStatus) {
                        LoopHandler.this.handlePayStatus(payStatus);
                    }

                    public void onFail(Error error) {
                        LoopHandler.this.sendEmptyMessageDelayed(101, 5000);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public void handlePayStatus(PayStatus payStatus) {
            switch (payStatus.payStatus) {
                case 0:
                case 1:
                case 4:
                case 5:
                case 6:
                case 7:
                    removeCallbacksAndMessages((Object) null);
                    if (this.ref.get() != null) {
                        ((NewUIUnifiedPayEntrancePresenter) this.ref.get()).m14117g();
                    }
                    MReporter.Companion.reportError("pay_error", 2, payStatus.statusMsg, payStatus.payStatus, "", "autoPay", (Map<String, Object>) null);
                    return;
                case 2:
                    sendEmptyMessageDelayed(101, 5000);
                    return;
                case 3:
                    if (this.ref.get() != null) {
                        ((NewUIUnifiedPayEntrancePresenter) this.ref.get()).hideLoadingWithNewUI();
                    }
                    removeCallbacksAndMessages((Object) null);
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public String getCancelContent(CarOrder carOrder) {
        if (carOrder == null || carOrder.carCancelTrip == null || TextUtils.isEmpty(carOrder.carCancelTrip.showTitle)) {
            return "";
        }
        return carOrder.carCancelTrip.showTitle;
    }
}
