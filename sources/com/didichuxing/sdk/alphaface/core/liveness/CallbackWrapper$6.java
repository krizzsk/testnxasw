package com.didichuxing.sdk.alphaface.core.liveness;

class CallbackWrapper$6 implements Runnable {
    final /* synthetic */ C17138c this$0;
    final /* synthetic */ int val$p;

    CallbackWrapper$6(C17138c cVar, int i) {
        this.this$0 = cVar;
        this.val$p = i;
    }

    public void run() {
        if (this.this$0.f51296a != null) {
            this.this$0.f51296a.onMirrorProcess((long) this.val$p);
        }
    }
}
