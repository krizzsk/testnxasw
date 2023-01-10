package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzjw implements Runnable {
    final /* synthetic */ ComponentName zza;
    final /* synthetic */ zzka zzb;

    zzjw(zzka zzka, ComponentName componentName) {
        this.zzb = zzka;
        this.zza = componentName;
    }

    public final void run() {
        zzkb.zzo(this.zzb.zza, this.zza);
    }
}
