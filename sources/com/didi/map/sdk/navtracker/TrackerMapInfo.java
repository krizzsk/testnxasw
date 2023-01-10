package com.didi.map.sdk.navtracker;

import com.google.gson.annotations.SerializedName;

public class TrackerMapInfo {
    @SerializedName("app_name")
    public String appName;
    @SerializedName("app_version")
    public String appVersion = "";
    @SerializedName("country_code")
    public String countryCode = "";
    @SerializedName("dt")

    /* renamed from: dt */
    public String f31011dt = String.valueOf(System.currentTimeMillis() / 1000);
    @SerializedName("map_id")
    public String mapId;
    @SerializedName("os")

    /* renamed from: os */
    public String f31012os = "1";
    @SerializedName("phone_num")
    public String phoneNumber = "";
    @SerializedName("user_id")
    public String userId = "";

    public String toString() {
        return String.format("map_info|dt:%s, mapId:%s, os:%s, appName:%s", new Object[]{this.f31011dt, this.mapId, this.f31012os, this.appName});
    }
}
