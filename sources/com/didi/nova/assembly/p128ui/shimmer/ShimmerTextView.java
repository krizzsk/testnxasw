package com.didi.nova.assembly.p128ui.shimmer;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.didi.nova.assembly.p128ui.shimmer.ShimmerViewHelper;

/* renamed from: com.didi.nova.assembly.ui.shimmer.ShimmerTextView */
public class ShimmerTextView extends TextView implements ShimmerViewBase {

    /* renamed from: a */
    private ShimmerViewHelper f31763a;

    public ShimmerTextView(Context context) {
        super(context);
        ShimmerViewHelper shimmerViewHelper = new ShimmerViewHelper(this, getPaint(), (AttributeSet) null);
        this.f31763a = shimmerViewHelper;
        shimmerViewHelper.setPrimaryColor(getCurrentTextColor());
    }

    public ShimmerTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ShimmerViewHelper shimmerViewHelper = new ShimmerViewHelper(this, getPaint(), attributeSet);
        this.f31763a = shimmerViewHelper;
        shimmerViewHelper.setPrimaryColor(getCurrentTextColor());
    }

    public ShimmerTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ShimmerViewHelper shimmerViewHelper = new ShimmerViewHelper(this, getPaint(), attributeSet);
        this.f31763a = shimmerViewHelper;
        shimmerViewHelper.setPrimaryColor(getCurrentTextColor());
    }

    public float getGradientX() {
        return this.f31763a.getGradientX();
    }

    public void setGradientX(float f) {
        this.f31763a.setGradientX(f);
    }

    public boolean isShimmering() {
        return this.f31763a.isShimmering();
    }

    public void setShimmering(boolean z) {
        this.f31763a.setShimmering(z);
    }

    public boolean isSetUp() {
        return this.f31763a.isSetUp();
    }

    public void setAnimationSetupCallback(ShimmerViewHelper.AnimationSetupCallback animationSetupCallback) {
        this.f31763a.setAnimationSetupCallback(animationSetupCallback);
    }

    public int getPrimaryColor() {
        return this.f31763a.getPrimaryColor();
    }

    public void setPrimaryColor(int i) {
        this.f31763a.setPrimaryColor(i);
    }

    public int getReflectionColor() {
        return this.f31763a.getReflectionColor();
    }

    public void setReflectionColor(int i) {
        this.f31763a.setReflectionColor(i);
    }

    public void setTextColor(int i) {
        super.setTextColor(i);
        ShimmerViewHelper shimmerViewHelper = this.f31763a;
        if (shimmerViewHelper != null) {
            shimmerViewHelper.setPrimaryColor(getCurrentTextColor());
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        ShimmerViewHelper shimmerViewHelper = this.f31763a;
        if (shimmerViewHelper != null) {
            shimmerViewHelper.setPrimaryColor(getCurrentTextColor());
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ShimmerViewHelper shimmerViewHelper = this.f31763a;
        if (shimmerViewHelper != null) {
            shimmerViewHelper.onSizeChanged();
        }
    }

    public void onDraw(Canvas canvas) {
        ShimmerViewHelper shimmerViewHelper = this.f31763a;
        if (shimmerViewHelper != null) {
            shimmerViewHelper.onDraw();
        }
        super.onDraw(canvas);
    }
}
