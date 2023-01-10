package com.didichuxing.afanty.common.collector;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.didi.dcrypto.DCryptoMainFragment;
import com.didi.sdk.apm.SystemUtils;

public class PackageCollector {

    /* renamed from: a */
    private static Context f48215a;

    /* renamed from: b */
    private static PackageManager f48216b;

    /* renamed from: c */
    private static PackageInfo f48217c;

    public static void init(Context context) {
        f48215a = context;
    }

    public static String getPkgName() {
        try {
            if (f48215a != null) {
                return f48215a.getPackageName();
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getVN() {
        try {
            PackageManager packageManager = f48215a.getPackageManager();
            f48216b = packageManager;
            PackageInfo packageInfo = SystemUtils.getPackageInfo(packageManager, f48215a.getPackageName(), 0);
            f48217c = packageInfo;
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return DCryptoMainFragment.DCRYPTO_NA;
        } catch (Exception unused) {
            return DCryptoMainFragment.DCRYPTO_NA;
        }
    }

    public static int getVC() {
        try {
            PackageManager packageManager = f48215a.getPackageManager();
            f48216b = packageManager;
            PackageInfo packageInfo = SystemUtils.getPackageInfo(packageManager, f48215a.getPackageName(), 0);
            f48217c = packageInfo;
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }
}
