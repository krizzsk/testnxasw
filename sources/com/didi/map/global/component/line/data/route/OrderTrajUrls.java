package com.didi.map.global.component.line.data.route;

import android.content.Context;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;

public class OrderTrajUrls {

    /* renamed from: a */
    private static final String f28097a = "https://apimap.didiglobal.com";

    /* renamed from: b */
    private static final String f28098b = "https://apimap.liggyglobal.com";

    /* renamed from: c */
    private static final String f28099c = "/navi/v1/ordertraj/";

    /* renamed from: d */
    private static final String f28100d = "com.linkee.global";

    /* renamed from: e */
    private static String f28101e = "https://apimap.didiglobal.com";

    public static String getOrderTrajUrl(Context context) {
        IToggle toggle = Apollo.getToggle("global_passenger_route_url_toggle");
        if (toggle != null && toggle.allow()) {
            IExperiment experiment = toggle.getExperiment();
            return ((String) experiment.getParam("order_traj_host", "https://apimap.didiglobal.com")) + ((String) experiment.getParam("order_traj_path", f28099c));
        } else if (m22088a(context)) {
            return "https://apimap.liggyglobal.com/navi/v1/ordertraj/";
        } else {
            return f28101e + f28099c;
        }
    }

    public static void setOrderTrajHost(String str) {
        f28101e = str;
    }

    /* renamed from: a */
    private static boolean m22088a(Context context) {
        return f28100d.equals(m22089b(context));
    }

    /* renamed from: b */
    private static String m22089b(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return null;
        }
        return context.getApplicationContext().getPackageName();
    }

    public static String getUrlHost(Context context) {
        return m22088a(context) ? f28098b : "https://apimap.didiglobal.com";
    }
}
