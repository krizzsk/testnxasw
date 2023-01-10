package com.didi.sdk.p155ms.common.utils;

import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.p155ms.common.MSAdapterFacade;

/* renamed from: com.didi.sdk.ms.common.utils.LogUtil */
public class LogUtil {
    private static final String TAG = "MSAdapter";

    /* renamed from: v */
    public static void m29856v(String str, String str2) {
        if (MSAdapterFacade.isDebug()) {
            SystemUtils.log(2, "MSAdapter." + str, str2, (Throwable) null, "com.didi.sdk.ms.common.utils.LogUtil", 13);
        }
    }

    /* renamed from: d */
    public static void m29853d(String str, String str2) {
        if (MSAdapterFacade.isDebug()) {
            SystemUtils.log(3, "MSAdapter." + str, str2, (Throwable) null, "com.didi.sdk.ms.common.utils.LogUtil", 19);
        }
    }

    /* renamed from: i */
    public static void m29855i(String str, String str2) {
        if (MSAdapterFacade.isDebug()) {
            SystemUtils.log(4, "MSAdapter." + str, str2, (Throwable) null, "com.didi.sdk.ms.common.utils.LogUtil", 25);
        }
    }

    /* renamed from: w */
    public static void m29857w(String str, String str2) {
        if (MSAdapterFacade.isDebug()) {
            SystemUtils.log(5, "MSAdapter." + str, str2, (Throwable) null, "com.didi.sdk.ms.common.utils.LogUtil", 31);
        }
    }

    /* renamed from: e */
    public static void m29854e(String str, String str2) {
        if (MSAdapterFacade.isDebug()) {
            SystemUtils.log(6, "MSAdapter." + str, str2, (Throwable) null, "com.didi.sdk.ms.common.utils.LogUtil", 37);
        }
    }
}
