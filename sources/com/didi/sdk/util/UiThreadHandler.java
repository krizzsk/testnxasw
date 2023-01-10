package com.didi.sdk.util;

import android.os.Handler;
import android.os.Looper;

public class UiThreadHandler {

    /* renamed from: a */
    private static Handler f40416a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private static Object f40417b = new Object();

    public static final boolean post(Runnable runnable) {
        Handler handler = f40416a;
        if (handler == null) {
            return false;
        }
        return handler.post(runnable);
    }

    public static final boolean postDelayed(Runnable runnable, long j) {
        Handler handler = f40416a;
        if (handler == null) {
            return false;
        }
        return handler.postDelayed(runnable, j);
    }

    public static final Handler getsUiHandler() {
        return f40416a;
    }

    public static final boolean postOnceDelayed(Runnable runnable, long j) {
        Handler handler = f40416a;
        if (handler == null) {
            return false;
        }
        handler.removeCallbacks(runnable);
        return f40416a.postDelayed(runnable, j);
    }

    public static void removeCallbacks(Runnable runnable) {
        Handler handler = f40416a;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
