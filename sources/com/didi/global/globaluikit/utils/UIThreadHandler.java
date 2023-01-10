package com.didi.global.globaluikit.utils;

import android.os.Handler;
import android.os.Looper;

public class UIThreadHandler {

    /* renamed from: a */
    private static Handler f24554a = new Handler(Looper.getMainLooper());

    public static void post(Runnable runnable) {
        if (runnable != null) {
            m19736a();
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                runnable.run();
                return;
            }
            Handler handler = f24554a;
            if (handler != null) {
                handler.post(runnable);
            }
        }
    }

    public static void post(Runnable runnable, long j) {
        if (runnable != null) {
            m19736a();
            Handler handler = f24554a;
            if (handler != null) {
                handler.postDelayed(runnable, j);
            }
        }
    }

    /* renamed from: a */
    private static void m19736a() {
        if (f24554a == null) {
            f24554a = new Handler(Looper.getMainLooper());
        }
    }
}
