package com.didi.payment.base.logger;

import android.text.TextUtils;
import com.didi.payment.base.utils.PayLogUtils;
import com.didi.sdk.logging.HeaderType;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

class PayDidiLogger implements IPayLogger {

    /* renamed from: a */
    private static final String f32369a = "PayDidiLogger";

    /* renamed from: b */
    private static final String f32370b = "PayLog";

    /* renamed from: c */
    private Logger f32371c;

    public static class LogType {
        public static final int LONG = 2;
        public static final int SHORT = 1;
    }

    public PayDidiLogger() {
        Logger logger = LoggerFactory.getLogger(f32370b);
        this.f32371c = logger;
        logger.setHeaderType(HeaderType.SHORT);
    }

    public void traceEvent(String str, HashMap<String, Object> hashMap) {
        if (!TextUtils.isEmpty(str) && hashMap != null) {
            this.f32371c.traceEvent(str, (Map<?, ?>) hashMap);
        }
    }

    public void debugEvent(String str, HashMap<String, Object> hashMap) {
        if (!TextUtils.isEmpty(str) && hashMap != null) {
            this.f32371c.debugEvent(str, (Map<?, ?>) hashMap);
        }
    }

    public void infoEvent(String str, HashMap<String, Object> hashMap) {
        if (!TextUtils.isEmpty(str) && hashMap != null) {
            this.f32371c.infoEvent(str, (Map<?, ?>) hashMap);
        }
    }

    public void warnEvent(String str, HashMap<String, Object> hashMap) {
        if (!TextUtils.isEmpty(str) && hashMap != null) {
            this.f32371c.warnEvent(str, (Map<?, ?>) hashMap);
        }
    }

    public void errorEvent(String str, HashMap<String, Object> hashMap) {
        if (!TextUtils.isEmpty(str) && hashMap != null) {
            this.f32371c.errorEvent(str, (Map<?, ?>) hashMap);
        }
    }

    public void setLogType(int i) {
        PayLogUtils.m24617d(f32369a, "setLogType type " + i);
        if (i == 1) {
            this.f32371c.setHeaderType(HeaderType.SHORT);
        } else if (i == 2) {
            this.f32371c.setHeaderType(HeaderType.LONG);
        }
    }
}
