package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zziv implements Runnable {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zziu zzb;
    final /* synthetic */ zziu zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzjb zze;

    zziv(zzjb zzjb, Bundle bundle, zziu zziu, zziu zziu2, long j) {
        this.zze = zzjb;
        this.zza = bundle;
        this.zzb = zziu;
        this.zzc = zziu2;
        this.zzd = j;
    }

    public final void run() {
        zzjb.zzp(this.zze, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
