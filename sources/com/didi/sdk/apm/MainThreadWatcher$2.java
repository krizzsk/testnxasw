package com.didi.sdk.apm;

import android.os.SystemClock;
import android.util.Log;

class MainThreadWatcher$2 implements Runnable {
    final /* synthetic */ C12711c this$0;

    MainThreadWatcher$2(C12711c cVar) {
        this.this$0 = cVar;
    }

    public void run() {
        long uptimeMillis = SystemClock.uptimeMillis() - this.this$0.f37749l;
        Log.i(C12711c.f37738a, "loop for " + uptimeMillis + " ms");
        this.this$0.f37743f.set(true);
    }
}
