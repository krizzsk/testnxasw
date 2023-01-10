package com.dmap.navigation.engine.p207a;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.api.route.IRouteTag;
import com.dmap.navigation.jni.swig.NaviRouteTag;
import com.dmap.navigation.simple.SimpleLatlng;

/* renamed from: com.dmap.navigation.engine.a.h */
/* compiled from: SimpleRouteTag */
public final class C18175h implements IRouteTag {

    /* renamed from: a */
    private String f54351a;

    /* renamed from: b */
    private String f54352b;

    /* renamed from: c */
    private LatLng f54353c;

    public C18175h(NaviRouteTag naviRouteTag) {
        this.f54351a = naviRouteTag.getKey();
        this.f54352b = naviRouteTag.getValue();
        this.f54353c = new SimpleLatlng(naviRouteTag.getPosition().getLat(), naviRouteTag.getPosition().getLng());
    }

    public final String toString() {
        return "SimpleRouteTag{key='" + this.f54351a + '\'' + ", value='" + this.f54352b + '\'' + ", position=" + this.f54353c + '}';
    }

    public final String getKey() {
        return this.f54351a;
    }

    public final String getValue() {
        return this.f54352b;
    }

    public final LatLng getPosition() {
        return this.f54353c;
    }
}
