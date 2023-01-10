package com.didichuxing.sdk.alphaface.core.liveness;

class CallbackWrapper$1 implements Runnable {
    final /* synthetic */ C17138c this$0;
    final /* synthetic */ int val$type;

    CallbackWrapper$1(C17138c cVar, int i) {
        this.this$0 = cVar;
        this.val$type = i;
    }

    public void run() {
        if (this.this$0.f51296a != null) {
            this.this$0.f51296a.onFaceError(this.val$type);
        }
    }
}
