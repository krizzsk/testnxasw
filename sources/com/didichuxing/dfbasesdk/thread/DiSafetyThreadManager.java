package com.didichuxing.dfbasesdk.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DiSafetyThreadManager {

    /* renamed from: a */
    private static volatile Handler f49332a;

    /* renamed from: b */
    private static volatile Handler f49333b;

    /* renamed from: c */
    private static volatile ExecutorService f49334c;

    /* renamed from: d */
    private static volatile ExecutorService f49335d;

    public static Handler getUiHandler() {
        if (f49332a == null) {
            synchronized (DiSafetyThreadManager.class) {
                if (f49332a == null) {
                    f49332a = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f49332a;
    }

    public static Handler getWorkHandler() {
        if (f49333b == null) {
            synchronized (DiSafetyThreadManager.class) {
                if (f49333b == null) {
                    HandlerThread handlerThread = new HandlerThread("DiSafetyThreadManager");
                    handlerThread.start();
                    f49333b = new Handler(handlerThread.getLooper());
                }
            }
        }
        return f49333b;
    }

    public static ExecutorService getCachedThreadPool() {
        if (f49334c == null) {
            synchronized (DiSafetyThreadManager.class) {
                if (f49334c == null) {
                    f49334c = Executors.newCachedThreadPool();
                }
            }
        }
        return f49334c;
    }

    public static ExecutorService getSingleThreadExecutor() {
        if (f49335d == null) {
            synchronized (DiSafetyThreadManager.class) {
                if (f49335d == null) {
                    f49335d = Executors.newSingleThreadExecutor();
                }
            }
        }
        return f49335d;
    }
}
