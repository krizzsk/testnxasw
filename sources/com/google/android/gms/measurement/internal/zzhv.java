package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzhv implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzin zzb;

    zzhv(zzin zzin, long j) {
        this.zzb = zzin;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzM(this.zza, true);
        this.zzb.zzs.zzt().zzu(new AtomicReference());
    }
}
