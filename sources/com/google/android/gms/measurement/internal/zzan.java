package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzan implements Runnable {
    final /* synthetic */ zzhd zza;
    final /* synthetic */ zzao zzb;

    zzan(zzao zzao, zzhd zzhd) {
        this.zzb = zzao;
        this.zza = zzhd;
    }

    public final void run() {
        this.zza.zzax();
        if (zzaa.zza()) {
            this.zza.zzaA().zzp(this);
            return;
        }
        boolean zze = this.zzb.zze();
        this.zzb.zzd = 0;
        if (zze) {
            this.zzb.zzc();
        }
    }
}
