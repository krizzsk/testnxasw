package com.didi.addressold.view.tips;

import android.view.ViewTreeObserver;

class TipsWithLine$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ C4090c this$0;

    TipsWithLine$1(C4090c cVar) {
        this.this$0 = cVar;
    }

    public void onGlobalLayout() {
        if (this.this$0.f9867l) {
            this.this$0.m8597d();
        } else if (!this.this$0.f9869n && this.this$0.f9875t != null && !this.this$0.f9867l) {
            this.this$0.m8598e();
            boolean unused = this.this$0.f9868m = false;
        }
    }
}
