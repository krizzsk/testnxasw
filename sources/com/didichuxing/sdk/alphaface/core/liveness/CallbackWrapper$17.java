package com.didichuxing.sdk.alphaface.core.liveness;

class CallbackWrapper$17 implements Runnable {
    final /* synthetic */ C17138c this$0;

    CallbackWrapper$17(C17138c cVar) {
        this.this$0 = cVar;
    }

    public void run() {
        if (this.this$0.f51296a != null) {
            this.this$0.f51296a.onRestart();
        }
    }
}
