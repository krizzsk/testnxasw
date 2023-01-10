package com.didiglobal.enginecore.utils;

import android.util.Log;
import com.didi.component.framework.pages.invitation.fragment.InvitationTrackFragment;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.TextUtil;

public class XEngineLog {

    /* renamed from: a */
    private static String f52719a = "Bff";

    /* renamed from: b */
    private static boolean f52720b = false;

    /* renamed from: c */
    private static boolean f52721c = true;

    public static void setWriteFile(boolean z) {
        f52721c = z;
    }

    public static void setOutput(boolean z) {
        f52720b = z;
    }

    public static void setTag(String str) {
        f52719a = str;
    }

    /* renamed from: v */
    public static void m39596v(String str) {
        m39585a(2, str);
    }

    /* renamed from: v */
    public static void m39597v(String str, String str2) {
        m39586a(2, str, str2);
    }

    /* renamed from: d */
    public static void m39587d(String str) {
        m39585a(3, str);
    }

    /* renamed from: d */
    public static void m39588d(String str, String str2) {
        m39586a(3, str, str2);
    }

    /* renamed from: w */
    public static void m39598w(String str) {
        m39585a(5, str);
    }

    /* renamed from: w */
    public static void m39599w(String str, String str2) {
        m39586a(5, str, str2);
    }

    /* renamed from: e */
    public static void m39590e(String str) {
        m39585a(6, str);
    }

    /* renamed from: e */
    public static void m39591e(String str, String str2) {
        m39586a(6, str, str2);
    }

    /* renamed from: e */
    public static void m39592e(String str, String str2, Throwable th) {
        m39586a(6, str, str2 + 10 + Log.getStackTraceString(th));
    }

    /* renamed from: d */
    public static void m39589d(String str, String str2, Throwable th) {
        m39586a(3, str, str2 + 10 + Log.getStackTraceString(th));
    }

    /* renamed from: fi */
    public static void m39594fi(String str) {
        if (f52721c) {
            Logger logger = LoggerFactory.getLogger(f52719a);
            if (f52720b) {
                TagInfo a = m39584a(4);
                logger.info("%s %s %s", a.tagName, str, a.jumpInfo);
                return;
            }
            logger.info(InvitationTrackFragment.INVITE_DATE, str);
        }
    }

    /* renamed from: fw */
    public static void m39595fw(String str) {
        if (f52721c) {
            Logger logger = LoggerFactory.getLogger(f52719a);
            if (f52720b) {
                TagInfo a = m39584a(4);
                logger.warn("%s %s %s", a.tagName, str, a.jumpInfo);
                return;
            }
            logger.warn(InvitationTrackFragment.INVITE_DATE, str);
        }
    }

    /* renamed from: fe */
    public static void m39593fe(String str) {
        if (f52721c) {
            Logger logger = LoggerFactory.getLogger(f52719a);
            if (f52720b) {
                TagInfo a = m39584a(4);
                logger.error("%s %s %s", a.tagName, str, a.jumpInfo);
                return;
            }
            logger.error(InvitationTrackFragment.INVITE_DATE, str);
        }
    }

    public static void printStackTrace() {
        if (f52720b) {
            new Throwable("Don't panic, just print the stack trace.").printStackTrace();
        }
    }

    /* renamed from: a */
    private static void m39585a(int i, String str) {
        if (f52720b) {
            TagInfo a = m39584a(5);
            String access$000 = a.tagName;
            m39586a(i, access$000, str + a.jumpInfo);
        }
    }

    /* renamed from: a */
    private static void m39586a(int i, String str, String str2) {
        if (f52720b) {
            SystemUtils.log(i, str, str2, (Throwable) null, "com.didiglobal.enginecore.utils.XEngineLog", 196);
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
    private static TagInfo m39584a(int i) {
        TagInfo tagInfo = new TagInfo();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length <= i) {
            String unused = tagInfo.tagName = f52719a;
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
