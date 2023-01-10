package com.didi.safetoolkit.util;

import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class SfLog {

    /* renamed from: a */
    private static String f37300a = "SfLog";

    static class Debug {
        private static boolean PRINT_DEBUG = Log.isLoggable("SfDebugLog", 3);
        private static boolean apolloInit = false;
        private static boolean enableDebugLog = false;

        Debug() {
        }

        static boolean isEnable() {
            boolean z = enableDebugLog | PRINT_DEBUG;
            enableDebugLog = z;
            if (apolloInit) {
            }
            return z;
        }
    }

    /* renamed from: a */
    private static TagInfo m28128a(String str) {
        TagInfo tagInfo = new TagInfo();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length > 5) {
            StackTraceElement stackTraceElement = stackTrace[5];
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className)) {
                String fileName = stackTraceElement.getFileName();
                String substring = (TextUtils.isEmpty(fileName) || !fileName.contains(".")) ? "" : fileName.substring(0, fileName.indexOf("."));
                if (TextUtils.isEmpty(substring)) {
                    substring = className.substring(className.lastIndexOf(".") + 1, className.length());
                }
                String unused = tagInfo.tagName = substring;
                String unused2 = tagInfo.jumpInfo = " (" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") ";
            }
        }
        if (!TextUtils.isEmpty(str)) {
            String unused3 = tagInfo.tagName = str;
        }
        return tagInfo;
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
    private static void m28129a(int i, Throwable th, String str, String str2) {
        if (!TextUtils.isEmpty(str2) || th != null) {
            TagInfo a = m28128a(str);
            Logger logger = LoggerFactory.getLogger(f37300a);
            if (i == 2) {
                logger.trace("%s %s %s", a.tagName, str2, a.jumpInfo);
            } else if (i != 3) {
                if (i == 4) {
                    logger.info("%s %s %s", a.tagName, str2, a.jumpInfo);
                } else if (i == 5) {
                    logger.warn("%s %s %s", a.tagName, str2, a.jumpInfo);
                } else if (i == 6) {
                    if (th == null) {
                        logger.error("%s %s %s", a.tagName, str2, a.jumpInfo);
                        return;
                    }
                    logger.error(String.format("%s %s %s", new Object[]{a.tagName, str2, a.jumpInfo}), th);
                }
            } else if (Debug.isEnable()) {
                logger.info("DEBUG %s %s %s", a.tagName, str2, a.jumpInfo);
            } else {
                logger.debug("%s %s %s", a.tagName, str2, a.jumpInfo);
            }
        }
    }

    /* renamed from: v */
    public static void m28139v(String str) {
        m28129a(2, (Throwable) null, (String) null, str);
    }

    /* renamed from: v */
    public static void m28140v(String str, String str2) {
        m28129a(2, (Throwable) null, str, str2);
    }

    /* renamed from: d */
    public static void m28130d(String str) {
        m28129a(3, (Throwable) null, (String) null, str);
    }

    /* renamed from: d */
    public static void m28131d(String str, String str2) {
        m28129a(3, (Throwable) null, str, str2);
    }

    /* renamed from: i */
    public static void m28137i(String str) {
        m28129a(4, (Throwable) null, (String) null, str);
    }

    /* renamed from: i */
    public static void m28138i(String str, String str2) {
        m28129a(4, (Throwable) null, str, str2);
    }

    /* renamed from: w */
    public static void m28141w(String str) {
        m28129a(5, (Throwable) null, (String) null, str);
    }

    /* renamed from: w */
    public static void m28142w(String str, String str2) {
        m28129a(5, (Throwable) null, str, str2);
    }

    /* renamed from: e */
    public static void m28132e(String str) {
        m28129a(6, (Throwable) null, (String) null, str);
    }

    /* renamed from: e */
    public static void m28136e(Throwable th) {
        m28129a(6, th, (String) null, (String) null);
    }

    /* renamed from: e */
    public static void m28133e(String str, String str2) {
        m28129a(6, (Throwable) null, str, str2);
    }

    /* renamed from: e */
    public static void m28135e(String str, Throwable th) {
        m28129a(6, th, (String) null, str);
    }

    /* renamed from: e */
    public static void m28134e(String str, String str2, Throwable th) {
        m28129a(6, th, str, str2);
    }
}
