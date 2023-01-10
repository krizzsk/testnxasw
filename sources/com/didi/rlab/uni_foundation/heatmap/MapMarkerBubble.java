package com.didi.rlab.uni_foundation.heatmap;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import java.util.HashMap;
import java.util.Map;

public class MapMarkerBubble extends UniModel {

    /* renamed from: a */
    private String f36790a;

    /* renamed from: b */
    private String f36791b;

    /* renamed from: c */
    private String f36792c;

    /* renamed from: d */
    private String f36793d;

    public String getText() {
        return this.f36790a;
    }

    public void setText(String str) {
        this.f36790a = str;
    }

    public String getIcon() {
        return this.f36791b;
    }

    public void setIcon(String str) {
        this.f36791b = str;
    }

    public String getIcon2() {
        return this.f36792c;
    }

    public void setIcon2(String str) {
        this.f36792c = str;
    }

    public String getColor() {
        return this.f36793d;
    }

    public void setColor(String str) {
        this.f36793d = str;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("text", this.f36790a);
        hashMap.put("icon", this.f36791b);
        hashMap.put("icon2", this.f36792c);
        hashMap.put("color", this.f36793d);
        return hashMap;
    }

    public static MapMarkerBubble fromMap(Map<String, Object> map) {
        MapMarkerBubble mapMarkerBubble = new MapMarkerBubble();
        String str = "";
        mapMarkerBubble.f36790a = (!map.containsKey("text") || map.get("text") == null) ? str : (String) map.get("text");
        mapMarkerBubble.f36791b = (!map.containsKey("icon") || map.get("icon") == null) ? str : (String) map.get("icon");
        mapMarkerBubble.f36792c = (!map.containsKey("icon2") || map.get("icon2") == null) ? str : (String) map.get("icon2");
        if (map.containsKey("color") && map.get("color") != null) {
            str = (String) map.get("color");
        }
        mapMarkerBubble.f36793d = str;
        return mapMarkerBubble;
    }
}
