package com.didichuxing.sofa.animation;

import android.animation.ValueAnimator;

/* renamed from: com.didichuxing.sofa.animation.g */
/* compiled from: AnimatorUpdateListenerWrapper */
class C17262g implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    private Animator f51668a;

    /* renamed from: b */
    private AnimatorUpdateListener f51669b;

    C17262g(Animator animator, AnimatorUpdateListener animatorUpdateListener) {
        this.f51668a = animator;
        this.f51669b = animatorUpdateListener;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        AnimatorUpdateListener animatorUpdateListener = this.f51669b;
        if (animatorUpdateListener != null) {
            animatorUpdateListener.onAnimationUpdate(this.f51668a, valueAnimator.getAnimatedValue());
        }
    }
}
