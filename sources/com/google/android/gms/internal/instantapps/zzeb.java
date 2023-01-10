package com.google.android.gms.internal.instantapps;

import java.util.Iterator;
import java.util.Map;

final class zzeb implements zzdy {
    zzeb() {
    }

    public final Map<?, ?> zzf(Object obj) {
        return (zzdz) obj;
    }

    public final zzdw<?, ?> zzk(Object obj) {
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> zzg(Object obj) {
        return (zzdz) obj;
    }

    public final boolean zzh(Object obj) {
        return !((zzdz) obj).isMutable();
    }

    public final Object zzi(Object obj) {
        ((zzdz) obj).zzs();
        return obj;
    }

    public final Object zzj(Object obj) {
        return zzdz.zzcv().zzcw();
    }

    public final Object zzb(Object obj, Object obj2) {
        zzdz zzdz = (zzdz) obj;
        zzdz zzdz2 = (zzdz) obj2;
        if (!zzdz2.isEmpty()) {
            if (!zzdz.isMutable()) {
                zzdz = zzdz.zzcw();
            }
            zzdz.zza(zzdz2);
        }
        return zzdz;
    }

    public final int zzb(int i, Object obj, Object obj2) {
        zzdz zzdz = (zzdz) obj;
        if (zzdz.isEmpty()) {
            return 0;
        }
        Iterator it = zzdz.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
