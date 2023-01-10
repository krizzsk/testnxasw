package com.iproov.sdk.logging;

import p099while.C3701do;
import p099while.C3702if;

public class IPLog {
    private static boolean loggingEnabled = true;
    private static final C3702if loggingInstance = new C3701do();

    private IPLog() {
    }

    /* renamed from: d */
    public static void m43489d(String str, String str2) {
        if (loggingEnabled) {
            C3702if ifVar = loggingInstance;
            ifVar.m46702new(getPrefix() + str, str2);
        }
    }

    /* renamed from: e */
    public static void m43490e(String str, String str2) {
        if (loggingEnabled) {
            C3702if ifVar = loggingInstance;
            ifVar.mo43575do(getPrefix() + str, str2);
        }
    }

    private static String getPrefix() {
        return String.format("£ [%s] ", new Object[]{Thread.currentThread().getName()});
    }

    /* renamed from: i */
    public static void m43492i(String str, String str2) {
        if (loggingEnabled) {
            C3702if ifVar = loggingInstance;
            ifVar.m46703try(getPrefix() + str, str2);
        }
    }

    public static void setLoggingEnabled(boolean z) {
        loggingEnabled = z;
    }

    /* renamed from: v */
    public static void m43493v(String str, String str2) {
        if (loggingEnabled) {
            C3702if ifVar = loggingInstance;
            ifVar.mo43578if(getPrefix() + str, str2);
        }
    }

    /* renamed from: w */
    public static void m43494w(String str, String str2) {
        if (loggingEnabled) {
            C3702if ifVar = loggingInstance;
            ifVar.m46701for(getPrefix() + str, str2);
        }
    }

    /* renamed from: e */
    public static void m43491e(String str, String str2, Throwable th) {
        if (loggingEnabled) {
            C3702if ifVar = loggingInstance;
            ifVar.mo43579if(getPrefix() + str, str2, th);
        }
    }

    /* renamed from: w */
    public static void m43495w(String str, String str2, Throwable th) {
        if (loggingEnabled) {
            C3702if ifVar = loggingInstance;
            ifVar.mo43576do(getPrefix() + str, str2, th);
        }
    }
}
