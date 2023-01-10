package com.didi.map.intl.commonwalkengine.impl.navbase;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.intl.commonwalkengine.IWalkEngine;
import com.map.global.nav.libc.common.Convertor;
import com.map.global.nav.libc.common.DMKEventPoint;
import com.map.global.nav.libc.common.DMKMatchResult;
import com.map.global.nav.libc.common.GeoPoint;
import com.map.global.nav.libc.common.RouteGuidanceGPSPoint;
import java.util.List;

public class NavBaseEngineImpl implements IWalkEngine {

    /* renamed from: a */
    private static final String f30278a = "NavBaseEngineImpl";

    /* renamed from: b */
    private static final int f30279b = 1;

    /* renamed from: c */
    private static final int f30280c = 3;

    /* renamed from: d */
    private static final int f30281d = 4;

    /* renamed from: e */
    private List<LatLng> f30282e;

    /* renamed from: f */
    private IWalkEngine.IWalkEngineEventCallback f30283f;

    /* renamed from: g */
    private NavBaseJniWrapper f30284g;

    /* renamed from: h */
    private DMKMatchResult f30285h;

    /* renamed from: i */
    private DMKEventPoint f30286i;

    /* renamed from: j */
    private MatchPointType f30287j = MatchPointType.UNKNOWN;

    /* renamed from: k */
    private RouteGuidanceGPSPoint f30288k;

    /* renamed from: l */
    private RouteGuidanceGPSPoint f30289l;

    /* renamed from: m */
    private RouteGuidanceGPSPoint f30290m;

    /* renamed from: n */
    private RouteGuidanceGPSPoint f30291n;

    /* renamed from: o */
    private long f30292o = 1000;

    public NavBaseEngineImpl() {
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
        this.f30288k = routeGuidanceGPSPoint;
        routeGuidanceGPSPoint.segmentIndex = -1;
        this.f30286i = new DMKEventPoint();
        this.f30285h = new DMKMatchResult();
    }

    public void destroy() {
        DLog.m10773d(f30278a, "destroy", new Object[0]);
        NavBaseJniWrapper navBaseJniWrapper = this.f30284g;
        if (navBaseJniWrapper != null) {
            navBaseJniWrapper.destroy();
            this.f30284g = null;
        }
        this.f30288k = null;
        this.f30289l = null;
        this.f30282e = null;
        this.f30286i = null;
    }

    public void setRoutePoints(List<LatLng> list) {
        DLog.m10773d(f30278a, " setRoutePoints", new Object[0]);
        this.f30282e = list;
        NavBaseJniWrapper navBaseJniWrapper = this.f30284g;
        if (navBaseJniWrapper != null) {
            navBaseJniWrapper.destroy();
            this.f30284g = null;
        }
        this.f30289l = null;
        this.f30291n = null;
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
        this.f30288k = routeGuidanceGPSPoint;
        routeGuidanceGPSPoint.segmentIndex = -1;
        if (list != null && list.size() > 1) {
            NavBaseJniWrapper navBaseJniWrapper2 = new NavBaseJniWrapper();
            this.f30284g = navBaseJniWrapper2;
            navBaseJniWrapper2.setRoutePoints(m23523a(list));
            this.f30284g.setNextRoutePoints((List<LatLng>) null);
        }
    }

    public void setRoutePoints(List<LatLng> list, int i) {
        if (list == null || list.size() <= 1 || list.size() <= i) {
            setRoutePoints(list);
            return;
        }
        setRoutePoints(list.subList(0, i));
        List<LatLng> subList = list.subList(i, list.size());
        NavBaseJniWrapper navBaseJniWrapper = this.f30284g;
        if (navBaseJniWrapper != null) {
            navBaseJniWrapper.setNextRoutePoints(subList);
        }
    }

    public void setWalkEngineEventCallback(IWalkEngine.IWalkEngineEventCallback iWalkEngineEventCallback) {
        this.f30283f = iWalkEngineEventCallback;
    }

    public int distanceLeft(RouteGuidanceGPSPoint routeGuidanceGPSPoint) {
        NavBaseJniWrapper navBaseJniWrapper = this.f30284g;
        if (navBaseJniWrapper != null) {
            return navBaseJniWrapper.distanceLeft(routeGuidanceGPSPoint);
        }
        return 0;
    }

    public int distanceLeft() {
        NavBaseJniWrapper navBaseJniWrapper = this.f30284g;
        if (navBaseJniWrapper != null) {
            return navBaseJniWrapper.distanceLeft2();
        }
        return 0;
    }

    public MatchPointType getMatchPointType() {
        DLog.m10773d(f30278a, "getMatchPointType = " + this.f30287j, new Object[0]);
        return this.f30287j;
    }

    public void setRequestIntervalInMills(int i) {
        this.f30292o = (long) i;
    }

    public RouteGuidanceGPSPoint getLastMatchGPSPoint() {
        return this.f30288k;
    }

