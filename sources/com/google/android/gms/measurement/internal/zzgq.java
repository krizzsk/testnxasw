package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
final class zzgq implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzha zzb;

    zzgq(zzha zzha, zzp zzp) {
        this.zzb = zzha;
        this.zza = zzp;
    }

    public final void run() {
        this.zzb.zza.zzA();
        this.zzb.zza.zzP(this.zza);
    }
}
