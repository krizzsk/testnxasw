package com.didi.sdk.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;
import com.didi.passenger.C11267R;

public class SuperscriptView extends TextView {
    public static final int Gravity_LEFT_TOP = 1;
    public static final int Gravity_RIGHT_TOP = 2;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public float f40614a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public float f40615b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public float f40616c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f40617d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f40618e;

    /* renamed from: f */
    private int f40619f;

    /* renamed from: g */
    private Animation f40620g = new Animation() {
        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            if (SuperscriptView.this.f40617d >= 1 && SuperscriptView.this.f40618e >= 1) {
                Matrix matrix = transformation.getMatrix();
                matrix.setTranslate(SuperscriptView.this.f40614a, SuperscriptView.this.f40615b);
                matrix.postRotate(SuperscriptView.this.f40616c, SuperscriptView.this.f40614a, SuperscriptView.this.f40615b);
            }
        }
    };

    public SuperscriptView(Context context) {
        super(context);
    }

    public SuperscriptView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30492a(context, attributeSet);
    }

    public SuperscriptView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30492a(context, attributeSet);
    }

    public void setVisibility(int i) {
        clearAnimation();
        super.setVisibility(i);
        if (i == 0) {
            startAnimation(this.f40620g);
        }
    }

    /* renamed from: a */
    private void m30492a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.SuperscriptView);
        this.f40619f = obtainStyledAttributes.getInt(0, 1);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        int i = this.f40619f;
        if (i == 1) {
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            if (dimensionPixelSize4 <= 0 || dimensionPixelSize2 <= 0) {
                m30494b(dimensionPixelSize3, dimensionPixelSize);
            } else {
                m30495b(dimensionPixelSize3, dimensionPixelSize4, dimensionPixelSize, dimensionPixelSize2);
            }
        } else if (i == 2) {
            int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            int dimensionPixelSize6 = obtainStyledAttributes.getDimensionPixelSize(4, 0);
            if (dimensionPixelSize6 <= 0 || dimensionPixelSize2 <= 0) {
                m30490a(dimensionPixelSize5, dimensionPixelSize);
            } else {
                m30491a(dimensionPixelSize5, dimensionPixelSize6, dimensionPixelSize, dimensionPixelSize2);
            }
        }
        obtainStyledAttributes.recycle();
        this.f40620g.setFillBefore(true);
        this.f40620g.setFillAfter(true);
        this.f40620g.setFillEnabled(true);
        startAnimation(this.f40620g);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4 = this.f40617d;
        if (i4 < 1 || (i3 = this.f40618e) < 1) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (super.getVisibility() == 0) {
            startAnimation(this.f40620g);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        super.clearAnimation();
    }

    /* renamed from: a */
    private void m30490a(int i, int i2) {
        double d = (double) i2;
        double d2 = (double) i;
        double sqrt = Math.sqrt(Math.pow(d, 2.0d) + Math.pow(d2, 2.0d));
        double d3 = d2 / sqrt;
        this.f40616c = (float) Math.toDegrees(Math.asin(d3));
        int round = Math.round((float) (d3 * d));
        this.f40617d = round;
        this.f40615b = -((float) ((d / sqrt) * ((double) round)));
        this.f40614a = (float) ((d3 * ((double) round)) + (sqrt - d));
        this.f40618e = Math.round((float) sqrt);
    }

    /* renamed from: a */
    private void m30491a(int i, int i2, int i3, int i4) {
        double d = (double) i3;
        double d2 = (double) i;
        double sqrt = Math.sqrt(Math.pow(d, 2.0d) + Math.pow(d2, 2.0d));
        double d3 = d2 / sqrt;
        double d4 = (d - ((double) i4)) * d3;
        this.f40615b = (float) (-((d / sqrt) * d4));
        this.f40614a = (float) ((sqrt - d) + (d3 * d4));
        this.f40616c = (float) Math.toDegrees(Math.asin(d3));
        this.f40618e = Math.round((float) sqrt);
        this.f40617d = Math.round((float) d4);
    }

    /* renamed from: b */
    private void m30494b(int i, int i2) {
        double d = (double) i2;
        double d2 = (double) i;
        double sqrt = Math.sqrt(Math.pow(d, 2.0d) + Math.pow(d2, 2.0d));
        double d3 = d2 / sqrt;
        this.f40616c = -((float) Math.toDegrees(Math.asin(d3)));
        this.f40617d = Math.round((float) (d3 * d));
        double d4 = d2 * d3;
        this.f40614a = -((float) ((d / sqrt) * d4));
        this.f40615b = (float) (d3 * d4);
        this.f40618e = Math.round((float) sqrt);
    }

    /* renamed from: b */
    private void m30495b(int i, int i2, int i3, int i4) {
        double d = (double) i3;
        double d2 = (double) i;
        double sqrt = Math.sqrt(Math.pow(d, 2.0d) + Math.pow(d2, 2.0d));
        double d3 = d2 / sqrt;
        this.f40616c = -((float) Math.toDegrees(Math.asin(d3)));
        this.f40617d = Math.round((float) (((double) (i3 - i4)) * d3));
        double d4 = ((double) (i - i2)) * d3;
        this.f40614a = -((float) ((d / sqrt) * d4));
        this.f40615b = (float) (((double) i2) + (d3 * d4));
        this.f40618e = Math.round((float) sqrt);
    }
}
