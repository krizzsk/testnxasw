package com.p228kt.didichuxing.didi_network.sched;

import com.didi.sdk.apm.SystemUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.kt.didichuxing.didi_network.sched.ScheduleHelper */
public final class ScheduleHelper {

    /* renamed from: a */
    private static final int f58326a;

    /* renamed from: b */
    private static final int f58327b;

    /* renamed from: c */
    private static final int f58328c = 5;

    /* renamed from: d */
    private static final RejectedExecutionHandler f58329d = new RejectedExecutionHandler() {
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            runnable.run();
        }
    };

    /* renamed from: e */
    private static final ExecutorService f58330e = new PriorityThreadPoolExecutor(0, f58327b, 30, TimeUnit.SECONDS, new LinkedBlockingDeque(), f58329d);

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f58326a = availableProcessors;
        f58327b = (availableProcessors << 1) + 1;
    }

    public static ScheduleHelper getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* renamed from: com.kt.didichuxing.didi_network.sched.ScheduleHelper$SingletonHolder */
    private static final class SingletonHolder {
        static final ScheduleHelper INSTANCE = new ScheduleHelper();

        private SingletonHolder() {
        }
    }

    private ScheduleHelper() {
    }

    public void schedule(Runnable runnable) {
        f58330e.execute(runnable);
    }

    public Future<?> submit(Runnable runnable) {
        return f58330e.submit(runnable);
    }

    /* renamed from: com.kt.didichuxing.didi_network.sched.ScheduleHelper$PriorityThreadPoolExecutor */
    static class PriorityThreadPoolExecutor extends ThreadPoolExecutor {
        PriorityThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, RejectedExecutionHandler rejectedExecutionHandler) {
            super(i, i2, j, timeUnit, blockingQueue, rejectedExecutionHandler);
        }

        /* access modifiers changed from: protected */
        public void beforeExecute(Thread thread, Runnable runnable) {
            SystemUtils.setProcessThreadPriority(5);
        }
    }
}
