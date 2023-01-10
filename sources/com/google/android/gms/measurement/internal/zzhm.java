package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final /* synthetic */ class zzhm implements Runnable {
    public final /* synthetic */ zzin zza;

    public /* synthetic */ zzhm(zzin zzin) {
        this.zza = zzin;
    }

    public final void run() {
        zzin zzin = this.zza;
        zzin.zzg();
        if (!zzin.zzs.zzm().zzm.zzb()) {
            long zza2 = zzin.zzs.zzm().zzn.zza();
            zzin.zzs.zzm().zzn.zzb(1 + zza2);
            zzin.zzs.zzf();
            if (zza2 >= 5) {
                zzin.zzs.zzaz().zzk().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                zzin.zzs.zzm().zzm.zza(true);
                return;
            }
            zzin.zzs.zzE();
            return;
        }
        zzin.zzs.zzaz().zzc().zza("Deferred Deep Link already retrieved. Not fetching again.");
    }
}
