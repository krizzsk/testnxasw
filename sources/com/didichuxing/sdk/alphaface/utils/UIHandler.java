package com.didichuxing.sdk.alphaface.utils;

import android.os.Handler;
import android.os.Looper;

public class UIHandler {

    /* renamed from: a */
    private static Handler f51328a = new Handler(Looper.getMainLooper());

    public static Handler getHandler() {
        return f51328a;
    }

    public static void postDelayed(long j, Runnable runnable) {
        f51328a.postDelayed(runnable, j);
    }

    public static void post(Runnable runnable) {
        f51328a.post(runnable);
    }

    public static void removeCallbacks(Runnable runnable) {
        f51328a.removeCallbacks(runnable);
    }
}
