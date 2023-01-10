package com.didiglobal.p205sa.biz.util;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.didiglobal.sa.biz.util.ThreadPoolHelper */
public class ThreadPoolHelper {

    /* renamed from: b */
    private static final int f53803b = 4;

    /* renamed from: c */
    private static final int f53804c = 12;

    /* renamed from: e */
    private static volatile ThreadPoolHelper f53805e;

    /* renamed from: f */
    private static ThreadPoolExecutor f53806f;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Logger f53807a = LoggerFactory.getLogger("ThreadPoolHelper");
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f53808d = 0;

    /* renamed from: c */
    static /* synthetic */ int m40139c(ThreadPoolHelper threadPoolHelper) {
        int i = threadPoolHelper.f53808d;
        threadPoolHelper.f53808d = i + 1;
        return i;
    }

    private ThreadPoolHelper() {
        m40137a();
    }

    /* renamed from: a */
    private void m40137a() {
        f53806f = new ThreadPoolExecutor(4, 12, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(128), new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Logger b = ThreadPoolHelper.this.f53807a;
                b.info("create a new thread,num is " + ThreadPoolHelper.this.f53808d, new Object[0]);
                return new Thread(runnable, "global_ride_common_thread_" + ThreadPoolHelper.m40139c(ThreadPoolHelper.this));
            }
        }, new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                Logger b = ThreadPoolHelper.this.f53807a;
                b.error("rejected exception is appeared, the runnable will be cast away : " + runnable.toString(), new Object[0]);
            }
        });
    }

    public static ThreadPoolHelper getInstance() {
        if (f53805e == null) {
            synchronized (ThreadPoolHelper.class) {
                if (f53805e == null) {
                    f53805e = new ThreadPoolHelper();
                }
            }
        }
        return f53805e;
    }

    public void execute(Runnable runnable) {
        if (runnable != null) {
            if (f53806f == null) {
                m40137a();
            }
            Logger logger = this.f53807a;
            logger.info("runnable " + runnable.toString() + "  will be executed", new Object[0]);
            f53806f.execute(runnable);
        }
    }
}
