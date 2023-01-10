package com.didi.sdk.log;

import android.content.Context;

public final class Logger {
    public static final String DEFAULT_TAG = "theone";
    public static final boolean IS_DEBUG = false;

    /* renamed from: a */
    private static final Printer f39207a = new C13207a();

    public static void clear(Context context) {
    }

    public static void initFloatView(Context context) {
    }

    public static void mToFv(String str) {
    }

    public static void removeFloatView(Context context) {
    }

    private Logger() {
    }

    public static Settings init() {
        return f39207a.init(DEFAULT_TAG);
    }

    public static Settings init(String str) {
        return f39207a.init(str);
    }

    /* renamed from: t */
    public static Printer m29541t(String str) {
        Printer printer = f39207a;
        return printer.mo98901t(str, printer.getSettings().getMethodCount());
    }

    /* renamed from: t */
    public static Printer m29540t(int i) {
        return f39207a.mo98901t((String) null, i);
    }

    /* renamed from: t */
    public static Printer m29542t(String str, int i) {
        return f39207a.mo98901t(str, i);
    }

    /* renamed from: d */
    public static void m29536d(String str, Object... objArr) {
        f39207a.mo98893d(str, objArr);
    }

    /* renamed from: e */
    public static void m29537e(String str, Object... objArr) {
        f39207a.mo98895e((Throwable) null, str, objArr);
    }

    /* renamed from: e */
    public static void m29538e(Throwable th, String str, Object... objArr) {
        f39207a.mo98895e(th, str, objArr);
    }

    /* renamed from: i */
    public static void m29539i(String str, Object... objArr) {
        f39207a.mo98897i(str, objArr);
    }

    /* renamed from: v */
    public static void m29543v(String str, Object... objArr) {
        f39207a.mo98902v(str, objArr);
    }

    /* renamed from: w */
    public static void m29544w(String str, Object... objArr) {
        f39207a.mo98903w(str, objArr);
    }

    public static void wtf(String str, Object... objArr) {
        f39207a.wtf(str, objArr);
    }

    public static void easylog(String str, String str2) {
        m29541t(str).normalLog(str2);
    }

    public static void json(String str) {
        f39207a.json(str);
    }

    public static void xml(String str) {
        f39207a.xml(str);
    }

    public static Settings getSettings() {
        return f39207a.getSettings();
    }
}
