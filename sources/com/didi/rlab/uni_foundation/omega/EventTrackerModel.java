package com.didi.rlab.uni_foundation.omega;

import com.didi.raven.config.RavenKey;
import com.didi.rlab.uni_foundation.uniapi.UniModel;
import java.util.HashMap;
import java.util.Map;

public class EventTrackerModel extends UniModel {

    /* renamed from: a */
    private String f36851a;

    /* renamed from: b */
    private Map<String, Object> f36852b;

    public String getEventId() {
        return this.f36851a;
    }

    public void setEventId(String str) {
        this.f36851a = str;
    }

    public Map<String, Object> getAttrs() {
        return this.f36852b;
    }

    public void setAttrs(Map<String, Object> map) {
        this.f36852b = map;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("eventId", this.f36851a);
        hashMap.put(RavenKey.ATTRS, this.f36852b);
        return hashMap;
    }

    public static EventTrackerModel fromMap(Map<String, Object> map) {
        EventTrackerModel eventTrackerModel = new EventTrackerModel();
        eventTrackerModel.f36851a = (!map.containsKey("eventId") || map.get("eventId") == null) ? "" : (String) map.get("eventId");
        eventTrackerModel.f36852b = (!map.containsKey(RavenKey.ATTRS) || map.get(RavenKey.ATTRS) == null) ? new HashMap<>() : (Map) map.get(RavenKey.ATTRS);
        return eventTrackerModel;
    }
}
