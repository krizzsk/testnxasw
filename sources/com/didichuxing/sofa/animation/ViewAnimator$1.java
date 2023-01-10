package com.didichuxing.sofa.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class ViewAnimator$1 extends AnimatorListenerAdapter {
    final /* synthetic */ C17277w this$0;
    final /* synthetic */ C17273s val$builder;

    ViewAnimator$1(C17277w wVar, C17273s sVar) {
        this.this$0 = wVar;
        this.val$builder = sVar;
    }

    public void onAnimationStart(Animator animator) {
        C17277w wVar = this.this$0;
        wVar.m38847a("onAnimationStart animation: " + animator);
        super.onAnimationStart(animator);
        View b = this.val$builder.mo127649b();
        if (b == null) {
            LoggerUtil.m38758e("ViewAnimator", "onAnimationStart error: target is null!!");
        } else {
            b.setVisibility(0);
        }
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        animator.removeListener(this);
        C17277w wVar = this.this$0;
        wVar.m38847a("onAnimationEnd animation.getListeners(): " + animator.getListeners());
    }
}
