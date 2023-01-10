package com.didichuxing.routesearchsdk.multi;

import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.map.sdk.proto.driver_gl.TravelMode;
import java.util.List;

public class SingleRouteReqParam {

    /* renamed from: a */
    private DoublePoint f51128a;

    /* renamed from: b */
    private DoublePoint f51129b;

    /* renamed from: c */
    private List<OdPoint> f51130c;

    /* renamed from: d */
    private TravelMode f51131d;

    /* renamed from: e */
    private int f51132e;

    public SingleRouteReqParam(DoublePoint doublePoint, DoublePoint doublePoint2, List<OdPoint> list, TravelMode travelMode) {
        this.f51128a = doublePoint;
        this.f51129b = doublePoint2;
        this.f51130c = list;
        this.f51131d = travelMode;
    }

    public SingleRouteReqParam(DoublePoint doublePoint, DoublePoint doublePoint2, List<OdPoint> list, TravelMode travelMode, int i) {
        this.f51128a = doublePoint;
        this.f51129b = doublePoint2;
        this.f51130c = list;
        this.f51131d = travelMode;
        this.f51132e = i;
    }

    public DoublePoint getStart() {
        return this.f51128a;
    }

    public DoublePoint getEnd() {
        return this.f51129b;
    }

    public List<OdPoint> getWayPoints() {
        return this.f51130c;
    }

    public TravelMode getTravelMode() {
        return this.f51131d;
    }

    public int getExpectStyle() {
        return this.f51132e;
    }
}
