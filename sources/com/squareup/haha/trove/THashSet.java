package com.squareup.haha.trove;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class THashSet<E> extends TObjectHash<E> implements Set<E> {
    public boolean add(E e) {
        int insertionIndex = insertionIndex(e);
        boolean z = false;
        if (insertionIndex < 0) {
            return false;
        }
        Object obj = this._set[insertionIndex];
        this._set[insertionIndex] = e;
        if (obj == null) {
            z = true;
        }
        postInsertHook(z);
        return true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (set.size() != size()) {
            return false;
        }
        return containsAll(set);
    }

    public int hashCode() {
        HashProcedure hashProcedure = new HashProcedure();
        forEach(hashProcedure);
        return hashProcedure.f58791h;
    }

    final class HashProcedure implements TObjectProcedure<E> {

        /* renamed from: h */
        int f58791h;

        HashProcedure() {
        }

        public final boolean execute(E e) {
            this.f58791h += THashSet.this._hashingStrategy.computeHashCode(e);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void rehash(int i) {
        int length = this._set.length;
        Object[] objArr = this._set;
        this._set = new Object[i];
        while (true) {
            int i2 = length - 1;
            if (length > 0) {
                if (!(objArr[i2] == null || objArr[i2] == REMOVED)) {
                    Object obj = objArr[i2];
                    int insertionIndex = insertionIndex(obj);
                    if (insertionIndex < 0) {
                        throwObjectContractViolation(this._set[(-insertionIndex) - 1], obj);
                    }
                    this._set[insertionIndex] = obj;
                }
                length = i2;
            } else {
                return;
            }
        }
    }

    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        forEach(new ToObjectArrayProcedure(objArr));
        return objArr;
    }

    public <T> T[] toArray(T[] tArr) {
        int size = size();
        if (tArr.length < size) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        }
        Iterator it = iterator();
        for (int i = 0; i < size; i++) {
            tArr[i] = it.next();
        }
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    public void clear() {
        super.clear();
        Object[] objArr = this._set;
        int length = objArr.length;
        while (true) {
            int i = length - 1;
            if (length > 0) {
                objArr[i] = null;
                length = i;
            } else {
                return;
            }
        }
    }

    public boolean remove(Object obj) {
        int index = index(obj);
        if (index < 0) {
            return false;
        }
        removeAt(index);
        return true;
    }

    public Iterator<E> iterator() {
        return new TObjectHashIterator(this);
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size();
        ensureCapacity(size);
        Iterator<? extends E> it = collection.iterator();
        boolean z = false;
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return z;
            }
            if (add(it.next())) {
                z = true;
            }
            size = i;
        }
    }

    public boolean removeAll(Collection<?> collection) {
        int size = collection.size();
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return z;
            }
            if (remove(it.next())) {
                z = true;
            }
            size = i;
        }
    }

    public boolean retainAll(Collection<?> collection) {
        int size = size();
        Iterator it = iterator();
        boolean z = false;
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return z;
            }
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
            size = i;
        }
    }
}
