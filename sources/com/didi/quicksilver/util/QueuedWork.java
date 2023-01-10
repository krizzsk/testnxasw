package com.didi.quicksilver.util;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class QueuedWork {

    /* renamed from: a */
    private static ExecutorService f35842a;

    /* renamed from: b */
    private static final ArrayDeque<QueuedTask> f35843b = new ArrayDeque<>();

    /* renamed from: c */
    private static QueuedTask f35844c;

    public static ExecutorService singleThreadExecutor() {
        ExecutorService executorService;
        synchronized (QueuedWork.class) {
            if (f35842a == null) {
                f35842a = Executors.newSingleThreadExecutor(new ThreadFactory() {
                    public Thread newThread(Runnable runnable) {
                        return new Thread(runnable, "qsp-QueuedWork");
                    }
                });
            }
            executorService = f35842a;
        }
        return executorService;
    }

    public static synchronized void queueTask(QueuedTask queuedTask) {
        synchronized (QueuedWork.class) {
            f35843b.offer(queuedTask);
            if (f35844c == null) {
                m26998b();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static synchronized void m26998b() {
        synchronized (QueuedWork.class) {
            QueuedTask poll = f35843b.poll();
            if (poll == null) {
                f35844c = null;
                return;
            }
            Iterator<QueuedTask> it = f35843b.iterator();
            while (it.hasNext()) {
                QueuedTask next = it.next();
                if (next.name.equals(poll.name)) {
                    it.remove();
                    poll = next;
                }
            }
            f35844c = poll;
            singleThreadExecutor().execute(f35844c);
        }
    }

    public static class QueuedTask implements Runnable {
        String name;
        Runnable task;

        public QueuedTask(String str, Runnable runnable) {
            this.name = str;
            this.task = runnable;
        }

        public void run() {
            try {
                this.task.run();
            } finally {
                QueuedWork.m26998b();
            }
        }
    }
}
