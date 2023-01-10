package com.didi.rlab.uni_foundation.passport;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import java.util.HashMap;
import java.util.Map;

public class LevelInfo extends UniModel {

    /* renamed from: a */
    private String f36853a;

    /* renamed from: b */
    private String f36854b;

    public String getLevel() {
        return this.f36853a;
    }

    public void setLevel(String str) {
        this.f36853a = str;
    }

    public String getTitle() {
        return this.f36854b;
    }

    public void setTitle(String str) {
        this.f36854b = str;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("level", this.f36853a);
        hashMap.put("title", this.f36854b);
        return hashMap;
    }

    public static LevelInfo fromMap(Map<String, Object> map) {
        LevelInfo levelInfo = new LevelInfo();
        String str = "";
        levelInfo.f36853a = (!map.containsKey("level") || map.get("level") == null) ? str : (String) map.get("level");
        if (map.containsKey("title") && map.get("title") != null) {
            str = (String) map.get("title");
        }
        levelInfo.f36854b = str;
        return levelInfo;
    }
}
