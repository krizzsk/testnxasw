package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzkm implements Runnable {
    final long zza;
    final long zzb;
    final /* synthetic */ zzkn zzc;

    zzkm(zzkn zzkn, long j, long j2) {
        this.zzc = zzkn;
        this.zza = j;
        this.zzb = j2;
    }

    public final void run() {
        this.zzc.zza.zzs.zzaA().zzp(new zzkl(this));
    }
}
