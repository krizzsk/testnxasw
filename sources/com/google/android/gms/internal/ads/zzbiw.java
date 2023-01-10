package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbiw {
    public static final SharedPreferences zza(Context context) {
        return SystemUtils.getSharedPreferences(context, "google_ads_flags", 0);
    }
}
