package com.didi.soda.manager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomerManagerRegistry<K, V> {

    /* renamed from: a */
    private ConcurrentHashMap<K, V> f45910a = new ConcurrentHashMap<>();

    interface Iterator<K, V> {
        void entry(K k, V v);
    }

    public void clear() {
        this.f45910a.clear();
    }

    public V get(K k) {
        return this.f45910a.get(k);
    }

    public void iterator(Iterator iterator) {
        for (Map.Entry next : this.f45910a.entrySet()) {
            if (iterator != null) {
                iterator.entry(next.getKey(), next.getValue());
            }
        }
    }

    public void register(K k, V v) {
        if (this.f45910a.get(k) == null) {
            this.f45910a.put(k, v);
        }
    }

    public V unregister(K k) {
        return this.f45910a.remove(k);
    }
}
