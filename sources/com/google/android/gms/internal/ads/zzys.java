package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzys {
    public static final zzys zza = new zzys(-3, -9223372036854775807L, -1);
    /* access modifiers changed from: private */
    public final int zzb;
    /* access modifiers changed from: private */
    public final long zzc;
    /* access modifiers changed from: private */
    public final long zzd;

    private zzys(int i, long j, long j2) {
        this.zzb = i;
        this.zzc = j;
        this.zzd = j2;
    }

    public static zzys zzd(long j, long j2) {
        return new zzys(-1, j, j2);
    }

    public static zzys zze(long j) {
        return new zzys(0, -9223372036854775807L, j);
    }

    public static zzys zzf(long j, long j2) {
        return new zzys(-2, j, j2);
    }
}
