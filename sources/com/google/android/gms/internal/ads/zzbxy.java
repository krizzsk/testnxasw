package com.google.android.gms.internal.ads;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbxy implements View.OnClickListener {
    final /* synthetic */ zzbxz zza;

    zzbxy(zzbxz zzbxz) {
        this.zza = zzbxz;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        this.zza.zza(true);
    }
}
