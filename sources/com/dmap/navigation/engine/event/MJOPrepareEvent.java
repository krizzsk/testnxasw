package com.dmap.navigation.engine.event;

import java.math.BigInteger;

public class MJOPrepareEvent extends NaviEvent {

    /* renamed from: a */
    private final int f54468a;

    /* renamed from: b */
    private final long f54469b;

    /* renamed from: c */
    private final String f54470c;

    /* renamed from: d */
    private final BigInteger f54471d;

    public MJOPrepareEvent(int i) {
        this(i, 0, (String) null, BigInteger.valueOf(0));
    }

    public MJOPrepareEvent(int i, long j, String str, BigInteger bigInteger) {
        this.f54468a = i;
        this.f54469b = j;
        this.f54470c = str;
        this.f54471d = bigInteger;
    }

    public String toString() {
        return "MjoEvent{updateType=" + this.f54468a + ", mjoId=" + this.f54469b + ", url='" + this.f54470c + '\'' + ", linkId=" + this.f54471d + '}';
    }

    public int getUpdateType() {
        return this.f54468a;
    }

    public long getMjoId() {
        return this.f54469b;
    }

    public String getUrl() {
        return this.f54470c;
    }

    public BigInteger getLinkId() {
        return this.f54471d;
    }
}
