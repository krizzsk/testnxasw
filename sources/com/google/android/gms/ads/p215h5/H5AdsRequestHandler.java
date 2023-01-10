package com.google.android.gms.ads.p215h5;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbqy;

/* renamed from: com.google.android.gms.ads.h5.H5AdsRequestHandler */
/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class H5AdsRequestHandler {
    private final zzbqy zza;

    public H5AdsRequestHandler(Context context, OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = new zzbqy(context, onH5AdsEventListener);
    }

    public void clearAdObjects() {
        this.zza.zza();
    }

    public boolean handleH5AdsRequest(String str) {
        return this.zza.zzb(str);
    }

    public boolean shouldInterceptRequest(String str) {
        return zzbqy.zzc(str);
    }
}
