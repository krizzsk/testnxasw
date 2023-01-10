package com.didichuxing.sdk.alphaface.core.liveness;

class CallbackWrapper$2 implements Runnable {
    final /* synthetic */ C17138c this$0;
    final /* synthetic */ int[] val$actions;

    CallbackWrapper$2(C17138c cVar, int[] iArr) {
        this.this$0 = cVar;
        this.val$actions = iArr;
    }

    public void run() {
        if (this.this$0.f51296a != null) {
            this.this$0.f51296a.onStartAction(this.val$actions);
        }
    }
}
