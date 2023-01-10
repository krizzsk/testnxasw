package com.didichuxing.dfbasesdk.logupload2;

import java.util.LinkedHashMap;

public class LogHashMap<K, V> {

    /* renamed from: a */
    private final LinkedHashMap<K, V> f49294a;

    /* renamed from: b */
    private int f49295b;

    /* renamed from: c */
    private int f49296c;

    public LogHashMap() {
        this.f49295b = 5;
        this.f49294a = new LinkedHashMap<>();
    }

    public LogHashMap(int i) {
        this.f49295b = 5;
        if (i > 0) {
            this.f49295b = i;
            this.f49294a = new LinkedHashMap<>();
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final void put(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        this.f49294a.put(k, v);
    }

    public int getSize() {
        return this.f49296c;
    }

    public boolean isFull() {
        return this.f49294a.size() >= this.f49295b;
    }
}
