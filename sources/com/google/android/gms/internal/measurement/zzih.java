package com.google.android.gms.internal.measurement;

import com.didi.beatles.p101im.access.utils.IMTextUtils;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzih implements zzif {
    @CheckForNull
    volatile zzif zza;
    volatile boolean zzb;
    @CheckForNull
    Object zzc;

    zzih(zzif zzif) {
        if (zzif != null) {
            this.zza = zzif;
            return;
        }
        throw null;
    }

    public final String toString() {
        Object obj = this.zza;
        if (obj == null) {
            String valueOf = String.valueOf(this.zzc);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(IMTextUtils.STREET_IMAGE_TAG_END);
            obj = sb.toString();
        }
        String obj2 = obj.toString();
        StringBuilder sb2 = new StringBuilder(obj2.length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(obj2);
        sb2.append(")");
        return sb2.toString();
    }

    public final Object zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    zzif zzif = this.zza;
                    zzif.getClass();
                    Object zza2 = zzif.zza();
                    this.zzc = zza2;
                    this.zzb = true;
                    this.zza = null;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}
