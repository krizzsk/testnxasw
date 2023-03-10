package com.google.android.gms.internal.instantapps;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzbj<E> extends AbstractList<E> implements zzdc<E> {
    private boolean zzakn = true;

    zzbj() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public boolean add(E e) {
        zzt();
        return super.add(e);
    }

    public void add(int i, E e) {
        zzt();
        super.add(i, e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        zzt();
        return super.addAll(collection);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        zzt();
        return super.addAll(i, collection);
    }

    public void clear() {
        zzt();
        super.clear();
    }

    public boolean zzr() {
        return this.zzakn;
    }

    public final void zzs() {
        this.zzakn = false;
    }

    public E remove(int i) {
        zzt();
        return super.remove(i);
    }

    public boolean remove(Object obj) {
        zzt();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        zzt();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        zzt();
        return super.retainAll(collection);
    }

    public E set(int i, E e) {
        zzt();
        return super.set(i, e);
    }

    /* access modifiers changed from: protected */
    public final void zzt() {
        if (!this.zzakn) {
            throw new UnsupportedOperationException();
        }
    }
}
