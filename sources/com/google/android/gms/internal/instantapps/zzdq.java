package com.google.android.gms.internal.instantapps;

import java.util.List;

final class zzdq extends zzdp {
    private zzdq() {
        super();
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> zza(Object obj, long j) {
        zzdc zzc = zzc(obj, j);
        if (zzc.zzr()) {
            return zzc;
        }
        int size = zzc.size();
        zzdc zzi = zzc.zzi(size == 0 ? 10 : size << 1);
        zzfs.zza(obj, j, (Object) zzi);
        return zzi;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzs();
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzdc zzc = zzc(obj, j);
        zzdc zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zzr()) {
                zzc = zzc.zzi(size2 + size);
            }
            zzc.addAll(zzc2);
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zzfs.zza(obj, j, (Object) zzc2);
    }

    private static <E> zzdc<E> zzc(Object obj, long j) {
        return (zzdc) zzfs.zzp(obj, j);
    }
}
