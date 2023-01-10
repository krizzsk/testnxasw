package com.didi.component.common.cache;

import java.util.HashMap;
import java.util.Map;

public class CacheManager<T, F> {

    /* renamed from: a */
    private Map<T, F> f13321a;

    public void addCache(T t, F f) {
        if (t != null && f != null) {
            m11149a();
            this.f13321a.put(t, f);
        }
    }

    public F getCache(T t) {
        Map<T, F> map = this.f13321a;
        if (map == null || t == null) {
            return null;
        }
        return map.get(t);
    }

    public boolean hasCache(T t) {
        Map<T, F> map = this.f13321a;
        if (map == null || t == null) {
            return false;
        }
        return map.containsKey(t);
    }

    /* renamed from: a */
    private void m11149a() {
        if (this.f13321a == null) {
            this.f13321a = new HashMap();
        }
    }
}
