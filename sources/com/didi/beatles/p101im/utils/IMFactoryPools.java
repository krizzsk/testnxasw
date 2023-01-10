package com.didi.beatles.p101im.utils;

import androidx.core.util.Pools;

/* renamed from: com.didi.beatles.im.utils.IMFactoryPools */
public final class IMFactoryPools {

    /* renamed from: a */
    private static final String f11603a = IMFactoryPools.class.getSimpleName();

    /* renamed from: b */
    private static final Resetter<Object> f11604b = new Resetter<Object>() {
        public void reset(Object obj) {
        }
    };

    /* renamed from: com.didi.beatles.im.utils.IMFactoryPools$Factory */
    public interface Factory<T> {
        T create();
    }

    /* renamed from: com.didi.beatles.im.utils.IMFactoryPools$Resetter */
    public interface Resetter<T> {
        void reset(T t);
    }

    private IMFactoryPools() {
    }

    public static <T> Pools.Pool<T> simple(int i, Factory<T> factory) {
        return m10007a(new Pools.SimplePool(i), factory);
    }

    public static <T> Pools.Pool<T> simple(int i, Factory<T> factory, Resetter<T> resetter) {
        return m10008a(new Pools.SimplePool(i), factory, resetter);
    }

    public static <T> Pools.Pool<T> threadSafe(int i, Factory<T> factory) {
        return m10007a(new Pools.SynchronizedPool(i), factory);
    }

    public static <T> Pools.Pool<T> threadSafe(int i, Factory<T> factory, Resetter<T> resetter) {
        return m10008a(new Pools.SynchronizedPool(i), factory, resetter);
    }

    /* renamed from: a */
    private static <T> Pools.Pool<T> m10007a(Pools.Pool<T> pool, Factory<T> factory) {
        return m10008a(pool, factory, m10009a());
    }

    /* renamed from: a */
    private static <T> Pools.Pool<T> m10008a(Pools.Pool<T> pool, Factory<T> factory, Resetter<T> resetter) {
        return new FactoryPool(pool, factory, resetter);
    }

    /* renamed from: a */
    private static <T> Resetter<T> m10009a() {
        return f11604b;
    }

    /* renamed from: com.didi.beatles.im.utils.IMFactoryPools$FactoryPool */
    private static final class FactoryPool<T> implements Pools.Pool<T> {
        private final Factory<T> factory;
        private final Pools.Pool<T> pool;
        private final Resetter<T> resetter;

        public FactoryPool(Pools.Pool<T> pool2, Factory<T> factory2, Resetter<T> resetter2) {
            this.factory = factory2;
            this.resetter = resetter2;
            this.pool = pool2;
        }

        public T acquire() {
            T acquire = this.pool.acquire();
            return acquire == null ? this.factory.create() : acquire;
        }

        public boolean release(T t) {
            this.resetter.reset(t);
            return this.pool.release(t);
        }
    }
}
