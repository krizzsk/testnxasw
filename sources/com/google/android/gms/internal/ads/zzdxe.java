package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdxe implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;
    private final zzgxv zzc;

    public zzdxe(zzgxv zzgxv, zzgxv zzgxv2, zzgxv zzgxv3) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
        this.zzc = zzgxv3;
    }

    public final /* synthetic */ Object zzb() {
        zzdxb zzdxb = (zzdxb) this.zza.zzb();
        zzfzq zzfzq = zzchc.zza;
        zzgxq.zzb(zzfzq);
        return ((Boolean) zzay.zzc().zzb(zzbjc.zzhs)).booleanValue() ? new zzdkg((zzeeu) this.zzc.zzb(), zzfzq) : new zzdkg(zzdxb, zzfzq);
    }
}
