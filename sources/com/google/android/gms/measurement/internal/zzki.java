package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcl;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzki {
    private final Context zza;

    public zzki(Context context) {
        Preconditions.checkNotNull(context);
        this.zza = context;
    }

    private final zzey zzk() {
        return zzgi.zzp(this.zza, (zzcl) null, (Long) null).zzaz();
    }

    public final int zza(Intent intent, int i, int i2) {
        zzgi zzp = zzgi.zzp(this.zza, (zzcl) null, (Long) null);
        zzey zzaz = zzp.zzaz();
        if (intent == null) {
            zzaz.zzk().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzp.zzax();
        zzaz.zzj().zzc("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zzh(new zzke(this, i2, zzaz, intent));
        }
        return 2;
    }

    public final IBinder zzb(Intent intent) {
        if (intent == null) {
            zzk().zzd().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzha(zzli.zzt(this.zza), (String) null);
        }
        zzk().zzk().zzb("onBind received unknown action", action);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(int i, zzey zzey, Intent intent) {
        if (((zzkh) this.zza).zzc(i)) {
            zzey.zzj().zzb("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzk().zzj().zza("Completed wakeful intent.");
            ((zzkh) this.zza).zza(intent);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzey zzey, JobParameters jobParameters) {
        zzey.zzj().zza("AppMeasurementJobService processed last upload request.");
        ((zzkh) this.zza).zzb(jobParameters, false);
    }

    public final void zze() {
        zzgi zzp = zzgi.zzp(this.zza, (zzcl) null, (Long) null);
        zzey zzaz = zzp.zzaz();
        zzp.zzax();
        zzaz.zzj().zza("Local AppMeasurementService is starting up");
    }

    public final void zzf() {
        zzgi zzp = zzgi.zzp(this.zza, (zzcl) null, (Long) null);
        zzey zzaz = zzp.zzaz();
        zzp.zzax();
        zzaz.zzj().zza("Local AppMeasurementService is shutting down");
    }

    public final void zzg(Intent intent) {
        if (intent == null) {
            zzk().zzd().zza("onRebind called with null intent");
            return;
        }
        zzk().zzj().zzb("onRebind called. action", intent.getAction());
    }

    public final void zzh(Runnable runnable) {
        zzli zzt = zzli.zzt(this.zza);
        zzt.zzaA().zzp(new zzkg(this, zzt, runnable));
    }

    public final boolean zzi(JobParameters jobParameters) {
        zzgi zzp = zzgi.zzp(this.zza, (zzcl) null, (Long) null);
        zzey zzaz = zzp.zzaz();
        String string = jobParameters.getExtras().getString("action");
        zzp.zzax();
        zzaz.zzj().zzb("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        zzh(new zzkf(this, zzaz, jobParameters));
        return true;
    }

    public final boolean zzj(Intent intent) {
        if (intent == null) {
            zzk().zzd().zza("onUnbind called with null intent");
            return true;
        }
        zzk().zzj().zzb("onUnbind called for intent. action", intent.getAction());
        return true;
    }
}
