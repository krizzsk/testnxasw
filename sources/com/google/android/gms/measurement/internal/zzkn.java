package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzkn {
    final /* synthetic */ zzkr zza;
    private zzkm zzb;

    zzkn(zzkr zzkr) {
        this.zza = zzkr;
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j) {
        this.zzb = new zzkm(this, this.zza.zzs.zzaw().currentTimeMillis(), j);
        this.zza.zzd.postDelayed(this.zzb, 2000);
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        this.zza.zzg();
        zzkm zzkm = this.zzb;
        if (zzkm != null) {
            this.zza.zzd.removeCallbacks(zzkm);
        }
        this.zza.zzs.zzm().zzl.zza(false);
    }
}
