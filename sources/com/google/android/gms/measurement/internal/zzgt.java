package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
final class zzgt implements Runnable {
    final /* synthetic */ zzav zza;
    final /* synthetic */ zzp zzb;
    final /* synthetic */ zzha zzc;

    zzgt(zzha zzha, zzav zzav, zzp zzp) {
        this.zzc = zzha;
        this.zza = zzav;
        this.zzb = zzp;
    }

    public final void run() {
        this.zzc.zzv(this.zzc.zzb(this.zza, this.zzb), this.zzb);
    }
}
