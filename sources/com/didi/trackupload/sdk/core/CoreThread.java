package com.didi.trackupload.sdk.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.didi.trackupload.sdk.utils.TrackLog;

public class CoreThread {

    /* renamed from: a */
    private static final String f46553a = "TrackCoreThread";

    /* renamed from: b */
    private static Handler f46554b;

    public static void create() {
        if (f46554b == null) {
            HandlerThread handlerThread = new HandlerThread("TrackSDKCoreThread", -1);
            handlerThread.start();
            f46554b = new Handler(handlerThread.getLooper());
        }
    }

    public static void destory() {
        Handler handler = f46554b;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            f46554b.getLooper().quit();
            f46554b = null;
        }
    }

    public static boolean ensureCoreThread() {
        Handler handler = f46554b;
        boolean z = handler != null && handler.getLooper() == Looper.myLooper();
        if (!z) {
            TrackLog.m34830d(f46553a, "ensureCoreThread vaild=false trace=" + Log.getStackTraceString(new Throwable()));
        }
        return z;
    }

    public static void post(Runnable runnable) {
        postDelayed(runnable, 0);
    }

    public static void postDelayed(Runnable runnable, long j) {
        Handler handler = f46554b;
        if (handler != null && runnable != null && j >= 0) {
            handler.postDelayed(runnable, j);
        }
    }

    public static void cancel(Runnable runnable) {
        Handler handler = f46554b;
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
