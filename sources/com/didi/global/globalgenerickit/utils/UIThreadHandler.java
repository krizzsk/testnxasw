package com.didi.global.globalgenerickit.utils;

import android.os.Handler;
import android.os.Looper;

public class UIThreadHandler {

    /* renamed from: a */
    private static Handler f24253a = new Handler(Looper.getMainLooper());

    public static void post(Runnable runnable) {
        if (runnable != null) {
            m19536a();
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                runnable.run();
                return;
            }
            Handler handler = f24253a;
            if (handler != null) {
                handler.post(runnable);
            }
        }
    }

    public static void post(Runnable runnable, long j) {
        if (runnable != null) {
            m19536a();
            Handler handler = f24253a;
            if (handler != null) {
                handler.postDelayed(runnable, j);
            }
        }
    }

    /* renamed from: a */
    private static void m19536a() {
        if (f24253a == null) {
            f24253a = new Handler(Looper.getMainLooper());
        }
    }
}
