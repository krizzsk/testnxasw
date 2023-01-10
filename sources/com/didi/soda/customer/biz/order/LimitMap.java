package com.didi.soda.customer.biz.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LimitMap<K, E> {

    /* renamed from: a */
    private int f42998a;

    /* renamed from: b */
    private LinkedHashMap<K, E> f42999b = new LinkedHashMap<>();

    /* renamed from: c */
    private Comparator<Map.Entry<K, E>> f43000c;

    public LimitMap(int i) {
        this.f42998a = i;
    }

    public void addComparator(Comparator<Map.Entry<K, E>> comparator) {
        this.f43000c = comparator;
    }

    public Comparator<Map.Entry<K, E>> getComparator() {
        return this.f43000c;
    }

    public void clear() {
        this.f42999b.clear();
    }

    public E get(K k) {
        return this.f42999b.get(k);
    }

    public int size() {
        return this.f42999b.size();
    }

    public int getLimitSize() {
        return this.f42998a;
    }

    public Iterator<Map.Entry<K, E>> getIterator() {
        return this.f42999b.entrySet().iterator();
    }

    public Set<K> getKeySet() {
        return this.f42999b.keySet();
    }

    public Set<Map.Entry<K, E>> getEntrySet() {
        return this.f42999b.entrySet();
    }

    public List<E> getList() {
        return new ArrayList(this.f42999b.values());
    }

    public synchronized void offerAndSort(K k, E e) {
        offer(k, e);
        resort();
    }

    public void offer(K k, E e) {
        this.f42999b.put(k, e);
    }

    public void resort() {
        LinkedList<Map.Entry> linkedList = new LinkedList<>(getEntrySet());
        Collections.sort(linkedList, this.f43000c);
        this.f42999b.clear();
        for (Map.Entry entry : linkedList) {
            if (this.f42999b.size() < this.f42998a) {
                this.f42999b.put(entry.getKey(), entry.getValue());
            } else {
                return;
            }
        }
    }
}
