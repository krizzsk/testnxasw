package com.didichuxing.sofa.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* renamed from: com.didichuxing.sofa.animation.f */
/* compiled from: AnimatorSetListenerWrapper */
class C17261f extends AnimatorListenerAdapter {

    /* renamed from: a */
    private Animator f51666a;

    /* renamed from: b */
    private AnimatorListener f51667b;

    C17261f(Animator animator, AnimatorListener animatorListener) {
        this.f51666a = animator;
        this.f51667b = animatorListener;
    }

    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        AnimatorListener animatorListener = this.f51667b;
        if (animatorListener != null) {
            animatorListener.onAnimationStart(this.f51666a, (View) null);
        }
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        animator.removeListener(this);
        AnimatorListener animatorListener = this.f51667b;
        if (animatorListener != null) {
            animatorListener.onAnimationEnd(this.f51666a, (View) null);
        }
    }
}
