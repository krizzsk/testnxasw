package com.didi.map.sdk.sharetrack.google.inner.model;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.map.sdk.sharetrack.delegate.IEventHandler;
import com.didi.map.sdk.sharetrack.entity.NaviRoute;
import com.didi.map.sdk.sharetrack.entity.OrderPoint;
import com.didi.map.sdk.sharetrack.entity.RouteEvent;
import com.didi.map.sdk.sharetrack.google.inner.utils.ApolloUtils;
import com.didi.map.sdk.sharetrack.logger.DLog;
import java.util.List;

public class RouteUnreachableHandler implements IEventHandler<RouteEvent> {

    /* renamed from: a */
    private static final String f31283a = "RouteUnreachable";

    /* renamed from: b */
    private int f31284b;

    public boolean dispatchEvent(RouteEvent routeEvent) {
        if (routeEvent == null) {
            DLog.m23962d(f31283a, "InterceptEvent eventMode is null", new Object[0]);
            return false;
        } else if (routeEvent.getNavRoute() != null) {
            return !onInterceptEvent(routeEvent);
        } else {
            DLog.m23962d(f31283a, "InterceptEvent NavRoute is null", new Object[0]);
            return false;
        }
    }

    public boolean onInterceptEvent(RouteEvent routeEvent) {
        if (!ApolloUtils.getBERTtsEnable() || ApolloUtils.getBERTtsEda() <= routeEvent.getEdaMeter()) {
            return true;
        }
        int bERTtsDistance = ApolloUtils.getBERTtsDistance();
        int a = m23933a(routeEvent.getNavRoute(), routeEvent.getWayList(), routeEvent.getPickUpPoint());
        this.f31284b = a;
        if (bERTtsDistance >= a) {
            return true;
        }
        return false;
    }

    public int getCurUnreachableDis() {
        return this.f31284b;
    }

    /* renamed from: a */
    private int m23933a(NaviRoute naviRoute, List<OrderPoint> list, LatLng latLng) {
        LatLng latLng2;
        if (naviRoute == null) {
            return 0;
        }
        int dstRouteGeoIndex = naviRoute.getDstRouteGeoIndex();
        List<LatLng> routePoints = naviRoute.getRoutePoints();
        if (dstRouteGeoIndex < 0 || dstRouteGeoIndex >= routePoints.size() || list == null || list.size() <= 0) {
            latLng2 = routePoints.get(routePoints.size() - 1);
        } else {
            latLng2 = routePoints.get(dstRouteGeoIndex);
            latLng = list.get(0).point;
        }
        return (int) DDSphericalUtil.computeDistanceBetween(latLng2, latLng);
    }
}
