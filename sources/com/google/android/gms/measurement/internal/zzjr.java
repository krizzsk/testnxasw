package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzjr implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzab zzc;
    final /* synthetic */ zzab zzd;
    final /* synthetic */ zzkb zze;

    zzjr(zzkb zzkb, boolean z, zzp zzp, boolean z2, zzab zzab, zzab zzab2) {
        this.zze = zzkb;
        this.zza = zzp;
        this.zzb = z2;
        this.zzc = zzab;
        this.zzd = zzab2;
    }

    public final void run() {
        zzab zzab;
        zzkb zzkb = this.zze;
        zzeo zzh = zzkb.zzb;
        if (zzh == null) {
            zzkb.zzs.zzaz().zzd().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzkb zzkb2 = this.zze;
        if (this.zzb) {
            zzab = null;
        } else {
            zzab = this.zzc;
        }
        zzkb2.zzD(zzh, zzab, this.zza);
        this.zze.zzQ();
    }
}
