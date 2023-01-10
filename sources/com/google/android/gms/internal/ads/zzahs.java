package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzahs implements zzaib {
    private zzaf zza;
    private zzel zzb;
    private zzaap zzc;

    public zzahs(String str) {
        zzad zzad = new zzad();
        zzad.zzS(str);
        this.zza = zzad.zzY();
    }

    public final void zza(zzef zzef) {
        zzdd.zzb(this.zzb);
        int i = zzen.zza;
        long zzd = this.zzb.zzd();
        long zze = this.zzb.zze();
        if (zzd != -9223372036854775807L && zze != -9223372036854775807L) {
            zzaf zzaf = this.zza;
            if (zze != zzaf.zzq) {
                zzad zzb2 = zzaf.zzb();
                zzb2.zzW(zze);
                zzaf zzY = zzb2.zzY();
                this.zza = zzY;
                this.zzc.zzk(zzY);
            }
            int zza2 = zzef.zza();
            this.zzc.zzq(zzef, zza2);
            this.zzc.zzs(zzd, 1, zza2, 0, (zzaao) null);
        }
    }

    public final void zzb(zzel zzel, zzzl zzzl, zzaio zzaio) {
        this.zzb = zzel;
        zzaio.zzc();
        zzaap zzv = zzzl.zzv(zzaio.zza(), 5);
        this.zzc = zzv;
        zzv.zzk(this.zza);
    }
}
