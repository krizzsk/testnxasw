package com.didi.rlab.uni_foundation.map;

import com.didi.rlab.uni_foundation.heatmap.MapLineOptions;
import com.didi.rlab.uni_foundation.uniapi.UniModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapServiceTripModel extends UniModel {

    /* renamed from: a */
    private String f36836a;

    /* renamed from: b */
    private String f36837b;

    /* renamed from: c */
    private boolean f36838c;

    /* renamed from: d */
    private MapLineOptions f36839d;

    /* renamed from: e */
    private MapLineOptions f36840e;

    /* renamed from: f */
    private MapLineOptions f36841f;

    /* renamed from: g */
    private List<MapServiceTripPoiDataModel> f36842g;

    public String getOrderId() {
        return this.f36836a;
    }

    public void setOrderId(String str) {
        this.f36836a = str;
    }

    public String getUid() {
        return this.f36837b;
    }

    public void setUid(String str) {
        this.f36837b = str;
    }

    public boolean getIsShowOtherRoute() {
        return this.f36838c;
    }

    public void setIsShowOtherRoute(boolean z) {
        this.f36838c = z;
    }

    public MapLineOptions getCurrentRouteOptions() {
        return this.f36839d;
    }

    public void setCurrentRouteOptions(MapLineOptions mapLineOptions) {
        this.f36839d = mapLineOptions;
    }

    public MapLineOptions getOtherRouteOptions() {
        return this.f36840e;
    }

    public void setOtherRouteOptions(MapLineOptions mapLineOptions) {
        this.f36840e = mapLineOptions;
    }

    public MapLineOptions getWalkRouteOptions() {
        return this.f36841f;
    }

    public void setWalkRouteOptions(MapLineOptions mapLineOptions) {
        this.f36841f = mapLineOptions;
    }

    public List<MapServiceTripPoiDataModel> getAfterList() {
        return this.f36842g;
    }

    public void setAfterList(List<MapServiceTripPoiDataModel> list) {
        this.f36842g = list;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("orderId", this.f36836a);
        hashMap.put("uid", this.f36837b);
        hashMap.put("isShowOtherRoute", Boolean.valueOf(this.f36838c));
        MapLineOptions mapLineOptions = this.f36839d;
        if (mapLineOptions != null) {
            hashMap.put("currentRouteOptions", mapLineOptions.toMap());
        }
        MapLineOptions mapLineOptions2 = this.f36840e;
        if (mapLineOptions2 != null) {
            hashMap.put("otherRouteOptions", mapLineOptions2.toMap());
        }
        MapLineOptions mapLineOptions3 = this.f36841f;
        if (mapLineOptions3 != null) {
            hashMap.put("walkRouteOptions", mapLineOptions3.toMap());
        }
        hashMap.put("afterList", map(this.f36842g, $$Lambda$MapServiceTripModel$ERXzhCi8cBy9i5BU2cRfScS6yWk.INSTANCE));
        return hashMap;
    }

    public static MapServiceTripModel fromMap(Map<String, Object> map) {
        MapServiceTripModel mapServiceTripModel = new MapServiceTripModel();
        String str = "";
        mapServiceTripModel.f36836a = (!map.containsKey("orderId") || map.get("orderId") == null) ? str : (String) map.get("orderId");
        if (map.containsKey("uid") && map.get("uid") != null) {
            str = (String) map.get("uid");
        }
        mapServiceTripModel.f36837b = str;
        mapServiceTripModel.f36838c = (!map.containsKey("isShowOtherRoute") || map.get("isShowOtherRoute") == null) ? false : ((Boolean) map.get("isShowOtherRoute")).booleanValue();
        MapLineOptions mapLineOptions = null;
        mapServiceTripModel.f36839d = (!map.containsKey("currentRouteOptions") || map.get("currentRouteOptions") == null) ? null : MapLineOptions.fromMap((Map) map.get("currentRouteOptions"));
        mapServiceTripModel.f36840e = (!map.containsKey("otherRouteOptions") || map.get("otherRouteOptions") == null) ? null : MapLineOptions.fromMap((Map) map.get("otherRouteOptions"));
        if (map.containsKey("walkRouteOptions") && map.get("walkRouteOptions") != null) {
            mapLineOptions = MapLineOptions.fromMap((Map) map.get("walkRouteOptions"));
        }
        mapServiceTripModel.f36841f = mapLineOptions;
        mapServiceTripModel.f36842g = (!map.containsKey("afterList") || map.get("afterList") == null) ? new ArrayList<>() : map((List) map.get("afterList"), $$Lambda$MapServiceTripModel$x69pL2G613ZkfYvqm8U9k4Zk3dQ.INSTANCE);
        return mapServiceTripModel;
    }
}
