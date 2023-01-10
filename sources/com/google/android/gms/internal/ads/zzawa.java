package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzawa implements zzavy {
    private final int zza = this.zzc.zzi();
    private final int zzb = this.zzc.zzi();
    private final zzbak zzc;

    public zzawa(zzavv zzavv) {
        zzbak zzbak = zzavv.zza;
        this.zzc = zzbak;
        zzbak.zzv(12);
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        int i = this.zza;
        return i == 0 ? this.zzc.zzi() : i;
    }

    public final boolean zzc() {
        return this.zza != 0;
    }
}
