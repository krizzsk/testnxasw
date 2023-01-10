package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzesh implements zzevd {
    public final String zza;
    public final boolean zzb;

    public zzesh(String str, boolean z) {
        this.zza = str;
        this.zzb = z;
    }

    public final /* synthetic */ void zzf(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("gct", this.zza);
        if (this.zzb) {
            bundle.putString(Constants.FILE_DART_ERROR_KEY, "1");
        }
    }
}
