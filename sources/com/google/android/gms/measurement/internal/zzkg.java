package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
final class zzkg implements Runnable {
    final /* synthetic */ zzli zza;
    final /* synthetic */ Runnable zzb;

    zzkg(zzki zzki, zzli zzli, Runnable runnable) {
        this.zza = zzli;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzA();
        this.zza.zzz(this.zzb);
        this.zza.zzW();
    }
}
