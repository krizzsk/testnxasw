package com.didi.component.payentrance.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.component.common.view.RichTextView;
import com.taxis99.R;

public class PayentranceLoadingView extends FrameLayout {

    /* renamed from: a */
    private ImageView f16860a;

    /* renamed from: b */
    private View f16861b;

    /* renamed from: c */
    private RichTextView f16862c;

    /* renamed from: d */
    private AnimationDrawable f16863d;

    public PayentranceLoadingView(Context context) {
        super(context);
        m14174a();
    }

    public PayentranceLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14174a();
    }

    public PayentranceLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14174a();
    }

    /* renamed from: a */
    private void m14174a() {
        LayoutInflater.from(getContext()).inflate(R.layout.global_pe_loading_view, this);
        this.f16860a = (ImageView) findViewById(R.id.oc_dot_loading_view);
        this.f16861b = findViewById(R.id.oc_loading_mask);
        this.f16863d = (AnimationDrawable) this.f16860a.getDrawable();
        this.f16862c = (RichTextView) findViewById(R.id.oc_loading_error_view);
    }

    public void showMask() {
        hideError();
        this.f16861b.setVisibility(0);
    }

    public void hideMask() {
        this.f16861b.setVisibility(8);
    }

    public void showLoading() {
        hideError();
        if (this.f16860a.getVisibility() != 0) {
            this.f16860a.setVisibility(0);
        }
        if (!this.f16863d.isRunning()) {
            this.f16863d.start();
        }
    }

    public void hideLoading() {
        if (this.f16860a.getVisibility() != 8) {
            this.f16860a.setVisibility(8);
        }
        if (this.f16863d.isRunning()) {
            this.f16863d.stop();
        }
    }

    public void showError(CharSequence charSequence) {
        hideMask();
        hideLoading();
        this.f16862c.setText(charSequence);
        this.f16862c.setVisibility(0);
    }

    public void hideError() {
        this.f16862c.setVisibility(8);
    }

    public void showError() {
        hideMask();
        this.f16862c.setVisibility(0);
    }
}
