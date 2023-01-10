package com.didi.entrega.manager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomerManagerRegistry<K, V> {

    /* renamed from: a */
    private ConcurrentHashMap<K, V> f22677a = new ConcurrentHashMap<>();

    interface Iterator<K, V> {
        void entry(K k, V v);
    }

    public void clear() {
        this.f22677a.clear();
    }

    public V get(K k) {
        return this.f22677a.get(k);
    }

    public void iterator(Iterator iterator) {
        for (Map.Entry next : this.f22677a.entrySet()) {
            if (iterator != null) {
                iterator.entry(next.getKey(), next.getValue());
            }
        }
    }

    public void register(K k, V v) {
        if (this.f22677a.get(k) == null) {
            this.f22677a.put(k, v);
        }
    }

    public V unregister(K k) {
        return this.f22677a.remove(k);
    }
}
