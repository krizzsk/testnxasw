package com.didi.unifiedPay.component.widget.loading;

import android.animation.ValueAnimator;

class DefaultDelegate$2 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ C15291a this$0;

    DefaultDelegate$2(C15291a aVar) {
        this.this$0 = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f;
        float a = C15297g.m35132a(valueAnimator);
        if (this.this$0.f47183u) {
            f = a * ((float) this.this$0.f47162B);
        } else {
            f = (a * ((float) (this.this$0.f47162B - this.this$0.f47161A))) + ((float) this.this$0.f47161A);
        }
        this.this$0.mo118214b(f);
    }
}
