package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final /* synthetic */ class zzkl implements Runnable {
    public final /* synthetic */ zzkm zza;

    public /* synthetic */ zzkl(zzkm zzkm) {
        this.zza = zzkm;
    }

    public final void run() {
        zzkm zzkm = this.zza;
        zzkn zzkn = zzkm.zzc;
        long j = zzkm.zza;
        long j2 = zzkm.zzb;
        zzkn.zza.zzg();
        zzkn.zza.zzs.zzaz().zzc().zza("Application going to the background");
        zzkn.zza.zzs.zzm().zzl.zza(true);
        Bundle bundle = new Bundle();
        if (!zzkn.zza.zzs.zzf().zzu()) {
            zzkn.zza.zzb.zzb(j2);
            zzkn.zza.zzb.zzd(false, false, j2);
        }
        zzkn.zza.zzs.zzq().zzI(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ab", j, bundle);
    }
}
