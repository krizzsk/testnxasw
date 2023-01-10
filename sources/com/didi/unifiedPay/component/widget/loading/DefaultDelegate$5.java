package com.didi.unifiedPay.component.widget.loading;

import android.animation.Animator;

class DefaultDelegate$5 extends C15296f {
    final /* synthetic */ C15291a this$0;

    DefaultDelegate$5(C15291a aVar) {
        this.this$0 = aVar;
    }

    /* access modifiers changed from: protected */
    public void onPreAnimationEnd(Animator animator) {
        if (isStartedAndNotCancelled()) {
            this.this$0.m35110h();
            C15291a aVar = this.this$0;
            int unused = aVar.f47178p = (aVar.f47178p + 1) % this.this$0.f47186x.length;
            C15291a aVar2 = this.this$0;
            int unused2 = aVar2.f47177o = aVar2.f47186x[this.this$0.f47178p];
            this.this$0.f47167G.getCurrentPaint().setColor(this.this$0.f47177o);
            this.this$0.f47171i.start();
        }
    }
}
