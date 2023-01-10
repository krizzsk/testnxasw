package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final /* synthetic */ class zzgj implements Runnable {
    public final /* synthetic */ zzha zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Bundle zzc;

    public /* synthetic */ zzgj(zzha zzha, String str, Bundle bundle) {
        this.zza = zzha;
        this.zzb = str;
        this.zzc = bundle;
    }

    public final void run() {
        this.zza.zzw(this.zzb, this.zzc);
    }
}
