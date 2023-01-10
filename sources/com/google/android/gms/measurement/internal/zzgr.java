package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
final class zzgr implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzha zzb;

    zzgr(zzha zzha, zzp zzp) {
        this.zzb = zzha;
        this.zza = zzp;
    }

    public final void run() {
        this.zzb.zza.zzA();
        zzli zzc = this.zzb.zza;
        zzp zzp = this.zza;
        zzc.zzaA().zzg();
        zzc.zzB();
        Preconditions.checkNotEmpty(zzp.zza);
        zzc.zzd(zzp);
    }
}
