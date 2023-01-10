package com.didi.beatles.p101im.thirty.greenrobot.dao.identityscope;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.identityscope.IdentityScopeObject */
public class IdentityScopeObject<K, T> implements IdentityScope<K, T> {

    /* renamed from: a */
    private final HashMap<K, Reference<T>> f11530a = new HashMap<>();

    /* renamed from: b */
    private final ReentrantLock f11531b = new ReentrantLock();

    public void reserveRoom(int i) {
    }

    public T get(K k) {
        this.f11531b.lock();
        try {
            Reference reference = this.f11530a.get(k);
            if (reference != null) {
                return reference.get();
            }
            return null;
        } finally {
            this.f11531b.unlock();
        }
    }

    public T getNoLock(K k) {
        Reference reference = this.f11530a.get(k);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    public void put(K k, T t) {
        this.f11531b.lock();
        try {
            this.f11530a.put(k, new WeakReference(t));
        } finally {
            this.f11531b.unlock();
        }
    }

    public void putNoLock(K k, T t) {
        this.f11530a.put(k, new WeakReference(t));
    }

    public boolean detach(K k, T t) {
        boolean z;
        this.f11531b.lock();
        try {
            if (get(k) != t || t == null) {
                z = false;
            } else {
                remove(k);
                z = true;
            }
            return z;
        } finally {
            this.f11531b.unlock();
        }
    }

    public void remove(K k) {
        this.f11531b.lock();
        try {
            this.f11530a.remove(k);
        } finally {
            this.f11531b.unlock();
        }
    }

    public void remove(Iterable<K> iterable) {
        this.f11531b.lock();
        try {
            for (K remove : iterable) {
                this.f11530a.remove(remove);
            }
        } finally {
            this.f11531b.unlock();
        }
    }

    public void clear() {
        this.f11531b.lock();
        try {
            this.f11530a.clear();
        } finally {
            this.f11531b.unlock();
        }
    }

    public void lock() {
        this.f11531b.lock();
    }

    public void unlock() {
        this.f11531b.unlock();
    }
}
