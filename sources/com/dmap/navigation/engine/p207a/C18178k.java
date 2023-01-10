package com.dmap.navigation.engine.p207a;

import com.dmap.navigation.api.route.ITunnelGeoPoint;
import com.dmap.navigation.jni.swig.TunnelGeoPoint;

/* renamed from: com.dmap.navigation.engine.a.k */
/* compiled from: SimpleTunnelGeoPoint */
public final class C18178k implements ITunnelGeoPoint {

    /* renamed from: a */
    private final int f54364a;

    /* renamed from: b */
    private final int f54365b;

    /* renamed from: c */
    private final int f54366c;

    /* renamed from: d */
    private final int f54367d;

    /* renamed from: e */
    private final int f54368e;

    public C18178k(TunnelGeoPoint tunnelGeoPoint) {
        this.f54364a = tunnelGeoPoint.getLat();
        this.f54365b = tunnelGeoPoint.getLng();
        this.f54366c = tunnelGeoPoint.getEnd();
        this.f54367d = tunnelGeoPoint.getIndex();
        this.f54368e = tunnelGeoPoint.getDefaultSpeed();
    }

    public final int getLat() {
        return this.f54364a;
    }

    public final int getLng() {
        return this.f54365b;
    }

    public final int getEnd() {
        return this.f54366c;
    }

    public final int getIndex() {
        return this.f54367d;
    }

    public final int getDefaultSpeed() {
        return this.f54368e;
    }
}
