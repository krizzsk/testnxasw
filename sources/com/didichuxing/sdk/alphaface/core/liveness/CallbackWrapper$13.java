package com.didichuxing.sdk.alphaface.core.liveness;

class CallbackWrapper$13 implements Runnable {
    final /* synthetic */ C17138c this$0;
    final /* synthetic */ int val$action;
    final /* synthetic */ int[] val$info;
    final /* synthetic */ int val$pass;
    final /* synthetic */ int val$type;

    CallbackWrapper$13(C17138c cVar, int i, int i2, int i3, int[] iArr) {
        this.this$0 = cVar;
        this.val$pass = i;
        this.val$type = i2;
        this.val$action = i3;
        this.val$info = iArr;
    }

    public void run() {
        if (this.this$0.f51296a != null) {
            this.this$0.f51296a.onActionInfo(this.val$pass, this.val$type, this.val$action, this.val$info);
        }
    }
}
