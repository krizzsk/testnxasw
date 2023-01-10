package com.kwai.koom.javaoom;

import androidx.lifecycle.ProcessLifecycleOwner;

class KOOMInternal$1 implements Runnable {
    final /* synthetic */ C21294a this$0;

    KOOMInternal$1(C21294a aVar) {
        this.this$0 = aVar;
    }

    public void run() {
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this.this$0.f58351c);
    }
}
