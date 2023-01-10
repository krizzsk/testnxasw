package com.google.android.gms.measurement.internal;

import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
final class zzfw extends LruCache {
    final /* synthetic */ zzfz zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfw(zzfz zzfz, int i) {
        super(20);
        this.zza = zzfz;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object create(Object obj) {
        String str = (String) obj;
        Preconditions.checkNotEmpty(str);
        return zzfz.zzd(this.zza, str);
    }
}
