package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.res.Resources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.taxis99.R;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzga {
    public static String zza(Context context) {
        try {
            return context.getResources().getResourcePackageName(R.string.common_google_play_services_unknown_issue);
        } catch (Resources.NotFoundException unused) {
            return context.getPackageName();
        }
    }

    public static final String zzb(String str, Resources resources, String str2) {
        int identifier = resources.getIdentifier(str, TypedValues.Custom.S_STRING, str2);
        if (identifier == 0) {
            return null;
        }
        try {
            return resources.getString(identifier);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }
}
