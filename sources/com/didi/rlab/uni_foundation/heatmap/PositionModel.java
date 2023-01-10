package com.didi.rlab.uni_foundation.heatmap;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PositionModel extends UniModel {

    /* renamed from: a */
    private List<MapPositionModel> f36816a;

    public List<MapPositionModel> getPositionModel() {
        return this.f36816a;
    }

    public void setPositionModel(List<MapPositionModel> list) {
        this.f36816a = list;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("positionModel", map(this.f36816a, $$Lambda$PositionModel$OZY5Gch4cPtlLdxfZFNSbMKIYy0.INSTANCE));
        return hashMap;
    }

    public static PositionModel fromMap(Map<String, Object> map) {
        PositionModel positionModel = new PositionModel();
        positionModel.f36816a = (!map.containsKey("positionModel") || map.get("positionModel") == null) ? new ArrayList<>() : map((List) map.get("positionModel"), $$Lambda$PositionModel$gaA2DB5Bzg4Expqvn83UiBgK6U4.INSTANCE);
        return positionModel;
    }
}
