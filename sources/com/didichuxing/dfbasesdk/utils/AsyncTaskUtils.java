package com.didichuxing.dfbasesdk.utils;

import android.os.Handler;
import android.os.HandlerThread;

@Deprecated
public class AsyncTaskUtils {

    /* renamed from: a */
    private static volatile Handler f49350a;

    public static void runOnWorkThread(Runnable runnable) {
        m37025a().post(runnable);
    }

    public static void runOnWorkThread(Runnable runnable, long j) {
        m37025a().postDelayed(runnable, j);
    }

    public static void removeCallback(Runnable runnable) {
        m37025a().removeCallbacks(runnable);
    }

    /* renamed from: a */
    private static Handler m37025a() {
        if (f49350a == null) {
            synchronized (AsyncTaskUtils.class) {
                if (f49350a == null) {
                    HandlerThread handlerThread = new HandlerThread("diface");
                    handlerThread.start();
                    f49350a = new Handler(handlerThread.getLooper());
                }
            }
        }
        return f49350a;
    }
}
