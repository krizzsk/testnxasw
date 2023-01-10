package com.didichuxing.sofa.animation;

import com.didichuxing.sofa.animation.Animator;

class ViewAnimator$2 implements Animator.PrepareAnimationCallback {
    final /* synthetic */ C17277w this$0;

    ViewAnimator$2(C17277w wVar) {
        this.this$0 = wVar;
    }

    public void onPrepared() {
        this.this$0.m38853d();
        boolean unused = this.this$0.f51709g = true;
        C17277w wVar = this.this$0;
        wVar.m38847a("build onPrepared mPending: " + this.this$0.f51710h);
        if (this.this$0.f51710h) {
            boolean unused2 = this.this$0.f51710h = false;
            this.this$0.m38855e();
        }
    }
}
