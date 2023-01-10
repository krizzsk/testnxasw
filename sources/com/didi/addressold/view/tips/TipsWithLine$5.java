package com.didi.addressold.view.tips;

import android.os.CountDownTimer;

class TipsWithLine$5 extends CountDownTimer {
    final /* synthetic */ C4090c this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TipsWithLine$5(C4090c cVar, long j, long j2) {
        super(j, j2);
        this.this$0 = cVar;
    }

    public void onTick(long j) {
        if (this.this$0.f9856a != null) {
            C4090c cVar = this.this$0;
            cVar.m8590b("" + (j / 1000));
        }
    }

    public void onFinish() {
        this.this$0.m8590b("0");
        this.this$0.mo44859b();
    }
}
