package com.google.android.gms.internal.instantapps;

import com.didi.sdk.push.fcm.Constact;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzeq {
    private static final zzeq zzasg = new zzeq();
    private final zzex zzash = new zzds();
    private final ConcurrentMap<Class<?>, zzeu<?>> zzasi = new ConcurrentHashMap();

    public static zzeq zzdi() {
        return zzasg;
    }

    public final <T> zzeu<T> zze(Class<T> cls) {
        zzcy.zza(cls, Constact.KEY_LINK_MESSAGETYPE);
        zzeu<T> zzeu = (zzeu) this.zzasi.get(cls);
        if (zzeu != null) {
            return zzeu;
        }
        zzeu<T> zzd = this.zzash.zzd(cls);
        zzcy.zza(cls, Constact.KEY_LINK_MESSAGETYPE);
        zzcy.zza(zzd, "schema");
        zzeu<T> putIfAbsent = this.zzasi.putIfAbsent(cls, zzd);
        return putIfAbsent != null ? putIfAbsent : zzd;
    }

    public final <T> zzeu<T> zzp(T t) {
        return zze(t.getClass());
    }

    private zzeq() {
    }
}
