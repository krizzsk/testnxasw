package com.didi.sdk.log.util;

import android.os.Handler;
import android.os.Looper;

public class UiThreadHandler {

    /* renamed from: a */
    private static Handler f39229a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private static Object f39230b = new Object();

    public static boolean post(Runnable runnable) {
        Handler handler = f39229a;
        if (handler == null) {
            return false;
        }
        return handler.post(runnable);
    }

    public static boolean postDelayed(Runnable runnable, long j) {
        Handler handler = f39229a;
        if (handler == null) {
            return false;
        }
        return handler.postDelayed(runnable, j);
    }

    public static Handler getsUiHandler() {
        return f39229a;
    }

    public static boolean postOnceDelayed(Runnable runnable, long j) {
        Handler handler = f39229a;
        if (handler == null) {
            return false;
        }
        handler.removeCallbacks(runnable, f39230b);
        return f39229a.postDelayed(runnable, j);
    }

    public static void removeCallbacks(Runnable runnable) {
        Handler handler = f39229a;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
