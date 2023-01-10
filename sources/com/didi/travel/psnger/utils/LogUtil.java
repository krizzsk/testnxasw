package com.didi.travel.psnger.utils;

import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class LogUtil {

    /* renamed from: a */
    private static final boolean f46893a = true;

    /* renamed from: b */
    private static final String f46894b = "car_log_write_file";

    /* renamed from: c */
    private static final String f46895c = "isOutputLog";

    /* renamed from: d */
    private static final String f46896d = "isWriteFile";

    /* renamed from: e */
    private static String f46897e = "car_log";

    /* renamed from: f */
    private static boolean f46898f = false;

    /* renamed from: g */
    private static boolean f46899g = true;

    public static void setOutput(boolean z) {
        f46898f = z;
    }

    public static void setWriteFile(boolean z) {
        f46899g = z;
    }

    public static void setTag(String str) {
        f46897e = str;
    }

    /* renamed from: v */
    public static void m34923v(String str) {
        m34911a(2, str);
    }

    /* renamed from: v */
    public static void m34924v(String str, String str2) {
        m34912a(2, str, str2);
    }

    /* renamed from: d */
    public static void m34913d(String str) {
        m34911a(3, str);
    }

    /* renamed from: d */
    public static void m34914d(String str, String str2) {
        m34912a(3, str, str2);
    }

    /* renamed from: i */
    public static void m34921i(String str) {
        m34911a(4, str);
    }

    /* renamed from: i */
    public static void m34922i(String str, String str2) {
        m34912a(4, str, str2);
    }

    /* renamed from: w */
    public static void m34925w(String str) {
        m34911a(5, str);
    }

    /* renamed from: w */
    public static void m34926w(String str, String str2) {
        m34912a(5, str, str2);
    }

    /* renamed from: e */
    public static void m34916e(String str) {
        m34911a(6, str);
    }

    /* renamed from: e */
    public static void m34917e(String str, String str2) {
        m34912a(6, str, str2);
    }

    /* renamed from: d */
    public static void m34915d(String str, String str2, Throwable th) {
        m34912a(3, str, str2 + 10 + Log.getStackTraceString(th));
    }

    /* renamed from: fi */
    public static void m34919fi(String str) {
        if (f46899g) {
            Logger logger = LoggerFactory.getLogger(f46897e);
            TagInfo a = m34910a(4);
            String access$000 = a.tagName;
            m34912a(4, access$000, str + a.jumpInfo);
            logger.info("%s %s %s", a.tagName, str, a.jumpInfo);
        }
    }

    /* renamed from: fw */
    public static void m34920fw(String str) {
        if (f46899g) {
            Logger logger = LoggerFactory.getLogger(f46897e);
            TagInfo a = m34910a(4);
            String access$000 = a.tagName;
            m34912a(5, access$000, str + a.jumpInfo);
            logger.warn("%s %s %s", a.tagName, str, a.jumpInfo);
        }
    }

    /* renamed from: fe */
    public static void m34918fe(String str) {
        if (f46899g) {
            Logger logger = LoggerFactory.getLogger(f46897e);
            TagInfo a = m34910a(4);
            String access$000 = a.tagName;
            m34912a(6, access$000, str + a.jumpInfo);
            logger.error("%s %s %s", a.tagName, str, a.jumpInfo);
        }
    }

    /* renamed from: a */
    private static void m34911a(int i, String str) {
        if (f46898f) {
            TagInfo a = m34910a(5);
            String access$000 = a.tagName;
            m34912a(i, access$000, str + a.jumpInfo);
        }
    }

    /* renamed from: a */
    private static void m34912a(int i, String str, String str2) {
        if (f46898f) {
            SystemUtils.log(i, str, str2, (Throwable) null, "com.didi.travel.psnger.utils.LogUtil", 197);
        }
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
    private static TagInfo m34910a(int i) {
        TagInfo tagInfo = new TagInfo();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length <= i) {
            String unused = tagInfo.tagName = f46897e;
        } else {
            StackTraceElement stackTraceElement = stackTrace[i];
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className)) {
                String unused2 = tagInfo.tagName = className.substring(className.lastIndexOf(".") + 1, className.length()) + "|" + stackTraceElement.getMethodName();
                String unused3 = tagInfo.jumpInfo = " (" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") ";
            }
        }
        return tagInfo;
    }

    public static void printStackTrace() {
        new Throwable("Don't panic, just print the stack trace.").printStackTrace();
    }
}
