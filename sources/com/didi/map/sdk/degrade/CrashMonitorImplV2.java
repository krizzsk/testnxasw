package com.didi.map.sdk.degrade;

import com.didi.map.sdk.navtracker.log.DLog;

public class CrashMonitorImplV2 implements ICrashMonitor {

    /* renamed from: a */
    private static volatile boolean f30545a = false;

    public void start(ICrashListener iCrashListener) {
        if (f30545a) {
            DLog.m23804d("ccc", "crash monitor v2 already init", new Object[0]);
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new DegradeUncaughtExceptionHandler(iCrashListener));
        f30545a = true;
        DLog.m23804d("ccc", "degrade handler is ready", new Object[0]);
    }
}
