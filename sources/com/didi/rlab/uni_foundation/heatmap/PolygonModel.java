package com.didi.rlab.uni_foundation.heatmap;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PolygonModel extends UniModel {

    /* renamed from: a */
    private MapPolygonOptions f36814a;

    /* renamed from: b */
    private List<MapPositionModel> f36815b;

    public MapPolygonOptions getOptions() {
        return this.f36814a;
    }

    public void setOptions(MapPolygonOptions mapPolygonOptions) {
        this.f36814a = mapPolygonOptions;
    }

    public List<MapPositionModel> getPoints() {
        return this.f36815b;
    }

    public void setPoints(List<MapPositionModel> list) {
        this.f36815b = list;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        MapPolygonOptions mapPolygonOptions = this.f36814a;
        if (mapPolygonOptions != null) {
            hashMap.put(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, mapPolygonOptions.toMap());
        }
        hashMap.put("points", map(this.f36815b, $$Lambda$PolygonModel$EtDGIqeO46jmrzaEl0wY9RphnIM.INSTANCE));
        return hashMap;
    }

    public static PolygonModel fromMap(Map<String, Object> map) {
        PolygonModel polygonModel = new PolygonModel();
        polygonModel.f36814a = (!map.containsKey(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS) || map.get(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS) == null) ? null : MapPolygonOptions.fromMap((Map) map.get(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS));
        polygonModel.f36815b = (!map.containsKey("points") || map.get("points") == null) ? new ArrayList<>() : map((List) map.get("points"), $$Lambda$PolygonModel$s_3VgDfySrVxqornGlej30nquA.INSTANCE);
        return polygonModel;
    }
}
