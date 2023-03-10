package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgpn implements Comparator {
    zzgpn() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzgpw zzgpw = (zzgpw) obj;
        zzgpw zzgpw2 = (zzgpw) obj2;
        zzgpq zzs = zzgpw.iterator();
        zzgpq zzs2 = zzgpw2.iterator();
        while (zzs.hasNext() && zzs2.hasNext()) {
            int compareTo = Integer.valueOf(zzs.zza() & 255).compareTo(Integer.valueOf(zzs2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzgpw.zzd()).compareTo(Integer.valueOf(zzgpw2.zzd()));
    }
}
