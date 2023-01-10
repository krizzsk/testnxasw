package com.didi.globalsafetoolkit.util;

import android.os.Handler;
import android.os.Looper;

public class SfUIThreadHelper {

    /* renamed from: a */
    private static Handler f25189a = new Handler(Looper.getMainLooper());

    public static void post(Runnable runnable) {
        f25189a.post(runnable);
    }

    public static void postDelay(Runnable runnable, long j) {
        f25189a.postDelayed(runnable, j);
    }
}
