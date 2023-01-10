package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;
import com.didi.autotracker.AutoTrackHelper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcmi implements DialogInterface.OnClickListener {
    final /* synthetic */ JsResult zza;

    zzcmi(JsResult jsResult) {
        this.zza = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
        this.zza.cancel();
    }
}
