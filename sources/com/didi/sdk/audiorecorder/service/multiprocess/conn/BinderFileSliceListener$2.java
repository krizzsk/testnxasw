package com.didi.sdk.audiorecorder.service.multiprocess.conn;

class BinderFileSliceListener$2 implements Runnable {
    final /* synthetic */ C12926b this$0;
    final /* synthetic */ String val$filePath;

    BinderFileSliceListener$2(C12926b bVar, String str) {
        this.this$0 = bVar;
        this.val$filePath = str;
    }

    public void run() {
        if (this.this$0.f38256a != null) {
            this.this$0.f38256a.onAudioFileSliced(this.val$filePath);
        }
    }
}
