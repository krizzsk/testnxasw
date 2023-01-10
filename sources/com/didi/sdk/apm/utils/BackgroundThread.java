package com.didi.sdk.apm.utils;

import android.os.Handler;
import android.os.HandlerThread;

public final class BackgroundThread extends HandlerThread {

    /* renamed from: a */
    private static BackgroundThread f37819a;

    /* renamed from: b */
    private static Handler f37820b;

    private BackgroundThread() {
        super("apm-BackgroundThread", 10);
    }

    /* renamed from: a */
    private static void m28497a() {
        if (f37819a == null) {
            BackgroundThread backgroundThread = new BackgroundThread();
            f37819a = backgroundThread;
            backgroundThread.start();
            f37820b = new Handler(f37819a.getLooper());
        }
    }

    public static BackgroundThread get() {
        BackgroundThread backgroundThread;
        synchronized (BackgroundThread.class) {
            m28497a();
            backgroundThread = f37819a;
        }
        return backgroundThread;
    }

    public static Handler getHandler() {
        Handler handler;
        synchronized (BackgroundThread.class) {
            m28497a();
            handler = f37820b;
        }
        return handler;
    }
}
