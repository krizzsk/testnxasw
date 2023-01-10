package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfp extends zzjy implements zzlk {
    private zzfp() {
        super(zzfq.zza);
    }

    public final zzfp zza(long j) {
        if (this.zzb) {
            zzaI();
            this.zzb = false;
        }
        zzfq.zzf((zzfq) this.zza, j);
        return this;
    }

    public final zzfp zzb(int i) {
        if (this.zzb) {
            zzaI();
            this.zzb = false;
        }
        zzfq.zze((zzfq) this.zza, i);
        return this;
    }

    /* synthetic */ zzfp(zzfj zzfj) {
        super(zzfq.zza);
    }
}
