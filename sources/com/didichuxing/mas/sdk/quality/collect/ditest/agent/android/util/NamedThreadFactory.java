package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory implements ThreadFactory {

    /* renamed from: a */
    final ThreadGroup f50631a;

    /* renamed from: b */
    final String f50632b;

    /* renamed from: c */
    final AtomicInteger f50633c = new AtomicInteger(1);

    public NamedThreadFactory(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.f50631a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f50632b = "NR_" + str + "-";
    }

    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.f50631a;
        Thread thread = new Thread(threadGroup, runnable, this.f50632b + this.f50633c.getAndIncrement(), 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
