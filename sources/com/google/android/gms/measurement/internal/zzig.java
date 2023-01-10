package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzig implements Runnable {
    final /* synthetic */ Boolean zza;
    final /* synthetic */ zzin zzb;

    zzig(zzin zzin, Boolean bool) {
        this.zzb = zzin;
        this.zza = bool;
    }

    public final void run() {
        this.zzb.zzad(this.zza, true);
    }
}
