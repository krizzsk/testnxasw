package com.didichuxing.sdk.alphaface.core.liveness;

class CallbackWrapper$9 implements Runnable {
    final /* synthetic */ C17138c this$0;
    final /* synthetic */ int val$time;

    CallbackWrapper$9(C17138c cVar, int i) {
        this.this$0 = cVar;
        this.val$time = i;
    }

    public void run() {
        this.this$0.f51296a.onActionCountdown(this.val$time);
    }
}
