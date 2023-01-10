package com.didi.sdk.audiorecorder.service.multiprocess.conn;

class BinderRecordDurationListener$1 implements Runnable {
    final /* synthetic */ C12927c this$0;
    final /* synthetic */ int val$recordDuration;

    BinderRecordDurationListener$1(C12927c cVar, int i) {
        this.this$0 = cVar;
        this.val$recordDuration = i;
    }

    public void run() {
        if (this.this$0.f38258a != null) {
            this.this$0.f38258a.onTimeTick(this.val$recordDuration);
        }
    }
}
