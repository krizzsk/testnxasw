package com.didi.component.evaluateentrance.evaluate.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class LinearLayoutAnimator extends LinearLayout {

    /* renamed from: a */
    private static final String f15399a = "FrameLayoutAnimator";

    /* renamed from: b */
    private ValueAnimator f15400b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f15401c = false;

    /* renamed from: d */
    private boolean f15402d = false;

    public LinearLayoutAnimator(Context context) {
        super(context);
        m12699a();
    }

    public LinearLayoutAnimator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12699a();
    }

    public LinearLayoutAnimator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12699a();
    }

    public LinearLayoutAnimator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m12699a();
    }

    /* renamed from: a */
    private void m12699a() {
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f15400b = valueAnimator;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LinearLayoutAnimator.this.setLayoutHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.f15400b.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = LinearLayoutAnimator.this.f15401c = false;
                LinearLayoutAnimator.this.setLayoutHeight(-2);
            }
        });
        this.f15400b.setDuration(400);
    }

    public void setEnableAnimator(boolean z) {
        this.f15402d = z;
    }

    public ValueAnimator getValueAnimator() {
        return this.f15400b;
    }

    /* access modifiers changed from: private */
    public void setLayoutHeight(int i) {
        if (getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = i;
            setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int measuredHeight = getMeasuredHeight();
        super.onMeasure(i, i2);
        int measuredHeight2 = getMeasuredHeight();
        if (this.f15402d && !this.f15401c && Math.abs(measuredHeight - measuredHeight2) >= 5) {
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
            this.f15401c = true;
            this.f15400b.setIntValues(new int[]{measuredHeight, measuredHeight2});
            this.f15400b.start();
        }
    }
}
