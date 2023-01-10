package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzgc implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ zzgf zza;
    private final String zzb;

    public zzgc(zzgf zzgf, String str) {
        this.zza = zzgf;
        Preconditions.checkNotNull(str);
        this.zzb = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.zza.zzs.zzaz().zzd().zzb(this.zzb, th);
    }
}
