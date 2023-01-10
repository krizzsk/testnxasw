package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool.Poolable;
import java.util.List;

public class ObjectPool<T extends Poolable> {

    /* renamed from: a */
    private static int f55044a;

    /* renamed from: b */
    private int f55045b;

    /* renamed from: c */
    private int f55046c;

    /* renamed from: d */
    private Object[] f55047d;

    /* renamed from: e */
    private int f55048e;

    /* renamed from: f */
    private T f55049f;

    /* renamed from: g */
    private float f55050g;

    public static abstract class Poolable {
        public static int NO_OWNER = -1;
        int currentOwnerId = NO_OWNER;

        /* access modifiers changed from: protected */
        public abstract Poolable instantiate();
    }

    public int getPoolId() {
        return this.f55045b;
    }

    public static synchronized ObjectPool create(int i, Poolable poolable) {
        ObjectPool objectPool;
        synchronized (ObjectPool.class) {
            objectPool = new ObjectPool(i, poolable);
            objectPool.f55045b = f55044a;
            f55044a++;
        }
        return objectPool;
    }

    private ObjectPool(int i, T t) {
        if (i > 0) {
            this.f55046c = i;
            this.f55047d = new Object[i];
            this.f55048e = 0;
            this.f55049f = t;
            this.f55050g = 1.0f;
            m40711a();
            return;
        }
        throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
    }

    public void setReplenishPercentage(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.f55050g = f;
    }

    public float getReplenishPercentage() {
        return this.f55050g;
    }

    /* renamed from: a */
    private void m40711a() {
        m40712a(this.f55050g);
    }

    /* renamed from: a */
    private void m40712a(float f) {
        int i = this.f55046c;
        int i2 = (int) (((float) i) * f);
        if (i2 < 1) {
            i = 1;
        } else if (i2 <= i) {
            i = i2;
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.f55047d[i3] = this.f55049f.instantiate();
        }
        this.f55048e = i - 1;
    }

    public synchronized T get() {
        T t;
        if (this.f55048e == -1 && this.f55050g > 0.0f) {
            m40711a();
        }
        t = (Poolable) this.f55047d[this.f55048e];
        t.currentOwnerId = Poolable.NO_OWNER;
        this.f55048e--;
        return t;
    }

    public synchronized void recycle(T t) {
        if (t.currentOwnerId == Poolable.NO_OWNER) {
            int i = this.f55048e + 1;
            this.f55048e = i;
            if (i >= this.f55047d.length) {
                m40713b();
            }
            t.currentOwnerId = this.f55045b;
            this.f55047d[this.f55048e] = t;
        } else if (t.currentOwnerId == this.f55045b) {
            throw new IllegalArgumentException("The object passed is already stored in this pool!");
        } else {
            throw new IllegalArgumentException("The object to recycle already belongs to poolId " + t.currentOwnerId + ".  Object cannot belong to two different pool instances simultaneously!");
        }
    }

    public synchronized void recycle(List<T> list) {
        while (list.size() + this.f55048e + 1 > this.f55046c) {
            m40713b();
        }
        int size = list.size();
        int i = 0;
        while (i < size) {
            Poolable poolable = (Poolable) list.get(i);
            if (poolable.currentOwnerId == Poolable.NO_OWNER) {
                poolable.currentOwnerId = this.f55045b;
                this.f55047d[this.f55048e + 1 + i] = poolable;
                i++;
            } else if (poolable.currentOwnerId == this.f55045b) {
                throw new IllegalArgumentException("The object passed is already stored in this pool!");
            } else {
                throw new IllegalArgumentException("The object to recycle already belongs to poolId " + poolable.currentOwnerId + ".  Object cannot belong to two different pool instances simultaneously!");
            }
        }
        this.f55048e += size;
    }

    /* renamed from: b */
    private void m40713b() {
        int i = this.f55046c;
        int i2 = i * 2;
        this.f55046c = i2;
        Object[] objArr = new Object[i2];
        for (int i3 = 0; i3 < i; i3++) {
            objArr[i3] = this.f55047d[i3];
        }
        this.f55047d = objArr;
    }

    public int getPoolCapacity() {
        return this.f55047d.length;
    }

    public int getPoolCount() {
        return this.f55048e + 1;
    }
}
