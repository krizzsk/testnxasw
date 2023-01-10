package com.didi.sdk.view.tips;

import android.view.ViewTreeObserver;

class TipsWithLine$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ C14097c this$0;

    TipsWithLine$1(C14097c cVar) {
        this.this$0 = cVar;
    }

    public void onGlobalLayout() {
        if (this.this$0.f41000l) {
            this.this$0.m30737d();
        } else if (!this.this$0.f41002n && this.this$0.f41008t != null && !this.this$0.f41000l) {
            this.this$0.m30738e();
            boolean unused = this.this$0.f41001m = false;
        }
    }
}
