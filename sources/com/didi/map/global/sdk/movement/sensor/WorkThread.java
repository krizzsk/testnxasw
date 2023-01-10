package com.didi.map.global.sdk.movement.sensor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WorkThread {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ExecutorService f30224a = new ThreadPoolExecutor(1, 1, 3, TimeUnit.SECONDS, this.f30225b, new ExecutionHandlerPolicy());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LinkedBlockingQueue<Runnable> f30225b = new LinkedBlockingQueue<>(5);

    public void executeTask(Runnable runnable) {
        ExecutorService executorService = this.f30224a;
        if (executorService != null && !executorService.isShutdown() && runnable != null) {
            this.f30224a.execute(runnable);
        }
    }

    public void destroy() {
        ExecutorService executorService = this.f30224a;
        if (executorService != null && !executorService.isShutdown()) {
            this.f30224a.shutdownNow();
            this.f30224a = null;
        }
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = this.f30225b;
        if (linkedBlockingQueue != null) {
            linkedBlockingQueue.clear();
            this.f30225b = null;
        }
    }

    private class ExecutionHandlerPolicy implements RejectedExecutionHandler {
        private ExecutionHandlerPolicy() {
        }

        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (WorkThread.this.f30225b != null) {
                WorkThread.this.f30225b.clear();
            }
            if (WorkThread.this.f30224a != null) {
                WorkThread.this.f30224a.execute(runnable);
            }
        }
    }
}
