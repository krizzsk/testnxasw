package com.dmap.navigation.engine.event;

import com.dmap.navigation.base.location.INaviLocation;
import com.dmap.navigation.engine.simple.SimpleLocation;
import com.dmap.navigation.jni.swig.NaviLocation;
import java.math.BigInteger;

public final class MatchLocationEvent extends NaviEvent {

    /* renamed from: a */
    private final int f54472a;

    /* renamed from: b */
    private final int f54473b;

    /* renamed from: c */
    private final double f54474c;

    /* renamed from: d */
    private final int f54475d;

    /* renamed from: e */
    private final INaviLocation f54476e;

    /* renamed from: f */
    private final BigInteger f54477f;

    public MatchLocationEvent(BigInteger bigInteger, NaviLocation naviLocation, int i, int i2, double d, int i3) {
        this.f54477f = bigInteger;
        this.f54476e = new SimpleLocation(naviLocation);
        this.f54472a = i;
        this.f54473b = i2;
        this.f54474c = d;
        this.f54475d = i3;
    }

    public final String toString() {
        return "MatchLocationEvent{matchIndex=" + this.f54472a + ", matchedStatus=" + this.f54473b + ", shapeOffset=" + this.f54474c + ", navigationType=" + this.f54475d + ", location=" + this.f54476e + ", routeId=" + this.f54477f + '}';
    }

    public final int getMatchIndex() {
        return this.f54472a;
    }

    public final int getMatchedStatus() {
        return this.f54473b;
    }

    public final double getShapeOffset() {
        return this.f54474c;
    }

    public final int getNavigationType() {
        return this.f54475d;
    }

    public final INaviLocation getLocation() {
        return this.f54476e;
    }

    public final BigInteger getRouteId() {
        return this.f54477f;
    }
}
