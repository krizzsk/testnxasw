package com.didi.map.sdk.nav.inertia;

import java.util.LinkedList;

public class LimitQueue<E> {

    /* renamed from: a */
    private int f30923a;

    /* renamed from: b */
    private LinkedList<E> f30924b = new LinkedList<>();

    public LimitQueue(int i) {
        this.f30923a = i;
    }

    public void offer(E e) {
        if (this.f30924b.size() >= this.f30923a) {
            this.f30924b.poll();
        }
        this.f30924b.offer(e);
    }

    public E get(int i) {
        return this.f30924b.get(i);
    }

    public E getLast() {
        if (this.f30924b.size() == 0) {
            return null;
        }
        return this.f30924b.getLast();
    }

    public void poll() {
        LinkedList<E> linkedList = this.f30924b;
        if (linkedList != null && linkedList.size() > 0) {
            this.f30924b.poll();
        }
    }

    public E getFirst() {
        return this.f30924b.getFirst();
    }

    public int getLimit() {
        return this.f30923a;
    }

    public void setLimitedSize(int i) {
        this.f30923a = i;
    }

    public int size() {
        return this.f30924b.size();
    }

    public void clear() {
        this.f30924b.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f30924b.size(); i++) {
            sb.append(this.f30924b.get(i));
            sb.append(" ");
        }
        return sb.toString();
    }
}
