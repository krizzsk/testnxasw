package com.didi.dimina.starbox.p108ui.windowpop;

import android.os.Handler;
import android.os.HandlerThread;

/* renamed from: com.didi.dimina.starbox.ui.windowpop.GlobalDispatcher */
public class GlobalDispatcher {

    /* renamed from: a */
    private static volatile Handler f20021a;

    /* renamed from: b */
    private static volatile HandlerThread f20022b;

    /* renamed from: a */
    private static void m16976a() {
        if (f20021a == null) {
            synchronized (GlobalDispatcher.class) {
                if (f20021a == null) {
                    f20022b = new HandlerThread("ForegroundCheck");
                    f20022b.start();
                    f20021a = new Handler(f20022b.getLooper());
                }
            }
        } else if (f20022b == null || !f20022b.isAlive()) {
            f20021a = null;
            m16976a();
        }
    }

    public static void post(Runnable runnable) {
        m16976a();
        f20021a.post(runnable);
    }

    public static void postDelay(Runnable runnable, long j) {
        m16976a();
        f20021a.postDelayed(runnable, j);
    }

    public static void removeCallbacks(Runnable runnable) {
        m16976a();
        f20021a.removeCallbacks(runnable);
    }
}
