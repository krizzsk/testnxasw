package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzgh implements Runnable {
    final /* synthetic */ zzhl zza;
    final /* synthetic */ zzgi zzb;

    zzgh(zzgi zzgi, zzhl zzhl) {
        this.zzb = zzgi;
        this.zza = zzhl;
    }

    public final void run() {
        zzgi.zzA(this.zzb, this.zza);
        this.zzb.zzH(this.zza.zzg);
    }
}
