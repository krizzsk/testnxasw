package com.dmap.navigation.engine.simple;

import com.dmap.navigation.base.route.IMatchRouteInfo;
import com.dmap.navigation.jni.swig.MatchedRouteInfo;
import java.math.BigInteger;

public class SimpleMatchRouteInfo implements IMatchRouteInfo {

    /* renamed from: a */
    private final BigInteger f54556a;

    /* renamed from: b */
    private final BigInteger f54557b;

    /* renamed from: c */
    private final String f54558c;

    public SimpleMatchRouteInfo(MatchedRouteInfo matchedRouteInfo) {
        this.f54556a = matchedRouteInfo.getLinkId();
        this.f54557b = matchedRouteInfo.getLinkIdRaw();
        this.f54558c = matchedRouteInfo.getMapVersion();
    }

    public BigInteger getLinkId() {
        return this.f54556a;
    }

    public BigInteger getLinkIdRaw() {
        return this.f54557b;
    }

    public String getMapVersion() {
        return this.f54558c;
    }
}
