package com.didichuxing.dfbasesdk.utils;

import android.os.Handler;
import android.os.Looper;

@Deprecated
public class UIHandler {

    /* renamed from: a */
    private static Handler f49423a = new Handler(Looper.getMainLooper());

    public static Handler getHandler() {
        return f49423a;
    }

    public static void postDelayed(long j, Runnable runnable) {
        f49423a.postDelayed(runnable, j);
    }

    public static void post(Runnable runnable) {
        f49423a.post(runnable);
    }

    public static void removeCallbacks(Runnable runnable) {
        f49423a.removeCallbacks(runnable);
    }
}
