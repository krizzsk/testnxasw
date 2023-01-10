package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.measurement.zzby;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzkr extends zzf {
    protected final zzkq zza = new zzkq(this);
    protected final zzkp zzb = new zzkp(this);
    protected final zzkn zzc = new zzkn(this);
    /* access modifiers changed from: private */
    public Handler zzd;

    zzkr(zzgi zzgi) {
        super(zzgi);
    }

    static /* synthetic */ void zzj(zzkr zzkr, long j) {
        zzkr.zzg();
        zzkr.zzm();
        zzkr.zzs.zzaz().zzj().zzb("Activity paused, time", Long.valueOf(j));
        zzkr.zzc.zza(j);
        if (zzkr.zzs.zzf().zzu()) {
            zzkr.zzb.zzb(j);
        }
    }

    static /* synthetic */ void zzl(zzkr zzkr, long j) {
        zzkr.zzg();
        zzkr.zzm();
        zzkr.zzs.zzaz().zzj().zzb("Activity resumed, time", Long.valueOf(j));
        if (zzkr.zzs.zzf().zzu() || zzkr.zzs.zzm().zzl.zzb()) {
            zzkr.zzb.zzc(j);
        }
        zzkr.zzc.zzb();
        zzkq zzkq = zzkr.zza;
        zzkq.zza.zzg();
        if (zzkq.zza.zzs.zzJ()) {
            zzkq.zzb(zzkq.zza.zzs.zzaw().currentTimeMillis(), false);
        }
    }

    /* access modifiers changed from: private */
    public final void zzm() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new zzby(Looper.getMainLooper());
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return false;
    }
}