    public void getMatchPoint(RouteGuidanceGPSPoint routeGuidanceGPSPoint) {
        this.f30290m = routeGuidanceGPSPoint;
        if (routeGuidanceGPSPoint == null) {
            this.f30287j = MatchPointType.UNKNOWN;
            DLog.m10773d(f30278a, "onMatchRoute gps is null", new Object[0]);
            m23521a(1);
            return;
        }
        DLog.m10773d(f30278a, "onRecvDriverLocation: %s ", routeGuidanceGPSPoint.toString());
        if (this.f30289l == null) {
            this.f30289l = this.f30290m.copy();
        }
        this.f30291n = this.f30290m;
        if (m23522a()) {
            m23524b();
            if (this.f30284g.isOutWay()) {
                IWalkEngine.IWalkEngineEventCallback iWalkEngineEventCallback = this.f30283f;
                if (iWalkEngineEventCallback != null) {
                    iWalkEngineEventCallback.onOffRoute();
                }
                m23521a(3);
                return;
            }
            m23521a(4);
            return;
        }
        m23521a(3);
    }

    /* renamed from: a */
    private boolean m23522a() {
        if (this.f30284g == null) {
            return false;
        }
        if (this.f30285h == null) {
            this.f30285h = new DMKMatchResult();
        }
        this.f30285h.resGpsFrequency = ((float) this.f30292o) / 1000.0f;
        RouteGuidanceGPSPoint matchResult = this.f30284g.matchResult(this.f30290m, this.f30285h);
        DMKMatchResult dMKMatchResult = this.f30285h;
        if (dMKMatchResult == null) {
            return false;
        }
        RouteGuidanceGPSPoint convertFromDMKGPSPoint = Convertor.convertFromDMKGPSPoint(dMKMatchResult.resMatchPoint);
        this.f30288k.point = convertFromDMKGPSPoint.point;
        this.f30288k.velocity = convertFromDMKGPSPoint.velocity;
        this.f30288k.timestamp = convertFromDMKGPSPoint.timestamp;
        this.f30288k.source = convertFromDMKGPSPoint.source;
        this.f30288k.shapeOffSet = convertFromDMKGPSPoint.shapeOffSet;
        this.f30288k.segmentIndex = convertFromDMKGPSPoint.segmentIndex;
        this.f30288k.matchedStatus = convertFromDMKGPSPoint.matchedStatus;
        this.f30288k.heading = convertFromDMKGPSPoint.heading;
        this.f30288k.accuracy = convertFromDMKGPSPoint.accuracy;
        if (matchResult != null) {
            this.f30288k.originMatchPoint = matchResult.originMatchPoint;
        }
        this.f30287j = MatchPointType.valueOf(this.f30285h.resPointType);
        this.f30286i = this.f30285h.resEventPoint;
        return true;
    }

    /* renamed from: a */
    private void m23521a(int i) {
        DLog.m10773d(f30278a, "doInertiaNavi, matchType:" + i, new Object[0]);
        if (i == 4) {
            RouteGuidanceGPSPoint routeGuidanceGPSPoint = this.f30288k;
            if (routeGuidanceGPSPoint != null) {
                this.f30289l = routeGuidanceGPSPoint.copy();
            }
        } else {
            RouteGuidanceGPSPoint routeGuidanceGPSPoint2 = this.f30290m;
            if (routeGuidanceGPSPoint2 != null) {
                RouteGuidanceGPSPoint copy = routeGuidanceGPSPoint2.copy();
                this.f30289l = copy;
                copy.segmentIndex = -1;
            }
        }
        RouteGuidanceGPSPoint routeGuidanceGPSPoint3 = this.f30289l;
        if (routeGuidanceGPSPoint3 != null && routeGuidanceGPSPoint3.point != null) {
            LatLng latLng = new LatLng(((double) this.f30289l.point.getLatitudeE6()) / 1000000.0d, ((double) this.f30289l.point.getLongitudeE6()) / 1000000.0d);
            IWalkEngine.IWalkEngineEventCallback iWalkEngineEventCallback = this.f30283f;
            if (iWalkEngineEventCallback != null) {
                iWalkEngineEventCallback.onMatched(latLng, this.f30289l.segmentIndex, this.f30289l.shapeOffSet, 0, 0, this.f30286i);
            }
        }
    }

    /* renamed from: b */
    private void m23524b() {
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = this.f30288k;
        if (routeGuidanceGPSPoint != null && routeGuidanceGPSPoint.segmentIndex > -1 && this.f30282e != null && this.f30288k.segmentIndex < this.f30282e.size()) {
            double computeDistanceBetween = ((double) this.f30288k.shapeOffSet) / DDSphericalUtil.computeDistanceBetween(this.f30282e.get(this.f30288k.segmentIndex), this.f30282e.get(this.f30288k.segmentIndex + 1));
            if (computeDistanceBetween > 0.0d && computeDistanceBetween < 1.0d) {
                LatLng interpolate = DDSphericalUtil.interpolate(this.f30282e.get(this.f30288k.segmentIndex), this.f30282e.get(this.f30288k.segmentIndex + 1), computeDistanceBetween);
                this.f30288k.point = new GeoPoint((int) (interpolate.latitude * 1000000.0d), (int) (interpolate.longitude * 1000000.0d));
            }
        }
    }

    /* renamed from: a */
    private GeoPoint[] m23523a(List<LatLng> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        int size = list.size();
        GeoPoint[] geoPointArr = new GeoPoint[size];
        for (int i = 0; i < size; i++) {
            GeoPoint geoPoint = new GeoPoint();
            geoPoint.setLatitudeE6((int) (list.get(i).latitude * 1000000.0d));
            geoPoint.setLongitudeE6((int) (list.get(i).longitude * 1000000.0d));
            geoPointArr[i] = geoPoint;
        }
        return geoPointArr;
    }
}
