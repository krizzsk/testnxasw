package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzawb implements zzavy {
    private final zzbak zza;
    private final int zzb = this.zza.zzi();
    private final int zzc = (this.zza.zzi() & 255);
    private int zzd;
    private int zze;

    public zzawb(zzavv zzavv) {
        zzbak zzbak = zzavv.zza;
        this.zza = zzbak;
        zzbak.zzv(12);
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        int i = this.zzc;
        if (i == 8) {
            return this.zza.zzg();
        }
        if (i == 16) {
            return this.zza.zzj();
        }
        int i2 = this.zzd;
        this.zzd = i2 + 1;
        if (i2 % 2 != 0) {
            return this.zze & 15;
        }
        int zzg = this.zza.zzg();
        this.zze = zzg;
        return (zzg & 240) >> 4;
    }

    public final boolean zzc() {
        return false;
    }
}
