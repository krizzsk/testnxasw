package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzjd implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzll zzc;
    final /* synthetic */ zzkb zzd;

    zzjd(zzkb zzkb, zzp zzp, boolean z, zzll zzll) {
        this.zzd = zzkb;
        this.zza = zzp;
        this.zzb = z;
        this.zzc = zzll;
    }

    public final void run() {
        zzll zzll;
        zzkb zzkb = this.zzd;
        zzeo zzh = zzkb.zzb;
        if (zzh == null) {
            zzkb.zzs.zzaz().zzd().zza("Discarding data. Failed to set user property");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzkb zzkb2 = this.zzd;
        if (this.zzb) {
            zzll = null;
        } else {
            zzll = this.zzc;
        }
        zzkb2.zzD(zzh, zzll, this.zza);
        this.zzd.zzQ();
    }
}
