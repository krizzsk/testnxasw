package com.didi.travel.psnger.p171v2.host;

import android.text.TextUtils;
import com.didi.travel.psnger.IHostConfig;

/* renamed from: com.didi.travel.psnger.v2.host.HostManager */
public class HostManager {
    public static final String DEFAULT_BIZ_HOST = "https://api.didiglobal.com/";
    public static final String DEFAULT_CAR_SLIDING_HOST = "https://common.didiglobal.com/";
    public static final String DEFAULT_ENTERPRISE_PAY_HOST = "https://esapi.didiglobal.com/";
    public static final String DEFAULT_RESOURCES_HOST = "https://api.didiglobal.com/";
    public static final String DEFAULT_ROUTE_TRACK_HOST = "https://common.didiglobal.com/";
    public static final String HOST_KEY_BIZ = "host_key_biz";
    public static final String HOST_KEY_CAR_SLIDING = "host_key_car_sliding";
    public static final String HOST_KEY_ENTERPRISE_PAY = "host_key_enterprise_pay";
    public static final String HOST_KEY_RESOURCES = "host_key_resources";
    public static final String HOST_KEY_ROUTE = "host_key_route";
    public static final String SHARE_PATH_BIZ_V1 = "gulfstream/api/v1/";
    public static final String SHARE_PATH_BIZ_V2 = "gulfstream/passenger/v2/";
    public static final String SHARE_PATH_ENTERPRISE_PAY = "crius/";
    public static final String SHARE_PATH_EVALUATE = "gulfstream/";

    /* renamed from: a */
    private static String f46911a = "https://api.didiglobal.com/";

    /* renamed from: b */
    private static String f46912b = null;

    /* renamed from: c */
    private static String f46913c = "https://common.didiglobal.com/";

    /* renamed from: d */
    private static String f46914d = "https://api.didiglobal.com/";

    /* renamed from: e */
    private static String f46915e = "https://api.didiglobal.com/";

    /* renamed from: f */
    private static String f46916f = "https://esapi.didiglobal.com/";

    public static void setHostConfig(IHostConfig iHostConfig) {
        if (iHostConfig != null) {
            if (!TextUtils.isEmpty(iHostConfig.businessHost())) {
                f46911a = iHostConfig.businessHost();
            }
            if (!TextUtils.isEmpty(iHostConfig.evaluateHost())) {
                f46912b = iHostConfig.evaluateHost();
            }
            if (!TextUtils.isEmpty(iHostConfig.carSlidingHost())) {
                f46913c = iHostConfig.carSlidingHost();
            }
            if (!TextUtils.isEmpty(iHostConfig.activityHost())) {
                f46914d = iHostConfig.activityHost();
            }
            if (!TextUtils.isEmpty(iHostConfig.routeTrackHost())) {
                f46915e = iHostConfig.routeTrackHost();
            }
            if (!TextUtils.isEmpty(iHostConfig.enterprisePayHost())) {
                f46916f = iHostConfig.enterprisePayHost();
            }
        }
    }

    public static String getBizHost() {
        return f46911a;
    }

    public static String getCarSlidingHost() {
        return f46913c;
    }

    public static String getResourcesHost() {
        return f46914d;
    }

    public static String getRouteHost() {
        return f46915e;
    }

    public static String getEnterprisePayHost() {
        return f46916f;
    }
}
