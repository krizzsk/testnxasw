package com.google.android.gms.measurement.internal;

import com.didi.sdk.apm.SystemUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzev implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ Object zzd;
    final /* synthetic */ Object zze;
    final /* synthetic */ zzey zzf;

    zzev(zzey zzey, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzey;
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    public final void run() {
        zzfn zzm = this.zzf.zzs.zzm();
        if (zzm.zzx()) {
            zzey zzey = this.zzf;
            if (zzey.zza == 0) {
                if (zzey.zzs.zzf().zzy()) {
                    zzey zzey2 = this.zzf;
                    zzey2.zzs.zzax();
                    zzey2.zza = 'C';
                } else {
                    zzey zzey3 = this.zzf;
                    zzey3.zzs.zzax();
                    zzey3.zza = 'c';
                }
            }
            zzey zzey4 = this.zzf;
            if (zzey4.zzb < 0) {
                zzey4.zzs.zzf().zzh();
                zzey4.zzb = 61000;
            }
            char charAt = "01VDIWEA?".charAt(this.zza);
            zzey zzey5 = this.zzf;
            String str = "2" + charAt + zzey5.zza + zzey5.zzb + ":" + zzey.zzo(true, this.zzb, this.zzc, this.zzd, this.zze);
            if (str.length() > 1024) {
                str = this.zzb.substring(0, 1024);
            }
            zzfl zzfl = zzm.zzb;
            if (zzfl != null) {
                zzfl.zzb(str, 1);
                return;
            }
            return;
        }
        SystemUtils.log(6, this.zzf.zzq(), "Persisted config not initialized. Not logging error/warn", (Throwable) null, "com.google.android.gms.measurement.internal.zzev", 16);
    }
}
