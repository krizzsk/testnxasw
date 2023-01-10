package com.didichuxing.sofa.animation;

import android.animation.TypeEvaluator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;

/* renamed from: com.didichuxing.sofa.animation.x */
/* compiled from: ViewAnimatorBuilder */
class C17278x extends AnimatorBuilder {
    C17278x() {
        this.f51645b = new C17277w();
    }

    public AnimatorBuilder repeatCount(int i) {
        this.f51644a.mo127653c(i);
        return this;
    }

    public AnimatorBuilder repeatInfinite() {
        this.f51644a.mo127653c(-1);
        return this;
    }

    public AnimatorBuilder repeatRestart() {
        this.f51644a.mo127651b(1);
        return this;
    }

    public AnimatorBuilder repeatReverse() {
        this.f51644a.mo127651b(2);
        return this;
    }

    public AnimatorBuilder duration(int i) {
        this.f51644a.mo127645a(i);
        return this;
    }

    public AnimatorBuilder accelerateDecelerate() {
        this.f51644a.mo127648a((Interpolator) new AccelerateDecelerateInterpolator());
        return this;
    }

    public AnimatorBuilder accelerate() {
        this.f51644a.mo127648a((Interpolator) new AccelerateInterpolator());
        return this;
    }

    public AnimatorBuilder bounce() {
        this.f51644a.mo127648a((Interpolator) new BounceInterpolator());
        return this;
    }

    public AnimatorBuilder decelerate() {
        this.f51644a.mo127648a((Interpolator) new DecelerateInterpolator());
        return this;
    }

    public AnimatorBuilder overshoot() {
        this.f51644a.mo127648a((Interpolator) new OvershootInterpolator());
        return this;
    }

    public AnimatorBuilder anticipate() {
        this.f51644a.mo127648a((Interpolator) new AnticipateInterpolator());
        return this;
    }

    public AnimatorBuilder anticipateOvershoot() {
        this.f51644a.mo127648a((Interpolator) new AnticipateOvershootInterpolator());
        return this;
    }

    public AnimatorBuilder interpolator(Interpolator interpolator) {
        this.f51644a.mo127648a(interpolator);
        return this;
    }

    public AnimatorBuilder evaluator(TypeEvaluator typeEvaluator) {
        this.f51644a.mo127647a(typeEvaluator);
        return this;
    }

    public AnimatorBuilder startDelay(long j) {
        this.f51644a.mo127646a(j);
        return this;
    }

    /* renamed from: a */
    public AnimatorBuilder bounceEaseOut() {
        this.f51644a.mo127647a((TypeEvaluator) new C17264i(0.0f));
        return this;
    }

    /* renamed from: b */
    public AnimatorBuilder elasticEaseOut() {
        this.f51644a.mo127647a((TypeEvaluator) new C17268m(0.0f));
        return this;
    }
}
