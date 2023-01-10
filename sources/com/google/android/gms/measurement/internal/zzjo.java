package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzjo implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzkb zzb;

    zzjo(zzkb zzkb, zzp zzp) {
        this.zzb = zzkb;
        this.zza = zzp;
    }

    public final void run() {
        zzkb zzkb = this.zzb;
        zzeo zzh = zzkb.zzb;
        if (zzh == null) {
            zzkb.zzs.zzaz().zzd().zza("Failed to send measurementEnabled to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzh.zzs(this.zza);
            this.zzb.zzQ();
        } catch (RemoteException e) {
            this.zzb.zzs.zzaz().zzd().zzb("Failed to send measurementEnabled to the service", e);
        }
    }
}
