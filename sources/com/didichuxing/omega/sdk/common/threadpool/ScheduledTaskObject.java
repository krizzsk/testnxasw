package com.didichuxing.omega.sdk.common.threadpool;

import com.didichuxing.omega.sdk.common.threadpool.ThreadPoolHelp;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledTaskObject {
    private static ScheduledTaskObject instance;
    private static ScheduledExecutorService mScheduledExecutorService;

    private ScheduledTaskObject() {
        init();
    }

    public static ScheduledTaskObject getInstance() {
        if (instance == null) {
            instance = new ScheduledTaskObject();
        }
        return instance;
    }

    private void init() {
        if (mScheduledExecutorService == null) {
            mScheduledExecutorService = ThreadPoolHelp.Builder.schedule(3).scheduleBuilder();
        }
    }

    public void start(Runnable runnable, long j) {
        mScheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    public void start(Runnable runnable, long j, long j2) {
        mScheduledExecutorService.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS);
    }
}
