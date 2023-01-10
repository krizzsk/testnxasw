package com.didi.rlab.uni_foundation.heatmap;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineModel extends UniModel {

    /* renamed from: a */
    private MapLineOptions f36779a;

    /* renamed from: b */
    private List<MapPositionModel> f36780b;

    public MapLineOptions getOptions() {
        return this.f36779a;
    }

    public void setOptions(MapLineOptions mapLineOptions) {
        this.f36779a = mapLineOptions;
    }

    public List<MapPositionModel> getPoints() {
        return this.f36780b;
    }

    public void setPoints(List<MapPositionModel> list) {
        this.f36780b = list;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        MapLineOptions mapLineOptions = this.f36779a;
        if (mapLineOptions != null) {
            hashMap.put(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, mapLineOptions.toMap());
        }
        hashMap.put("points", map(this.f36780b, $$Lambda$LineModel$Ui0Q_a9uFNHfTzegK4TvbzazONA.INSTANCE));
        return hashMap;
    }

    public static LineModel fromMap(Map<String, Object> map) {
        LineModel lineModel = new LineModel();
        lineModel.f36779a = (!map.containsKey(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS) || map.get(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS) == null) ? null : MapLineOptions.fromMap((Map) map.get(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS));
        lineModel.f36780b = (!map.containsKey("points") || map.get("points") == null) ? new ArrayList<>() : map((List) map.get("points"), $$Lambda$LineModel$q2ndnmltxCalRxtfmWL0FZ_4CE8.INSTANCE);
        return lineModel;
    }
}
