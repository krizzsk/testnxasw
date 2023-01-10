package com.didi.map.global.sdk.movement.sensor;

import java.util.LinkedList;

public class SMAQueue {

    /* renamed from: a */
    private final LinkedList f30198a = new LinkedList();

    public void clear() {
        this.f30198a.clear();
    }

    public boolean isEmpty() {
        return this.f30198a.isEmpty();
    }

    public void enQueue(Object obj) {
        this.f30198a.addLast(obj);
    }

    public Object deQueue() {
        if (!this.f30198a.isEmpty()) {
            return this.f30198a.removeFirst();
        }
        return null;
    }

    public int QueueLength() {
        return this.f30198a.size();
    }

    public Object QueuePeek() {
        return this.f30198a.getFirst();
    }

    public Object get(int i) {
        return this.f30198a.get(i);
    }
}
