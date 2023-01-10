package com.didi.beatles.p101im.thirty.greenrobot.dao.identityscope;

import com.didi.beatles.p101im.thirty.greenrobot.dao.internal.LongHashMap;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.identityscope.IdentityScopeLong */
public class IdentityScopeLong<T> implements IdentityScope<Long, T> {

    /* renamed from: a */
    private final LongHashMap<Reference<T>> f11528a = new LongHashMap<>();

    /* renamed from: b */
    private final ReentrantLock f11529b = new ReentrantLock();

    public T get(Long l) {
        return get2(l.longValue());
    }

    public T getNoLock(Long l) {
        return get2NoLock(l.longValue());
    }

    public T get2(long j) {
        this.f11529b.lock();
        try {
            Reference reference = this.f11528a.get(j);
            if (reference != null) {
                return reference.get();
            }
            return null;
        } finally {
            this.f11529b.unlock();
        }
    }

    public T get2NoLock(long j) {
        Reference reference = this.f11528a.get(j);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    public void put(Long l, T t) {
        put2(l.longValue(), t);
    }

    public void putNoLock(Long l, T t) {
        put2NoLock(l.longValue(), t);
    }

    public void put2(long j, T t) {
        this.f11529b.lock();
        try {
            this.f11528a.put(j, new WeakReference(t));
        } finally {
            this.f11529b.unlock();
        }
    }

    public void put2NoLock(long j, T t) {
        this.f11528a.put(j, new WeakReference(t));
    }

    public boolean detach(Long l, T t) {
        boolean z;
        this.f11529b.lock();
        try {
            if (get(l) != t || t == null) {
                z = false;
            } else {
                remove(l);
                z = true;
            }
            return z;
        } finally {
            this.f11529b.unlock();
        }
    }

    public void remove(Long l) {
        this.f11529b.lock();
        try {
            this.f11528a.remove(l.longValue());
        } finally {
            this.f11529b.unlock();
        }
    }

    public void remove(Iterable<Long> iterable) {
        this.f11529b.lock();
        try {
            for (Long longValue : iterable) {
                this.f11528a.remove(longValue.longValue());
            }
        } finally {
            this.f11529b.unlock();
        }
    }

    public void clear() {
        this.f11529b.lock();
        try {
            this.f11528a.clear();
        } finally {
            this.f11529b.unlock();
        }
    }

    public void lock() {
        this.f11529b.lock();
    }

    public void unlock() {
        this.f11529b.unlock();
    }

    public void reserveRoom(int i) {
        this.f11528a.reserveRoom(i);
    }
}
