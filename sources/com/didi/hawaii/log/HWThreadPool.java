package com.didi.hawaii.log;

import com.didi.sdk.apm.SystemUtils;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class HWThreadPool {

    /* renamed from: a */
    private static ThreadPoolExecutor f25722a = new ThreadPoolExecutor(f25724c, f25725d, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(10), new ThreadFactory() {

        /* renamed from: id */
        private final AtomicInteger f25727id = new AtomicInteger();

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "HWThreadPool-" + this.f25727id.getAndIncrement());
        }
    });

    /* renamed from: b */
    private static final int f25723b;

    /* renamed from: c */
    private static final int f25724c;

    /* renamed from: d */
    private static final int f25725d = ((f25723b * 2) + 1);

    /* renamed from: e */
    private static final int f25726e = 30;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f25723b = availableProcessors;
        f25724c = Math.max(2, Math.min(availableProcessors - 1, 4));
    }

    private HWThreadPool() {
    }

    public static void execute(Runnable runnable) {
        SystemUtils.excuteThreadPool(f25722a, runnable);
    }
}
