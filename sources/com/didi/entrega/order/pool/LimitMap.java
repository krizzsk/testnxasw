package com.didi.entrega.order.pool;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LimitMap<K, E> {

    /* renamed from: a */
    private int f22764a;

    /* renamed from: b */
    private LinkedHashMap<K, E> f22765b = new LinkedHashMap<>();

    /* renamed from: c */
    private Comparator<Map.Entry<K, E>> f22766c;

    public LimitMap(int i) {
        this.f22764a = i;
    }

    public void addComparator(Comparator<Map.Entry<K, E>> comparator) {
        this.f22766c = comparator;
    }

    public Comparator<Map.Entry<K, E>> getComparator() {
        return this.f22766c;
    }

    public void clear() {
        this.f22765b.clear();
    }

    public E get(K k) {
        return this.f22765b.get(k);
    }

    public int size() {
        return this.f22765b.size();
    }

    public int getLimitSize() {
        return this.f22764a;
    }

    public Iterator<Map.Entry<K, E>> getIterator() {
        return this.f22765b.entrySet().iterator();
    }

    public Set<K> getKeySet() {
        return this.f22765b.keySet();
    }

    public Set<Map.Entry<K, E>> getEntrySet() {
        return this.f22765b.entrySet();
    }

    public List<E> getList() {
        return new ArrayList(this.f22765b.values());
    }

    public synchronized void offerAndSort(K k, E e) {
        offer(k, e);
    }

    public void offer(K k, E e) {
        this.f22765b.put(k, e);
    }
}
