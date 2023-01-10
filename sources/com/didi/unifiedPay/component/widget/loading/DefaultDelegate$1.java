package com.didi.unifiedPay.component.widget.loading;

import android.animation.ValueAnimator;

class DefaultDelegate$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ C15291a this$0;

    DefaultDelegate$1(C15291a aVar) {
        this.this$0 = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.this$0.mo118209a(C15297g.m35132a(valueAnimator) * 360.0f);
    }
}
