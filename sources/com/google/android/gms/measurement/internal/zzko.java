package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzko extends zzao {
    final /* synthetic */ zzkp zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzko(zzkp zzkp, zzhd zzhd) {
        super(zzhd);
        this.zza = zzkp;
    }

    public final void zzc() {
        zzkp zzkp = this.zza;
        zzkp.zzc.zzg();
        zzkp.zzd(false, false, zzkp.zzc.zzs.zzaw().elapsedRealtime());
        zzkp.zzc.zzs.zzd().zzf(zzkp.zzc.zzs.zzaw().elapsedRealtime());
    }
}
