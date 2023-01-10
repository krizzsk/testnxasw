package com.didiglobal.domainservice.utils;

import android.content.Context;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class ELog {

    /* renamed from: a */
    private static boolean f52612a = false;

    /* renamed from: b */
    private static Logger f52613b = LoggerFactory.getLogger("DomainService");

    public static void init(Context context) {
        f52612a = isDebuggableApp(context);
    }

    public static boolean isDebuggableApp(Context context) {
        try {
            boolean z = (context.getApplicationInfo().flags & 2) != 0;
            return !z ? Log.isLoggable("didi", 3) : z;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void log(String str) {
        if (f52612a) {
            SystemUtils.log(3, "DomainService", str, (Throwable) null, "com.didiglobal.domainservice.utils.ELog", 37);
        }
    }

    public static void info(String str) {
        boolean isInitial = LoggerFactory.isInitial();
        if (f52612a) {
            if (!isInitial) {
                SystemUtils.log(4, "DomainService", str, (Throwable) null, "com.didiglobal.domainservice.utils.ELog", 45);
            } else {
                f52613b.info(str, new Object[0]);
            }
        } else if (isInitial) {
            f52613b.warn(str, new Object[0]);
        }
    }

    public static void debug(String str) {
        boolean isInitial = LoggerFactory.isInitial();
        if (f52612a) {
            if (!isInitial) {
                SystemUtils.log(3, "DomainService", str, (Throwable) null, "com.didiglobal.domainservice.utils.ELog", 58);
            } else {
                f52613b.debug(str, new Object[0]);
            }
        } else if (isInitial) {
            f52613b.warn(str, new Object[0]);
        }
    }

    public static void warn(String str) {
        boolean isInitial = LoggerFactory.isInitial();
        if (f52612a) {
            if (!isInitial) {
                SystemUtils.log(5, "DomainService", str, (Throwable) null, "com.didiglobal.domainservice.utils.ELog", 73);
            } else {
                f52613b.warn(str, new Object[0]);
            }
        } else if (isInitial) {
            f52613b.warn(str, new Object[0]);
        }
    }

    public static void error(String str) {
        boolean isInitial = LoggerFactory.isInitial();
        if (f52612a) {
            if (!isInitial) {
                SystemUtils.log(6, "DomainService", str, (Throwable) null, "com.didiglobal.domainservice.utils.ELog", 86);
            } else {
                f52613b.warn(str, new Object[0]);
            }
        } else if (isInitial) {
            f52613b.warn(str, new Object[0]);
        }
    }
}
