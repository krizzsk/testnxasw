package com.didichuxing.dfbasesdk.utils;

import com.didi.sdk.apm.SystemUtils;
import rui.config.RConfigConstants;

public class LogUtils {

    /* renamed from: a */
    private static final String f49405a = "DiFace";

    private LogUtils() {
    }

    /* renamed from: a */
    private static String m37050a(String str, StackTraceElement stackTraceElement) {
        if (stackTraceElement == null) {
            return str;
        }
        String a = m37049a(stackTraceElement.getClassName());
        String methodName = stackTraceElement.getMethodName();
        int lineNumber = stackTraceElement.getLineNumber();
        String fileName = stackTraceElement.getFileName();
        return str + " at " + a + RConfigConstants.KEYWORD_COLOR_SIGN + methodName + " (" + fileName + ":" + lineNumber + ")  ";
    }

    /* renamed from: a */
    private static String m37049a(String str) {
        return str.substring(str.lastIndexOf(".") + 1);
    }

    /* renamed from: a */
    private static StackTraceElement m37048a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            StackTraceElement stackTraceElement = stackTrace[i];
            boolean equals = stackTraceElement.getClassName().equals(LogUtils.class.getName());
            if (z && !equals) {
                return stackTraceElement;
            }
            i++;
            z = equals;
        }
        return null;
    }

    /* renamed from: d */
    public static void m37052d(String str, String str2) {
        if (DebugUtils.isDebug()) {
            SystemUtils.log(3, str, m37050a(str2, m37048a()), (Throwable) null, "com.didichuxing.dfbasesdk.utils.LogUtils", 45);
        }
    }

    /* renamed from: d */
    public static void m37051d(String str) {
        m37052d(f49405a, str);
    }

    /* renamed from: i */
    public static void m37058i(String str, String str2) {
        SystemUtils.log(4, str, str2, (Throwable) null, "com.didichuxing.dfbasesdk.utils.LogUtils", 54);
    }

    /* renamed from: i */
    public static void m37057i(String str) {
        m37058i(f49405a, str);
    }

    /* renamed from: e */
    public static void m37054e(String str, String str2) {
        SystemUtils.log(6, str, str2, (Throwable) null, "com.didichuxing.dfbasesdk.utils.LogUtils", 62);
    }

    /* renamed from: e */
    public static void m37055e(String str, String str2, Throwable th) {
        SystemUtils.log(6, str, str2, th, "com.didichuxing.dfbasesdk.utils.LogUtils", 66);
    }

    /* renamed from: e */
    public static void m37053e(String str) {
        m37054e(f49405a, str);
    }

    /* renamed from: e */
    public static void m37056e(String str, Throwable th) {
        m37055e(f49405a, str, th);
    }

    public static void logStackTrace(Throwable th) {
        if (DebugUtils.isDebug() && th != null) {
            th.printStackTrace();
        }
    }
}
