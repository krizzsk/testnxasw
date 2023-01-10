package com.didi.sdk.app;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.swarm.toolkit.LogService;

/* renamed from: com.didi.sdk.app.f */
/* compiled from: LogServiceImpl */
class C12839f implements LogService {

    /* renamed from: a */
    static final Logger f37992a = LoggerFactory.getLogger("LogService");

    C12839f() {
    }

    public boolean isVerboseEnabled() {
        return f37992a.isTraceEnabled();
    }

    public boolean isDebugEnabled() {
        return f37992a.isDebugEnabled();
    }

    public boolean isInfoEnabled() {
        return f37992a.isInfoEnabled();
    }

    public boolean isWarnEnabled() {
        return f37992a.isWarnEnabled();
    }

    public boolean isErrorEnabled() {
        return f37992a.isErrorEnabled();
    }

    public void verbose(String str, String str2) {
        if (isVerboseEnabled()) {
            LoggerFactory.getLogger(str).trace(str2, new Object[0]);
        }
    }

    public void verbose(String str, String str2, Throwable th) {
        if (isVerboseEnabled()) {
            LoggerFactory.getLogger(str).trace(str2, th);
        }
    }

    public void debug(String str, String str2) {
        if (isDebugEnabled()) {
            LoggerFactory.getLogger(str).debug(str2, new Object[0]);
        }
    }

    public void debug(String str, String str2, Throwable th) {
        if (isDebugEnabled()) {
            LoggerFactory.getLogger(str).debug(str2, th);
        }
    }

    public void info(String str, String str2) {
        if (isInfoEnabled()) {
            LoggerFactory.getLogger(str).info(str2, new Object[0]);
        }
    }

    public void info(String str, String str2, Throwable th) {
        if (isInfoEnabled()) {
            LoggerFactory.getLogger(str).info(str2, th);
        }
    }

    public void warn(String str, String str2) {
        if (isWarnEnabled()) {
            LoggerFactory.getLogger(str).warn(str2, new Object[0]);
        }
    }

    public void warn(String str, String str2, Throwable th) {
        if (isWarnEnabled()) {
            LoggerFactory.getLogger(str).warn(str2, th);
        }
    }

    public void error(String str, String str2) {
        if (isErrorEnabled()) {
            LoggerFactory.getLogger(str).error(str2, new Object[0]);
        }
    }

    public void error(String str, String str2, Throwable th) {
        if (isErrorEnabled()) {
            LoggerFactory.getLogger(str).error(str2, th);
        }
    }
}
