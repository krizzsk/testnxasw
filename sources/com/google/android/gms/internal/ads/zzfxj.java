package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.CheckForNull;
import org.osgi.framework.VersionRange;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfxj extends zzfvs {
    final transient Object zza;

    zzfxj(Object obj) {
        if (obj != null) {
            this.zza = obj;
            return;
        }
        throw null;
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.equals(obj);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final /* synthetic */ Iterator iterator() {
        return new zzfvv(this.zza);
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        return VersionRange.LEFT_CLOSED + this.zza.toString() + VersionRange.RIGHT_CLOSED;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        objArr[i] = this.zza;
        return i + 1;
    }

    public final zzfvn zzd() {
        return zzfvn.zzp(this.zza);
    }

    public final zzfxm zze() {
        return new zzfvv(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        throw null;
    }
}
