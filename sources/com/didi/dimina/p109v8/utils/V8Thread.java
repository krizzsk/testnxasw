package com.didi.dimina.p109v8.utils;

import com.didi.dimina.p109v8.C8369V8;

/* renamed from: com.didi.dimina.v8.utils.V8Thread */
public class V8Thread extends Thread {
    private C8369V8 runtime;
    private final V8Runnable target;

    public V8Thread(V8Runnable v8Runnable) {
        this.target = v8Runnable;
    }

    public void run() {
        C8369V8 createV8Runtime = C8369V8.createV8Runtime();
        this.runtime = createV8Runtime;
        try {
            this.target.run(createV8Runtime);
            synchronized (this) {
                if (this.runtime.getLocker().hasLock()) {
                    this.runtime.close();
                    this.runtime = null;
                }
            }
        } catch (Throwable th) {
            synchronized (this) {
                if (this.runtime.getLocker().hasLock()) {
                    this.runtime.close();
                    this.runtime = null;
                }
                throw th;
            }
        }
    }
}
