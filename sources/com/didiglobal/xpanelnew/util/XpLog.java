package com.didiglobal.xpanelnew.util;

import android.text.TextUtils;
import android.util.Log;
import com.didi.component.framework.pages.invitation.fragment.InvitationTrackFragment;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class XpLog {

    /* renamed from: a */
    private static boolean f54171a = false;

    /* renamed from: b */
    private static boolean f54172b = true;
    public static String sTAG = "NewXpanelLog";

    public static void setWriteFile(boolean z) {
        f54172b = z;
    }

    public static void setOutput(boolean z) {
        f54171a = z;
    }

    public static void setTag(String str) {
        sTAG = str;
    }

    /* renamed from: v */
    public static void m40358v(String str) {
        m40347a(2, str);
    }

    /* renamed from: v */
    public static void m40359v(String str, String str2) {
        m40348a(2, str, str2);
    }

    /* renamed from: d */
    public static void m40349d(String str) {
        m40347a(3, str);
    }

    /* renamed from: d */
    public static void m40350d(String str, String str2) {
        m40348a(3, str, str2);
    }

    /* renamed from: w */
    public static void m40360w(String str) {
        m40347a(5, str);
    }

    /* renamed from: w */
    public static void m40361w(String str, String str2) {
        m40348a(5, str, str2);
    }

    /* renamed from: e */
    public static void m40352e(String str) {
        m40347a(6, str);
    }

    /* renamed from: e */
    public static void m40353e(String str, String str2) {
        m40348a(6, str, str2);
    }

    /* renamed from: e */
    public static void m40354e(String str, String str2, Throwable th) {
        m40348a(6, str, str2 + 10 + Log.getStackTraceString(th));
    }

    /* renamed from: d */
    public static void m40351d(String str, String str2, Throwable th) {
        m40348a(3, str, str2 + 10 + Log.getStackTraceString(th));
    }

    /* renamed from: fi */
    public static void m40356fi(String str) {
        if (f54172b) {
            Logger logger = LoggerFactory.getLogger(sTAG);
            if (f54171a) {
                TagInfo a = m40346a(4);
                logger.info("%s %s %s", a.tagName, str, a.jumpInfo);
                return;
            }
            logger.info(InvitationTrackFragment.INVITE_DATE, str);
        }
    }

    /* renamed from: fw */
    public static void m40357fw(String str) {
        if (f54172b) {
            Logger logger = LoggerFactory.getLogger(sTAG);
            if (f54171a) {
                TagInfo a = m40346a(4);
                logger.warn("%s %s %s", a.tagName, str, a.jumpInfo);
                return;
            }
            logger.warn(InvitationTrackFragment.INVITE_DATE, str);
        }
    }

    /* renamed from: fe */
    public static void m40355fe(String str) {
        if (f54172b) {
            Logger logger = LoggerFactory.getLogger(sTAG);
            if (f54171a) {
                TagInfo a = m40346a(4);
                logger.error("%s %s %s", a.tagName, str, a.jumpInfo);
                return;
            }
            logger.error(InvitationTrackFragment.INVITE_DATE, str);
        }
    }

    public static void printStackTrace() {
        if (f54171a) {
            new Throwable("Don't panic, just print the stack trace.").printStackTrace();
        }
    }

    /* renamed from: a */
    private static void m40347a(int i, String str) {
        if (f54171a) {
            TagInfo a = m40346a(5);
            String access$000 = a.tagName;
            m40348a(i, access$000, str + a.jumpInfo);
        }
    }

    /* renamed from: a */
    private static void m40348a(int i, String str, String str2) {
        if (f54171a) {
            SystemUtils.log(i, str, str2, (Throwable) null, "com.didiglobal.xpanelnew.util.XpLog", 201);
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
    private static TagInfo m40346a(int i) {
        TagInfo tagInfo = new TagInfo();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length <= i) {
            String unused = tagInfo.tagName = sTAG;
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
}
