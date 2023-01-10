package com.dmap.navigation.engine.event;

import com.dmap.navigation.jni.swig.LongList;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RoutesEvent extends NaviEvent {

    /* renamed from: a */
    private final List<BigInteger> f54497a;

    /* renamed from: b */
    private final BigInteger f54498b;

    /* renamed from: c */
    private final int f54499c;

    /* renamed from: d */
    private String f54500d;

    /* renamed from: e */
    private int f54501e = -1;

    public RoutesEvent(LongList longList, BigInteger bigInteger, int i) {
        this.f54499c = i;
        this.f54498b = bigInteger;
        int size = (int) longList.size();
        if (size > 0) {
            this.f54497a = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.f54497a.add(longList.get(i2));
            }
            return;
        }
        this.f54497a = null;
    }

    public String toString() {
        return "RoutesEvent{allRouteIds=" + this.f54497a + ", currentRouteId=" + this.f54498b + ", reason=" + this.f54499c + '}';
    }

    public List<BigInteger> getAllRouteIds() {
        return this.f54497a;
    }

    public int getReason() {
        return this.f54499c;
    }

    public BigInteger getCurrentRouteId() {
        return this.f54498b;
    }

    public String getText() {
        return this.f54500d;
    }

    public void setText(String str) {
        this.f54500d = str;
    }

    public int getType() {
        return this.f54501e;
    }

    public void setType(int i) {
        this.f54501e = i;
    }
}
