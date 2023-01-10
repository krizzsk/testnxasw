package com.didi.sdk.apm.crash;

import android.util.Log;
import java.util.concurrent.TimeoutException;

public class FinalizerWatchdogDaemonInterceptor extends CrashInterceptor {

    /* renamed from: a */
    private static final String f37765a = "FinalizerWatchdogDaemonInterceptor";

    public boolean intercept(Thread thread, Throwable th) {
        try {
            if (!thread.getName().equals("FinalizerWatchdogDaemon") || !(th instanceof TimeoutException)) {
                return false;
            }
            Log.e(f37765a, "Caught an uncaught exception,FinalizerWatchdogDaemon will ignore :" + th.getMessage());
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void doCrashStrategy(Thread thread, Throwable th) {
        Log.e(f37765a, "doCrashStrategy", th);
    }
}
