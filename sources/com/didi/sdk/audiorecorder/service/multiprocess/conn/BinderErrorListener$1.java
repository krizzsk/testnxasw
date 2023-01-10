package com.didi.sdk.audiorecorder.service.multiprocess.conn;

class BinderErrorListener$1 implements Runnable {
    final /* synthetic */ C12925a this$0;
    final /* synthetic */ int val$errorCode;

    BinderErrorListener$1(C12925a aVar, int i) {
        this.this$0 = aVar;
        this.val$errorCode = i;
    }

    public void run() {
        if (this.this$0.f38253a != null) {
            this.this$0.f38253a.onError(this.val$errorCode);
        }
    }
}
