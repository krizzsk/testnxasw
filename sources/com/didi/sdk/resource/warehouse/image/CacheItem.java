package com.didi.sdk.resource.warehouse.image;

import java.lang.ref.WeakReference;

public final class CacheItem {

    /* renamed from: a */
    private final long f39814a;

    /* renamed from: b */
    private final String f39815b;

    /* renamed from: c */
    private final PriorityType f39816c;

    /* renamed from: d */
    private final WeakReference<ICacheProvider> f39817d;

    /* renamed from: e */
    private final WeakReference<IRetryStrategy> f39818e;

    public CacheItem(long j, String str, PriorityType priorityType, ICacheProvider iCacheProvider, IRetryStrategy iRetryStrategy) {
        this.f39814a = j;
        this.f39815b = str;
        this.f39816c = priorityType;
        this.f39817d = new WeakReference<>(iCacheProvider);
        this.f39818e = new WeakReference<>(iRetryStrategy);
    }

    public long getResId() {
        return this.f39814a;
    }

    public String getUrl() {
        return this.f39815b;
    }

    public PriorityType getPriorityType() {
        return this.f39816c;
    }

    public ICacheProvider getCacheProvider() {
        return (ICacheProvider) this.f39817d.get();
    }

    public IRetryStrategy getRetryStrategy() {
        return (IRetryStrategy) this.f39818e.get();
    }
}
