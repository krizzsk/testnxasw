package com.didi.sdk.apm;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;

class MainThreadWatcher$1 implements Runnable {
    final /* synthetic */ C12711c this$0;

    MainThreadWatcher$1(C12711c cVar) {
        this.this$0 = cVar;
    }

    public void run() {
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            public boolean queueIdle() {
                Log.d(C12711c.f37738a, "main thread idle");
                return true;
            }
        });
    }
}
