package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
final class zzgx implements Callable {
    final /* synthetic */ String zza;
    final /* synthetic */ zzha zzb;

    zzgx(zzha zzha, String str) {
        this.zzb = zzha;
        this.zza = str;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzb.zza.zzA();
        return this.zzb.zza.zzi().zzu(this.zza);
    }
}
