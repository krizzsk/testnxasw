package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbf;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeos {
    private final zzdpb zza;
    private final zzeof zzb;
    private final zzddd zzc;

    public zzeos(zzdpb zzdpb, zzfir zzfir) {
        this.zza = zzdpb;
        zzeof zzeof = new zzeof(zzfir);
        this.zzb = zzeof;
        this.zzc = new zzeor(zzeof, this.zza.zzg());
    }

    public final zzddd zza() {
        return this.zzc;
    }

    public final zzdeo zzb() {
        return this.zzb;
    }

    public final zzdmy zzc() {
        return new zzdmy(this.zza, this.zzb.zzc());
    }

    public final zzeof zzd() {
        return this.zzb;
    }

    public final void zze(zzbf zzbf) {
        this.zzb.zze(zzbf);
    }
}
