package com.didi.map.utils.logger;

public interface Printer {
    void addAdapter(LogAdapter logAdapter);

    void clearLogAdapters();

    /* renamed from: d */
    void mo85888d(Object obj);

    /* renamed from: d */
    void mo85889d(String str, Object... objArr);

    /* renamed from: e */
    void mo85890e(String str, Object... objArr);

    /* renamed from: e */
    void mo85891e(Throwable th, String str, Object... objArr);

    /* renamed from: i */
    void mo85892i(String str, Object... objArr);

    void json(String str);

    void log(int i, String str, String str2, Throwable th);

    /* renamed from: t */
    Printer mo85895t(String str);

    /* renamed from: v */
    void mo85896v(String str, Object... objArr);

    /* renamed from: w */
    void mo85897w(String str, Object... objArr);

    void wtf(String str, Object... objArr);

    void xml(String str);
}
