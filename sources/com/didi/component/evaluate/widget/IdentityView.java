package com.didi.component.evaluate.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.component.common.widget.CircleImageView;
import com.taxis99.R;

public class IdentityView extends LinearLayout {

    /* renamed from: a */
    private CircleImageView f15298a;

    /* renamed from: b */
    private ImageView f15299b;

    /* renamed from: c */
    private TextView f15300c;

    /* renamed from: d */
    private TextView f15301d;

    /* renamed from: e */
    private TextView f15302e;

    /* renamed from: f */
    private int f15303f = 5;

    public IdentityView(Context context) {
        super(context);
        m12604a();
    }

    public IdentityView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12604a();
    }

    public IdentityView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12604a();
    }

    /* renamed from: a */
    private void m12604a() {
        setOrientation(1);
        setGravity(1);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.global_evaluate_identity_view, this, true);
        this.f15298a = (CircleImageView) inflate.findViewById(R.id.iv_head);
        this.f15299b = (ImageView) inflate.findViewById(R.id.iv_status);
        this.f15300c = (TextView) inflate.findViewById(R.id.tv_name);
        this.f15301d = (TextView) inflate.findViewById(R.id.tv_status);
        this.f15302e = (TextView) inflate.findViewById(R.id.tv_tips);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        m12605a(this.f15303f);
    }

    public void setFocus() {
        this.f15301d.setFocusable(true);
        this.f15301d.sendAccessibilityEvent(128);
    }

    public void setHead(int i) {
        this.f15298a.setImageResource(i);
    }

    public void setHead(String str) {
        Glide.with(getContext()).load(str).into((ImageView) this.f15298a);
    }

    public void setLevel(int i) {
        if (this.f15303f != i) {
            this.f15303f = i;
            m12605a(i);
        }
    }

    public void setName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f15300c.setText(str);
        }
    }

    public void setTips(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f15302e.setText(str);
        }
    }

    public void hideTipsView() {
        this.f15302e.setVisibility(8);
    }

    /* renamed from: a */
    private void m12605a(int i) {
        if (i == 5) {
            this.f15299b.setImageResource(R.drawable.global_evaluate_btn_satisfaction);
            this.f15301d.setText(R.string.oc_evaluate_satisfied);
            return;
        }
        this.f15299b.setImageResource(R.drawable.global_evaluate_btn_unsatisfaction);
        this.f15301d.setText(R.string.oc_evaluate_unsatisfied);
    }
}
