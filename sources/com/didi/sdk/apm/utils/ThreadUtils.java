package com.didi.sdk.apm.utils;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeoutException;

public class ThreadUtils {
    public static final String TAG = "ThreadUtils";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final ArrayList<Thread.UncaughtExceptionHandler> f37829a = new ArrayList<>();

    public static void init() {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread thread, Throwable th) {
                ArrayList arrayList;
                if (!ThreadUtils.m28502b(thread, th)) {
                    synchronized (ThreadUtils.f37829a) {
                        arrayList = new ArrayList(ThreadUtils.f37829a);
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((Thread.UncaughtExceptionHandler) it.next()).uncaughtException(thread, th);
                    }
                }
            }
        });
    }

    public static boolean isInMainThread() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        synchronized (f37829a) {
            f37829a.add(uncaughtExceptionHandler);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m28502b(Thread thread, Throwable th) {
        try {
            if (!thread.getName().equals("FinalizerWatchdogDaemon") || !(th instanceof TimeoutException)) {
                return false;
            }
            Log.w(TAG, "Caught an uncaught exception, will ignore this exception :" + th.getMessage());
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void setPriority(Thread thread, int i) {
        if (Looper.getMainLooper().getThread() != thread && i > 3) {
            i = 4;
        }
        thread.setPriority(i);
    }

    public static void setProcessThreadPriority(int i) {
        if (!isInMainThread()) {
            if (i < 10) {
                i = 10;
            }
            Process.setThreadPriority(i);
        }
    }

    public static void setProcessThreadPriority(int i, int i2) {
        if (!(Looper.getMainLooper().getThread().getId() == ((long) i))) {
            if (i2 < 10) {
                i2 = 10;
            }
            Process.setThreadPriority(i, i2);
        }
    }

    public static void start(Thread thread) {
        if (thread.isDaemon() || (thread instanceof HandlerThread)) {
            if (Looper.getMainLooper().getThread() != thread && thread.getPriority() > 4) {
                Log.d(TAG, "ThreadUtils setPriority:" + thread);
                thread.setPriority(4);
            }
            thread.start();
            return;
        }
        ApmThreadPool.execute((Runnable) thread);
    }

    public static void excuteThreadPool(ThreadPoolExecutor threadPoolExecutor, Runnable runnable) {
        ApmThreadPool.execute(runnable);
    }
}
