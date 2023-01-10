package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
final class zzky implements Runnable {
    final /* synthetic */ zzlj zza;
    final /* synthetic */ zzli zzb;

    zzky(zzli zzli, zzlj zzlj) {
        this.zzb = zzli;
        this.zza = zzlj;
    }

    public final void run() {
        zzli.zzy(this.zzb, this.zza);
        this.zzb.zzR();
    }
}
