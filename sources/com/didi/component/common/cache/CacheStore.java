package com.didi.component.common.cache;

public class CacheStore {

    /* renamed from: a */
    private static CacheStore f13322a;

    /* renamed from: b */
    private CacheManager<String, Object> f13323b = new CacheManager<>();

    private CacheStore() {
    }

    public static CacheStore getInstance() {
        if (f13322a == null) {
            synchronized (CacheManager.class) {
                if (f13322a == null) {
                    f13322a = new CacheStore();
                }
            }
        }
        return f13322a;
    }

    public <T> T getCache(String str, T t) {
        T cache = this.f13323b.getCache(str);
        return cache != null ? cache : t;
    }

    public <T> void addCache(String str, T t) {
        this.f13323b.addCache(str, t);
    }
}
