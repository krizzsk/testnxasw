package com.google.android.gms.internal.ads;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdus implements View.OnClickListener {
    public final /* synthetic */ zzdux zza;

    public /* synthetic */ zzdus(zzdux zzdux) {
        this.zza = zzdux;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        this.zza.zzf(view);
    }
}
