package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@20.1.2 */
final class zzm implements Runnable {
    final /* synthetic */ zzcf zza;
    final /* synthetic */ AppMeasurementDynamiteService zzb;

    zzm(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcf) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzcf;
    }

    public final void run() {
        this.zzb.zza.zzv().zzP(this.zza, this.zzb.zza.zzI());
    }
}
