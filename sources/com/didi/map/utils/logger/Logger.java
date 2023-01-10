package com.didi.map.utils.logger;

public final class Logger {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    /* renamed from: a */
    private static Printer f31501a = new C11056a();

    public static boolean isLoggable() {
        return false;
    }

    private Logger() {
    }

    public static void printer(Printer printer) {
        f31501a = (Printer) C11057b.m24081b(printer);
    }

    public static void addLogAdapter(LogAdapter logAdapter) {
        f31501a.addAdapter((LogAdapter) C11057b.m24081b(logAdapter));
    }

    public static void clearLogAdapters() {
        f31501a.clearLogAdapters();
    }

    /* renamed from: t */
    public static Printer m24045t(String str) {
        return f31501a.mo85895t(str);
    }

    public static void log(int i, String str, String str2, Throwable th) {
        if (isLoggable()) {
            f31501a.log(i, str, str2, th);
        }
    }

    /* renamed from: d */
    public static void m24041d(String str, Object... objArr) {
        if (isLoggable()) {
            f31501a.mo85889d(str, objArr);
        }
    }

    /* renamed from: d */
    public static void m24040d(Object obj) {
        if (isLoggable()) {
            f31501a.mo85888d(obj);
        }
    }

    /* renamed from: e */
    public static void m24042e(String str, Object... objArr) {
        if (isLoggable()) {
            f31501a.mo85891e((Throwable) null, str, objArr);
        }
    }

    /* renamed from: e */
    public static void m24043e(Throwable th, String str, Object... objArr) {
        if (isLoggable()) {
            f31501a.mo85891e(th, str, objArr);
        }
    }

    /* renamed from: i */
    public static void m24044i(String str, Object... objArr) {
        if (isLoggable()) {
            f31501a.mo85892i(str, objArr);
        }
    }

    /* renamed from: v */
    public static void m24046v(String str, Object... objArr) {
        if (isLoggable()) {
            f31501a.mo85896v(str, objArr);
        }
    }

    /* renamed from: w */
    public static void m24047w(String str, Object... objArr) {
        if (isLoggable()) {
            f31501a.mo85897w(str, objArr);
        }
    }

    public static void wtf(String str, Object... objArr) {
        if (isLoggable()) {
            f31501a.wtf(str, objArr);
        }
    }

    public static void json(String str) {
        if (isLoggable()) {
            f31501a.json(str);
        }
    }

    public static void xml(String str) {
        if (isLoggable()) {
            f31501a.xml(str);
        }
    }
}
