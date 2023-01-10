package com.didi.component.common.helper;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolHelper {

    /* renamed from: b */
    private static final int f13472b = 4;

    /* renamed from: c */
    private static final int f13473c = 12;

    /* renamed from: e */
    private static volatile ThreadPoolHelper f13474e;

    /* renamed from: f */
    private static ThreadPoolExecutor f13475f;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Logger f13476a = LoggerFactory.getLogger("ThreadPoolHelper");
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f13477d = 0;

    /* renamed from: c */
    static /* synthetic */ int m11259c(ThreadPoolHelper threadPoolHelper) {
        int i = threadPoolHelper.f13477d;
        threadPoolHelper.f13477d = i + 1;
        return i;
    }

    private ThreadPoolHelper() {
        m11257a();
    }

    /* renamed from: a */
    private void m11257a() {
        f13475f = new ThreadPoolExecutor(4, 12, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(128), new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Logger b = ThreadPoolHelper.this.f13476a;
                b.info("create a new thread,num is " + ThreadPoolHelper.this.f13477d, new Object[0]);
                return new Thread(runnable, "global_ride_common_thread_" + ThreadPoolHelper.m11259c(ThreadPoolHelper.this));
            }
        }, new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                Logger b = ThreadPoolHelper.this.f13476a;
                b.error("rejected exception is appeared, the runnable will be cast away : " + runnable.toString(), new Object[0]);
            }
        });
    }

    public static ThreadPoolHelper getInstance() {
        if (f13474e == null) {
            synchronized (ThreadPoolHelper.class) {
                if (f13474e == null) {
                    f13474e = new ThreadPoolHelper();
                }
            }
        }
        return f13474e;
    }

    public void execute(Runnable runnable) {
        if (runnable != null) {
            if (f13475f == null) {
                m11257a();
            }
            Logger logger = this.f13476a;
            logger.info("runnable " + runnable.toString() + "  will be executed", new Object[0]);
            f13475f.execute(runnable);
        }
    }
}
