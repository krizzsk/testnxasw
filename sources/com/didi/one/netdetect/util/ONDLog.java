package com.didi.one.netdetect.util;

import android.util.Log;
import com.didi.sdk.apm.SystemUtils;

public final class ONDLog {

    /* renamed from: a */
    private static int f31944a = 2;

    /* renamed from: a */
    private static boolean m24358a() {
        return false;
    }

    private ONDLog() {
        throw new RuntimeException();
    }

    /* renamed from: v */
    public static int m24365v(String str, String str2) {
        if (f31944a > 2) {
            return 0;
        }
        return SystemUtils.log(2, str, str2, (Throwable) null, "com.didi.one.netdetect.util.ONDLog", 27);
    }

    /* renamed from: v */
    public static int m24366v(String str, String str2, Throwable th) {
        if (f31944a > 2) {
            return 0;
        }
        return SystemUtils.log(2, str, str2, th, "com.didi.one.netdetect.util.ONDLog", 39);
    }

    /* renamed from: d */
    public static int m24359d(String str, String str2) {
        if (f31944a > 3) {
            return 0;
        }
        return SystemUtils.log(3, str, str2, (Throwable) null, "com.didi.one.netdetect.util.ONDLog", 50);
    }

    /* renamed from: d */
    public static int m24360d(String str, String str2, Throwable th) {
        if (f31944a > 3) {
            return 0;
        }
        return SystemUtils.log(3, str, str2, th, "com.didi.one.netdetect.util.ONDLog", 62);
    }

    /* renamed from: i */
    public static int m24363i(String str, String str2) {
        if (f31944a > 4) {
            return 0;
        }
        return SystemUtils.log(4, str, str2, (Throwable) null, "com.didi.one.netdetect.util.ONDLog", 73);
    }

    /* renamed from: i */
    public static int m24364i(String str, String str2, Throwable th) {
        if (f31944a > 4) {
            return 0;
        }
        return SystemUtils.log(4, str, str2, th, "com.didi.one.netdetect.util.ONDLog", 85);
    }

    /* renamed from: w */
    public static int m24367w(String str, String str2) {
        if (f31944a > 5) {
            return 0;
        }
        return SystemUtils.log(5, str, str2, (Throwable) null, "com.didi.one.netdetect.util.ONDLog", 96);
    }

    /* renamed from: w */
    public static int m24368w(String str, String str2, Throwable th) {
        if (f31944a > 5) {
            return 0;
        }
        return SystemUtils.log(5, str, str2, th, "com.didi.one.netdetect.util.ONDLog", 108);
    }

    /* renamed from: w */
    public static int m24369w(String str, Throwable th) {
        if (f31944a > 5) {
            return 0;
        }
        return Log.w(str, th);
    }

    /* renamed from: e */
    public static int m24361e(String str, String str2) {
        if (f31944a > 6) {
            return 0;
        }
        return SystemUtils.log(6, str, str2, (Throwable) null, "com.didi.one.netdetect.util.ONDLog", 130);
    }

    /* renamed from: e */
    public static int m24362e(String str, String str2, Throwable th) {
        if (f31944a > 6) {
            return 0;
        }
        return SystemUtils.log(6, str, str2, th, "com.didi.one.netdetect.util.ONDLog", 142);
    }

    public static void logClassAndMethod(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj.hashCode());
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        if (!(stackTrace == null || stackTrace.length < 2 || stackTrace[1] == null)) {
            sb.append("|");
            sb.append(stackTrace[1].getMethodName());
        }
        m24359d(obj.getClass().getSimpleName(), sb.toString());
    }

    public static void setLevel(int i) {
        if (m24358a()) {
            f31944a = 2;
        } else {
            f31944a = i;
        }
    }
}
