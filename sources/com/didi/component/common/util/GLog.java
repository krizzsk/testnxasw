package com.didi.component.common.util;

import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;

public class GLog {

    /* renamed from: a */
    private static String f13593a = "g_log";

    /* renamed from: b */
    private static boolean f13594b = false;

    public static void setOutput(boolean z) {
        f13594b = z;
    }

    public static void setTag(String str) {
        f13593a = str;
    }

    /* renamed from: v */
    public static void m11361v(String str, String str2) {
        m11352a(2, str, str2);
    }

    /* renamed from: d */
    public static void m11353d(String str) {
        m11351a(3, str);
    }

    /* renamed from: d */
    public static void m11354d(String str, String str2) {
        m11352a(3, str, str2);
    }

    /* renamed from: i */
    public static void m11359i(String str) {
        m11351a(4, str);
    }

    /* renamed from: i */
    public static void m11360i(String str, String str2) {
        m11352a(4, str, str2);
    }

    /* renamed from: w */
    public static void m11362w(String str) {
        m11351a(5, str);
    }

    /* renamed from: w */
    public static void m11363w(String str, String str2) {
        m11352a(5, str, str2);
    }

    /* renamed from: e */
    public static void m11356e(String str) {
        m11351a(6, str);
    }

    /* renamed from: e */
    public static void m11357e(String str, String str2) {
        m11352a(6, str, str2);
    }

    /* renamed from: e */
    public static void m11358e(String str, String str2, Throwable th) {
        m11352a(6, str, str2 + 10 + Log.getStackTraceString(th));
    }

    /* renamed from: d */
    public static void m11355d(String str, String str2, Throwable th) {
        m11352a(3, str, str2 + 10 + Log.getStackTraceString(th));
    }

    public static void printStackTrace() {
        if (f13594b) {
            new Throwable("Don't panic, just print the stack trace.").printStackTrace();
        }
    }

    /* renamed from: a */
    private static void m11351a(int i, String str) {
        if (f13594b) {
            TagInfo a = m11350a(5);
            String access$000 = a.tagName;
            m11352a(i, access$000, str + a.jumpInfo);
        }
    }

    /* renamed from: a */
    private static void m11352a(int i, String str, String str2) {
        if (f13594b) {
            SystemUtils.log(i, str, str2, (Throwable) null, "com.didi.component.common.util.GLog", 141);
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
    private static TagInfo m11350a(int i) {
        TagInfo tagInfo = new TagInfo();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length <= i) {
            String unused = tagInfo.tagName = f13593a;
        } else {
            StackTraceElement stackTraceElement = stackTrace[i];
            String className = stackTraceElement.getClassName();
            if (!TextUtil.isEmpty(className)) {
                String unused2 = tagInfo.tagName = className.substring(className.lastIndexOf(".") + 1, className.length());
                String unused3 = tagInfo.jumpInfo = " (" + stackTraceElement.getFileName() + "-" + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber() + ") ";
            }
        }
        return tagInfo;
    }
}
