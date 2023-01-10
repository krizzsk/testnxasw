package com.didi.soda.order.component.debtpay;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.didi.security.uuid.adapter.DeviceTokenWrapper;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.DebtRepayEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerOrderManager;
import com.didi.soda.manager.base.ICustomerPayManager;
import com.didi.soda.order.component.debtpay.Contract;
import com.didi.soda.pay.PayMethodPage;
import com.didi.soda.pay.ValidateCardHelper;
import com.didi.universal.pay.biz.model.PayStatusModel;
import com.didichuxing.dfbasesdk.utils.GsonUtils;
import com.taxis99.R;
import java.io.Serializable;

public class DebtOrderPayPresenter extends Contract.AbsDebtOrderPayPresenter {

    /* renamed from: a */
    private int f45929a;

    /* renamed from: b */
    private String f45930b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public PayChannelEntity f45931c;

    /* renamed from: d */
    private String f45932d;

    /* renamed from: e */
    private String f45933e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f45934f = true;

    public void closePage() {
        if (this.f45934f) {
            getScopeContext().getNavigator().finish();
        }
    }

    public void pay() {
        if (this.f45931c == null) {
            ToastUtil.showCustomerErrorToast(getScopeContext(), ResourceHelper.getString(R.string.customer_name_pelease_select_pay_method));
            return;
        }
        this.f45934f = false;
        ((Contract.AbsDebtOrderPayView) getLogicView()).setLoading(true);
        CustomerRpcManagerProxy.get().debtRepay(this.f45932d, this.f45933e, this.f45931c, DeviceTokenWrapper.getInstance().getDeviceToken(), new CustomerRpcCallback<DebtRepayEntity>() {
            public void onRpcSuccess(DebtRepayEntity debtRepayEntity, long j) {
                if (debtRepayEntity == null || TextUtils.isEmpty(debtRepayEntity.transId)) {
                    ((Contract.AbsDebtOrderPayView) DebtOrderPayPresenter.this.getLogicView()).setLoading(false);
                    boolean unused = DebtOrderPayPresenter.this.f45934f = true;
                    return;
                }
                DebtOrderPayPresenter.this.m34062a(debtRepayEntity.transId);
            }

            public void onRpcFailure(SFRpcException sFRpcException) {
                ((Contract.AbsDebtOrderPayView) DebtOrderPayPresenter.this.getLogicView()).setLoading(false);
                boolean unused = DebtOrderPayPresenter.this.f45934f = true;
                if (sFRpcException == null) {
                    ToastUtil.showCustomerErrorToast(DebtOrderPayPresenter.this.getScopeContext(), ResourceHelper.getString(R.string.customer_cart_error_hint));
                } else if (sFRpcException.getCode() != 48201 || DebtOrderPayPresenter.this.f45931c == null) {
                    ToastUtil.showCustomerErrorToast(DebtOrderPayPresenter.this.getScopeContext(), TextUtils.isEmpty(sFRpcException.getMessage()) ? ResourceHelper.getString(R.string.customer_cart_error_hint) : sFRpcException.getMessage());
                } else {
                    ValidateCardHelper.Companion.validateCard(DebtOrderPayPresenter.this.f45931c.cardSuffix, DebtOrderPayPresenter.this.f45931c.cardIndex, -1);
                }
            }
        });
    }

    public void selectPayMethod() {
        Bundle bundle = new Bundle();
        bundle.putInt("pay_scene", 1);
        bundle.putInt("pay_method_price", this.f45929a);
        PayMethodPage.toPayMethod(getScopeContext(), "", this.f45929a, 1, "", 0, this.f45931c);
    }

    public void onPageResult(Bundle bundle) {
        if (bundle != null) {
            PayChannelEntity payChannelEntity = (PayChannelEntity) bundle.getSerializable(Const.BundleKey.SELECT_PAYMENT_METHOD);
            this.f45931c = payChannelEntity;
            if (payChannelEntity != null) {
                ((Contract.AbsDebtOrderPayView) getLogicView()).setPayInfo(this.f45932d, this.f45930b, this.f45931c);
            }
        }
    }

