package com.didi.soda.order.component.debtpay;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.didi.soda.bill.widgets.CustomerBottomButton;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.text.IconTextView;
import com.didi.soda.order.component.debtpay.Contract;
import com.taxis99.R;

public class DebtOrderPayView extends Contract.AbsDebtOrderPayView {

    /* renamed from: a */
    private String f45935a;
    @BindView(19211)
    View mBackground;
    @BindView(17961)
    View mChangePaymentMethod;
    @BindView(17964)
    IconTextView mClose;
    @BindView(17965)
    CustomerBottomButton mConfirm;
    @BindView(18028)
    TextView mPaymentCardNum;
    @BindView(18467)
    ImageView mPaymentIcon;
    @BindView(18033)
    TextView mPaymentMoney;

    public void setPayInfo(String str, String str2, PayChannelEntity payChannelEntity) {
        this.f45935a = str;
        if (!TextUtils.isEmpty(str2)) {
            this.mPaymentMoney.setText(str2);
        }
        if (payChannelEntity == null) {
            this.mPaymentIcon.setVisibility(8);
            this.mPaymentCardNum.setVisibility(0);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mPaymentCardNum, IToolsService.FontType.NORMAL);
            this.mPaymentCardNum.setText(ResourceHelper.getString(R.string.customer_name_please_select));
            this.mPaymentCardNum.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_4_80_CCCCCC));
            return;
        }
        if (!TextUtils.isEmpty(payChannelEntity.cardOrg)) {
            this.mPaymentIcon.setVisibility(0);
            FlyImageLoader.loadImageUnspecified(getContext(), payChannelEntity.cardOrg).into(this.mPaymentIcon);
        } else {
            this.mPaymentIcon.setVisibility(8);
        }
        if (!TextUtils.isEmpty(payChannelEntity.cardSuffix)) {
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mPaymentCardNum, IToolsService.FontType.MEDIUM);
            this.mPaymentCardNum.setVisibility(0);
            this.mPaymentCardNum.setText(payChannelEntity.cardSuffix.substring(payChannelEntity.cardSuffix.length() - 4));
            this.mPaymentCardNum.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
            return;
        }
        this.mPaymentCardNum.setVisibility(8);
    }

    public void setLoading(boolean z) {
        if (z) {
            this.mConfirm.loading();
        } else {
            this.mConfirm.hideLoading();
        }
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_component_order_pay_info, viewGroup, true);
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        this.mConfirm.setMiddleTextText(ResourceHelper.getString(R.string.customer_pay));
        this.mChangePaymentMethod.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                DebtOrderPayView.this.m34071d(view);
            }
        });
        this.mClose.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                DebtOrderPayView.this.m34070c(view);
            }
        });
        this.mConfirm.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                DebtOrderPayView.this.m34069b(view);
            }
        });
        this.mBackground.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                DebtOrderPayView.this.m34067a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m34071d(View view) {
        ((Contract.AbsDebtOrderPayPresenter) getPresenter()).selectPayMethod();
        m34068a(EventConst.Order.ORDER_DEBT_ARREARS_PAYMETHOD_CK);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m34070c(View view) {
        ((Contract.AbsDebtOrderPayPresenter) getPresenter()).closePage();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m34069b(View view) {
        ((Contract.AbsDebtOrderPayPresenter) getPresenter()).pay();
        m34068a(EventConst.Order.ORDER_DEBT_ARREARS_PAY_CK);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m34067a(View view) {
        ((Contract.AbsDebtOrderPayPresenter) getPresenter()).closePage();
    }

    /* renamed from: a */
    private void m34068a(String str) {
        OmegaTracker.Builder.create(str, getScopeContext()).addEventParam("order_id", this.f45935a).build().track();
    }
}
