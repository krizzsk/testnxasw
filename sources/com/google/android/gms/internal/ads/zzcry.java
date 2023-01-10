package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcry implements zzfde {
    private final zzcpw zza;
    private final zzcry zzb = this;
    private final zzgxv zzc;
    private final zzgxv zzd;
    private final zzgxv zze;
    private final zzgxv zzf;
    private final zzgxv zzg;
    private final zzgxv zzh;
    private final zzgxv zzi;
    private final zzgxv zzj;

    /* synthetic */ zzcry(zzcpw zzcpw, Context context, String str, zzcrx zzcrx) {
        this.zza = zzcpw;
        zzgxi zza2 = zzgxj.zza(context);
        this.zzc = zza2;
        zzcpw zzcpw2 = this.zza;
        this.zzd = new zzfbe(zza2, zzcpw2.zzaz, zzcpw2.zzaA);
        this.zze = zzgxh.zzc(new zzfco(zzcpw2.zzaz));
        this.zzf = zzgxh.zzc(zzfec.zza());
        zzgxv zzgxv = this.zzc;
        zzcpw zzcpw3 = this.zza;
        zzgxv zzc2 = zzgxh.zzc(new zzfcy(zzgxv, zzcpw3.zzp, zzcpw3.zzR, this.zzd, this.zze, zzfeh.zza(), this.zzf));
        this.zzg = zzc2;
        this.zzh = zzgxh.zzc(new zzfdi(zzc2, this.zze, this.zzf));
        zzgxi zzc3 = zzgxj.zzc(str);
        this.zzi = zzc3;
        this.zzj = zzgxh.zzc(new zzfdc(zzc3, this.zzg, this.zzc, this.zze, this.zzf, this.zza.zzi));
    }

    public final zzfdb zza() {
        return (zzfdb) this.zzj.zzb();
    }

    public final zzfdh zzb() {
        return (zzfdh) this.zzh.zzb();
    }
}
