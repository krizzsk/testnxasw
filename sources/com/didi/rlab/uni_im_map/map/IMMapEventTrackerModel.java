package com.didi.rlab.uni_im_map.map;

import com.didi.raven.config.RavenKey;
import com.didi.rlab.uni_im_map.uniapi.UniModel;
import java.util.HashMap;
import java.util.Map;

public class IMMapEventTrackerModel extends UniModel {

    /* renamed from: a */
    private String f36965a;

    /* renamed from: b */
    private Map<String, Object> f36966b;

    public String getEventId() {
        return this.f36965a;
    }

    public void setEventId(String str) {
        this.f36965a = str;
    }

    public Map<String, Object> getAttrs() {
        return this.f36966b;
    }

    public void setAttrs(Map<String, Object> map) {
        this.f36966b = map;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("eventId", this.f36965a);
        hashMap.put(RavenKey.ATTRS, this.f36966b);
        return hashMap;
    }

    public static IMMapEventTrackerModel fromMap(Map<String, Object> map) {
        IMMapEventTrackerModel iMMapEventTrackerModel = new IMMapEventTrackerModel();
        iMMapEventTrackerModel.f36965a = (!map.containsKey("eventId") || map.get("eventId") == null) ? "" : (String) map.get("eventId");
        iMMapEventTrackerModel.f36966b = (!map.containsKey(RavenKey.ATTRS) || map.get(RavenKey.ATTRS) == null) ? new HashMap<>() : (Map) map.get(RavenKey.ATTRS);
        return iMMapEventTrackerModel;
    }
}
