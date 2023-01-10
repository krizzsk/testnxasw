package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zziz implements Runnable {
    final /* synthetic */ zziu zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzjb zzc;

    zziz(zzjb zzjb, zziu zziu, long j) {
        this.zzc = zzjb;
        this.zza = zziu;
        this.zzb = j;
    }

    public final void run() {
        this.zzc.zzC(this.zza, false, this.zzb);
        zzjb zzjb = this.zzc;
        zzjb.zza = null;
        zzjb.zzs.zzt().zzG((zziu) null);
    }
}
