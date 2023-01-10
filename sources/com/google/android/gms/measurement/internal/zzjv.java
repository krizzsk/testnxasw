package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzjv implements Runnable {
    final /* synthetic */ zzeo zza;
    final /* synthetic */ zzka zzb;

    zzjv(zzka zzka, zzeo zzeo) {
        this.zzb = zzka;
        this.zza = zzeo;
    }

    public final void run() {
        synchronized (this.zzb) {
            this.zzb.zzb = false;
            if (!this.zzb.zza.zzL()) {
                this.zzb.zza.zzs.zzaz().zzj().zza("Connected to service");
                this.zzb.zza.zzJ(this.zza);
            }
        }
    }
}
