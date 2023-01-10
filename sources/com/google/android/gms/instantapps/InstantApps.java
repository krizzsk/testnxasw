package com.google.android.gms.instantapps;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.appsflyer.internal.referrer.Payload;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.instantapps.zzaf;
import com.google.android.gms.internal.instantapps.zzaj;
import com.google.android.gms.internal.instantapps.zzao;
import com.google.android.gms.internal.instantapps.zzg;
import com.google.android.gms.internal.instantapps.zzy;

public final class InstantApps {
    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> API;
    private static final Api.ClientKey<zzaf> CLIENT_KEY = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzaf, Api.ApiOptions.NoOptions> zzl;
    @Deprecated
    private static final zzc zzm = new zzy();

    public static InstantAppsClient getInstantAppsClient(Activity activity) {
        return new InstantAppsClient(activity);
    }

    public static InstantAppsClient getInstantAppsClient(Context context) {
        return new InstantAppsClient(context);
    }

    public static PackageManagerCompat getPackageManagerCompat(Context context) {
        return zzao.zza(context, true);
    }

    public static ActivityCompat getActivityCompat(Activity activity) {
        return new zzg(activity);
    }

    public static Launcher getLauncher(Context context) {
        return zzaj.zzf(context);
    }

    public static boolean showInstallPrompt(Activity activity, Intent intent, int i, String str) {
        boolean z = false;
        if (!getPackageManagerCompat(activity).isInstantApp()) {
            return false;
        }
        if (intent == null) {
            intent = new Intent();
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("market").authority("details").appendQueryParameter("id", activity.getPackageName());
        if (!TextUtils.isEmpty(str)) {
            appendQueryParameter.appendQueryParameter(Payload.REFERRER, str);
        }
        Intent intent2 = new Intent("com.google.android.finsky.action.IA_INSTALL").setData(appendQueryParameter.build()).setPackage("com.android.vending");
        intent2.putExtra("postInstallIntent", intent);
        if (activity.getPackageManager().resolveActivity(intent2, 0) != null) {
            z = true;
        }
        if (z) {
            activity.startActivityForResult(intent2, i);
            return true;
        }
        Intent putExtra = new Intent("android.intent.action.VIEW").setPackage("com.android.vending").addCategory("android.intent.category.DEFAULT").putExtra("callerId", activity.getPackageName()).putExtra("overlay", true);
        Uri.Builder appendQueryParameter2 = new Uri.Builder().scheme("market").authority("details").appendQueryParameter("id", activity.getPackageName());
        if (!TextUtils.isEmpty(str)) {
            appendQueryParameter2.appendQueryParameter(Payload.REFERRER, str);
        }
        putExtra.setData(appendQueryParameter2.build());
        activity.startActivityForResult(putExtra, i);
        return true;
    }

    private InstantApps() {
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.google.android.gms.internal.instantapps.zzy, com.google.android.gms.instantapps.zzc] */
    static {
        zzd zzd = new zzd();
        zzl = zzd;
        API = new Api<>("InstantApps.API", zzd, CLIENT_KEY);
    }
}
