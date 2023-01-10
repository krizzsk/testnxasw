package com.didi.map.global.task.engine;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolManage {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final LinkedBlockingQueue<Runnable> f30234a = new LinkedBlockingQueue<>(1);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ExecutorService f30235b;

    public ExecutorService newSingleThreadExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, this.f30234a, new ExecutionHandlerPolicy());
        this.f30235b = threadPoolExecutor;
        return threadPoolExecutor;
    }

    private class ExecutionHandlerPolicy implements RejectedExecutionHandler {
        private ExecutionHandlerPolicy() {
        }

        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            ThreadPoolManage.this.f30234a.clear();
            ThreadPoolManage.this.f30235b.execute(runnable);
        }
    }
}
