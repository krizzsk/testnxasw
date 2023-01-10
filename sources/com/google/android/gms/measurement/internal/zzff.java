package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
final class zzff implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzfg zzb;

    zzff(zzfg zzfg, boolean z) {
        this.zzb = zzfg;
        this.zza = z;
    }

    public final void run() {
        this.zzb.zzb.zzI(this.zza);
    }
}
