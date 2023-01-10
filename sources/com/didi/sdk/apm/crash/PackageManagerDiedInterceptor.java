package com.didi.sdk.apm.crash;

import android.util.Log;

public class PackageManagerDiedInterceptor extends CrashInterceptor {

    /* renamed from: a */
    private static final String f37767a = "PackageManagerDiedInterceptor";

    public boolean intercept(Thread thread, Throwable th) {
        try {
            return (th instanceof RuntimeException) && isMatchSpecialExceptionMsg(th, "Package manager has died") && isMatchSpecialStackTraceElement(th, "android.app.ApplicationPackageManager", "getPackageInfo");
        } catch (Throwable unused) {
            return false;
        }
    }

    public void doCrashStrategy(Thread thread, Throwable th) {
        Log.e(f37767a, "doCrashStrategy", th);
        closeApp();
    }
}
