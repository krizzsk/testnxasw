package com.google.android.gms.internal.ads;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.util.IllegalFormatException;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfrn {
    private final String zza;

    public zzfrn(String str) {
        int myUid = Process.myUid();
        int myPid = Process.myPid();
        this.zza = ("UID: [" + myUid + "]  PID: [" + myPid + "] ").concat(str);
    }

    private static String zzf(String str, String str2, Object... objArr) {
        if (objArr.length > 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (IllegalFormatException e) {
                SystemUtils.log(6, "PlayCore", "Unable to format ".concat(str2), e, "com.google.android.gms.internal.ads.zzfrn", 2);
                str2 = str2 + " [" + TextUtils.join(", ", objArr) + Const.jaRight;
            }
        }
        return str + " : " + str2;
    }

    public final int zza(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 3)) {
            return SystemUtils.log(3, "PlayCore", zzf(this.zza, "Already connected to the service.", objArr), (Throwable) null, "com.google.android.gms.internal.ads.zzfrn", 2);
        }
        return 0;
    }

    public final int zzb(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            return SystemUtils.log(6, "PlayCore", zzf(this.zza, str, objArr), (Throwable) null, "com.google.android.gms.internal.ads.zzfrn", 2);
        }
        return 0;
    }

    public final int zzc(Throwable th, String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            return SystemUtils.log(6, "PlayCore", zzf(this.zza, str, objArr), th, "com.google.android.gms.internal.ads.zzfrn", 2);
        }
        return 0;
    }

    public final int zzd(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 4)) {
            return SystemUtils.log(4, "PlayCore", zzf(this.zza, str, objArr), (Throwable) null, "com.google.android.gms.internal.ads.zzfrn", 2);
        }
        return 0;
    }

    public final int zze(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 5)) {
            return SystemUtils.log(5, "PlayCore", zzf(this.zza, "Phonesky package is not signed -- possibly self-built package. Could not verify.", objArr), (Throwable) null, "com.google.android.gms.internal.ads.zzfrn", 2);
        }
        return 0;
    }
}
