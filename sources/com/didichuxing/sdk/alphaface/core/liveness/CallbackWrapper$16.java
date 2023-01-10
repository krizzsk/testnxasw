package com.didichuxing.sdk.alphaface.core.liveness;

class CallbackWrapper$16 implements Runnable {
    final /* synthetic */ C17138c this$0;
    final /* synthetic */ LivenessResult val$livenessResult;

    CallbackWrapper$16(C17138c cVar, LivenessResult livenessResult) {
        this.this$0 = cVar;
        this.val$livenessResult = livenessResult;
    }

    public void run() {
        if (this.this$0.f51296a != null) {
            this.this$0.f51296a.onSuccess(this.val$livenessResult);
        }
    }
}
