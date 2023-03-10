package com.google.android.gms.internal.instantapps;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

class zzfg extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzez zzasu;

    private zzfg(zzez zzez) {
        this.zzasu = zzez;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new zzfh(this.zzasu, (zzey) null);
    }

    public int size() {
        return this.zzasu.size();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzasu.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzasu.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.zzasu.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzasu.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ zzfg(zzez zzez, zzey zzey) {
        this(zzez);
    }
}
