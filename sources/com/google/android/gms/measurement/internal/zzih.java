package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpp;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzih implements Runnable {
    final /* synthetic */ zzah zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ zzah zzf;
    final /* synthetic */ zzin zzg;

    zzih(zzin zzin, zzah zzah, long j, int i, long j2, boolean z, zzah zzah2) {
        this.zzg = zzin;
        this.zza = zzah;
        this.zzb = j;
        this.zzc = i;
        this.zzd = j2;
        this.zze = z;
        this.zzf = zzah2;
    }

    public final void run() {
        this.zzg.zzX(this.zza);
        this.zzg.zzM(this.zzb, false);
        zzin.zzw(this.zzg, this.zza, this.zzc, this.zzd, true, this.zze);
        zzpp.zzc();
        if (this.zzg.zzs.zzf().zzs((String) null, zzel.zzaI)) {
            zzin.zzv(this.zzg, this.zza, this.zzf);
        }
    }
}
