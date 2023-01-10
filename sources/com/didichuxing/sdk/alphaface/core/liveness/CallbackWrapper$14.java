package com.didichuxing.sdk.alphaface.core.liveness;

class CallbackWrapper$14 implements Runnable {
    final /* synthetic */ C17138c this$0;
    final /* synthetic */ int val$action;

    CallbackWrapper$14(C17138c cVar, int i) {
        this.this$0 = cVar;
        this.val$action = i;
    }

    public void run() {
        if (this.this$0.f51296a != null) {
            this.this$0.f51296a.onActionTip(this.val$action);
        }
    }
}
