package com.didichuxing.sdk.alphaface.core.liveness;

import java.util.List;

class CallbackWrapper$12 implements Runnable {
    final /* synthetic */ C17138c this$0;
    final /* synthetic */ List val$bestPicList;

    CallbackWrapper$12(C17138c cVar, List list) {
        this.this$0 = cVar;
        this.val$bestPicList = list;
    }

    public void run() {
        if (this.this$0.f51296a != null) {
            this.this$0.f51296a.onActionSuccess(this.val$bestPicList);
        }
        C17138c cVar = this.this$0;
        cVar.onSuccess(cVar.f51304i);
    }
}
