package com.didi.travel.psnger.utils;

import android.os.Handler;
import android.os.Looper;

public class UIThreadHandler {

    /* renamed from: a */
    private static Handler f46901a = new Handler(Looper.getMainLooper());

    public static void post(Runnable runnable) {
        if (runnable != null) {
            m34928a();
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                runnable.run();
                return;
            }
            Handler handler = f46901a;
            if (handler != null) {
                handler.post(runnable);
            }
        }
    }

    public static void post(Runnable runnable, long j) {
        if (runnable != null) {
            m34928a();
            Handler handler = f46901a;
            if (handler != null) {
                handler.postDelayed(runnable, j);
            }
        }
    }

    /* renamed from: a */
    private static void m34928a() {
        if (f46901a == null) {
            f46901a = new Handler(Looper.getMainLooper());
        }
    }
}
