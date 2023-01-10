package com.didi.sdk.store;

import androidx.collection.LruCache;

class StoreCache<T> {

    /* renamed from: a */
    public static final int f40255a = -1;

    /* renamed from: b */
    public static final int f40256b = -2;

    /* renamed from: c */
    private static final int f40257c = 32;

    /* renamed from: d */
    private LruCache<String, StoreCache<T>.CacheItem> f40258d = new LruCache<>(32);

    /* renamed from: a */
    public void mo103017a(String str, T t, long j) {
        CacheItem cacheItem = new CacheItem(t, j);
        synchronized (this.f40258d) {
            this.f40258d.put(str, cacheItem);
        }
    }

    /* renamed from: a */
    public void mo103016a(String str) {
        synchronized (this.f40258d) {
            this.f40258d.remove(str);
        }
    }

    /* renamed from: b */
    public T mo103018b(String str) {
        StoreCache<T>.CacheItem e = m30329e(str);
        if (e == null) {
            return null;
        }
        return e.getValue();
    }

    /* renamed from: c */
    public boolean mo103019c(String str) {
        StoreCache<T>.CacheItem e = m30329e(str);
        if (e == null) {
            return true;
        }
        return e.isExpired();
    }

    /* renamed from: d */
    public boolean mo103020d(String str) {
        return this.f40258d.snapshot().keySet().contains(str);
    }

    /* renamed from: e */
    private StoreCache<T>.CacheItem m30329e(String str) {
        StoreCache<T>.CacheItem cacheItem;
        synchronized (this.f40258d) {
            cacheItem = this.f40258d.get(str);
        }
        return cacheItem;
    }

    private class CacheItem {
        private long mDuration;
        private long mStartTimestamp = System.currentTimeMillis();
        private T mValue;

        public CacheItem(T t, long j) {
            this.mValue = t;
            this.mDuration = j;
        }

        public T getValue() {
            return this.mValue;
        }

        public boolean isExpired() {
            long j = this.mDuration;
            if (j == -1) {
                return false;
            }
            if (j != -2 && System.currentTimeMillis() - this.mStartTimestamp <= this.mDuration) {
                return false;
            }
            return true;
        }
    }
}
