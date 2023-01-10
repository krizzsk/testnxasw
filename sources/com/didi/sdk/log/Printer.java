package com.didi.sdk.log;

public interface Printer {
    /* renamed from: d */
    void mo98893d(String str, Object... objArr);

    /* renamed from: e */
    void mo98894e(String str, Object... objArr);

    /* renamed from: e */
    void mo98895e(Throwable th, String str, Object... objArr);

    Settings getSettings();

    /* renamed from: i */
    void mo98897i(String str, Object... objArr);

    Settings init(String str);

    void json(String str);

    void normalLog(String str);

    /* renamed from: t */
    Printer mo98901t(String str, int i);

    /* renamed from: v */
    void mo98902v(String str, Object... objArr);

    /* renamed from: w */
    void mo98903w(String str, Object... objArr);

    void wtf(String str, Object... objArr);

    void xml(String str);
}
