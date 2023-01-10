package com.didi.beatles.p101im.utils;

import android.os.Handler;
import android.os.Looper;

@Deprecated
/* renamed from: com.didi.beatles.im.utils.UiThreadHandler */
public class UiThreadHandler {

    /* renamed from: a */
    private static Handler f11666a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private static Object f11667b = new Object();

    public static final boolean post(Runnable runnable) {
        Handler handler = f11666a;
        if (handler == null) {
            return false;
        }
        return handler.post(runnable);
    }

    public static final boolean postDelayed(Runnable runnable, long j) {
        Handler handler = f11666a;
        if (handler == null) {
            return false;
        }
        return handler.postDelayed(runnable, j);
    }

    public static final Handler getsUiHandler() {
        return f11666a;
    }

    public static final boolean postOnceDelayed(Runnable runnable, long j) {
        Handler handler = f11666a;
        if (handler == null) {
            return false;
        }
        handler.removeCallbacks(runnable, f11667b);
        return f11666a.postDelayed(runnable, j);
    }

    public static void removeCallbacks(Runnable runnable) {
        Handler handler = f11666a;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
