package com.didi.rlab.uni_foundation.passport;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import java.util.HashMap;
import java.util.Map;

public class RiderCenter extends UniModel {

    /* renamed from: a */
    private String f36864a;

    /* renamed from: b */
    private String f36865b;

    /* renamed from: c */
    private String f36866c;

    public String getColor() {
        return this.f36864a;
    }

    public void setColor(String str) {
        this.f36864a = str;
    }

    public String getUrl() {
        return this.f36865b;
    }

    public void setUrl(String str) {
        this.f36865b = str;
    }

    public String getText() {
        return this.f36866c;
    }

    public void setText(String str) {
        this.f36866c = str;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("color", this.f36864a);
        hashMap.put("url", this.f36865b);
        hashMap.put("text", this.f36866c);
        return hashMap;
    }

    public static RiderCenter fromMap(Map<String, Object> map) {
        RiderCenter riderCenter = new RiderCenter();
        String str = "";
        riderCenter.f36864a = (!map.containsKey("color") || map.get("color") == null) ? str : (String) map.get("color");
        riderCenter.f36865b = (!map.containsKey("url") || map.get("url") == null) ? str : (String) map.get("url");
        if (map.containsKey("text") && map.get("text") != null) {
            str = (String) map.get("text");
        }
        riderCenter.f36866c = str;
        return riderCenter;
    }
}
