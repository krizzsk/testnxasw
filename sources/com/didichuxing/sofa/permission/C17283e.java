package com.didichuxing.sofa.permission;

import android.app.Activity;
import android.app.AppOpsManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;

/* renamed from: com.didichuxing.sofa.permission.e */
/* compiled from: PermissionChecker */
final class C17283e {

    /* renamed from: a */
    private static AppOpsManager f51720a;

    /* renamed from: a */
    private static boolean m38881a(int i) {
        return i == 0;
    }

    private C17283e() {
    }

    /* renamed from: a */
    static boolean m38883a(Activity activity, String... strArr) {
        for (String str : strArr) {
            if (C17284f.m38890a(str)) {
                if (!C17284f.m38889a(activity, str)) {
                    return false;
                }
            } else if (!m38882a(activity, str)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m38882a(Activity activity, String str) {
        if (!m38881a(ContextCompat.checkSelfPermission(activity, str))) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (f51720a == null) {
                f51720a = (AppOpsManager) activity.getApplicationContext().getSystemService("appops");
            }
            String permissionToOp = AppOpsManager.permissionToOp(str);
            if (f51720a == null || TextUtils.isEmpty(permissionToOp) || f51720a.checkOp(permissionToOp, Process.myUid(), activity.getPackageName()) == 0) {
                return true;
            }
            return false;
        }
        return true;
    }

    /* renamed from: b */
    static boolean m38886b(Activity activity, String... strArr) {
        for (String str : strArr) {
            if (!C17284f.m38890a(str) && ActivityCompat.shouldShowRequestPermissionRationale(activity, str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    static String[] m38885a(String[] strArr, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArr.length; i++) {
            if (!m38881a(iArr[i])) {
                arrayList.add(strArr[i]);
            }
        }
        String[] strArr2 = new String[arrayList.size()];
        arrayList.toArray(strArr2);
        return strArr2;
    }

    /* renamed from: a */
    static boolean m38884a(int[] iArr) {
        for (int a : iArr) {
            if (!m38881a(a)) {
                return false;
            }
        }
        return true;
    }
}
