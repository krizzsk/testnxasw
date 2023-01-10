package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpm;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
final class zzgz implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzha zze;

    zzgz(zzha zzha, String str, String str2, String str3, long j) {
        this.zze = zzha;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j;
    }

    public final void run() {
        zzpm.zzc();
        if (this.zze.zza.zzg().zzs((String) null, zzel.zzat)) {
            String str = this.zza;
            if (str == null) {
                this.zze.zza.zzQ(this.zzb, (zziu) null);
                return;
            }
            this.zze.zza.zzQ(this.zzb, new zziu(this.zzc, str, this.zzd));
            return;
        }
        String str2 = this.zza;
        if (str2 == null) {
            this.zze.zza.zzq().zzs().zzy(this.zzb, (zziu) null);
            return;
        }
        this.zze.zza.zzq().zzs().zzy(this.zzb, new zziu(this.zzc, str2, this.zzd));
    }
}
