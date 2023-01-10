package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
final class zzgu implements Runnable {
    final /* synthetic */ zzav zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzha zzc;

    zzgu(zzha zzha, zzav zzav, String str) {
        this.zzc = zzha;
        this.zza = zzav;
        this.zzb = str;
    }

    public final void run() {
        this.zzc.zza.zzA();
        this.zzc.zza.zzE(this.zza, this.zzb);
    }
}
