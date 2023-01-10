package com.didi.beatles.p101im.net;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.didi.beatles.im.net.IMThreadHelper */
public class IMThreadHelper {

    /* renamed from: a */
    private static IMThreadHelper f11179a;

    /* renamed from: b */
    private static final int f11180b;

    /* renamed from: c */
    private static final int f11181c;

    /* renamed from: d */
    private static final int f11182d;

    /* renamed from: e */
    private static ThreadPoolExecutor f11183e;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f11180b = availableProcessors;
        f11181c = availableProcessors + 2;
        f11182d = (availableProcessors * 2) + 2;
    }

    public static IMThreadHelper getInstance() {
        if (f11179a == null) {
            f11179a = new IMThreadHelper();
        }
        return f11179a;
    }

    private IMThreadHelper() {
        f11183e = new ThreadPoolExecutor(f11181c, f11182d, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                new Thread(runnable).start();
            }
        });
    }

    public void execute(Runnable runnable) {
        if (runnable != null) {
            f11183e.execute(runnable);
        }
    }
}
