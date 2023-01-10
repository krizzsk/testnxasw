package com.didi.map.constant;

import com.didi.map.common.ApolloHawaii;

public class NavUrls {
    public static final String DiDiDolphinUrl;
    public static final String DiDiDolphinUrlForBasic;
    public static String DiDiDrawLineRequesturl = (f26956b + "/navi/drawline/");
    public static final String DiDiVecEnlargeUrl = (f26956b + "/v1/DynamicEnLargePic");
    public static final String DidiDolphinTrafficUrl;
    public static final String DidiDriverRouteRequestUrl = (f26956b + "/navi/v1/driver/orderroute/");
    public static final String DidiPassengerRouteRequestUrl = (f26956b + "/navi/v1/passenger/orderroute/");
    public static final String DidiPassengerRouteUrl = (f26956b + "/navi/v1/route/");
    public static final String DidiPassengerTrafficUrl = (f26956b + "/navi/v1/traffic/");
    public static final String DidiRouteUrl = (f26956b + "/navi/v1/driver/didiroute/");
    public static final String DidiSameRouteRequestUrl = (f26956b + "/navi/v1/driver/orderroute/consistency/");
    public static final String DidiSelfDriveForHotMapUrl = (f26956b + "/navi/v1/driver/order/didiroute/");
    public static final String DidiSelfDriveUrl = (f26956b + "/map/navi/");

    /* renamed from: a */
    private static final String f26955a = "http://apimap.didiglobal.com";

    /* renamed from: b */
    private static String f26956b = "https://apimap.didiglobal.com";

    /* renamed from: c */
    private static String f26957c = "https://apimap.didiglobal.com";

    static {
        if (ApolloHawaii.isUseTestUrl()) {
            String testUrlIP = ApolloHawaii.getTestUrlIP();
            if (testUrlIP.equals("")) {
                f26956b = "https://apimap.didiglobal.com";
                f26957c = "https://apimap.didiglobal.com";
            } else if (testUrlIP.startsWith("https")) {
                f26956b = ApolloHawaii.getTestUrlIP();
                f26957c = ApolloHawaii.getTestUrlIP();
            } else {
                f26956b = ApolloHawaii.getTestUrlIP();
                f26957c = ApolloHawaii.getTestUrlIP();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ApolloHawaii.useDolphinHost() ? f26957c : f26956b);
        sb.append("/navi/v2/traffic");
        DidiDolphinTrafficUrl = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(ApolloHawaii.useDolphinHost() ? f26957c : f26956b);
        sb2.append("/navi/v2/selfdriving");
        DiDiDolphinUrl = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(ApolloHawaii.useDolphinHost() ? f26957c : f26956b);
        sb3.append("/navi/v2/selfdriving/routeview");
        DiDiDolphinUrlForBasic = sb3.toString();
    }
}
