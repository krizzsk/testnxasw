package com.didi.sdk.audiorecorder.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.didichuxing.diface.logger.DiFaceLogger;
import java.lang.reflect.Method;

public final class DeviceUtil {

    /* renamed from: a */
    private static volatile String f38335a;

    /* renamed from: b */
    private static volatile String f38336b;

    public static boolean isSdcardMounted() {
        try {
            String externalStorageState = Environment.getExternalStorageState();
            if ("mounted".equalsIgnoreCase(externalStorageState) || "checking".equalsIgnoreCase(externalStorageState) || "mounted_ro".equalsIgnoreCase(externalStorageState)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getModel() {
        if (TextUtils.isEmpty(f38335a)) {
            synchronized (DeviceUtil.class) {
                if (TextUtils.isEmpty(f38335a)) {
                    f38335a = Build.MODEL;
                    if (!TextUtils.isEmpty(f38335a) && f38335a.contains("OPPO")) {
                        try {
                            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class, String.class});
                            declaredMethod.setAccessible(true);
                            if (((String) declaredMethod.invoke((Object) null, new Object[]{"ro.build.version.ota", "unknown"})).contains("A57UDP008")) {
                                f38335a = "OPPO A57D";
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return f38335a;
    }

    public static String getIMEI(Context context) {
        if (TextUtils.isEmpty(f38336b)) {
            synchronized (DeviceUtil.class) {
                if (TextUtils.isEmpty(f38336b)) {
                    try {
                        f38336b = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                    } catch (SecurityException e) {
                        LogUtil.log(Log.getStackTraceString(e));
                    } catch (Throwable th) {
                        LogUtil.log(Log.getStackTraceString(th));
                    }
                    if (TextUtils.isEmpty(f38336b) || "null".equalsIgnoreCase(f38336b)) {
                        f38336b = m28898a();
                    }
                }
            }
        }
        return f38336b;
    }

    /* renamed from: a */
    private static String m28898a() {
        return DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_NO + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
    }

    private DeviceUtil() {
    }
}
