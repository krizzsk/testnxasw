package com.didichuxing.sdk.alphaface.core.liveness;

import com.didichuxing.sdk.alphaface.core.liveness.IMirrorCallback;

class CallbackWrapper$3 implements Runnable {
    final /* synthetic */ C17138c this$0;
    final /* synthetic */ IMirrorCallback.FaceInfo val$faceInfo;

    CallbackWrapper$3(C17138c cVar, IMirrorCallback.FaceInfo faceInfo) {
        this.this$0 = cVar;
        this.val$faceInfo = faceInfo;
    }

    public void run() {
        if (this.this$0.f51296a != null) {
            this.this$0.f51296a.onDetectFace(this.val$faceInfo);
        }
    }
}
