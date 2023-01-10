package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzij {
    public static zzif zza(zzif zzif) {
        if ((zzif instanceof zzih) || (zzif instanceof zzig)) {
            return zzif;
        }
        if (zzif instanceof Serializable) {
            return new zzig(zzif);
        }
        return new zzih(zzif);
    }

    public static zzif zzb(Object obj) {
        return new zzii(obj);
    }
}
