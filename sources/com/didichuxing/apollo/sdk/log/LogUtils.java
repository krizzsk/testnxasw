package com.didichuxing.apollo.sdk.log;

import com.didi.sdk.apm.SystemUtils;

public class LogUtils {
    public static boolean DEBUG = false;

    /* renamed from: a */
    private static final String f48287a = "apollo";

    /* renamed from: b */
    private static ILogDelegate f48288b;

    public static void attachLogDelegate(ILogDelegate iLogDelegate) {
        f48288b = iLogDelegate;
    }

    public static void detachLogDelegate() {
        f48288b = null;
    }

    /* renamed from: d */
    public static void m36179d(String str, String str2) {
        if (DEBUG) {
            SystemUtils.log(3, str, str2, (Throwable) null, "com.didichuxing.apollo.sdk.log.LogUtils", 23);
        }
    }

    /* renamed from: d */
    public static void m36178d(String str) {
        if (DEBUG) {
            m36179d("apollo", str);
        }
    }

    /* renamed from: e */
    public static void m36180e(String str) {
        ILogDelegate iLogDelegate = f48288b;
        if (iLogDelegate != null) {
            iLogDelegate.saveErrorLog(new ApolloErrorLog(str));
        }
    }
}
