package com.facebook.common.logging;

public interface LoggingDelegate {
    /* renamed from: d */
    void mo134131d(String str, String str2);

    /* renamed from: d */
    void mo134132d(String str, String str2, Throwable th);

    /* renamed from: e */
    void mo134133e(String str, String str2);

    /* renamed from: e */
    void mo134134e(String str, String str2, Throwable th);

    int getMinimumLoggingLevel();

    /* renamed from: i */
    void mo134136i(String str, String str2);

    /* renamed from: i */
    void mo134137i(String str, String str2, Throwable th);

    boolean isLoggable(int i);

    void log(int i, String str, String str2);

    void setMinimumLoggingLevel(int i);

    /* renamed from: v */
    void mo134142v(String str, String str2);

    /* renamed from: v */
    void mo134143v(String str, String str2, Throwable th);

    /* renamed from: w */
    void mo134144w(String str, String str2);

    /* renamed from: w */
    void mo134145w(String str, String str2, Throwable th);

    void wtf(String str, String str2);

    void wtf(String str, String str2, Throwable th);
}
