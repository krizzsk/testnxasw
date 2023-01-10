package com.didi.hawaii.task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class LowPriorityExecutor implements Executor {

    /* renamed from: a */
    private static final int f26441a = 5;

    /* renamed from: b */
    private static final int f26442b = 20;

    /* renamed from: c */
    private static final int f26443c = 128;

    /* renamed from: d */
    private static final int f26444d = 1;

    /* renamed from: e */
    private final ThreadFactory f26445e = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Hawaii SDK MapTask Low #" + this.mCount.getAndIncrement());
        }
    };

    /* renamed from: f */
    private final BlockingQueue<Runnable> f26446f = new LinkedBlockingQueue(20);
    public final Executor mExecutor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, this.f26446f, this.f26445e, new ThreadPoolExecutor.DiscardOldestPolicy());

    public void execute(Runnable runnable) {
        this.mExecutor.execute(runnable);
    }
}
