package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcrk implements zzdyz {
    /* access modifiers changed from: private */
    public final Context zza;
    private final zzbqr zzb;
    private final zzcpw zzc;
    private final zzcrk zzd = this;
    private final zzgxv zze;
    private final zzgxv zzf;
    private final zzgxv zzg;
    private final zzgxv zzh;

    /* synthetic */ zzcrk(zzcpw zzcpw, Context context, zzbqr zzbqr, zzcrj zzcrj) {
        this.zzc = zzcpw;
        this.zza = context;
        this.zzb = zzbqr;
        this.zze = zzgxj.zza(this);
        zzgxi zza2 = zzgxj.zza(zzbqr);
        this.zzf = zza2;
        zzdyv zzdyv = new zzdyv(zza2);
        this.zzg = zzdyv;
        this.zzh = zzgxh.zzc(new zzdyx(this.zze, zzdyv));
    }

    public final zzdyq zzb() {
        return new zzcre(this.zzc, this.zzd, (zzcrd) null);
    }

    public final zzdyw zzd() {
        return (zzdyw) this.zzh.zzb();
    }
}
