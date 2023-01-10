package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpp;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzii implements Runnable {
    final /* synthetic */ zzah zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzah zze;
    final /* synthetic */ zzin zzf;

    zzii(zzin zzin, zzah zzah, int i, long j, boolean z, zzah zzah2) {
        this.zzf = zzin;
        this.zza = zzah;
        this.zzb = i;
        this.zzc = j;
        this.zzd = z;
        this.zze = zzah2;
    }

    public final void run() {
        this.zzf.zzX(this.zza);
        zzin.zzw(this.zzf, this.zza, this.zzb, this.zzc, false, this.zzd);
        zzpp.zzc();
        if (this.zzf.zzs.zzf().zzs((String) null, zzel.zzaI)) {
            zzin.zzv(this.zzf, this.zza, this.zze);
        }
    }
}
