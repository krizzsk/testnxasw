package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzhu implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzin zzc;

    zzhu(zzin zzin, AtomicReference atomicReference, boolean z) {
        this.zzc = zzin;
        this.zza = atomicReference;
        this.zzb = z;
    }

    public final void run() {
        this.zzc.zzs.zzt().zzx(this.zza, this.zzb);
    }
}
