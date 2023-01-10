package com.didi.sdk.apm.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ApmThreadPool {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static AtomicInteger f37809a = new AtomicInteger(1);

    /* renamed from: b */
    private static final String f37810b = "ApmPool—";

    /* renamed from: c */
    private static ScheduledThreadPoolExecutor f37811c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static Handler f37812d = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    private static HandlerThread f37813e;

    /* renamed from: f */
    private static Handler f37814f = new Handler(f37813e.getLooper());

    static {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, ApmThreadPool.f37810b + ApmThreadPool.f37809a.getAndIncrement());
            }
        });
        f37811c = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setKeepAliveTime(60, TimeUnit.SECONDS);
        f37811c.allowCoreThreadTimeOut(true);
        HandlerThread handlerThread = new HandlerThread("apm-work-looper", -2);
        f37813e = handlerThread;
        handlerThread.start();
    }

    public static ScheduledThreadPoolExecutor getExecutorService() {
        return f37811c;
    }

    public static void postDelay(Runnable runnable, int i) {
        f37811c.schedule(runnable, (long) i, TimeUnit.MILLISECONDS);
        m28496c();
    }

    public static void remove(Runnable runnable) {
        f37811c.remove(runnable);
    }

    public static void execute(Runnable runnable) {
        f37811c.execute(runnable);
        m28496c();
    }

    public static void excuteOnUiThread(Runnable runnable) {
        f37812d.post(runnable);
    }

    public static void postDelayOnUiThread(Runnable runnable, int i) {
        f37812d.postDelayed(runnable, (long) i);
    }

    public static void executeOnSingle(Runnable runnable) {
        f37814f.post(runnable);
    }

    public static void postDelayOnSingle(Runnable runnable, int i) {
        f37814f.postDelayed(runnable, (long) i);
    }

    /* renamed from: c */
    private static void m28496c() {
        int activeCount = f37811c.getActiveCount();
        long taskCount = f37811c.getTaskCount();
        Log.d(f37810b, "active count = " + activeCount + "; task count = " + taskCount);
    }

    public static void execute(IORunnable iORunnable) {
        execute((Runnable) new RunWrapper(iORunnable));
    }

    private static class RunWrapper implements Runnable {

        /* renamed from: r */
        final IORunnable f37815r;

        private RunWrapper(IORunnable iORunnable) {
            this.f37815r = iORunnable;
        }

        public void run() {
            this.f37815r.execute();
        }
    }

    public static abstract class IORunnable<T> {
        public abstract void postRun(T t);

        public abstract T run();

        /* access modifiers changed from: private */
        public void execute() {
            final Object run = run();
            ApmThreadPool.f37812d.post(new Runnable() {
                public void run() {
                    IORunnable.this.postRun(run);
                }
            });
        }
    }
}
