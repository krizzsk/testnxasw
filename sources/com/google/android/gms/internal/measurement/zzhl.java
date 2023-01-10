package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzhl extends ContentObserver {
    zzhl(zzhm zzhm, Handler handler) {
        super((Handler) null);
    }

    public final void onChange(boolean z) {
        zzhy.zzd();
    }
}
