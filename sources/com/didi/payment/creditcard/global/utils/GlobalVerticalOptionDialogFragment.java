package com.didi.payment.creditcard.global.utils;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.BaseDialogFragment;
import com.taxis99.R;

public class GlobalVerticalOptionDialogFragment extends BaseDialogFragment {

    /* renamed from: a */
    private TextView f32933a;

    /* renamed from: b */
    private TextView f32934b;

    /* renamed from: c */
    private LinearLayout f32935c;

    /* renamed from: d */
    private TextView f32936d;

    /* renamed from: e */
    private LinearLayout f32937e;

    /* renamed from: f */
    private TextView f32938f;

    /* renamed from: g */
    private String f32939g;

    /* renamed from: h */
    private String f32940h;

    /* renamed from: i */
    private String f32941i;

    /* renamed from: j */
    private String f32942j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View.OnClickListener f32943k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public View.OnClickListener f32944l;

    public void setTitle(String str) {
        this.f32939g = str;
    }

    public void setContent(String str) {
        this.f32940h = str;
    }

    public void setNegativeButton(String str, View.OnClickListener onClickListener) {
        this.f32942j = str;
        this.f32944l = onClickListener;
    }

    public void setPositiveButton(String str, View.OnClickListener onClickListener) {
        this.f32941i = str;
        this.f32943k = onClickListener;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.common_dialog_anim_style;
        }
        return layoutInflater.inflate(R.layout.one_payment_creditcard_global_dialog_vertical_option, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m25037a(view);
        m25036a();
    }

    /* renamed from: a */
    private void m25037a(View view) {
        this.f32933a = (TextView) view.findViewById(R.id.tv_title);
        this.f32934b = (TextView) view.findViewById(R.id.tv_content);
        this.f32935c = (LinearLayout) view.findViewById(R.id.ll_option_1);
        this.f32936d = (TextView) view.findViewById(R.id.tv_option_1);
        this.f32937e = (LinearLayout) view.findViewById(R.id.ll_option_2);
        this.f32938f = (TextView) view.findViewById(R.id.tv_option_2);
    }

    /* renamed from: a */
    private void m25036a() {
        if (!TextUtils.isEmpty(this.f32939g)) {
            this.f32933a.setVisibility(0);
            this.f32933a.setText(this.f32939g);
        }
        if (!TextUtils.isEmpty(this.f32940h)) {
            this.f32934b.setVisibility(0);
            this.f32934b.setText(this.f32940h);
        }
        if (!TextUtils.isEmpty(this.f32941i)) {
            this.f32935c.setVisibility(0);
            this.f32936d.setText(this.f32941i);
            this.f32935c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GlobalVerticalOptionDialogFragment.this.dismiss();
                    if (GlobalVerticalOptionDialogFragment.this.f32943k != null) {
                        GlobalVerticalOptionDialogFragment.this.f32943k.onClick(view);
                    }
                }
            });
        }
        if (!TextUtils.isEmpty(this.f32942j)) {
            this.f32937e.setVisibility(0);
            this.f32938f.setText(this.f32942j);
            this.f32937e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GlobalVerticalOptionDialogFragment.this.dismiss();
                    if (GlobalVerticalOptionDialogFragment.this.f32944l != null) {
                        GlobalVerticalOptionDialogFragment.this.f32944l.onClick(view);
                    }
                }
            });
        }
    }
}
