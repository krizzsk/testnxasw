package com.didi.permission.core;

import android.util.Log;
import com.didi.component.framework.pages.invitation.fragment.InvitationTrackFragment;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class LogUtil {

    /* renamed from: a */
    private static final boolean f35793a = false;

    /* renamed from: b */
    private static String f35794b = "Permission_log";

    /* renamed from: c */
    private static boolean f35795c = false;

    /* renamed from: d */
    private static boolean f35796d = true;

    public static void setOutput(boolean z) {
        f35795c = z;
    }

    public static void setWriteFile(boolean z) {
        f35796d = z;
    }

    public static void setTag(String str) {
        f35794b = str;
    }

    /* renamed from: v */
    public static void m26957v(String str) {
        m26945a(2, str);
    }

    /* renamed from: v */
    public static void m26958v(String str, String str2) {
        m26946a(2, str, str2);
    }

    /* renamed from: d */
    public static void m26947d(String str) {
        m26945a(3, str);
    }

    /* renamed from: d */
    public static void m26948d(String str, String str2) {
        m26946a(3, str, str2);
    }

    /* renamed from: i */
    public static void m26955i(String str) {
        m26945a(4, str);
    }

    /* renamed from: i */
    public static void m26956i(String str, String str2) {
        m26946a(4, str, str2);
    }

    /* renamed from: w */
    public static void m26959w(String str) {
        m26945a(5, str);
    }

    /* renamed from: w */
    public static void m26960w(String str, String str2) {
        m26946a(5, str, str2);
    }

    /* renamed from: e */
    public static void m26950e(String str) {
        m26945a(6, str);
    }

    /* renamed from: e */
    public static void m26951e(String str, String str2) {
        m26946a(6, str, str2);
    }

    /* renamed from: d */
    public static void m26949d(String str, String str2, Throwable th) {
        m26946a(3, str, str2 + 10 + Log.getStackTraceString(th));
    }

    /* renamed from: fi */
    public static void m26953fi(String str) {
        if (f35796d) {
            LoggerFactory.getLogger(f35794b).info(InvitationTrackFragment.INVITE_DATE, str);
        }
    }

    /* renamed from: fw */
    public static void m26954fw(String str) {
        if (f35796d) {
            Logger logger = LoggerFactory.getLogger(f35794b);
            m26946a(5, f35794b, str);
            logger.warn(InvitationTrackFragment.INVITE_DATE, str);
        }
    }

    /* renamed from: fe */
    public static void m26952fe(String str) {
        if (f35796d) {
            LoggerFactory.getLogger(f35794b).error(InvitationTrackFragment.INVITE_DATE, str);
        }
    }

    /* renamed from: a */
    private static void m26945a(int i, String str) {
        if (f35795c) {
            m26946a(i, f35794b, str);
        }
    }

    /* renamed from: a */
    private static void m26946a(int i, String str, String str2) {
        if (f35795c) {
            SystemUtils.log(i, str, str2, (Throwable) null, "com.didi.permission.core.LogUtil", 184);
        }
    }

    public static void printStackTrace() {
        if (f35795c) {
            new Throwable("Don't panic, just print the stack trace.").printStackTrace();
        }
    }
}
