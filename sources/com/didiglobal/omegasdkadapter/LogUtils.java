package com.didiglobal.omegasdkadapter;

import android.app.Application;
import com.didi.sdk.apm.SystemUtils;

public class LogUtils {

    /* renamed from: a */
    private static boolean f52798a = false;

    public static void init(Application application) {
        if (application != null && application.getApplicationInfo() != null) {
            f52798a = (application.getApplicationInfo().flags & 2) != 0;
        }
    }

    /* renamed from: d */
    public static void m39628d(String str, String str2) {
        if (f52798a) {
            SystemUtils.log(3, str, "debug " + str2, (Throwable) null, "com.didiglobal.omegasdkadapter.LogUtils", 27);
        }
    }
}
