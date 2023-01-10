package com.didi.unifiedPay.component.widget.loading;

import android.animation.ValueAnimator;

class DefaultDelegate$6 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ C15291a this$0;

    DefaultDelegate$6(C15291a aVar) {
        this.this$0 = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.this$0.m35101d(1.0f - C15297g.m35132a(valueAnimator));
    }
}
