package com.didichuxing.routesearchsdk;

import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;

public class RouteSearchUrls {

    /* renamed from: a */
    private static final String f51094a = "/navi/v1/routeplan/";

    /* renamed from: b */
    private static final String f51095b = "/navi/v1/multirouteplan/";

    /* renamed from: c */
    private static final String f51096c = "/bubblepage/";

    /* renamed from: d */
    private static final String f51097d = "/navi/v1/order/walking/";

    /* renamed from: e */
    private static String f51098e = "https://apimap.didiglobal.com";

    /* renamed from: f */
    private static String f51099f = "/preus/bubblepage/";

    public static void setHostGlobal(String str) {
        if (!TextUtils.isEmpty(str)) {
            f51098e = str;
        }
    }

    public static String getRoutePlanUrl() {
        IToggle toggle = Apollo.getToggle("global_passenger_route_url_toggle");
        if (toggle == null || !toggle.allow()) {
            return f51098e + f51094a;
        }
        IExperiment experiment = toggle.getExperiment();
        return ((String) experiment.getParam("rp_url_host", f51098e)) + ((String) experiment.getParam("rp_url_path", f51094a));
    }

    public static String getMultiRoutePlanUrl() {
        IToggle toggle = Apollo.getToggle("global_passenger_route_url_toggle");
        if (toggle == null || !toggle.allow()) {
            return f51098e + f51095b;
        }
        IExperiment experiment = toggle.getExperiment();
        return ((String) experiment.getParam("multi_rp_host", f51098e)) + ((String) experiment.getParam("multi_rp_path", f51095b));
    }

    public static String getBubblePageRouteSearchUrl() {
        IToggle toggle = Apollo.getToggle("global_passenger_route_url_toggle");
        if (toggle == null || !toggle.allow()) {
            return f51098e + f51096c;
        }
        IExperiment experiment = toggle.getExperiment();
        return ((String) experiment.getParam("bubpage_host", f51098e)) + ((String) experiment.getParam("bubpage_path", f51096c));
    }

    public static String getWalkNavRouteUrl() {
        IToggle toggle = Apollo.getToggle("global_passenger_route_url_toggle");
        if (toggle == null || !toggle.allow()) {
            return f51098e + f51097d;
        }
        return ((String) toggle.getExperiment().getParam("order_walk_ora_host", f51098e)) + f51097d;
    }
}
