package com.didi.sdk.apm.utils;

import android.util.Log;
import com.didi.sdk.apm.crash.CrashInterceptor;
import com.didi.sdk.apm.crash.DeadObjectExceptionByStorageManagerInterceptor;
import com.didi.sdk.apm.crash.DeadSystemExceptionInterceptor;
import com.didi.sdk.apm.crash.FailureFromSystemMInterceptor;
import com.didi.sdk.apm.crash.FinalizerWatchdogDaemonInterceptor;
import com.didi.sdk.apm.crash.JobIntentServiceExceptionInterceptor;
import com.didi.sdk.apm.crash.PackageManagerDiedInterceptor;
import com.didi.sdk.apm.crash.PendingResultFinishInterceptor;
import com.didi.sdk.apm.crash.ReportSizeConfigurationInterceptor;
import com.didi.sdk.apm.crash.SecurityExceptionInterceptor;
import com.didi.sdk.apm.crash.WindowManagerBadTokenExceptionInterceptor;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;

public class ApmUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private static final String f37816a = "ApmUncaughtExceptionHandler";

    /* renamed from: b */
    private static Thread.UncaughtExceptionHandler f37817b;

    /* renamed from: c */
    private static final List<CrashInterceptor> f37818c;

    static {
        ArrayList arrayList = new ArrayList();
        f37818c = arrayList;
        arrayList.add(new FinalizerWatchdogDaemonInterceptor());
        f37818c.add(new PendingResultFinishInterceptor());
        f37818c.add(new FailureFromSystemMInterceptor());
        f37818c.add(new ReportSizeConfigurationInterceptor());
        f37818c.add(new DeadObjectExceptionByStorageManagerInterceptor());
        f37818c.add(new WindowManagerBadTokenExceptionInterceptor());
        f37818c.add(new PackageManagerDiedInterceptor());
        f37818c.add(new DeadSystemExceptionInterceptor());
        f37818c.add(new SecurityExceptionInterceptor());
        f37818c.add(new JobIntentServiceExceptionInterceptor());
    }

    public void uncaughtException(Thread thread, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("uncaughtException and Thread is :");
        sb.append(thread);
        Log.e(f37816a, sb.toString() != null ? thread.toString() : "", th);
        for (CrashInterceptor next : f37818c) {
            if (next != null && next.intercept(thread, th)) {
                next.doCrashStrategy(thread, th);
                return;
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = f37817b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    public static void init() {
        f37817b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new ApmUncaughtExceptionHandler());
    }
}
