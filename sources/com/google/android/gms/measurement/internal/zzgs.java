package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
final class zzgs implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzha zzb;

    zzgs(zzha zzha, zzp zzp) {
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
        zzah zzb2 = zzah.zzb(zzp.zzv);
        zzah zzh = zzc.zzh(zzp.zza);
        zzc.zzaz().zzj().zzc("Setting consent, package, consent", zzp.zza, zzb2);
        zzc.zzU(zzp.zza, zzb2);
        if (zzb2.zzk(zzh)) {
            zzc.zzP(zzp);
        }
    }
}
