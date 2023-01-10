package com.didi.unifiedPay.component.widget.loading;

import android.animation.Animator;

class DefaultDelegate$3 extends C15296f {
    final /* synthetic */ C15291a this$0;

    DefaultDelegate$3(C15291a aVar) {
        this.this$0 = aVar;
    }

    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        boolean unused = this.this$0.f47175m = true;
    }

    /* access modifiers changed from: protected */
    public void onPreAnimationEnd(Animator animator) {
        if (isStartedAndNotCancelled()) {
            boolean unused = this.this$0.f47183u = false;
            this.this$0.m35112i();
            this.this$0.f47172j.start();
        }
    }
}
