package com.didi.sdk.audiorecorder.service.multiprocess.conn;

class BinderSpeechDetectListener$1 implements Runnable {
    final /* synthetic */ C12928d this$0;
    final /* synthetic */ String val$words;

    BinderSpeechDetectListener$1(C12928d dVar, String str) {
        this.this$0 = dVar;
        this.val$words = str;
    }

    public void run() {
        if (this.this$0.f38261a != null) {
            this.this$0.f38261a.onWordDetected(this.val$words);
        }
    }
}
