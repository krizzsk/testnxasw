package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzhd extends ContentObserver {
    final /* synthetic */ zzhe zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzhd(zzhe zzhe, Handler handler) {
        super((Handler) null);
        this.zza = zzhe;
    }

    public final void onChange(boolean z) {
        this.zza.zzf();
    }
}
