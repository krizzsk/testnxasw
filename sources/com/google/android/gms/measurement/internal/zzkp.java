package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzol;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzkp {
    protected long zza;
    protected long zzb;
    final /* synthetic */ zzkr zzc;
    private final zzao zzd = new zzko(this, this.zzc.zzs);

    public zzkp(zzkr zzkr) {
        this.zzc = zzkr;
        long elapsedRealtime = zzkr.zzs.zzaw().elapsedRealtime();
        this.zza = elapsedRealtime;
        this.zzb = elapsedRealtime;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzd.zzb();
        this.zza = 0;
        this.zzb = 0;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(long j) {
        this.zzd.zzb();
    }

    /* access modifiers changed from: package-private */
    public final void zzc(long j) {
        this.zzc.zzg();
        this.zzd.zzb();
        this.zza = j;
        this.zzb = j;
    }

    public final boolean zzd(boolean z, boolean z2, long j) {
        this.zzc.zzg();
        this.zzc.zza();
        zzol.zzc();
        if (!this.zzc.zzs.zzf().zzs((String) null, zzel.zzae)) {
            this.zzc.zzs.zzm().zzj.zzb(this.zzc.zzs.zzaw().currentTimeMillis());
        } else if (this.zzc.zzs.zzJ()) {
            this.zzc.zzs.zzm().zzj.zzb(this.zzc.zzs.zzaw().currentTimeMillis());
        }
        long j2 = j - this.zza;
        if (z || j2 >= 1000) {
            if (!z2) {
                j2 = j - this.zzb;
                this.zzb = j;
            }
            this.zzc.zzs.zzaz().zzj().zzb("Recording user engagement, ms", Long.valueOf(j2));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j2);
            zzlp.zzK(this.zzc.zzs.zzs().zzj(!this.zzc.zzs.zzf().zzu()), bundle, true);
            if (!z2) {
                this.zzc.zzs.zzq().zzH(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_e", bundle);
            }
            this.zza = j;
            this.zzd.zzb();
            this.zzd.zzd(3600000);
            return true;
        }
        this.zzc.zzs.zzaz().zzj().zzb("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
        return false;
    }
}
