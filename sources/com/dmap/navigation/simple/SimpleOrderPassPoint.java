package com.dmap.navigation.simple;

import com.dmap.navigation.base.location.INaviPoi;
import com.dmap.navigation.base.location.IOrderPassPoint;

public class SimpleOrderPassPoint implements IOrderPassPoint {

    /* renamed from: a */
    private final INaviPoi f54581a;

    /* renamed from: b */
    private final long f54582b;

    /* renamed from: c */
    private final int f54583c;

    /* renamed from: d */
    private final int f54584d;

    public SimpleOrderPassPoint(INaviPoi iNaviPoi, long j, int i, int i2) {
        this.f54581a = iNaviPoi;
        this.f54582b = j;
        this.f54583c = i;
        this.f54584d = i2;
    }

    public String toString() {
        return "SimpleOrderPassPoint{poi=" + this.f54581a + ", orderId=" + this.f54582b + ", orderType=" + this.f54583c + ", pointType=" + this.f54584d + '}';
    }

    public INaviPoi getPoi() {
        return this.f54581a;
    }

    public long getOrderId() {
        return this.f54582b;
    }

    public int getOrderType() {
        return this.f54583c;
    }

    public int getPointType() {
        return this.f54584d;
    }
}
