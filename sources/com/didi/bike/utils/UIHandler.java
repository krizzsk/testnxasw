package com.didi.bike.utils;

import android.os.Handler;
import android.os.Looper;

public class UIHandler {

    /* renamed from: a */
    private static Handler f12507a = new Handler(Looper.getMainLooper());

    public static Handler getHandler() {
        return f12507a;
    }

    public static void postDelayed(Runnable runnable, long j) {
        f12507a.postDelayed(runnable, j);
    }

    public static void post(Runnable runnable) {
        f12507a.post(runnable);
    }

    public static void removeCallbacks(Runnable runnable) {
        f12507a.removeCallbacks(runnable);
    }
}
