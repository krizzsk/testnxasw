package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbpq implements zzbpu {
    zzbpq() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzcmp zzcmp = (zzcmp) obj;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzcmp.zzbn();
        } else if ("resume".equals(str)) {
            zzcmp.zzbo();
        }
    }
}
