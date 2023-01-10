package com.didi.sdk.apm;

import com.didi.sdk.apm.AppStateMonitor;

class AppAutoCloser$1 implements AppStateMonitor.StateListener {
    final /* synthetic */ C12701a this$0;

    AppAutoCloser$1(C12701a aVar) {
        this.this$0 = aVar;
    }

    public void onInForeground() {
        this.this$0.m28449d();
    }

    public void onInBackground() {
        this.this$0.m28448c();
    }
}
