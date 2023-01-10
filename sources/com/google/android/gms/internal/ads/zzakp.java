package com.google.android.gms.internal.ads;

import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzakp {
    public static final String zza = "Volley";
    public static final boolean zzb = Log.isLoggable(zza, 2);
    private static final String zzc = zzakp.class.getName();

    public static void zza(String str, Object... objArr) {
        SystemUtils.log(3, zza, zze(str, objArr), (Throwable) null, "com.google.android.gms.internal.ads.zzakp", 1);
    }

    public static void zzb(String str, Object... objArr) {
        SystemUtils.log(6, zza, zze(str, objArr), (Throwable) null, "com.google.android.gms.internal.ads.zzakp", 1);
    }

    public static void zzc(Throwable th, String str, Object... objArr) {
        SystemUtils.log(6, zza, zze(str, objArr), th, "com.google.android.gms.internal.ads.zzakp", 1);
    }

    public static void zzd(String str, Object... objArr) {
        if (zzb) {
            SystemUtils.log(2, zza, zze(str, objArr), (Throwable) null, "com.google.android.gms.internal.ads.zzakp", 1);
        }
    }

    private static String zze(String str, Object... objArr) {
        String str2;
        String format = String.format(Locale.US, str, objArr);
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i].getClassName().equals(zzc)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, format});
    }
}
