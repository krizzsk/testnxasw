package com.didi.entrega.order.debt;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.entrega.customer.foundation.rpc.entity.PayChannel;
import com.didi.entrega.customer.foundation.util.FlyImageLoader;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.IToolsService;
import com.didi.entrega.order.debt.Contract;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.rfusion.widget.floating.RFFloatingIconAttr;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.rfusion.widget.floating.RFFloatingTextAttr;
import com.taxis99.R;

public class DebtOrderPayView extends Contract.AbsDebtOrderPayView implements IRFFloatingExpand {

    /* renamed from: a */
    RFMainButton f22740a;

    /* renamed from: b */
    TextView f22741b;

    /* renamed from: c */
    ImageView f22742c;

    /* renamed from: d */
    TextView f22743d;

    /* renamed from: e */
    View f22744e;

    public /* synthetic */ void dismiss(ScopeContext scopeContext) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext);
    }

    public /* synthetic */ void dismiss(ScopeContext scopeContext, Bundle bundle) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext, bundle);
    }

    public /* synthetic */ Bundle getFloatingArgs(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getFloatingArgs(this, scopeContext);
    }

    public /* synthetic */ RFFloatingNavBar getNavBar(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getNavBar(this, scopeContext);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, page);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Dialog dialog, String str) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, dialog, str);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page, int i) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page, i);
    }

    public /* synthetic */ void setGestureEnable(ScopeContext scopeContext, boolean z) {
        IRFFloatingExpand.CC.$default$setGestureEnable(this, scopeContext, z);
    }

    public void setPayInfo(String str, String str2, PayChannel payChannel) {
        if (!TextUtils.isEmpty(str2)) {
            this.f22741b.setText(str2);
        }
        if (payChannel == null) {
            this.f22742c.setVisibility(8);
            this.f22743d.setVisibility(0);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f22743d, IToolsService.FontType.NORMAL);
            this.f22743d.setText(ResourceHelper.getString(R.string.FoodC_unpaid_Select_NWED));
            this.f22743d.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_4_80_CCCCCC));
            return;
        }
        if (!TextUtils.isEmpty(payChannel.getCardOrg())) {
            this.f22742c.setVisibility(0);
            FlyImageLoader.loadImageUnspecified(getContext(), payChannel.getCardOrg()).into(this.f22742c);
        } else {
            this.f22742c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(payChannel.getCardSuffix())) {
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f22743d, IToolsService.FontType.MEDIUM);
            this.f22743d.setVisibility(0);
            this.f22743d.setText(payChannel.getCardSuffix().substring(payChannel.getCardSuffix().length() - 4));
            this.f22743d.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
            return;
        }
        this.f22743d.setVisibility(8);
    }

    public void setLoading(boolean z) {
        this.f22740a.setLoading(z);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.entrega_customer_component_order_pay_info, viewGroup);
        this.f22740a = (RFMainButton) inflate.findViewById(R.id.customer_custom_common_dialog_confirm);
        this.f22741b = (TextView) inflate.findViewById(R.id.customer_custom_payment_total_money);
        this.f22742c = (ImageView) inflate.findViewById(R.id.customer_iv_payment_card_icon);
        this.f22743d = (TextView) inflate.findViewById(R.id.customer_custom_payment_card_number);
        this.f22744e = inflate.findViewById(R.id.customer_custom_change_payment_method);
        this.f22740a.setText(ResourceHelper.getString(R.string.FoodC_unpaid_Payment_KjvL));
        this.f22744e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                DebtOrderPayView.this.m18718c(view);
            }
        });
        this.f22740a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                DebtOrderPayView.this.m18717b(view);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m18718c(View view) {
        ((Contract.AbsDebtOrderPayPresenter) getPresenter()).selectPayMethod();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m18717b(View view) {
        ((Contract.AbsDebtOrderPayPresenter) getPresenter()).pay();
    }

    public void onCreate() {
        super.onCreate();
        RFFloatingNavBar navBar = getNavBar(getScopeContext());
        if (navBar != null) {
            navBar.setLeftIcon(new RFFloatingIconAttr.Builder(1).click(new View.OnClickListener() {
                public final void onClick(View view) {
                    DebtOrderPayView.this.m18716a(view);
                }
            }).build());
            navBar.setTitle(new RFFloatingTextAttr.Builder(ResourceHelper.getString(R.string.FoodC_unpaid_Pay_this_zfnM)).build());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18716a(View view) {
        ((Contract.AbsDebtOrderPayPresenter) getPresenter()).closePage();
    }
}
