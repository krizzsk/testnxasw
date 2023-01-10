package com.didi.entrega.order.pool;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LimitQueue<E> {

    /* renamed from: a */
    private int f22767a;

    /* renamed from: b */
    private LinkedList<E> f22768b = new LinkedList<>();

    /* renamed from: c */
    private Comparator<E> f22769c;

    public LimitQueue(int i) {
        this.f22767a = i;
    }

    public void addComparator(Comparator<E> comparator) {
        this.f22769c = comparator;
    }

    public void clear() {
        this.f22768b.clear();
    }

    public E get(int i) {
        return this.f22768b.get(i);
    }

    public E getFirst() {
        return this.f22768b.getFirst();
    }

    public Iterator<E> getIterator() {
        LinkedList<E> linkedList = this.f22768b;
        if (linkedList != null) {
            return linkedList.iterator();
        }
        return null;
    }

    public E getLast() {
        return this.f22768b.getLast();
    }

    public int getLimitSize() {
        return this.f22767a;
    }

    public List<E> getList() {
        return new LinkedList(this.f22768b);
    }

    public void offer(E e) {
        synchronized (this.f22768b) {
            this.f22768b.add(e);
            if (this.f22769c != null) {
                Collections.sort(this.f22768b, this.f22769c);
            }
            if (this.f22768b.size() > this.f22767a) {
                this.f22768b.remove(getLast());
            }
        }
    }

    public int size() {
        return this.f22768b.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Const.jaLeft);
        Iterator it = this.f22768b.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        sb.append(Const.jaRight);
        return sb.toString();
    }
}
