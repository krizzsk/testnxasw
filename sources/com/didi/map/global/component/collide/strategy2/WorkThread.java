package com.didi.map.global.component.collide.strategy2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WorkThread {

    /* renamed from: a */
    private static final String f27090a = "WorkThread";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ExecutorService f27091b = new ThreadPoolExecutor(1, 1, 3, TimeUnit.SECONDS, this.f27092c, new ExecutionHandlerPolicy());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final LinkedBlockingQueue<Runnable> f27092c = new LinkedBlockingQueue<>(1);

    public void executeTask(Runnable runnable) {
        ExecutorService executorService = this.f27091b;
        if (executorService != null && !executorService.isShutdown() && runnable != null) {
            this.f27091b.execute(runnable);
        }
    }

    public void destroy() {
        ExecutorService executorService = this.f27091b;
        if (executorService != null && !executorService.isShutdown()) {
            this.f27091b.shutdownNow();
            this.f27091b = null;
        }
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = this.f27092c;
        if (linkedBlockingQueue != null) {
            linkedBlockingQueue.clear();
        }
    }

    private class ExecutionHandlerPolicy implements RejectedExecutionHandler {
        private ExecutionHandlerPolicy() {
        }

        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (WorkThread.this.f27092c != null) {
                WorkThread.this.f27092c.clear();
            }
            if (WorkThread.this.f27091b != null) {
                WorkThread.this.f27091b.execute(runnable);
            }
        }
    }
}
