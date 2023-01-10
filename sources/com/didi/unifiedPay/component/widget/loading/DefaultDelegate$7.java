package com.didi.unifiedPay.component.widget.loading;

import android.animation.Animator;
import com.didi.unifiedPay.component.widget.loading.CircularProgressDrawable;

class DefaultDelegate$7 extends C15296f {
    final /* synthetic */ C15291a this$0;

    DefaultDelegate$7(C15291a aVar) {
        this.this$0 = aVar;
    }

    public void onPreAnimationEnd(Animator animator) {
        this.this$0.f47174l.removeListener(this);
        CircularProgressDrawable.OnEndListener m = this.this$0.f47168H;
        CircularProgressDrawable.OnEndListener unused = this.this$0.f47168H = null;
        if (isStartedAndNotCancelled()) {
            this.this$0.m35101d(0.0f);
            this.this$0.f47167G.stop();
            if (m != null) {
                m.onEnd(this.this$0.f47167G);
            }
        }
    }
}
