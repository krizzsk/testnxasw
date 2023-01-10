package com.didi.dimina.webview.resource;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FusionAsynDispatcher {
    public static final FusionAsynDispatcher Instance = new FusionAsynDispatcher();

    /* renamed from: a */
    private final ScheduledExecutorService f20189a = Executors.newScheduledThreadPool(6, new DispatcherThreadFactory());

    public void asynRunTask(Runnable runnable) {
        this.f20189a.execute(runnable);
    }

    public void asynRunTask(Runnable runnable, long j, TimeUnit timeUnit) {
        this.f20189a.schedule(runnable, j, timeUnit);
    }

    private static class DispatcherThreadFactory implements ThreadFactory {
        private static final String THREAD_NAME_PREFIX = "fusion-asyn-dispatcher-";
        private final ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup2 = this.threadGroup;
            Thread thread = new Thread(threadGroup2, runnable, THREAD_NAME_PREFIX + this.threadNumber.getAndIncrement());
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }
}
