package com.google.android.gms.measurement.internal;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final /* synthetic */ class zzke implements Runnable {
    public final /* synthetic */ zzki zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ zzey zzc;
    public final /* synthetic */ Intent zzd;

    public /* synthetic */ zzke(zzki zzki, int i, zzey zzey, Intent intent) {
        this.zza = zzki;
        this.zzb = i;
        this.zzc = zzey;
        this.zzd = intent;
    }

    public final void run() {
        this.zza.zzc(this.zzb, this.zzc, this.zzd);
    }
}
