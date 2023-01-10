package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzjx implements Runnable {
    final /* synthetic */ zzeo zza;
    final /* synthetic */ zzka zzb;

    zzjx(zzka zzka, zzeo zzeo) {
        this.zzb = zzka;
        this.zza = zzeo;
    }

    public final void run() {
        synchronized (this.zzb) {
            this.zzb.zzb = false;
            if (!this.zzb.zza.zzL()) {
                this.zzb.zza.zzs.zzaz().zzc().zza("Connected to remote service");
                this.zzb.zza.zzJ(this.zza);
            }
        }
    }
}
