package com.didi.soda.customer.foundation.util;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ThreadPoolManager {

    /* renamed from: a */
    private static ThreadPoolExecutor f43855a;

    private ThreadPoolManager() {
    }

    private ThreadPoolManager(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        f43855a = new ThreadPoolExecutor(i3, i4, j2, TimeUnit.SECONDS, new LinkedBlockingDeque(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
    }

    public static ThreadPoolManager getInstance() {
        return Holder.INSTANCE;
    }

    public void execute(Runnable runnable) {
        f43855a.execute(runnable);
    }

    public void remove(Runnable runnable) {
        f43855a.remove(runnable);
    }

    public Future<?> submit(Runnable runnable) {
        return f43855a.submit(runnable);
    }

    static final class Holder {
        /* access modifiers changed from: private */
        public static final ThreadPoolManager INSTANCE = new ThreadPoolManager(1, 4, 30);

        private Holder() {
        }
    }
}
