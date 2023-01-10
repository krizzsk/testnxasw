package com.didi.sdk.p155ms.gms.push;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import java.util.List;

/* renamed from: com.didi.sdk.ms.gms.push.FcmUtil */
public class FcmUtil {
    public static void saveFcmToken(Context context, String str) {
        if (!TextUtils.equals(getFcmToken(context), str)) {
            saveSyncStatus(context, false);
        }
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(context, "fcm_sp", 0).edit();
        edit.putString("token", str);
        edit.commit();
    }

    public static String getFcmToken(Context context) {
        return SystemUtils.getSharedPreferences(context, "fcm_sp", 0).getString("token", "");
    }

    public static void saveSyncStatus(Context context, boolean z) {
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(context, "fcm_sp", 0).edit();
        edit.putBoolean("sync_status", z);
        edit.commit();
    }

    public static boolean getSyncStatus(Context context) {
        return SystemUtils.getSharedPreferences(context, "fcm_sp", 0).getBoolean("sync_status", false);
    }

    public static boolean isAppInForeground(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            if (!((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode() && (runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) != null) {
                if (!runningAppProcesses.isEmpty()) {
                    String packageName = context.getPackageName();
                    for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                        if (next.importance == 100 && next.importanceReasonCode == 0) {
                            return next.pkgList[0].equals(packageName);
                        }
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
