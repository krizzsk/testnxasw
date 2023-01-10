package com.didi.component.payentrance.view.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.component.payentrance.utils.PEUtils;
import com.didi.unifiedPay.sdk.model.DeductionInfo;
import com.taxis99.R;

public class PayClosedView extends BasePayEntranceView {

    /* renamed from: a */
    private TextView f16917a;

    /* renamed from: b */
    private TextView f16918b;

    /* renamed from: c */
    private View f16919c;

    public void addSupplement(DeductionInfo deductionInfo, String str) {
    }

    public int getLayoutId() {
        return R.layout.global_pe_pay_close_view;
    }

    public void removeSupplement() {
    }

    public void setActionText(String str) {
    }

    public PayClosedView(Context context, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(context, layoutInflater, viewGroup);
    }

    /* access modifiers changed from: protected */
    public void onViewCreated(View view) {
        this.f16917a = (TextView) findView(R.id.oc_tv_pay_entrance_price);
        this.f16918b = (TextView) findView(R.id.oc_pay_entrance_money_summary);
        this.f16919c = findView(R.id.oc_pay_entrance_icon);
    }

    public void setPrice(double d) {
        setPrice(this.mContext.getString(R.string.pe_pay_entrance_one_price, new Object[]{PEUtils.format(d)}));
    }

    public void setIconShow(boolean z) {
        this.f16919c.setVisibility(z ? 0 : 8);
    }

    public void setPrice(String str) {
        setMoneyWithUnit(this.f16917a, str);
        this.f16917a.setVisibility(0);
    }

    public void setMessage(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f16918b.setVisibility(8);
            return;
        }
        this.f16918b.setVisibility(0);
        this.f16918b.setText(charSequence);
    }

    /* access modifiers changed from: protected */
    public View getLoadingArea() {
        return findView(R.id.oc_pay_entrance_detail);
    }
}
