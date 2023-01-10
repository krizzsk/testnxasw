package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzafc implements zzafa {
    private final int zza;
    private final int zzb;
    private final zzef zzc;

    public zzafc(zzaew zzaew, zzaf zzaf) {
        zzef zzef = zzaew.zza;
        this.zzc = zzef;
        zzef.zzF(12);
        int zzn = this.zzc.zzn();
        if ("audio/raw".equals(zzaf.zzm)) {
            int zzo = zzen.zzo(zzaf.zzB, zzaf.zzz);
            if (zzn == 0 || zzn % zzo != 0) {
                zzdw.zze("AtomParsers", "Audio sample size mismatch. stsd sample size: " + zzo + ", stsz sample size: " + zzn);
                zzn = zzo;
            }
        }
        this.zza = zzn == 0 ? -1 : zzn;
        this.zzb = this.zzc.zzn();
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        int i = this.zza;
        return i == -1 ? this.zzc.zzn() : i;
    }
}
