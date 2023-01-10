package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzhr implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzin zzb;

    zzhr(zzin zzin, long j) {
        this.zzb = zzin;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzs.zzm().zzf.zzb(this.zza);
        this.zzb.zzs.zzaz().zzc().zzb("Session timeout duration set", Long.valueOf(this.zza));
    }
}
