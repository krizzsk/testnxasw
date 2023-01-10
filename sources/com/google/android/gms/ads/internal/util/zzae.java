package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import com.didi.autotracker.AutoTrackHelper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzae implements DialogInterface.OnClickListener {
    public static final /* synthetic */ zzae zza = new zzae();

    private /* synthetic */ zzae() {
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
    }
}
