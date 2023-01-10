package com.didi.greatwall.util.log;

import android.os.Bundle;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class GLogger {

    /* renamed from: a */
    private static final String f25226a = "GreatWall";

    /* renamed from: b */
    private String f25227b = "";

    /* renamed from: c */
    private Logger f25228c = LoggerFactory.getLogger(f25226a);

    public static final GLogger getLogger(String str) {
        return new GLogger(str);
    }

    public static final GLogger getLogger() {
        return new GLogger("");
    }

    public GLogger(String str) {
        this.f25227b = str;
    }

    public void debug(String str) {
        if (this.f25227b.length() > 0) {
            Logger logger = this.f25228c;
            logger.debug(this.f25227b + "-->" + str, new Object[0]);
            return;
        }
        this.f25228c.debug(str, new Object[0]);
    }

    public void info(String str) {
        if (this.f25227b.length() > 0) {
            Logger logger = this.f25228c;
            logger.info(this.f25227b + "-->" + str, new Object[0]);
            return;
        }
        this.f25228c.info(str, new Object[0]);
    }

    public void warn(String str) {
        if (this.f25227b.length() > 0) {
            Logger logger = this.f25228c;
            logger.warn(this.f25227b + "-->" + str, new Object[0]);
            return;
        }
        this.f25228c.warn(str, new Object[0]);
    }

    public void warn(String str, Throwable th) {
        if (this.f25227b.length() > 0) {
            Logger logger = this.f25228c;
            logger.warn(this.f25227b + "-->" + str, th);
            return;
        }
        this.f25228c.warn(str, th);
    }

    public void error(String str) {
        if (this.f25227b.length() > 0) {
            Logger logger = this.f25228c;
            logger.error(this.f25227b + "-->" + str, new Object[0]);
            return;
        }
        this.f25228c.error(str, new Object[0]);
    }

    public void error(String str, Throwable th) {
        if (this.f25227b.length() > 0) {
            Logger logger = this.f25228c;
            logger.error(this.f25227b + "-->" + str, th);
            return;
        }
        this.f25228c.error(str, th);
    }

    public static String bundleToString(Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : bundle.keySet()) {
            sb.append(str);
            sb.append(" = ");
            sb.append(bundle.get(str));
        }
        return sb.toString();
    }
}
