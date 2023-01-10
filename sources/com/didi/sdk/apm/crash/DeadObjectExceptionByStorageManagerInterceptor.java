package com.didi.sdk.apm.crash;

import android.os.DeadObjectException;
import android.util.Log;

public class DeadObjectExceptionByStorageManagerInterceptor extends CrashInterceptor {

    /* renamed from: a */
    private static final String f37762a = "DeadObjectExceptionByStorageManagerInterceptor";

    public boolean intercept(Thread thread, Throwable th) {
        try {
            return (th instanceof DeadObjectException) && isMatchSpecialStackTraceElement(th, "android.os.storage.StorageManager", "getVolumeList");
        } catch (Throwable unused) {
            return false;
        }
    }

    public void doCrashStrategy(Thread thread, Throwable th) {
        Log.e(f37762a, "doCrashStrategy", th);
        closeApp();
    }
}
