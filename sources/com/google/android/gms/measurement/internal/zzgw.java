package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
final class zzgw implements Runnable {
    final /* synthetic */ zzll zza;
    final /* synthetic */ zzp zzb;
    final /* synthetic */ zzha zzc;

    zzgw(zzha zzha, zzll zzll, zzp zzp) {
        this.zzc = zzha;
        this.zza = zzll;
        this.zzb = zzp;
    }

    public final void run() {
        this.zzc.zza.zzA();
        if (this.zza.zza() == null) {
            this.zzc.zza.zzO(this.zza, this.zzb);
        } else {
            this.zzc.zza.zzV(this.zza, this.zzb);
        }
    }
}
