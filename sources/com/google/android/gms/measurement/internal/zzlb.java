package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
final class zzlb implements Callable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzli zzb;

    zzlb(zzli zzli, zzp zzp) {
        this.zzb = zzli;
        this.zza = zzp;
    }

    public final /* synthetic */ Object call() throws Exception {
        if (this.zzb.zzh((String) Preconditions.checkNotNull(this.zza.zza)).zzi(zzag.ANALYTICS_STORAGE) && zzah.zzb(this.zza.zzv).zzi(zzag.ANALYTICS_STORAGE)) {
            return this.zzb.zzd(this.zza).zzu();
        }
        this.zzb.zzaz().zzj().zza("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
