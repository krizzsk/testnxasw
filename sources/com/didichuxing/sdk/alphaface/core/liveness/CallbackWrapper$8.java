package com.didichuxing.sdk.alphaface.core.liveness;

class CallbackWrapper$8 implements Runnable {
    final /* synthetic */ C17138c this$0;

    CallbackWrapper$8(C17138c cVar) {
        this.this$0 = cVar;
    }

    public void run() {
        if (this.this$0.f51296a != null) {
            this.this$0.f51296a.onActionReset();
        }
    }
}
