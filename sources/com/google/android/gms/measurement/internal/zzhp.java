package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final /* synthetic */ class zzhp implements Runnable {
    public final /* synthetic */ zzin zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzhp(zzin zzin, String str) {
        this.zza = zzin;
        this.zzb = str;
    }

    public final void run() {
        zzin zzin = this.zza;
        if (zzin.zzs.zzh().zzp(this.zzb)) {
            zzin.zzs.zzh().zzo();
        }
    }
}
