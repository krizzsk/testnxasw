package com.didi.sdk.audiorecorder.service.multiprocess.service;

import com.didi.sdk.audiorecorder.utils.LogUtil;

class FileSliceListenerWrapper$2 implements Runnable {
    final /* synthetic */ C12936b this$0;
    final /* synthetic */ String val$filePath;

    FileSliceListenerWrapper$2(C12936b bVar, String str) {
        this.this$0 = bVar;
        this.val$filePath = str;
    }

    public void run() {
        try {
            this.this$0.f38289a.onAudioFileSliced(this.val$filePath);
        } catch (Exception e) {
            LogUtil.log("Failed to callback onAudioFileSliced listener", e.getMessage());
        }
    }
}
