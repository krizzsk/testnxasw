package com.didi.unifiedPay.util;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.TextUtil;

public class LogUtil {

    /* renamed from: a */
    private static String f47258a = "car_log";
    public static final boolean debug = false;

    /* renamed from: d */
    public static void m35171d(String str, String str2) {
    }

    /* renamed from: fi */
    public static void m35172fi(String str, String str2) {
        Logger logger = LoggerFactory.getLogger(f47258a);
        TagInfo a = m35170a(4);
        m35171d(str, str2);
        logger.info("%s %s %s", a.tagName, str2, a.jumpInfo);
    }

    private static class TagInfo {
        /* access modifiers changed from: private */
        public String jumpInfo;
        /* access modifiers changed from: private */
        public String tagName;

        private TagInfo() {
            this.tagName = "";
            this.jumpInfo = "";
        }
    }

    /* renamed from: a */
    private static TagInfo m35170a(int i) {
        TagInfo tagInfo = new TagInfo();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length <= i) {
            String unused = tagInfo.tagName = f47258a;
        } else {
            StackTraceElement stackTraceElement = stackTrace[i];
            String className = stackTraceElement.getClassName();
            if (!TextUtil.isEmpty(className)) {
                String unused2 = tagInfo.tagName = className.substring(className.lastIndexOf(".") + 1, className.length()) + "|" + stackTraceElement.getMethodName();
                String unused3 = tagInfo.jumpInfo = " (" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") ";
            }
        }
        return tagInfo;
    }
}
