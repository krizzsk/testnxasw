package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzkj implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzkr zzb;

    zzkj(zzkr zzkr, long j) {
        this.zzb = zzkr;
        this.zza = j;
    }

    public final void run() {
        zzkr.zzl(this.zzb, this.zza);
    }
}
