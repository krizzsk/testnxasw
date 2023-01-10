package com.didichuxing.sofa.animation;

import android.animation.TypeEvaluator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import java.util.ArrayList;
import java.util.List;

public class ValueAnimatorBuilder implements C17260e, C17267l<ValueAnimatorBuilder> {

    /* renamed from: a */
    float[] f51647a = {0.0f, 1.0f};

    /* renamed from: b */
    int f51648b = 1000;

    /* renamed from: c */
    int f51649c = 0;

    /* renamed from: d */
    int f51650d = 1;

    /* renamed from: e */
    Interpolator f51651e = new LinearInterpolator();

    /* renamed from: f */
    long f51652f = 0;

    /* renamed from: g */
    TypeEvaluator f51653g = null;

    /* renamed from: h */
    List<AnimatorUpdateListener> f51654h = new ArrayList();

    /* renamed from: i */
    private final int f51655i = 1000;

    /* renamed from: j */
    private final long f51656j = 0;

    /* renamed from: k */
    private C17276v f51657k = new C17276v();

    ValueAnimatorBuilder() {
    }

    public ValueAnimatorBuilder values(float... fArr) {
        this.f51647a = fArr;
        return this;
    }

    public ValueAnimatorBuilder repeatCount(int i) {
        this.f51649c = i;
        return this;
    }

    public ValueAnimatorBuilder repeatInfinite() {
        this.f51649c = -1;
        return this;
    }

    public ValueAnimatorBuilder repeatRestart() {
        this.f51650d = 1;
        return this;
    }

    public ValueAnimatorBuilder repeatReverse() {
        this.f51650d = 2;
        return this;
    }

    public ValueAnimatorBuilder duration(int i) {
        this.f51648b = i;
        return this;
    }

    public ValueAnimatorBuilder accelerateDecelerate() {
        this.f51651e = new AccelerateDecelerateInterpolator();
        return this;
    }

    public ValueAnimatorBuilder accelerate() {
        this.f51651e = new AccelerateInterpolator();
        return this;
    }

    public ValueAnimatorBuilder bounce() {
        this.f51651e = new BounceInterpolator();
        return this;
    }

    public ValueAnimatorBuilder decelerate() {
        this.f51651e = new DecelerateInterpolator();
        return this;
    }

    public ValueAnimatorBuilder overshoot() {
        this.f51651e = new OvershootInterpolator();
        return this;
    }

    public ValueAnimatorBuilder anticipate() {
        this.f51651e = new AnticipateInterpolator();
        return this;
    }

    public ValueAnimatorBuilder anticipateOvershoot() {
        this.f51651e = new AnticipateOvershootInterpolator();
        return this;
    }

    public ValueAnimatorBuilder interpolator(Interpolator interpolator) {
        this.f51651e = interpolator;
        return this;
    }

    public ValueAnimatorBuilder evaluator(TypeEvaluator typeEvaluator) {
        this.f51653g = typeEvaluator;
        return this;
    }

    public ValueAnimatorBuilder startDelay(long j) {
        this.f51652f = j;
        return this;
    }

    public ValueAnimatorBuilder withListener(AnimatorUpdateListener animatorUpdateListener) {
        if (animatorUpdateListener != null) {
            this.f51654h.add(animatorUpdateListener);
        }
        return this;
    }

    public ValueAnimatorBuilder bounceEaseOut() {
        this.f51653g = new C17264i(0.0f);
        return this;
    }

    public ValueAnimatorBuilder elasticEaseOut() {
        this.f51653g = new C17268m(0.0f);
        return this;
    }

    public Animator playTogether(Animator... animatorArr) {
        this.f51657k.playTogether(animatorArr);
        return this.f51657k;
    }

    public Animator playSequentially(Animator... animatorArr) {
        this.f51657k.playSequentially(animatorArr);
        return this.f51657k;
    }

    public Animator build() {
        if (!this.f51654h.isEmpty()) {
            this.f51657k.mo127669a(this);
            return this.f51657k;
        }
        throw new IllegalStateException("Value animator must have one AnimatorUpdateListener at least, do you forget it? ");
    }
}
