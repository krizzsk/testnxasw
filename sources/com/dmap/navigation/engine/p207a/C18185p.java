package com.dmap.navigation.engine.p207a;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.base.ctx.INaviContext;
import com.dmap.navigation.base.location.INaviLocation;
import com.dmap.navigation.engine.core.INaviEngineVP;
import com.dmap.navigation.jni.sub.NaviLatLngNative;
import com.dmap.navigation.jni.sub.NaviLocationNative;
import com.dmap.navigation.jni.swig.BindNaviLocation;
import com.dmap.navigation.jni.swig.NaviEngineVP;
import com.dmap.navigation.jni.swig.NaviLatLngList;
import com.dmap.navigation.jni.swig.NaviOption;
import java.util.List;

/* renamed from: com.dmap.navigation.engine.a.p */
/* compiled from: NaviEngineVPImpl */
public final class C18185p implements INaviEngineVP {

    /* renamed from: a */
    private final NaviEngineVP f54386a = new NaviEngineVP();

    /* renamed from: b */
    private INaviContext f54387b;

    public C18185p(INaviContext iNaviContext) {
        this.f54387b = iNaviContext;
    }

    public final void init() {
        this.f54386a.init((NaviOption) this.f54387b.getNaviOption());
    }

    public final void setRoutePoints(List<LatLng> list) {
        NaviLatLngList naviLatLngList = new NaviLatLngList();
        if (list != null) {
            for (LatLng next : list) {
                naviLatLngList.add(new NaviLatLngNative(next.latitude, next.longitude));
            }
        }
        this.f54386a.setRoutePoints(naviLatLngList);
    }

    public final void destory() {
        this.f54386a.destory();
    }

    public final BindNaviLocation getMatchLocation(INaviLocation iNaviLocation) {
        return this.f54386a.getMatchLocation(new NaviLocationNative(iNaviLocation));
    }
}
