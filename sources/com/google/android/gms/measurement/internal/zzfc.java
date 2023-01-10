package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
final class zzfc implements Runnable {
    private final zzfa zza;
    private final int zzb;
    private final Throwable zzc;
    private final byte[] zzd;
    private final String zze;
    private final Map zzf;

    /* synthetic */ zzfc(String str, zzfa zzfa, int i, Throwable th, byte[] bArr, Map map, zzfb zzfb) {
        Preconditions.checkNotNull(zzfa);
        this.zza = zzfa;
        this.zzb = i;
        this.zzc = th;
        this.zzd = bArr;
        this.zze = str;
        this.zzf = map;
    }

    public final void run() {
        this.zza.zza(this.zze, this.zzb, this.zzc, this.zzd, this.zzf);
    }
}
