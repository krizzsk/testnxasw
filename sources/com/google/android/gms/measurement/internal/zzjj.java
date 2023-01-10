package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzjj implements Runnable {
    final /* synthetic */ zziu zza;
    final /* synthetic */ zzkb zzb;

    zzjj(zzkb zzkb, zziu zziu) {
        this.zzb = zzkb;
        this.zza = zziu;
    }

    public final void run() {
        zzkb zzkb = this.zzb;
        zzeo zzh = zzkb.zzb;
        if (zzh == null) {
            zzkb.zzs.zzaz().zzd().zza("Failed to send current screen to service");
            return;
        }
        try {
            zziu zziu = this.zza;
            if (zziu == null) {
                zzh.zzq(0, (String) null, (String) null, zzkb.zzs.zzav().getPackageName());
            } else {
                zzh.zzq(zziu.zzc, zziu.zza, zziu.zzb, zzkb.zzs.zzav().getPackageName());
            }
            this.zzb.zzQ();
        } catch (RemoteException e) {
            this.zzb.zzs.zzaz().zzd().zzb("Failed to send current screen to the service", e);
        }
    }
}
