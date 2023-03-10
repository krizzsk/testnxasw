package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzii implements zzif, Serializable {
    final Object zza;

    zzii(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof zzii)) {
            return false;
        }
        Object obj2 = this.zza;
        Object obj3 = ((zzii) obj).zza;
        if (obj2 == obj3 || obj2.equals(obj3)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public final String toString() {
        String obj = this.zza.toString();
        StringBuilder sb = new StringBuilder(obj.length() + 22);
        sb.append("Suppliers.ofInstance(");
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }

    public final Object zza() {
        return this.zza;
    }
}
