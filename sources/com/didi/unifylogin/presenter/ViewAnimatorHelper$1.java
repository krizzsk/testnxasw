package com.didi.unifylogin.presenter;

import android.animation.ValueAnimator;

class ViewAnimatorHelper$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ C15457a this$0;

    ViewAnimatorHelper$1(C15457a aVar) {
        this.this$0 = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.this$0.m35659a(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
