package com.didi.hawaii.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LoopQueue<T> {

    /* renamed from: a */
    private int f26451a;

    /* renamed from: b */
    private int f26452b;

    /* renamed from: c */
    private Queue<T> f26453c;

    /* renamed from: d */
    private int f26454d;

    public LoopQueue() {
        this.f26451a = 20;
        this.f26454d = 0;
        this.f26452b = 20;
        this.f26453c = new LinkedList();
    }

    public LoopQueue(T t) {
        this();
        this.f26453c.offer(t);
        this.f26454d++;
    }

    public LoopQueue(int i) {
        this();
        this.f26452b = i;
    }

    public LoopQueue(T t, int i) {
        this(t);
        this.f26452b = i;
    }

    public synchronized int size() {
        if (isEmpty()) {
            return 0;
        }
        return this.f26453c.size();
    }

    public synchronized void add(T t) {
        if (this.f26454d >= this.f26452b) {
            this.f26453c.poll();
            this.f26453c.offer(t);
            return;
        }
        this.f26453c.offer(t);
        this.f26454d++;
    }

    public synchronized boolean isEmpty() {
        return this.f26454d == 0;
    }

    public synchronized void clear() {
        this.f26453c.clear();
        this.f26454d = 0;
    }

    public synchronized List<T> getNowQueue() {
        return new ArrayList(this.f26453c);
    }
}
