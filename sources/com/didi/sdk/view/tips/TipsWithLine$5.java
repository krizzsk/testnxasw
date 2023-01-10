package com.didi.sdk.view.tips;

import android.os.CountDownTimer;

class TipsWithLine$5 extends CountDownTimer {
    final /* synthetic */ C14097c this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TipsWithLine$5(C14097c cVar, long j, long j2) {
        super(j, j2);
        this.this$0 = cVar;
    }

    public void onTick(long j) {
        if (this.this$0.f40989a != null) {
            C14097c cVar = this.this$0;
            cVar.m30730b("" + (j / 1000));
        }
    }

    public void onFinish() {
        this.this$0.m30730b("0");
        this.this$0.mo104339b();
    }
}
