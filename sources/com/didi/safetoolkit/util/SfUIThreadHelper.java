package com.didi.safetoolkit.util;

import android.os.Handler;
import android.os.Looper;

public class SfUIThreadHelper {

    /* renamed from: a */
    private static Handler f37301a = new Handler(Looper.getMainLooper());

    public static void post(Runnable runnable) {
        f37301a.post(runnable);
    }

    public static void postDelay(Runnable runnable, long j) {
        f37301a.postDelayed(runnable, j);
    }
}
