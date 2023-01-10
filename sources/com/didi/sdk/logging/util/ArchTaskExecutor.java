package com.didi.sdk.logging.util;

import java.util.concurrent.Executor;

public class ArchTaskExecutor extends TaskExecutor {

    /* renamed from: a */
    private static volatile ArchTaskExecutor f39412a;

    /* renamed from: d */
    private static final Executor f39413d = new Executor() {
        public void execute(Runnable runnable) {
            ArchTaskExecutor.getInstance().postToMainThread(runnable);
        }
    };

    /* renamed from: e */
    private static final Executor f39414e = new Executor() {
        public void execute(Runnable runnable) {
            ArchTaskExecutor.getInstance().executeOnDiskIO(runnable);
        }
    };

    /* renamed from: b */
    private TaskExecutor f39415b;

    /* renamed from: c */
    private TaskExecutor f39416c;

    private ArchTaskExecutor() {
        DefaultTaskExecutor defaultTaskExecutor = new DefaultTaskExecutor();
        this.f39416c = defaultTaskExecutor;
        this.f39415b = defaultTaskExecutor;
    }

    public static ArchTaskExecutor getInstance() {
        if (f39412a != null) {
            return f39412a;
        }
        synchronized (ArchTaskExecutor.class) {
            if (f39412a == null) {
                f39412a = new ArchTaskExecutor();
            }
        }
        return f39412a;
    }

    public void setDelegate(TaskExecutor taskExecutor) {
        if (taskExecutor == null) {
            taskExecutor = this.f39416c;
        }
        this.f39415b = taskExecutor;
    }

    public void executeOnDiskIO(Runnable runnable) {
        this.f39415b.executeOnDiskIO(runnable);
    }

    public void postToMainThread(Runnable runnable) {
        this.f39415b.postToMainThread(runnable);
    }

    public static Executor getMainThreadExecutor() {
        return f39413d;
    }

    public static Executor getIOThreadExecutor() {
        return f39414e;
    }

    public boolean isMainThread() {
        return this.f39415b.isMainThread();
    }
}
