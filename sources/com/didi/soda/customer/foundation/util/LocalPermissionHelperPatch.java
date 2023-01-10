package com.didi.soda.customer.foundation.util;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;

public final class LocalPermissionHelperPatch {

    /* renamed from: a */
    private static AppOpsManager f43841a;

    /* renamed from: a */
    private static boolean m32699a(int i) {
        return i == 0;
    }

    public static boolean checkoutPermission(Context context, String[] strArr) {
        return m32701a(context, strArr);
    }

    /* renamed from: a */
    static boolean m32701a(Context context, String... strArr) {
        for (String str : strArr) {
            if (SpecialPermissionCompat.isSpecialPermission(str)) {
                if (!SpecialPermissionCompat.permissionGranted(context, str)) {
                    return false;
                }
            } else if (!m32700a(context, str)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m32700a(Context context, String str) {
        if (!m32699a(ContextCompat.checkSelfPermission(context, str))) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (f43841a == null) {
                f43841a = (AppOpsManager) context.getApplicationContext().getSystemService("appops");
            }
            String permissionToOp = AppOpsManager.permissionToOp(str);
            if (f43841a == null || TextUtils.isEmpty(permissionToOp) || f43841a.checkOp(permissionToOp, Process.myUid(), context.getPackageName()) == 0) {
                return true;
            }
            return false;
        }
        return true;
    }

    static class SpecialPermissionCompat {
        private static final String TAG = "SpecialPermissionCompat";

        private SpecialPermissionCompat() {
        }

        static boolean isSpecialPermission(String str) {
            return str.equals("android.permission.SYSTEM_ALERT_WINDOW") || str.equals("android.permission.WRITE_SETTINGS");
        }

        static boolean permissionGranted(Context context, String str) {
            if (Build.VERSION.SDK_INT < 23) {
                return true;
            }
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -2078357533) {
                if (hashCode == -1561629405 && str.equals("android.permission.SYSTEM_ALERT_WINDOW")) {
                    c = 0;
                }
            } else if (str.equals("android.permission.WRITE_SETTINGS")) {
                c = 1;
            }
            if (c == 0) {
                return Settings.canDrawOverlays(context);
            }
            if (c != 1) {
                return true;
            }
            return Settings.System.canWrite(context);
        }
    }
}
