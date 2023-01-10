package com.didichuxing.sdk.alphaface.core.liveness;

class CallbackWrapper$11 implements Runnable {
    final /* synthetic */ C17138c this$0;
    final /* synthetic */ int val$actionCount;
    final /* synthetic */ int val$currentAction;
    final /* synthetic */ int val$currentIndex;
    final /* synthetic */ int val$nextAction;

    CallbackWrapper$11(C17138c cVar, int i, int i2, int i3, int i4) {
        this.this$0 = cVar;
        this.val$currentAction = i;
        this.val$nextAction = i2;
        this.val$currentIndex = i3;
        this.val$actionCount = i4;
    }

    public void run() {
        if (this.this$0.f51296a != null) {
            this.this$0.f51296a.onActionChange(this.val$currentAction, this.val$nextAction, this.val$currentIndex, this.val$actionCount);
        }
    }
}
