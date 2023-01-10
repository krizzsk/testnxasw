package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzez {
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final Bundle zzd;

    public zzez(String str, String str2, Bundle bundle, long j) {
        this.zza = str;
        this.zzb = str2;
        this.zzd = bundle;
        this.zzc = j;
    }

    public static zzez zzb(zzav zzav) {
        return new zzez(zzav.zza, zzav.zzc, zzav.zzb.zzc(), zzav.zzd);
    }

    public final String toString() {
        String str = this.zzb;
        String str2 = this.zza;
        String obj = this.zzd.toString();
        return "origin=" + str + ",name=" + str2 + ",params=" + obj;
    }

    public final zzav zza() {
        return new zzav(this.zza, new zzat(new Bundle(this.zzd)), this.zzb, this.zzc);
    }
}
