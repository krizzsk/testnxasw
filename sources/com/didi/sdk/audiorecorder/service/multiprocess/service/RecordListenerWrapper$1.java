package com.didi.sdk.audiorecorder.service.multiprocess.service;

import com.didi.sdk.audiorecorder.utils.LogUtil;

class RecordListenerWrapper$1 implements Runnable {
    final /* synthetic */ C12937c this$0;

    RecordListenerWrapper$1(C12937c cVar) {
        this.this$0 = cVar;
    }

    public void run() {
        try {
            this.this$0.f38295e.onStart();
        } catch (Exception e) {
            LogUtil.log("RecordListenerWrapper -> ", "Failed to callback onStart. ", e.getMessage());
        }
    }
}
