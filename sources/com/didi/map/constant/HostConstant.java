package com.didi.map.constant;

import com.didi.map.common.ApolloHawaii;
import com.didi.map.common.utils.SystemUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class HostConstant {
    public static final String HTTP_TYPE = "https";
    public static boolean ISENCRYPT = true;
    public static final String NAV_PARAM = "?token=9TXfYfnWeiMyJK2r3Y&q=test&strategy=2&fm=1";

    /* renamed from: a */
    private static final boolean f26945a = false;

    /* renamed from: b */
    private static String f26946b = "https://apimap.didiglobal.com";

    /* renamed from: c */
    private static final String f26947c = "apimap.didiglobal.com";

    /* renamed from: d */
    private static final String f26948d = "apimap.didiglobal.com";

    /* renamed from: e */
    private static final String f26949e = "http://apimap.didiglobal.com";

    /* renamed from: f */
    private static String f26950f = "/navi/v1/driver/didiroute/";

    /* renamed from: g */
    private static String f26951g = "/navi/v1/driver/didiroute/";

    /* renamed from: h */
    private static final String f26952h = "/navi/v1/driver/didiroute/";

    /* renamed from: i */
    private static String f26953i = null;

    /* renamed from: j */
    private static final String f26954j = "/mapserver/map_3d/?";

    public static final String getHostUrlForTrafficEvent() {
        return "http://apimap.didiglobal.com";
    }

    public static final String getTRAFFIC_URL() {
        return "https://trafficrenderapi.apimap.didiglobal.com/render?";
    }

    /* renamed from: a */
    private static final String m21245a() {
        if (ApolloHawaii.isMapUseTestUrl()) {
        }
        return "apimap.didiglobal.com";
    }

    public static final String getHOST_URL() {
        if (ApolloHawaii.isMapUseTestUrl()) {
        }
        return "https://apimap.didiglobal.com";
    }

    public static final String getROUTE_SERVER() {
        return f26950f;
    }

    public static String getVersion() {
        if (f26953i == null) {
            f26953i = "userid=DIDI-MAPSDK&pf=Android&ver=0.1.4.5766&imei=" + SystemUtil.obtainIMei();
        }
        return f26953i;
    }

    /* renamed from: b */
    private static String m21246b() {
        return "&attime=" + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
    }

    public static final String getCONFIG_UPDATE_URL() {
        return getHOST_URL() + "/map/dds/update?" + getVersion();
    }

    public static final String getDownMapUrl() {
        return getMapHOST() + "/mapserver/map_3d/?";
    }

    public static final String getMapHOST() {
        String mapSdkUrl = ApolloHawaii.getMapSdkUrl();
        if (mapSdkUrl.equals("")) {
            mapSdkUrl = m21245a();
        }
        if (mapSdkUrl.equals("apimap.didiglobal.com")) {
            return "https://" + mapSdkUrl + "/test";
        }
        return "https://" + mapSdkUrl;
    }

    public static String getURL_ROUTE_SERVER() {
        return getHOST_URL() + getROUTE_SERVER();
    }

    public static String getDisplayTrafficUrl() {
        return getTRAFFIC_URL() + getVersion() + m21246b();
    }

    public static String getTrafficEventUrl() {
        return getHOST_URL() + "/traffic/event?" + getVersion();
    }

    public static String getTwilightUrl() {
        return ApolloHawaii.isUseTestUrl() ? "https://apimap.didiglobal.com/02/navi-conf/v1/weather/sunrise_sunset" : "https://apimap.didiglobal.com/navi-conf/v1/weather/sunrise_sunset";
    }
}
