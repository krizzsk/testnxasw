package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzoc;
import com.google.android.gms.internal.measurement.zzpp;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzkq {
    final /* synthetic */ zzkr zza;

    zzkq(zzkr zzkr) {
        this.zza = zzkr;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zza.zzg();
        if (this.zza.zzs.zzm().zzk(this.zza.zzs.zzaw().currentTimeMillis())) {
            this.zza.zzs.zzm().zzg.zza(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.zza.zzs.zzaz().zzj().zza("Detected application was in foreground");
                zzc(this.zza.zzs.zzaw().currentTimeMillis(), false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(long j, boolean z) {
        this.zza.zzg();
        this.zza.zzm();
        if (this.zza.zzs.zzm().zzk(j)) {
            this.zza.zzs.zzm().zzg.zza(true);
            zzpp.zzc();
            if (this.zza.zzs.zzf().zzs((String) null, zzel.zzaI)) {
                this.zza.zzs.zzh().zzo();
            }
        }
        this.zza.zzs.zzm().zzj.zzb(j);
        if (this.zza.zzs.zzm().zzg.zzb()) {
            zzc(j, z);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(long j, boolean z) {
        this.zza.zzg();
        if (this.zza.zzs.zzJ()) {
            this.zza.zzs.zzm().zzj.zzb(j);
            this.zza.zzs.zzaz().zzj().zzb("Session started, time", Long.valueOf(this.zza.zzs.zzaw().elapsedRealtime()));
            Long valueOf = Long.valueOf(j / 1000);
            this.zza.zzs.zzq().zzaa(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sid", valueOf, j);
            this.zza.zzs.zzm().zzg.zza(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", valueOf.longValue());
            if (this.zza.zzs.zzf().zzs((String) null, zzel.zzaa) && z) {
                bundle.putLong("_aib", 1);
            }
            this.zza.zzs.zzq().zzI(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_s", j, bundle);
            zzoc.zzc();
            if (this.zza.zzs.zzf().zzs((String) null, zzel.zzad)) {
                String zza2 = this.zza.zzs.zzm().zzo.zza();
                if (!TextUtils.isEmpty(zza2)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("_ffr", zza2);
                    this.zza.zzs.zzq().zzI(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ssr", j, bundle2);
                }
            }
        }
    }
}
