package com.github.mikephil.charting.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import com.github.mikephil.charting.animation.Easing;

public class ChartAnimator {

    /* renamed from: a */
    private ValueAnimator.AnimatorUpdateListener f54767a;
    protected float mPhaseX = 1.0f;
    protected float mPhaseY = 1.0f;

    public ChartAnimator() {
    }

    public ChartAnimator(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f54767a = animatorUpdateListener;
    }

    /* renamed from: a */
    private ObjectAnimator m40684a(int i, Easing.EasingFunction easingFunction) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseX", new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(easingFunction);
        ofFloat.setDuration((long) i);
        return ofFloat;
    }

    /* renamed from: b */
    private ObjectAnimator m40685b(int i, Easing.EasingFunction easingFunction) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseY", new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(easingFunction);
        ofFloat.setDuration((long) i);
        return ofFloat;
    }

    public void animateX(int i) {
        animateX(i, Easing.Linear);
    }

    public void animateX(int i, Easing.EasingFunction easingFunction) {
        ObjectAnimator a = m40684a(i, easingFunction);
        a.addUpdateListener(this.f54767a);
        a.start();
    }

    public void animateXY(int i, int i2) {
        animateXY(i, i2, Easing.Linear, Easing.Linear);
    }

    public void animateXY(int i, int i2, Easing.EasingFunction easingFunction) {
        ObjectAnimator a = m40684a(i, easingFunction);
        ObjectAnimator b = m40685b(i2, easingFunction);
        if (i > i2) {
            a.addUpdateListener(this.f54767a);
        } else {
            b.addUpdateListener(this.f54767a);
        }
        a.start();
        b.start();
    }

    public void animateXY(int i, int i2, Easing.EasingFunction easingFunction, Easing.EasingFunction easingFunction2) {
        ObjectAnimator a = m40684a(i, easingFunction);
        ObjectAnimator b = m40685b(i2, easingFunction2);
        if (i > i2) {
            a.addUpdateListener(this.f54767a);
        } else {
            b.addUpdateListener(this.f54767a);
        }
        a.start();
        b.start();
    }

    public void animateY(int i) {
        animateY(i, Easing.Linear);
    }

    public void animateY(int i, Easing.EasingFunction easingFunction) {
        ObjectAnimator b = m40685b(i, easingFunction);
        b.addUpdateListener(this.f54767a);
        b.start();
    }

    public float getPhaseY() {
        return this.mPhaseY;
    }

    public void setPhaseY(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.mPhaseY = f;
    }

    public float getPhaseX() {
        return this.mPhaseX;
    }

    public void setPhaseX(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.mPhaseX = f;
    }
}
