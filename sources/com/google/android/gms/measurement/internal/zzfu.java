package com.google.android.gms.measurement.internal;

import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final /* synthetic */ class zzfu implements Callable {
    public final /* synthetic */ zzfz zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzfu(zzfz zzfz, String str) {
        this.zza = zzfz;
        this.zzb = str;
    }

    public final Object call() {
        zzfz zzfz = this.zza;
        String str = this.zzb;
        zzg zzj = zzfz.zzf.zzi().zzj(str);
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put(GlobalCashierCoreModule.PACKAGE_NAME, str);
        zzfz.zzs.zzf().zzh();
        hashMap.put("gmp_version", 61000L);
        if (zzj != null) {
            String zzw = zzj.zzw();
            if (zzw != null) {
                hashMap.put("app_version", zzw);
            }
            hashMap.put("app_version_int", Long.valueOf(zzj.zzb()));
            hashMap.put("dynamite_version", Long.valueOf(zzj.zzk()));
        }
        return hashMap;
    }
}
