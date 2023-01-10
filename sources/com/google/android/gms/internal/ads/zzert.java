package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzert implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;

    public zzert(zzgxv zzgxv, zzgxv zzgxv2) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
    }

    public final /* synthetic */ Object zzb() {
        return new zzero(((zzerj) this.zza).zzb(), 10000, (Clock) this.zzb.zzb());
    }
}
