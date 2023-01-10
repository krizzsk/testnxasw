package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zziw implements Runnable {
    final /* synthetic */ zziu zza;
    final /* synthetic */ zziu zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzjb zze;

    zziw(zzjb zzjb, zziu zziu, zziu zziu2, long j, boolean z) {
        this.zze = zzjb;
        this.zza = zziu;
        this.zzb = zziu2;
        this.zzc = j;
        this.zzd = z;
    }

    public final void run() {
        this.zze.zzB(this.zza, this.zzb, this.zzc, this.zzd, (Bundle) null);
    }
}
