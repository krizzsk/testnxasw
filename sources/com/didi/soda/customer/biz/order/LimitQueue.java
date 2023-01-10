package com.didi.soda.customer.biz.order;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LimitQueue<E> {

    /* renamed from: a */
    private int f43001a;

    /* renamed from: b */
    private LinkedList<E> f43002b = new LinkedList<>();

    /* renamed from: c */
    private Comparator<E> f43003c;

    public LimitQueue(int i) {
        this.f43001a = i;
    }

    public void addComparator(Comparator<E> comparator) {
        this.f43003c = comparator;
    }

    public void clear() {
        this.f43002b.clear();
    }

    public E get(int i) {
        return this.f43002b.get(i);
    }

    public E getFirst() {
        return this.f43002b.getFirst();
    }

    public Iterator<E> getIterator() {
        LinkedList<E> linkedList = this.f43002b;
        if (linkedList != null) {
            return linkedList.iterator();
        }
        return null;
    }

    public E getLast() {
        return this.f43002b.getLast();
    }

    public int getLimitSize() {
        return this.f43001a;
    }

    public List<E> getList() {
        return new LinkedList(this.f43002b);
    }

    public void offer(E e) {
        synchronized (this.f43002b) {
            this.f43002b.add(e);
            if (this.f43003c != null) {
                Collections.sort(this.f43002b, this.f43003c);
            }
            if (this.f43002b.size() > this.f43001a) {
                this.f43002b.remove(getLast());
            }
        }
    }

    public int size() {
        return this.f43002b.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Const.jaLeft);
        Iterator it = this.f43002b.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        sb.append(Const.jaRight);
        return sb.toString();
    }
}
