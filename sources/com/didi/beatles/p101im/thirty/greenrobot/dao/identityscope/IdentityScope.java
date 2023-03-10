package com.didi.beatles.p101im.thirty.greenrobot.dao.identityscope;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.identityscope.IdentityScope */
public interface IdentityScope<K, T> {
    void clear();

    boolean detach(K k, T t);

    T get(K k);

    T getNoLock(K k);

    void lock();

    void put(K k, T t);

    void putNoLock(K k, T t);

    void remove(Iterable<K> iterable);

    void remove(K k);

    void reserveRoom(int i);

    void unlock();
}
