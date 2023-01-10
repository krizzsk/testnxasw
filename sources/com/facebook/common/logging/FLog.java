package com.facebook.common.logging;

import java.util.Locale;

public class FLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static LoggingDelegate sHandler = FLogDefaultLoggingDelegate.getInstance();

    public static void setLoggingDelegate(LoggingDelegate loggingDelegate) {
        if (loggingDelegate != null) {
            sHandler = loggingDelegate;
            return;
        }
        throw new IllegalArgumentException();
    }

    public static boolean isLoggable(int i) {
        return sHandler.isLoggable(i);
    }

    public static void setMinimumLoggingLevel(int i) {
        sHandler.setMinimumLoggingLevel(i);
    }

    public static int getMinimumLoggingLevel() {
        return sHandler.getMinimumLoggingLevel();
    }

    /* renamed from: v */
    public static void m40552v(String str, String str2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo134142v(str, str2);
        }
    }

    /* renamed from: v */
    public static void m40553v(String str, String str2, Object obj) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo134142v(str, formatString(str2, obj));
        }
    }

    /* renamed from: v */
    public static void m40554v(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo134142v(str, formatString(str2, obj, obj2));
        }
    }

    /* renamed from: v */
    public static void m40555v(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo134142v(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* renamed from: v */
    public static void m40556v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo134142v(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: v */
    public static void m40544v(Class<?> cls, String str) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo134142v(getTag(cls), str);
        }
    }

    /* renamed from: v */
    public static void m40545v(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo134142v(getTag(cls), formatString(str, obj));
        }
    }

    /* renamed from: v */
    public static void m40546v(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo134142v(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* renamed from: v */
    public static void m40547v(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            m40544v(cls, formatString(str, obj, obj2, obj3));
        }
    }

    /* renamed from: v */
    public static void m40548v(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo134142v(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: v */
    public static void m40558v(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo134142v(str, formatString(str2, objArr));
        }
    }

    /* renamed from: v */
    public static void m40559v(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo134143v(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: v */
    public static void m40550v(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo134142v(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: v */
    public static void m40551v(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo134143v(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: v */
    public static void m40557v(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo134143v(str, str2, th);
        }
    }

    /* renamed from: v */
    public static void m40549v(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo134143v(getTag(cls), str, th);
        }
    }

    /* renamed from: d */
    public static void m40512d(String str, String str2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo134131d(str, str2);
        }
    }

    /* renamed from: d */
    public static void m40513d(String str, String str2, Object obj) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo134131d(str, formatString(str2, obj));
        }
    }

    /* renamed from: d */
    public static void m40514d(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo134131d(str, formatString(str2, obj, obj2));
        }
    }

    /* renamed from: d */
    public static void m40515d(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo134131d(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* renamed from: d */
    public static void m40516d(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo134131d(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: d */
    public static void m40504d(Class<?> cls, String str) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo134131d(getTag(cls), str);
        }
    }

    /* renamed from: d */
    public static void m40505d(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo134131d(getTag(cls), formatString(str, obj));
        }
    }

    /* renamed from: d */
    public static void m40506d(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo134131d(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* renamed from: d */
    public static void m40507d(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo134131d(getTag(cls), formatString(str, obj, obj2, obj3));
        }
    }

    /* renamed from: d */
    public static void m40508d(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo134131d(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: d */
    public static void m40518d(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            m40512d(str, formatString(str2, objArr));
        }
    }

    /* renamed from: d */
    public static void m40519d(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            m40517d(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: d */
    public static void m40510d(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo134131d(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: d */
    public static void m40511d(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo134132d(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: d */
    public static void m40517d(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo134132d(str, str2, th);
        }
    }

    /* renamed from: d */
    public static void m40509d(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo134132d(getTag(cls), str, th);
        }
    }

    /* renamed from: i */
    public static void m40536i(String str, String str2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo134136i(str, str2);
        }
    }

    /* renamed from: i */
    public static void m40537i(String str, String str2, Object obj) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo134136i(str, formatString(str2, obj));
        }
    }

    /* renamed from: i */
    public static void m40538i(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo134136i(str, formatString(str2, obj, obj2));
        }
    }

    /* renamed from: i */
    public static void m40539i(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo134136i(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* renamed from: i */
    public static void m40540i(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo134136i(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: i */
    public static void m40528i(Class<?> cls, String str) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo134136i(getTag(cls), str);
        }
    }

    /* renamed from: i */
    public static void m40529i(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo134136i(getTag(cls), formatString(str, obj));
        }
    }

    /* renamed from: i */
    public static void m40530i(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo134136i(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* renamed from: i */
    public static void m40531i(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo134136i(getTag(cls), formatString(str, obj, obj2, obj3));
        }
    }

    /* renamed from: i */
    public static void m40532i(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo134136i(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: i */
    public static void m40542i(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo134136i(str, formatString(str2, objArr));
        }
    }

    /* renamed from: i */
    public static void m40543i(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo134137i(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: i */
    public static void m40534i(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo134136i(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: i */
    public static void m40535i(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(4)) {
            sHandler.mo134137i(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: i */
    public static void m40541i(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo134137i(str, str2, th);
        }
    }

    /* renamed from: i */
    public static void m40533i(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo134137i(getTag(cls), str, th);
        }
    }

    /* renamed from: w */
    public static void m40564w(String str, String str2) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo134144w(str, str2);
        }
    }

    /* renamed from: w */
    public static void m40560w(Class<?> cls, String str) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo134144w(getTag(cls), str);
        }
    }

    /* renamed from: w */
    public static void m40566w(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo134144w(str, formatString(str2, objArr));
        }
    }

    /* renamed from: w */
    public static void m40567w(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo134145w(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: w */
    public static void m40562w(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo134144w(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: w */
    public static void m40563w(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            m40561w(cls, formatString(str, objArr), th);
        }
    }

    /* renamed from: w */
    public static void m40565w(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo134145w(str, str2, th);
        }
    }

    /* renamed from: w */
    public static void m40561w(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo134145w(getTag(cls), str, th);
        }
    }

    /* renamed from: e */
    public static void m40524e(String str, String str2) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo134133e(str, str2);
        }
    }

    /* renamed from: e */
    public static void m40520e(Class<?> cls, String str) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo134133e(getTag(cls), str);
        }
    }

    /* renamed from: e */
    public static void m40526e(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo134133e(str, formatString(str2, objArr));
        }
    }

    /* renamed from: e */
    public static void m40527e(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo134134e(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: e */
    public static void m40522e(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo134133e(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: e */
    public static void m40523e(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo134134e(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: e */
    public static void m40525e(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo134134e(str, str2, th);
        }
    }

    /* renamed from: e */
    public static void m40521e(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo134134e(getTag(cls), str, th);
        }
    }

    public static void wtf(String str, String str2) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, str2);
        }
    }

    public static void wtf(Class<?> cls, String str) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), str);
        }
    }

    public static void wtf(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, formatString(str2, objArr));
        }
    }

    public static void wtf(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, formatString(str2, objArr), th);
        }
    }

    public static void wtf(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), formatString(str, objArr));
        }
    }

    public static void wtf(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), formatString(str, objArr), th);
        }
    }

    public static void wtf(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, str2, th);
        }
    }

    public static void wtf(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), str, th);
        }
    }

    private static String formatString(String str, Object... objArr) {
        return String.format((Locale) null, str, objArr);
    }

    private static String getTag(Class<?> cls) {
        return cls.getSimpleName();
    }
}
