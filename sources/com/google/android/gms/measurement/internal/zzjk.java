package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzjk implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ Bundle zzb;
    final /* synthetic */ zzkb zzc;

    zzjk(zzkb zzkb, zzp zzp, Bundle bundle) {
        this.zzc = zzkb;
        this.zza = zzp;
        this.zzb = bundle;
    }

    public final void run() {
        zzkb zzkb = this.zzc;
        zzeo zzh = zzkb.zzb;
        if (zzh == null) {
            zzkb.zzs.zzaz().zzd().zza("Failed to send default event parameters to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzh.zzr(this.zzb, this.zza);
        } catch (RemoteException e) {
            this.zzc.zzs.zzaz().zzd().zzb("Failed to send default event parameters to service", e);
        }
    }
}
