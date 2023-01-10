package com.google.android.gms.measurement.internal;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
final class zzkz implements zzfa {
    final /* synthetic */ String zza;
    final /* synthetic */ zzli zzb;

    zzkz(zzli zzli, String str) {
        this.zzb = zzli;
        this.zza = str;
    }

    public final void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        this.zzb.zzJ(i, th, bArr, this.zza);
    }
}
