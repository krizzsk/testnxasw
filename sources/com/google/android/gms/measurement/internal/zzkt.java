package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
final class zzkt extends zzao {
    final /* synthetic */ zzku zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzkt(zzku zzku, zzhd zzhd) {
        super(zzhd);
        this.zza = zzku;
    }

    public final void zzc() {
        this.zza.zza();
        this.zza.zzs.zzaz().zzj().zza("Starting upload from DelayedRunnable");
        this.zza.zzf.zzW();
    }
}
