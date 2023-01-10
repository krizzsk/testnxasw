package com.dmap.navigation.engine.p207a;

import com.dmap.navigation.api.core.INaviPlanner;
import com.dmap.navigation.api.core.INaviPlannerBuilder;
import com.dmap.navigation.api.core.INormalNaviAPI;
import com.dmap.navigation.api.route.IRouteEx;
import com.dmap.navigation.base.ctx.INaviContext;
import com.dmap.navigation.base.location.INaviLocation;
import com.dmap.navigation.base.route.IRoute;
import com.dmap.navigation.jni.sub.BindNaviLocationNative;
import com.dmap.navigation.jni.sub.NaviPoiListNative;
import com.dmap.navigation.jni.sub.NaviPoiNative;
import com.dmap.navigation.jni.swig.FirstRetryStrategy;
import com.dmap.navigation.jni.swig.NaviBusinessBridge;
import com.dmap.navigation.jni.swig.NaviOption;
import com.dmap.navigation.jni.swig.NormalNaviAPI;
import com.dmap.navigation.jni.swig.ReqRouteInfo;
import com.dmap.navigation.jni.swig.RetryStrategy;
import com.dmap.navigation.jni.swig.UserInfo;

/* renamed from: com.dmap.navigation.engine.a.b */
/* compiled from: NormalNaviAPIImpl */
public final class C18163b extends C18154a<NormalNaviAPI> implements INaviPlanner, INormalNaviAPI {
    public C18163b(INaviContext iNaviContext) {
        super(iNaviContext, new NormalNaviAPI((UserInfo) iNaviContext.getUserInfo(), (NaviOption) iNaviContext.getNaviOption()));
    }

    public final INaviPlannerBuilder extremeSpeedRoute(IRoute iRoute, INaviLocation iNaviLocation, int i, INaviLocation iNaviLocation2, int i2) {
        this.f54275a.setEventType(NaviBusinessBridge.getAPI_EXTREME_SPEED_ROUTE());
        m40450a(iRoute, iNaviLocation, i, iNaviLocation2, i2);
        return this;
    }

    public final INaviPlannerBuilder preferenceRoute(IRoute iRoute, INaviLocation iNaviLocation, int i, INaviLocation iNaviLocation2, int i2) {
        this.f54275a.setEventType(NaviBusinessBridge.getAPI_PREFERENCE_ROUTE());
        m40450a(iRoute, iNaviLocation, i, iNaviLocation2, i2);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final RetryStrategy mo131841a(int i) {
        if (i == NaviBusinessBridge.getAPI_EXTREME_SPEED_ROUTE() || i == NaviBusinessBridge.getAPI_PREFERENCE_ROUTE()) {
            return new FirstRetryStrategy();
        }
        return super.mo131841a(i);
    }

    /* renamed from: a */
    private void m40450a(IRoute iRoute, INaviLocation iNaviLocation, int i, INaviLocation iNaviLocation2, int i2) {
        IRouteEx iRouteEx = (IRouteEx) iRoute;
        this.f54275a.setStart(new NaviPoiNative(iRouteEx.getStart()));
        this.f54275a.setEnd(new NaviPoiNative(iRouteEx.getEnd()));
        this.f54275a.setPassPoints(new NaviPoiListNative(iRouteEx.getOriginalPassPoints()));
        this.f54275a.setCurrentBindPoint(new BindNaviLocationNative(iNaviLocation, i));
        this.f54275a.setLastBindPoint(new BindNaviLocationNative(iNaviLocation2, i2));
        ReqRouteInfo reqRouteInfo = new ReqRouteInfo();
        reqRouteInfo.setLastRouteId(iRoute.getRouteId());
        reqRouteInfo.setPassfork(0);
        this.f54275a.setCurrentRoute(reqRouteInfo);
    }
}
