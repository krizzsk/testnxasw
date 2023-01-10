package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final /* synthetic */ class zzkf implements Runnable {
    public final /* synthetic */ zzki zza;
    public final /* synthetic */ zzey zzb;
    public final /* synthetic */ JobParameters zzc;

    public /* synthetic */ zzkf(zzki zzki, zzey zzey, JobParameters jobParameters) {
        this.zza = zzki;
        this.zzb = zzey;
        this.zzc = jobParameters;
    }

    public final void run() {
        this.zza.zzd(this.zzb, this.zzc);
    }
}
