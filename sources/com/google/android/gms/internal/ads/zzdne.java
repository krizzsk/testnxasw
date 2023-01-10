package com.google.android.gms.internal.ads;

import com.didi.soda.customer.app.constant.Const;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdne implements zzgxi {
    private final zzgxv zza;

    public zzdne(zzgxv zzgxv) {
        this.zza = zzgxv;
    }

    public final /* synthetic */ Object zzb() {
        Set set;
        if (((zzdnb) this.zza).zza().zze() != null) {
            set = Collections.singleton(Const.ComponentType.BANNER);
        } else {
            set = Collections.emptySet();
        }
        zzgxq.zzb(set);
        return set;
    }
}
