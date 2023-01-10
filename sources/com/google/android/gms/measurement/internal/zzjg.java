package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzjg implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzp zzb;
    final /* synthetic */ zzkb zzc;

    zzjg(zzkb zzkb, AtomicReference atomicReference, zzp zzp) {
        this.zzc = zzkb;
        this.zza = atomicReference;
        this.zzb = zzp;
    }

    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.zza) {
            try {
                if (!this.zzc.zzs.zzm().zzc().zzi(zzag.ANALYTICS_STORAGE)) {
                    this.zzc.zzs.zzaz().zzl().zza("Analytics storage consent denied; will not get app instance id");
                    this.zzc.zzs.zzq().zzP((String) null);
                    this.zzc.zzs.zzm().zze.zzb((String) null);
                    this.zza.set((Object) null);
                    this.zza.notify();
                    return;
                }
                zzkb zzkb = this.zzc;
                zzeo zzh = zzkb.zzb;
                if (zzh == null) {
                    zzkb.zzs.zzaz().zzd().zza("Failed to get app instance id");
                    this.zza.notify();
                    return;
                }
                Preconditions.checkNotNull(this.zzb);
                this.zza.set(zzh.zzd(this.zzb));
                String str = (String) this.zza.get();
                if (str != null) {
                    this.zzc.zzs.zzq().zzP(str);
                    this.zzc.zzs.zzm().zze.zzb(str);
                }
                this.zzc.zzQ();
                atomicReference = this.zza;
                atomicReference.notify();
            } catch (RemoteException e) {
                try {
                    this.zzc.zzs.zzaz().zzd().zzb("Failed to get app instance id", e);
                    atomicReference = this.zza;
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            }
        }
    }
}
