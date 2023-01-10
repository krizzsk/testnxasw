package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
final class zzgk implements Runnable {
    final /* synthetic */ zzab zza;
    final /* synthetic */ zzp zzb;
    final /* synthetic */ zzha zzc;

    zzgk(zzha zzha, zzab zzab, zzp zzp) {
        this.zzc = zzha;
        this.zza = zzab;
        this.zzb = zzp;
    }

    public final void run() {
        this.zzc.zza.zzA();
        if (this.zza.zzc.zza() == null) {
            this.zzc.zza.zzN(this.zza, this.zzb);
        } else {
            this.zzc.zza.zzT(this.zza, this.zzb);
        }
    }
}
