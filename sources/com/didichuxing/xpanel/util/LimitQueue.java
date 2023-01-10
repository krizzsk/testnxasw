package com.didichuxing.xpanel.util;

import java.util.LinkedList;

public class LimitQueue<E> {

    /* renamed from: a */
    private int f52154a;

    /* renamed from: b */
    private LinkedList<E> f52155b = new LinkedList<>();

    public LimitQueue(int i) {
        this.f52154a = i;
    }

    public void offer(E e) {
        if (this.f52155b.size() >= this.f52154a) {
            this.f52155b.poll();
        }
        this.f52155b.offerFirst(e);
    }

    public E get(int i) {
        if (i > size() || i < 0) {
            return null;
        }
        return this.f52155b.get(i);
    }

    public E getLast() {
        return this.f52155b.getLast();
    }

    public E getFirst() {
        return this.f52155b.getFirst();
    }

    public int getLimit() {
        return this.f52154a;
    }

    public int size() {
        return this.f52155b.size();
    }
}
