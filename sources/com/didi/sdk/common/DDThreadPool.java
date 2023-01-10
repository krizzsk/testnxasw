package com.didi.sdk.common;

import com.didi.sdk.apm.SystemUtils;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
public class DDThreadPool {

    /* renamed from: a */
    private static final String f38386a = "DDThreadPool";

    /* renamed from: b */
    private static final int f38387b = 3;

    /* renamed from: c */
    private ThreadPoolExecutor f38388c;

    /* renamed from: d */
    private ThreadPoolExecutor f38389d;

    private static class SingletonHolder {
        public static final DDThreadPool INSTANCE = new DDThreadPool();

        private SingletonHolder() {
        }
    }

    private static class PoolThreadFactory implements ThreadFactory {
        private AtomicInteger mCount = new AtomicInteger(1);
        private boolean mUiTask;

        public PoolThreadFactory(boolean z) {
            this.mUiTask = z;
        }

        public Thread newThread(Runnable runnable) {
            if (this.mUiTask) {
                return new Thread(runnable, "DDThreadPool#" + this.mCount.getAndIncrement());
            }
            return new Thread(runnable, "DDThreadPool#" + this.mCount.getAndIncrement());
        }
    }

    public static DDThreadPool getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private DDThreadPool() {
        int a = m28961a();
        this.f38388c = new ThreadPoolExecutor(a, a, 1, TimeUnit.SECONDS, new PriorityBlockingQueue(), new PoolThreadFactory(true));
        this.f38389d = new ThreadPoolExecutor(3, 3, 1, TimeUnit.SECONDS, new PriorityBlockingQueue(), new PoolThreadFactory(false));
        m28962b();
    }

    /* renamed from: a */
    private int m28961a() {
        return Math.max(2, Runtime.getRuntime().availableProcessors() / 2);
    }

    /* renamed from: b */
    private void m28962b() {
        int availableProcessors = Runtime.getRuntime().availableProcessors() / 2;
        int max = Math.max(4, availableProcessors);
        this.f38388c.setCorePoolSize(max);
        this.f38388c.setMaximumPoolSize(max);
        int max2 = Math.max(4, availableProcessors);
        this.f38389d.setCorePoolSize(max2);
        this.f38389d.setMaximumPoolSize(max2);
    }

    public void addUiTask(Runnable runnable) {
        ThreadPoolTask threadPoolTask = new ThreadPoolTask(runnable, true);
        threadPoolTask.mo97730a(System.currentTimeMillis());
        SystemUtils.excuteThreadPool(this.f38388c, threadPoolTask);
    }

    public void addUiTask(Runnable runnable, int i) {
        ThreadPoolTask threadPoolTask = new ThreadPoolTask(runnable, true, i);
        threadPoolTask.mo97730a(System.currentTimeMillis());
        SystemUtils.excuteThreadPool(this.f38388c, threadPoolTask);
    }

    public void addBkgTask(Runnable runnable) {
        ThreadPoolTask threadPoolTask = new ThreadPoolTask(runnable, false);
        threadPoolTask.mo97730a(System.currentTimeMillis());
        SystemUtils.excuteThreadPool(this.f38389d, threadPoolTask);
    }

    public void addBkgTask(Runnable runnable, int i) {
        ThreadPoolTask threadPoolTask = new ThreadPoolTask(runnable, false, i);
        threadPoolTask.mo97730a(System.currentTimeMillis());
        SystemUtils.excuteThreadPool(this.f38389d, threadPoolTask);
    }

    public void dumpState(String str) {
        SystemUtils.log(3, f38386a, str + "-UiTaskPool, PoolCoreSize: " + this.f38389d.getCorePoolSize() + ", ActiveThreadCount: " + this.f38389d.getActiveCount() + ", CompletedTaskCount: " + this.f38389d.getCompletedTaskCount() + ", CurPoolSize:" + this.f38389d.getPoolSize() + ", ScheduledTaskCount: " + this.f38389d.getTaskCount() + ", QueueSize: " + this.f38389d.getQueue().size(), (Throwable) null, "com.didi.sdk.common.DDThreadPool", 124);
        SystemUtils.log(3, f38386a, str + "-BkgTaskPool, PoolCoreSize: " + this.f38389d.getCorePoolSize() + ", ActiveThreadCount: " + this.f38389d.getActiveCount() + ", CompletedTaskCount: " + this.f38389d.getCompletedTaskCount() + ", CurPoolSize:" + this.f38389d.getPoolSize() + ", ScheduledTaskCount: " + this.f38389d.getTaskCount() + ", QueueSize: " + this.f38389d.getQueue().size(), (Throwable) null, "com.didi.sdk.common.DDThreadPool", 130);
    }

    public boolean isIncludeAliveThread() {
        return this.f38388c.getActiveCount() > 0 || this.f38389d.getActiveCount() > 0;
    }
}
