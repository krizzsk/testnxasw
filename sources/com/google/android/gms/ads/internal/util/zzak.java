package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import com.didi.autotracker.AutoTrackHelper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzak implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzas zza;

    public /* synthetic */ zzak(zzas zzas) {
        this.zza = zzas;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
        this.zza.zzr();
    }
}
