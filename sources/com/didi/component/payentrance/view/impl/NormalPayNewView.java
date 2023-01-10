package com.didi.component.payentrance.view.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.payentrance.model.Jumpable;
import com.didi.component.payentrance.utils.PEUtils;
import com.didi.component.payentrance.utils.TextUtil;
import com.didi.component.payentrance.view.IPayEntranceView;
import com.didi.unifiedPay.sdk.model.DeductionInfo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class NormalPayNewView extends BasePayEntranceView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public TextView f16896a;

    /* renamed from: b */
    private TextView f16897b;

    /* renamed from: c */
    private TextView f16898c;

    /* renamed from: d */
    private TextView f16899d;

    /* renamed from: e */
    private ViewGroup f16900e;

    /* renamed from: f */
    private ViewGroup f16901f;

    /* renamed from: g */
    private boolean f16902g;

    /* renamed from: h */
    private LinearLayout f16903h;

    /* renamed from: i */
    private Jumpable f16904i;

    /* renamed from: j */
    private View f16905j;

    public int getLayoutId() {
        return R.layout.global_pe_pay_normal_view_new;
    }

    public NormalPayNewView(Context context, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(context, layoutInflater, viewGroup);
    }

    /* access modifiers changed from: protected */
    public void onViewCreated(View view) {
        this.f16896a = (TextView) findView(R.id.oc_tv_pay_entrance_price);
        this.f16905j = findView(R.id.oc_iv_pay_price_arrow);
        this.f16897b = (TextView) findView(R.id.oc_pay_entrance_money_summary);
        this.f16903h = (LinearLayout) findView(R.id.oc_tv_pay_entrance_layout);
        TextView textView = (TextView) findView(R.id.oc_pay_entrance_goto_pay);
        this.f16898c = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                NormalPayNewView.this.performOnPay(TextUtil.getFirstMoneyFromText(String.valueOf(NormalPayNewView.this.f16896a.getText())), "0");
            }
        });
        this.f16901f = (ViewGroup) findView(R.id.oc_pay_entrance_supplement_container);
        this.f16900e = (ViewGroup) findView(R.id.oc_pay_jumpable_container);
        this.f16899d = (TextView) findView(R.id.oc_tv_fee_abnormal_describe);
    }

    public void setPrice(double d) {
        setPrice(this.mContext.getString(R.string.pe_pay_entrance_money, new Object[]{PEUtils.format(d)}));
    }

    public void setFeeDescribe(CharSequence charSequence) {
        super.setFeeDescribe(charSequence);
        if (charSequence == null || TextUtil.isEmpty(charSequence.toString())) {
            this.f16899d.setVisibility(8);
            return;
        }
        this.f16899d.setText(charSequence);
        this.f16899d.setVisibility(0);
    }

    public void setPrice(String str) {
        this.f16903h.setVisibility(0);
        setMoneyWithUnit(this.f16896a, str, 1.875f);
    }

    public void setMessage(CharSequence charSequence) {
        this.f16897b.setVisibility(0);
        this.f16897b.setText(charSequence);
    }

    public void addSupplement(DeductionInfo deductionInfo, String str) {
        if (!TextUtils.isEmpty(str)) {
            TextView textView = new TextView(this.mContext);
            textView.setText(str);
            textView.setTextColor(this.mContext.getResources().getColor(R.color.color_999999));
            textView.setTextSize(9.0f);
            this.f16901f.addView(textView);
        }
    }

    public void removeSupplement() {
        this.f16901f.removeAllViews();
    }

    public void setActionText(String str) {
        ((TextView) findView(R.id.oc_pay_entrance_goto_pay)).setText(str);
    }

    public void setJumpableItems(List<Jumpable> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (Jumpable next : list) {
                if (next.getId() == 1) {
                    this.f16904i = next;
                } else if (next.getId() != 3) {
                    arrayList.add(next);
                }
            }
            if (this.f16904i != null) {
                this.f16905j.setVisibility(0);
                this.f16896a.setTag(this.f16904i);
                this.f16896a.setOnClickListener(this.mOnViewClickListener);
            }
        }
        addJumpableViews(this.f16900e, arrayList);
    }

    /* access modifiers changed from: protected */
    public View getLoadingArea() {
        return findView(R.id.oc_pay_entrance_detail);
    }

    public void showTipsCheckbox(String str, boolean z, final IPayEntranceView.OnTipsCheckChangeListener onTipsCheckChangeListener) {
        this.f16902g = true;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.global_pe_pay_tips_item, this.f16901f, false);
        final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.oc_pay_entrance_supplement_checkbox);
        final TextView textView = (TextView) inflate.findViewById(R.id.oc_pay_entrance_supplement_title);
        textView.setText(str);
        if (!z) {
            textView.setTextColor(textView.getContext().getResources().getColor(R.color.pe_color_666666));
        } else {
            textView.setTextColor(textView.getContext().getResources().getColor(R.color.pe_color_FC9153));
        }
        checkBox.setChecked(z);
        ((RelativeLayout) inflate.findViewById(R.id.oc_rl_tips_item)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CheckBox checkBox = checkBox;
                checkBox.setChecked(!checkBox.isChecked());
                if (!checkBox.isChecked()) {
                    TextView textView = textView;
                    textView.setTextColor(textView.getContext().getResources().getColor(R.color.pe_color_666666));
                } else {
                    TextView textView2 = textView;
                    textView2.setTextColor(textView2.getContext().getResources().getColor(R.color.pe_color_FC9153));
                }
                IPayEntranceView.OnTipsCheckChangeListener onTipsCheckChangeListener = onTipsCheckChangeListener;
                if (onTipsCheckChangeListener != null) {
                    onTipsCheckChangeListener.onTipsCheckChanged(checkBox.isChecked());
                }
            }
        });
        this.f16901f.addView(inflate);
    }

    public void disableActionBtn() {
        ((TextView) findView(R.id.oc_pay_entrance_goto_pay)).setEnabled(false);
        this.f16898c.setClickable(false);
    }
}
