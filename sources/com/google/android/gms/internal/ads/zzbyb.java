package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import com.didi.autotracker.AutoTrackHelper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbyb implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbyc zza;

    zzbyb(zzbyc zzbyc) {
        this.zza = zzbyc;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
        this.zza.zzg("User canceled the download.");
    }
}
