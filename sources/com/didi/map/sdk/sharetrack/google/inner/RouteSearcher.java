package com.didi.map.sdk.sharetrack.google.inner;

import android.content.Context;
import com.didi.map.sdk.sharetrack.callback.ISearchRouteCallback;
import com.didi.map.sdk.sharetrack.common.NetUtils;
import com.didi.map.sdk.sharetrack.entity.OrderInfo;
import com.didi.map.sdk.sharetrack.entity.RouteSearchOptions;
import com.didi.map.sdk.sharetrack.google.inner.net.NormalRouteFetcherV2;
import com.didichuxing.routesearchsdk.CallFrom;

public class RouteSearcher {

    /* renamed from: a */
    private static final String f31267a = "RouteSearcher";

    /* renamed from: b */
    private Context f31268b;

    /* renamed from: c */
    private NormalRouteFetcherV2 f31269c;

    /* renamed from: d */
    private OrderInfo f31270d;

    /* renamed from: e */
    private CallFrom f31271e = CallFrom.UNKNOWN;

    public void stop() {
    }

    public RouteSearcher(Context context) {
        NetUtils.init(context);
        this.f31268b = context;
        this.f31269c = new NormalRouteFetcherV2(context);
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.f31270d = orderInfo;
    }

    public void calculateRoute(RouteSearchOptions routeSearchOptions, ISearchRouteCallback iSearchRouteCallback) {
        NormalRouteFetcherV2 normalRouteFetcherV2;
        if (routeSearchOptions != null && (normalRouteFetcherV2 = this.f31269c) != null) {
            normalRouteFetcherV2.setOrderInfo(this.f31270d);
            this.f31269c.setCaller(this.f31271e);
            this.f31269c.calculateRoute(routeSearchOptions, iSearchRouteCallback);
        }
    }

    public void destroy() {
        stop();
        this.f31269c = null;
    }

    public void setCaller(CallFrom callFrom) {
        if (callFrom != null) {
            this.f31271e = callFrom;
        }
    }
}
