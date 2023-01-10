package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzjq implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzav zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzkb zze;

    zzjq(zzkb zzkb, boolean z, zzp zzp, boolean z2, zzav zzav, String str) {
        this.zze = zzkb;
        this.zza = zzp;
        this.zzb = z2;
        this.zzc = zzav;
        this.zzd = str;
    }

    public final void run() {
        zzav zzav;
        zzkb zzkb = this.zze;
        zzeo zzh = zzkb.zzb;
        if (zzh == null) {
            zzkb.zzs.zzaz().zzd().zza("Discarding data. Failed to send event to service");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzkb zzkb2 = this.zze;
        if (this.zzb) {
            zzav = null;
        } else {
            zzav = this.zzc;
        }
        zzkb2.zzD(zzh, zzav, this.zza);
        this.zze.zzQ();
    }
}
