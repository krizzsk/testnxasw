package com.koushikdutta.async.util;

import com.koushikdutta.async.ByteBufferList;
import java.nio.ByteBuffer;

public class Allocator {

    /* renamed from: a */
    final int f58299a;

    /* renamed from: b */
    int f58300b;

    /* renamed from: c */
    int f58301c;

    public Allocator(int i) {
        this.f58300b = 0;
        this.f58301c = 4096;
        this.f58299a = i;
    }

    public Allocator() {
        this.f58300b = 0;
        this.f58301c = 4096;
        this.f58299a = ByteBufferList.MAX_ITEM_SIZE;
    }

    public ByteBuffer allocate() {
        return allocate(this.f58300b);
    }

    public ByteBuffer allocate(int i) {
        return ByteBufferList.obtain(Math.min(Math.max(i, this.f58301c), this.f58299a));
    }

    public void track(long j) {
        this.f58300b = ((int) j) * 2;
    }

    public int getMaxAlloc() {
        return this.f58299a;
    }

    public void setCurrentAlloc(int i) {
        this.f58300b = i;
    }

    public int getMinAlloc() {
        return this.f58301c;
    }

    public Allocator setMinAlloc(int i) {
        this.f58301c = Math.max(0, i);
        return this;
    }
}
