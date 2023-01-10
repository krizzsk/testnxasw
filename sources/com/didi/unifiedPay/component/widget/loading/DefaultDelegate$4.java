package com.didi.unifiedPay.component.widget.loading;

import android.animation.ValueAnimator;

class DefaultDelegate$4 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ C15291a this$0;

    DefaultDelegate$4(C15291a aVar) {
        this.this$0 = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float a = C15297g.m35132a(valueAnimator);
        C15291a aVar = this.this$0;
        aVar.mo118214b(((float) aVar.f47162B) - (a * ((float) (this.this$0.f47162B - this.this$0.f47161A))));
        float currentPlayTime = ((float) valueAnimator.getCurrentPlayTime()) / ((float) valueAnimator.getDuration());
        if (this.this$0.f47186x.length > 1 && currentPlayTime > 0.7f) {
            this.this$0.f47167G.getCurrentPaint().setColor(((Integer) C15291a.f47155c.evaluate((currentPlayTime - 0.7f) / 0.3f, Integer.valueOf(this.this$0.f47177o), Integer.valueOf(this.this$0.f47186x[(this.this$0.f47178p + 1) % this.this$0.f47186x.length]))).intValue());
        }
    }
}
