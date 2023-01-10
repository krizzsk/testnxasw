package com.didi.dimina.p109v8.utils;

import com.didi.dimina.p109v8.C8369V8;

/* renamed from: com.didi.dimina.v8.utils.ConcurrentV8 */
public final class ConcurrentV8 {

    /* renamed from: v8 */
    private C8369V8 f20075v8 = null;

    public ConcurrentV8() {
        C8369V8 createV8Runtime = C8369V8.createV8Runtime();
        this.f20075v8 = createV8Runtime;
        createV8Runtime.getLocker().release();
    }

    public C8369V8 getV8() {
        return this.f20075v8;
    }

    public synchronized void run(V8Runnable v8Runnable) {
        try {
            this.f20075v8.getLocker().acquire();
            v8Runnable.run(this.f20075v8);
            if (!(this.f20075v8 == null || this.f20075v8.getLocker() == null || !this.f20075v8.getLocker().hasLock())) {
                this.f20075v8.getLocker().release();
            }
        } catch (Throwable th) {
            if (!(this.f20075v8 == null || this.f20075v8.getLocker() == null || !this.f20075v8.getLocker().hasLock())) {
                this.f20075v8.getLocker().release();
            }
            throw th;
        }
    }

    public void release() {
        C8369V8 v8 = this.f20075v8;
        if (v8 != null && !v8.isReleased()) {
            run(new V8Runnable() {
                public void run(C8369V8 v8) {
                    if (v8 != null && !v8.isReleased()) {
                        v8.close();
                    }
                }
            });
        }
    }
}