    public boolean onHandleBack() {
        return !this.f45934f;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        String str;
        String str2;
        super.onCreate();
        Bundle bundle = getScopeContext().getBundle();
        try {
            this.f45931c = (PayChannelEntity) GsonUtils.fromJson(GsonUtils.toJson(bundle.getSerializable("payChannel")), PayChannelEntity.class);
        } catch (Exception e) {
            this.f45931c = null;
            Serializable serializable = bundle.getSerializable("payChannel");
            if (serializable != null) {
                str = serializable.toString();
            } else {
                str = "";
            }
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Order.ORDER_DEBT_INIT_CHANNEL_FAILED);
            if (e.getMessage() == null) {
                str2 = "";
            } else {
                str2 = e.getMessage();
            }
            create.addEventParam("error_msg", str2).addEventParam("pay_channel", str).build().track();
        }
        this.f45930b = bundle.getString("unpaidMoneyDisplay", "");
        this.f45929a = bundle.getInt("unpaidMoney", 0);
        this.f45932d = bundle.getString("orderId", "");
        this.f45933e = bundle.getString("debtId", "");
        ((Contract.AbsDebtOrderPayView) getLogicView()).setPayInfo(this.f45932d, this.f45930b, this.f45931c);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34057a() {
        ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).updateOrder2Monitor(this.f45932d);
        getScopeContext().getNavigator().finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34062a(String str) {
        ICustomerPayManager.PayParamEntity payParamEntity = new ICustomerPayManager.PayParamEntity();
        payParamEntity.token = LoginUtil.getToken();
        payParamEntity.transId = str;
        ((ICustomerPayManager) CustomerManagerLoader.loadManager(ICustomerPayManager.class)).getPayStatus((Activity) getContext(), getScopeContext(), payParamEntity, new ICustomerPayManager.PayCallback() {
            public void onThirdPayStart(int i) {
            }

            public void payFail(int i, String str, PayStatusModel payStatusModel) {
                boolean unused = DebtOrderPayPresenter.this.f45934f = true;
                DebtOrderPayPresenter.this.m34059a(i, str);
            }

            public void paySucceed() {
                boolean unused = DebtOrderPayPresenter.this.f45934f = true;
                DebtOrderPayPresenter.this.m34057a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34059a(final int i, final String str) {
        CustomerRpcManagerProxy.get().postDebtRepayFail(this.f45932d, this.f45933e, new CustomerRpcCallback<OrderInfoEntity>() {
            public void onRpcSuccess(OrderInfoEntity orderInfoEntity, long j) {
                DebtOrderPayPresenter.this.m34064b(i, str);
            }

            public void onRpcFailure(SFRpcException sFRpcException) {
                DebtOrderPayPresenter.this.m34064b(i, str);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m34064b(int i, String str) {
        OmegaTracker.Builder.create(EventConst.Order.ORDER_DEBT_PAY_FAIL_POPUP_SW, getScopeContext()).addEventParam("order_id", this.f45932d).build().track();
        ScopeContext scopeContext = getScopeContext();
        if (TextUtils.isEmpty(str)) {
            str = ResourceHelper.getString(R.string.customer_pay_internal_error);
        }
        DialogUtil.showDebtPayFailDialog(scopeContext, str, new RFDialogInterface.OnClickListener(i) {
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(RFDialog rFDialog) {
                DebtOrderPayPresenter.this.m34058a(this.f$1, rFDialog);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m34058a(int i, RFDialog rFDialog) {
        OmegaTracker.Builder.create(EventConst.Order.ORDER_DEBT_PAY_FAIL_POPUP_CK, getScopeContext()).addEventParam("order_id", this.f45932d).addEventParam("failure_reason", Integer.valueOf(i)).build().track();
        m34057a();
    }
}
