package com.google.android.gms.internal.instantapps;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.common.GoogleSignatureVerifier;

final class zzav {
    static boolean zzg(Context context) {
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(context.getPackageManager(), "com.google.android.gms", 64);
            if (GoogleSignatureVerifier.getInstance(context).isGooglePublicSignedPackage(packageInfo)) {
                return true;
            }
            String valueOf = String.valueOf(packageInfo.packageName);
            SystemUtils.log(6, "InstantAppsApi", valueOf.length() != 0 ? "Incorrect signature for package ".concat(valueOf) : new String("Incorrect signature for package "), (Throwable) null, "com.google.android.gms.internal.instantapps.zzav", 9);
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
