package com.didi.map.sdk.sharetrack.entity;

import com.didi.common.map.model.LatLng;
import java.util.List;

public class RouteEvent {

    /* renamed from: a */
    private NaviRoute f31106a;

    /* renamed from: b */
    private int f31107b;

    /* renamed from: c */
    private int f31108c;

    /* renamed from: d */
    private List<OrderPoint> f31109d;

    /* renamed from: e */
    private LatLng f31110e;

    public void updateRoute(NaviRoute naviRoute) {
        this.f31106a = naviRoute;
    }

    public void setPickUpPoint(LatLng latLng) {
        this.f31110e = latLng;
    }

    public LatLng getPickUpPoint() {
        return this.f31110e;
    }

    public void setWayList(List<OrderPoint> list) {
        this.f31109d = list;
    }

    public List<OrderPoint> getWayList() {
        return this.f31109d;
    }

    public void updateEdaEta(int i, int i2) {
        this.f31107b = i;
        this.f31108c = i2;
    }

    public NaviRoute getNavRoute() {
        return this.f31106a;
    }

    public int getEdaMeter() {
        return this.f31107b;
    }

    public int getEtaMinutes() {
        return this.f31108c;
    }
}
