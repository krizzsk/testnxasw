package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzjl extends zzao {
    final /* synthetic */ zzkb zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzjl(zzkb zzkb, zzhd zzhd) {
        super(zzhd);
        this.zza = zzkb;
    }

    public final void zzc() {
        zzkb zzkb = this.zza;
        zzkb.zzg();
        if (zzkb.zzL()) {
            zzkb.zzs.zzaz().zzj().zza("Inactivity, disconnecting from the service");
            zzkb.zzs();
        }
    }
}
