package com.didi.sdk.logging.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultTaskExecutor extends TaskExecutor {

    /* renamed from: a */
    private final Object f39421a = new Object();

    /* renamed from: b */
    private ExecutorService f39422b = Executors.newCachedThreadPool(new ThreadFactory() {
        AtomicLong mCount = new AtomicLong(0);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "LoggerTask #" + this.mCount.getAndIncrement());
        }
    });

    /* renamed from: c */
    private volatile Handler f39423c;

    public void executeOnDiskIO(Runnable runnable) {
        this.f39422b.execute(runnable);
    }

    public void postToMainThread(Runnable runnable) {
        if (this.f39423c == null) {
            synchronized (this.f39421a) {
                if (this.f39423c == null) {
                    this.f39423c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.f39423c.post(runnable);
    }

    public boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
