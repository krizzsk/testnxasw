package com.google.android.gms.internal.instantapps;

import java.util.Comparator;

final class zzbr implements Comparator<zzbp> {
    zzbr() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzbp zzbp = (zzbp) obj;
        zzbp zzbp2 = (zzbp) obj2;
        zzbu zzbu = (zzbu) zzbp.iterator();
        zzbu zzbu2 = (zzbu) zzbp2.iterator();
        while (zzbu.hasNext() && zzbu2.hasNext()) {
            int compare = Integer.compare(zzbp.zza(zzbu.nextByte()), zzbp.zza(zzbu2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzbp.size(), zzbp2.size());
    }
}
