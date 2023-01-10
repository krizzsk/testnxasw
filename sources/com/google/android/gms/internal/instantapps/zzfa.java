package com.google.android.gms.internal.instantapps;

import java.util.Iterator;
import java.util.Map;

final class zzfa extends zzfg {
    private final /* synthetic */ zzez zzasu;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzfa(zzez zzez) {
        super(zzez, (zzey) null);
        this.zzasu = zzez;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzfb(this.zzasu, (zzey) null);
    }

    /* synthetic */ zzfa(zzez zzez, zzey zzey) {
        this(zzez);
    }
}
