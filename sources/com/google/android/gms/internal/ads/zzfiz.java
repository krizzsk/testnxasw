package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.didi.raven.config.RavenKey;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.DeviceProperties;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfiz {
    private final Context zza;
    private final String zzb;
    private final String zzc;

    public zzfiz(Context context, zzcgv zzcgv) {
        this.zza = context;
        this.zzb = context.getPackageName();
        this.zzc = zzcgv.zza;
    }

    public final void zza(Map map) {
        map.put(RavenKey.STACK, "gmob_sdk");
        map.put(RavenKey.VERSION, "3");
        map.put("os", Build.VERSION.RELEASE);
        map.put("api_v", Build.VERSION.SDK);
        zzt.zzp();
        map.put("device", zzs.zzq());
        map.put("app", this.zzb);
        zzt.zzp();
        String str = "0";
        map.put("is_lite_sdk", true != zzs.zzA(this.zza) ? str : "1");
        List zzb2 = zzbjc.zzb();
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzfX)).booleanValue()) {
            zzb2.addAll(zzt.zzo().zzh().zzh().zzd());
        }
        map.put("e", TextUtils.join(",", zzb2));
        map.put("sdkVersion", this.zzc);
        if (((Boolean) zzay.zzc().zzb(zzbjc.zziQ)).booleanValue()) {
            if (true == DeviceProperties.isBstar(this.zza)) {
                str = "1";
            }
            map.put("is_bstar", str);
        }
    }
}
