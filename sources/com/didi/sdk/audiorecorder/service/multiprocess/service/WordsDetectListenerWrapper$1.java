package com.didi.sdk.audiorecorder.service.multiprocess.service;

import com.didi.sdk.audiorecorder.utils.LogUtil;

class WordsDetectListenerWrapper$1 implements Runnable {
    final /* synthetic */ C12938d this$0;
    final /* synthetic */ String val$words;

    WordsDetectListenerWrapper$1(C12938d dVar, String str) {
        this.this$0 = dVar;
        this.val$words = str;
    }

    public void run() {
        try {
            this.this$0.f38301a.onWordDetected(this.val$words);
        } catch (Exception e) {
            LogUtil.log("Send word detected error. ", e.getMessage());
        }
    }
}
