package com.didi.aoe.library.logging;

import com.didi.aoe.library.logging.impl.AoeLoggerImpl;

public final class LoggerFactory {

    /* renamed from: a */
    private static LoggerBinder f10046a;

    private LoggerFactory() {
    }

    public static Logger getLogger(String str) {
        LoggerBinder loggerBinder = f10046a;
        Logger logger = loggerBinder != null ? loggerBinder.getLogger(str) : null;
        if (logger != null) {
            return logger;
        }
        return m8717a(str);
    }

    /* renamed from: a */
    private static Logger m8717a(String str) {
        C41631 r0 = new LoggerBinder() {
            public Logger getLogger(String str) {
                return new AoeLoggerImpl(str);
            }
        };
        f10046a = r0;
        return r0.getLogger(str);
    }

    public static void setLoggerBinder(LoggerBinder loggerBinder) {
        f10046a = loggerBinder;
    }
}
