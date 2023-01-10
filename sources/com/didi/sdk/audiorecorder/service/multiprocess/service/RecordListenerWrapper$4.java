package com.didi.sdk.audiorecorder.service.multiprocess.service;

import com.didi.sdk.audiorecorder.utils.LogUtil;

class RecordListenerWrapper$4 implements Runnable {
    final /* synthetic */ C12937c this$0;

    RecordListenerWrapper$4(C12937c cVar) {
        this.this$0 = cVar;
    }

    public void run() {
        try {
            this.this$0.f38295e.onStop();
        } catch (Exception e) {
            LogUtil.log("Failed to callback onStop listener ", e.getMessage());
        }
    }
}
