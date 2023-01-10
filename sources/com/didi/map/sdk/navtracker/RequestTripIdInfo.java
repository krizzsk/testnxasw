package com.didi.map.sdk.navtracker;

import com.didi.map.sdk.proto.driver_gl.OidPidPair;
import java.util.List;

public class RequestTripIdInfo {
    public static final String API_NAME_DYNAMIC_STREET_VIEW = "DynamicStreetView";
    public static final String API_NAME_NAV_SDK = "GoogleNavSDK";
    public static final String API_NAME_STATIC_STREET_VIEW = "StaticStreetView";

    /* renamed from: a */
    private List<OidPidPair> f31006a;

    /* renamed from: b */
    private String f31007b;

    /* renamed from: c */
    private String f31008c;

    /* renamed from: d */
    private String f31009d;

    public @interface Scenes {
        public static final String DYNAMIC_STREET_VIEW = "DynamicStreetView";
        public static final String HOMEPAGE = "GoogleNavSDK_homepage";
        public static final String ONTRIP = "GoogleNavSDK_ontrip";
        public static final String PICKUP = "GoogleNavSDK_pickup";
        public static final String SODA = "GoogleNavSDK_soda";
        public static final String STATIC_STREET_VIEW = "StaticStreetView";
    }

    public RequestTripIdInfo(String str, String str2, List<OidPidPair> list) {
        this(str, str2, list, API_NAME_NAV_SDK);
    }

    public RequestTripIdInfo(String str, String str2, List<OidPidPair> list, String str3) {
        this.f31008c = str;
        this.f31007b = str2;
        this.f31006a = list;
        this.f31009d = str3;
    }

    public String getTicket() {
        return this.f31007b;
    }

    public List<OidPidPair> getOidPidPairList() {
        return this.f31006a;
    }

    public String getScenes() {
        return this.f31008c;
    }

    public String getApiName() {
        return this.f31009d;
    }
}
