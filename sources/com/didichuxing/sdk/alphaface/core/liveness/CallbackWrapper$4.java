package com.didichuxing.sdk.alphaface.core.liveness;

import java.util.List;

class CallbackWrapper$4 implements Runnable {
    final /* synthetic */ C17138c this$0;
    final /* synthetic */ List val$attackPicList;
    final /* synthetic */ List val$bestPicList;
    final /* synthetic */ List val$waterMarkPicList;

    CallbackWrapper$4(C17138c cVar, List list, List list2, List list3) {
        this.this$0 = cVar;
        this.val$bestPicList = list;
        this.val$attackPicList = list2;
        this.val$waterMarkPicList = list3;
    }

    public void run() {
        if (this.this$0.f51296a != null) {
            this.this$0.f51296a.onMirrorSuccess(this.val$bestPicList, this.val$attackPicList, this.val$waterMarkPicList);
        }
    }
}
