package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final /* synthetic */ class zzhn implements Runnable {
    public final /* synthetic */ zzin zza;
    public final /* synthetic */ Bundle zzb;

    public /* synthetic */ zzhn(zzin zzin, Bundle bundle) {
        this.zza = zzin;
        this.zzb = bundle;
    }

    public final void run() {
        this.zza.zzD(this.zzb);
    }
}
