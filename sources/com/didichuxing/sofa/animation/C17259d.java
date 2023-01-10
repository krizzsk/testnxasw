package com.didichuxing.sofa.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: com.didichuxing.sofa.animation.d */
/* compiled from: AnimatorListenerWrapper */
class C17259d extends AnimatorListenerAdapter {

    /* renamed from: a */
    private Animator f51663a;

    /* renamed from: b */
    private C17273s f51664b;

    /* renamed from: c */
    private AnimatorListener f51665c;

    C17259d(Animator animator, C17273s sVar, AnimatorListener animatorListener) {
        this.f51663a = animator;
        this.f51664b = sVar;
        this.f51665c = animatorListener;
    }

    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        AnimatorListener animatorListener = this.f51665c;
        if (animatorListener != null) {
            animatorListener.onAnimationStart(this.f51663a, this.f51664b.mo127649b());
        }
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        animator.removeListener(this);
        AnimatorListener animatorListener = this.f51665c;
        if (animatorListener != null) {
            animatorListener.onAnimationEnd(this.f51663a, this.f51664b.mo127649b());
        }
    }
}
