package com.didichuxing.security.cardverify.globalpay.utils;

import android.os.Handler;
import android.os.Looper;

public class UiHandlerUtil {

    /* renamed from: a */
    private static volatile Handler f51492a;

    public static Handler getHandler() {
        if (f51492a == null) {
            synchronized (UiHandlerUtil.class) {
                if (f51492a == null) {
                    f51492a = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f51492a;
    }

    public static void removeCallbacks(Runnable runnable) {
        getHandler().removeCallbacks(runnable);
    }

    public static final boolean postDelayed(Runnable runnable, long j) {
        return getHandler().postDelayed(runnable, j);
    }
}
