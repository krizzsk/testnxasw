package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
final class zzgl implements Runnable {
    final /* synthetic */ zzab zza;
    final /* synthetic */ zzha zzb;

    zzgl(zzha zzha, zzab zzab) {
        this.zzb = zzha;
        this.zza = zzab;
    }

    public final void run() {
        this.zzb.zza.zzA();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zzM(this.zza);
        } else {
            this.zzb.zza.zzS(this.zza);
        }
    }
}
