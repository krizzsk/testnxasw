package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzfo implements zzfsy {
    public static final /* synthetic */ zzfo zza = new zzfo();

    private /* synthetic */ zzfo() {
    }

    public final boolean zza(Object obj) {
        String str = (String) obj;
        if (str == null) {
            return false;
        }
        String zza2 = zzfse.zza(str);
        if (!TextUtils.isEmpty(zza2)) {
            return (!zza2.contains("text") || zza2.contains("text/vtt")) && !zza2.contains("html") && !zza2.contains("xml");
        }
        return false;
    }
}
