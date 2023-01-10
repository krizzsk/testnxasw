package com.iproov.sdk.p227ui.views;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;

/* renamed from: com.iproov.sdk.ui.views.ProgressView */
public class ProgressView extends ProgressBar {

    /* renamed from: a */
    private final ObjectAnimator f57286a = ObjectAnimator.ofInt(this, "progress", new int[]{0});

    public ProgressView(Context context) {
        super(context);
        m43566a();
    }

    /* renamed from: a */
    private void m43566a() {
        this.f57286a.setAutoCancel(true);
        this.f57286a.setInterpolator(new LinearInterpolator());
    }

    /* renamed from: do */
    public void mo171613do(int i, long j) {
        this.f57286a.setIntValues(new int[]{i});
        this.f57286a.setDuration(j);
        this.f57286a.start();
    }

    /* renamed from: do */
    public void mo171612do() {
        this.f57286a.cancel();
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m43566a();
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m43566a();
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m43566a();
    }
}
