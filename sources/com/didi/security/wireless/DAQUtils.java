package com.didi.security.wireless;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;

public class DAQUtils {

    /* renamed from: a */
    private static ISecurityDispatcher f41281a;

    public static String getCustomDEVICENO() {
        return null;
    }

    public static String getTicket() {
        return null;
    }

    public static String getUserPhone() {
        return null;
    }

    public static void setDispatcher(ISecurityDispatcher iSecurityDispatcher) {
        f41281a = iSecurityDispatcher;
    }

    public static ISecurityDispatcher getDispatcher() {
        return f41281a;
    }

    public static String getUserId() {
        ISecurityDispatcher iSecurityDispatcher = f41281a;
        if (iSecurityDispatcher != null) {
            return iSecurityDispatcher.getUid();
        }
        return null;
    }

    /* renamed from: a */
    static String m30987a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    static String m30988b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 16384).versionName;
        } catch (Exception unused) {
            return null;
        }
    }
}
