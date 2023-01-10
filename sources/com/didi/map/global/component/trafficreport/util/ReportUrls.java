package com.didi.map.global.component.trafficreport.util;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class ReportUrls {

    /* renamed from: a */
    private static String f28623a = "/event/elements/";

    /* renamed from: b */
    private static String f28624b = "/event/report/";

    /* renamed from: c */
    private static String f28625c = "/event/history/";

    /* renamed from: d */
    private static String f28626d = "https://apimap.didiglobal.com";

    /* renamed from: e */
    private static String f28627e = "https://apimap.didiglobal.com/preus";

    public static String getEventUrl() {
        IToggle toggle = Apollo.getToggle("global_passenger_route_url_toggle");
        if (toggle == null || !toggle.allow()) {
            return f28626d + f28623a;
        }
        return ((String) toggle.getExperiment().getParam("traffic_event_show_url_host", f28626d)) + f28623a;
    }

    public static String getReportUrl() {
        IToggle toggle = Apollo.getToggle("global_passenger_route_url_toggle");
        if (toggle == null || !toggle.allow()) {
            return f28626d + f28624b;
        }
        return ((String) toggle.getExperiment().getParam("traffic_event_show_url_host", f28626d)) + f28624b;
    }

    public static String getHistoryUrl() {
        IToggle toggle = Apollo.getToggle("global_passenger_route_url_toggle");
        if (toggle == null || !toggle.allow()) {
            return f28626d + f28625c;
        }
        return ((String) toggle.getExperiment().getParam("traffic_event_show_url_host", f28626d)) + f28625c;
    }
}
