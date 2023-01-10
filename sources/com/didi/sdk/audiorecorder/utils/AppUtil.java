package com.didi.sdk.audiorecorder.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;

public final class AppUtil {

    /* renamed from: a */
    private static volatile String f38321a;

    /* renamed from: b */
    private static volatile String f38322b;

    /* renamed from: c */
    private static volatile PackageInfo f38323c;

    private AppUtil() {
    }

    /* renamed from: a */
    private static String m28895a(Throwable th, boolean z) {
        String str = "";
        if (th == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (!z) {
            str = "Caused by: ";
        }
        sb.append(str);
        sb.append(th.getClass().getName());
        sb.append(": ");
        sb.append(th.getLocalizedMessage());
        sb.append("\n");
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb.append("\tat: ");
                sb.append(stackTraceElement.getClassName());
                sb.append(".");
                sb.append(stackTraceElement.getMethodName());
                sb.append("(");
                sb.append(stackTraceElement.getFileName());
                sb.append(":");
                sb.append(stackTraceElement.getLineNumber());
                sb.append(")\n");
            }
        }
        return sb.toString();
    }

    public static String createCrashMessage(Context context, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(getDeviceInfo(context));
        sb.append("\n");
        sb.append("channel: ");
        sb.append(MarketChannelHelper.getChannelID());
        sb.append("\n");
        sb.append("crashtime: ");
        sb.append(TimeUtil.formatCurrentTime(TimeUtil.YMD_HMSS));
        sb.append("\n");
        sb.append("crashlog:");
        sb.append("\n");
        sb.append(m28895a(th, true));
        if (th != null) {
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                sb.append(m28895a(cause, false));
            }
        }
        return sb.toString();
    }

    public static String getDeviceInfo(Context context) {
        return "device: " + Build.MANUFACTURER + " " + DeviceUtil.getModel() + "(" + Build.VERSION.RELEASE + ")\n" + "imei: " + DeviceUtil.getIMEI(context) + "\n" + "app_ver: " + getVersionName(context);
    }

    public static String getVersionName(Context context) {
        String str;
        if (TextUtils.isEmpty(f38321a)) {
            synchronized (DeviceUtil.class) {
                if (TextUtils.isEmpty(f38321a)) {
                    PackageInfo packageInfo = getPackageInfo(context);
                    if (packageInfo == null) {
                        str = "";
                    } else {
                        str = packageInfo.versionName;
                    }
                    f38321a = str;
                }
            }
        }
        return f38321a;
    }

    public static PackageInfo getPackageInfo(Context context) {
        if (f38323c == null) {
            synchronized (DeviceUtil.class) {
                if (f38323c == null) {
                    try {
                        f38323c = SystemUtils.getPackageInfo(context.getPackageManager(), getPackageName(context), 16384);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return f38323c;
    }

    public static String getPackageName(Context context) {
        if (TextUtils.isEmpty(f38322b)) {
            synchronized (DeviceUtil.class) {
                if (TextUtils.isEmpty(f38322b)) {
                    f38322b = context.getPackageName();
                }
            }
        }
        return f38322b;
    }
}
