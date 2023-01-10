package com.didi.beatles.p101im.thirty.greenrobot.dao;

import android.util.Log;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.DaoLog */
public class DaoLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    /* renamed from: a */
    private static final String f11496a = "greenDAO";

    public static boolean isLoggable(int i) {
        return Log.isLoggable(f11496a, i);
    }

    public static String getStackTraceString(Throwable th) {
        return Log.getStackTraceString(th);
    }

    public static void println(int i, String str) {
        SystemUtils.log(i, f11496a, str, (Throwable) null, "com.didi.beatles.im.thirty.greenrobot.dao.DaoLog", 47);
    }

    /* renamed from: v */
    public static void m9919v(String str) {
        SystemUtils.log(2, f11496a, str, (Throwable) null, "com.didi.beatles.im.thirty.greenrobot.dao.DaoLog", 51);
    }

    /* renamed from: v */
    public static void m9920v(String str, Throwable th) {
        SystemUtils.log(2, f11496a, str, th, "com.didi.beatles.im.thirty.greenrobot.dao.DaoLog", 55);
    }

    /* renamed from: d */
    public static void m9913d(String str) {
        IMLog.m10020d(f11496a, str);
    }

    /* renamed from: d */
    public static void m9914d(String str, Throwable th) {
        IMLog.m10020d(f11496a, str);
    }

    /* renamed from: i */
    public static void m9917i(String str) {
        SystemUtils.log(4, f11496a, str, (Throwable) null, "com.didi.beatles.im.thirty.greenrobot.dao.DaoLog", 67);
    }

    /* renamed from: i */
    public static void m9918i(String str, Throwable th) {
        SystemUtils.log(4, f11496a, str, th, "com.didi.beatles.im.thirty.greenrobot.dao.DaoLog", 71);
    }

    /* renamed from: w */
    public static void m9921w(String str) {
        SystemUtils.log(5, f11496a, str, (Throwable) null, "com.didi.beatles.im.thirty.greenrobot.dao.DaoLog", 75);
    }

    /* renamed from: w */
    public static void m9922w(String str, Throwable th) {
        SystemUtils.log(5, f11496a, str, th, "com.didi.beatles.im.thirty.greenrobot.dao.DaoLog", 79);
    }

    /* renamed from: w */
    public static void m9923w(Throwable th) {
        Log.w(f11496a, th);
    }

    /* renamed from: e */
    public static void m9915e(String str) {
        SystemUtils.log(5, f11496a, str, (Throwable) null, "com.didi.beatles.im.thirty.greenrobot.dao.DaoLog", 87);
    }

    /* renamed from: e */
    public static void m9916e(String str, Throwable th) {
        IMLog.m10021e(f11496a, str, th);
    }
}
