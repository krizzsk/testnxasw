package com.didi.sdk.data;

import android.text.TextUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class NLogger {
    public static final String TAG = "NLogger";

    /* renamed from: a */
    private static Logger f38540a = LoggerFactory.getLogger("NLogger");

    /* renamed from: b */
    private String f38541b;

    private NLogger() {
    }

    public static NLogger getNLogger(String str) {
        NLogger nLogger = new NLogger();
        nLogger.f38541b = str;
        return nLogger;
    }

    public static NLogger getNLogger() {
        return new NLogger();
    }

    public void debug(String str) {
        if (TextUtils.isEmpty(this.f38541b)) {
            f38540a.debug(str, new Object[0]);
            return;
        }
        Logger logger = f38540a;
        logger.debug("===" + this.f38541b + "=== " + str, new Object[0]);
    }

    public void info(String str) {
        if (TextUtils.isEmpty(this.f38541b)) {
            f38540a.info(str, new Object[0]);
            return;
        }
        Logger logger = f38540a;
        logger.info("===" + this.f38541b + "=== " + str, new Object[0]);
    }

    public void warn(String str) {
        if (TextUtils.isEmpty(this.f38541b)) {
            f38540a.warn(str, new Object[0]);
            return;
        }
        Logger logger = f38540a;
        logger.warn("===" + this.f38541b + "=== " + str, new Object[0]);
    }

    public void error(String str) {
        if (TextUtils.isEmpty(this.f38541b)) {
            f38540a.error(str, new Object[0]);
            return;
        }
        Logger logger = f38540a;
        logger.error("===" + this.f38541b + "=== " + str, new Object[0]);
    }
}
