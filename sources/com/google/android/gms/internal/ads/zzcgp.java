package com.google.android.gms.internal.ads;

import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.google.ads.AdRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public class zzcgp {
    protected static final zzftk zza = zzftk.zzb(4000);

    static String zzd(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4) {
            return str;
        }
        int lineNumber = stackTrace[3].getLineNumber();
        return str + " @" + lineNumber;
    }

    public static void zze(String str) {
        if (!zzm(3)) {
            return;
        }
        if (str.length() <= 4000) {
            SystemUtils.log(3, AdRequest.LOGTAG, str, (Throwable) null, "com.google.android.gms.internal.ads.zzcgp", 2);
            return;
        }
        boolean z = true;
        for (String str2 : zza.zzd(str)) {
            if (z) {
                SystemUtils.log(3, AdRequest.LOGTAG, str2, (Throwable) null, "com.google.android.gms.internal.ads.zzcgp", 4);
            } else {
                SystemUtils.log(3, "Ads-cont", str2, (Throwable) null, "com.google.android.gms.internal.ads.zzcgp", 5);
            }
            z = false;
        }
    }

    public static void zzf(String str, Throwable th) {
        if (zzm(3)) {
            SystemUtils.log(3, AdRequest.LOGTAG, str, th, "com.google.android.gms.internal.ads.zzcgp", 2);
        }
    }

    public static void zzg(String str) {
        if (!zzm(6)) {
            return;
        }
        if (str == null || str.length() <= 4000) {
            SystemUtils.log(6, AdRequest.LOGTAG, str, (Throwable) null, "com.google.android.gms.internal.ads.zzcgp", 2);
            return;
        }
        boolean z = true;
        for (String str2 : zza.zzd(str)) {
            if (z) {
                SystemUtils.log(6, AdRequest.LOGTAG, str2, (Throwable) null, "com.google.android.gms.internal.ads.zzcgp", 4);
            } else {
                SystemUtils.log(6, "Ads-cont", str2, (Throwable) null, "com.google.android.gms.internal.ads.zzcgp", 5);
            }
            z = false;
        }
    }

    public static void zzh(String str, Throwable th) {
        if (zzm(6)) {
            SystemUtils.log(6, AdRequest.LOGTAG, str, th, "com.google.android.gms.internal.ads.zzcgp", 2);
        }
    }

    public static void zzi(String str) {
        if (!zzm(4)) {
            return;
        }
        if (str == null || str.length() <= 4000) {
            SystemUtils.log(4, AdRequest.LOGTAG, str, (Throwable) null, "com.google.android.gms.internal.ads.zzcgp", 2);
            return;
        }
        boolean z = true;
        for (String str2 : zza.zzd(str)) {
            if (z) {
                SystemUtils.log(4, AdRequest.LOGTAG, str2, (Throwable) null, "com.google.android.gms.internal.ads.zzcgp", 4);
            } else {
                SystemUtils.log(4, "Ads-cont", str2, (Throwable) null, "com.google.android.gms.internal.ads.zzcgp", 5);
            }
            z = false;
        }
    }

    public static void zzj(String str) {
        if (!zzm(5)) {
            return;
        }
        if (str == null || str.length() <= 4000) {
            SystemUtils.log(5, AdRequest.LOGTAG, str, (Throwable) null, "com.google.android.gms.internal.ads.zzcgp", 2);
            return;
        }
        boolean z = true;
        for (String str2 : zza.zzd(str)) {
            if (z) {
                SystemUtils.log(5, AdRequest.LOGTAG, str2, (Throwable) null, "com.google.android.gms.internal.ads.zzcgp", 4);
            } else {
                SystemUtils.log(5, "Ads-cont", str2, (Throwable) null, "com.google.android.gms.internal.ads.zzcgp", 5);
            }
            z = false;
        }
    }

    public static void zzk(String str, Throwable th) {
        if (zzm(5)) {
            SystemUtils.log(5, AdRequest.LOGTAG, str, th, "com.google.android.gms.internal.ads.zzcgp", 2);
        }
    }

    public static void zzl(String str, Throwable th) {
        if (!zzm(5)) {
            return;
        }
        if (th != null) {
            zzk(zzd(str), th);
        } else {
            zzj(zzd(str));
        }
    }

    public static boolean zzm(int i) {
        return i >= 5 || Log.isLoggable(AdRequest.LOGTAG, i);
    }
}
