package com.didichuxing.sofa.permission;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.didi.sdk.apm.SystemUtils;

public final class PermissionHelper {

    /* renamed from: a */
    private static final String f51711a = "PermissionHelper";

    static {
        try {
            PermHelperDynamicRegistry.initialize();
            SystemUtils.log(3, f51711a, "Load PermissionDynamicRegistry success~", (Throwable) null, "com.didichuxing.sofa.permission.PermissionHelper", 27);
        } catch (Throwable th) {
            SystemUtils.log(3, f51711a, "Load PermissionDynamicRegistry failed: " + th, (Throwable) null, "com.didichuxing.sofa.permission.PermissionHelper", 29);
        }
    }

    private PermissionHelper() {
    }

    /* renamed from: a */
    private static C17281c m38864a(Object obj) throws Exception {
        String canonicalName = obj.getClass().getCanonicalName();
        C17281c a = C17282d.m38879a(canonicalName);
        if (a == null) {
            SystemUtils.log(3, f51711a, "initPermissionHelperImpl: Get PermissionHelper failed by class name for " + canonicalName + " and try the default one.", (Throwable) null, "com.didichuxing.sofa.permission.PermissionHelper", 41);
            if (obj instanceof PermissionResultCallback) {
                a = C17282d.m38878a();
            }
        }
        if (a != null) {
            return a;
        }
        throw new Exception("Can't find PermissionHelper for " + canonicalName);
    }

    public static void requestPermission(Activity activity, String... strArr) {
        requestPermission(activity, (Object) activity, strArr);
    }

    public static void requestPermission(Fragment fragment, String... strArr) {
        requestPermission(fragment, (Object) fragment, strArr);
    }

    public static void onRequestPermissionsResult(Activity activity, int i, String[] strArr, int[] iArr) {
        onRequestPermissionsResult(activity, (Object) activity, i, strArr, iArr);
    }

    public static void onRequestPermissionsResult(Fragment fragment, int i, String[] strArr, int[] iArr) {
        onRequestPermissionsResult(fragment, (Object) fragment, i, strArr, iArr);
    }

    public static void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        onActivityResult(activity, (Object) activity, i, i2, intent);
    }

    public static void onActivityResult(Fragment fragment, int i, int i2, Intent intent) {
        onActivityResult(fragment, (Object) fragment, i, i2, intent);
    }

    public static void requestPermission(Activity activity, Object obj, String... strArr) {
        try {
            m38864a(obj).requestPermission(activity, obj, strArr);
        } catch (Exception e) {
            SystemUtils.log(6, f51711a, "requestPermission() get PermissionHelper failed for " + obj + ": " + e, (Throwable) null, "com.didichuxing.sofa.permission.PermissionHelper", 115);
        }
    }

    public static void requestPermission(Fragment fragment, Object obj, String... strArr) {
        try {
            m38864a(obj).requestPermission(fragment, obj, strArr);
        } catch (Exception e) {
            SystemUtils.log(6, f51711a, "requestPermission() get PermissionHelper failed for " + obj + ": " + e, (Throwable) null, "com.didichuxing.sofa.permission.PermissionHelper", 126);
        }
    }

    public static void onRequestPermissionsResult(Activity activity, Object obj, int i, String[] strArr, int[] iArr) {
        try {
            m38864a(obj).onRequestPermissionsResult(activity, obj, i, strArr, iArr);
        } catch (Exception e) {
            SystemUtils.log(6, f51711a, "onRequestPermissionsResult() get PermissionHelper failed for " + obj + ": " + e, (Throwable) null, "com.didichuxing.sofa.permission.PermissionHelper", 149);
        }
    }

    public static void onRequestPermissionsResult(Fragment fragment, Object obj, int i, String[] strArr, int[] iArr) {
        try {
            m38864a(obj).onRequestPermissionsResult(fragment, obj, i, strArr, iArr);
        } catch (Exception e) {
            SystemUtils.log(6, f51711a, "onRequestPermissionsResult() get PermissionHelper failed for " + obj + ": " + e, (Throwable) null, "com.didichuxing.sofa.permission.PermissionHelper", 163);
        }
    }

    public static void onActivityResult(Activity activity, Object obj, int i, int i2, Intent intent) {
        try {
            m38864a(obj).onActivityResult(activity, obj, i, i2, intent);
        } catch (Exception e) {
            SystemUtils.log(6, f51711a, "onActivityResult() get PermissionHelper failed for " + obj + ": " + e, (Throwable) null, "com.didichuxing.sofa.permission.PermissionHelper", 185);
        }
    }

    public static void onActivityResult(Fragment fragment, Object obj, int i, int i2, Intent intent) {
        try {
            m38864a(obj).onActivityResult(fragment, obj, i, i2, intent);
        } catch (Exception e) {
            SystemUtils.log(6, f51711a, "onActivityResult() get PermissionHelper failed for " + obj + ": " + e, (Throwable) null, "com.didichuxing.sofa.permission.PermissionHelper", 197);
        }
    }

    public static int generateRequestCode(String... strArr) {
        return RequestCodeManager.get(strArr);
    }

    public static boolean isPermissionsGranted(Activity activity, String... strArr) {
        return C17283e.m38883a(activity, strArr);
    }
}
