package com.google.android.gms.ads.internal.util;

import com.didi.sdk.apm.SystemUtils;
import com.google.ads.AdRequest;
import com.google.android.gms.internal.ads.zzbkv;
import com.google.android.gms.internal.ads.zzcgp;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zze extends zzcgp {
    public static void zza(String str) {
        if (!zzc()) {
            return;
        }
        if (str == null || str.length() <= 4000) {
            SystemUtils.log(2, AdRequest.LOGTAG, str, (Throwable) null, "com.google.android.gms.ads.internal.util.zze", 2);
            return;
        }
        boolean z = true;
        for (String str2 : zza.zzd(str)) {
            if (z) {
                SystemUtils.log(2, AdRequest.LOGTAG, str2, (Throwable) null, "com.google.android.gms.ads.internal.util.zze", 4);
            } else {
                SystemUtils.log(2, "Ads-cont", str2, (Throwable) null, "com.google.android.gms.ads.internal.util.zze", 5);
            }
            z = false;
        }
    }

    public static void zzb(String str, Throwable th) {
        if (zzc()) {
            SystemUtils.log(2, AdRequest.LOGTAG, str, th, "com.google.android.gms.ads.internal.util.zze", 2);
        }
    }

    public static boolean zzc() {
        return zzm(2) && ((Boolean) zzbkv.zza.zze()).booleanValue();
    }
}
