package com.didi.global.globalgenerickit.config;

import java.util.HashMap;
import java.util.Map;

public class GGKConfigProcessor {
    public static final String ALERT = "passenger_newPopup";
    public static final String SHEET = "passenger_newSheet";

    /* renamed from: a */
    private static Map<String, IConfig> f23972a;

    static {
        HashMap hashMap = new HashMap();
        f23972a = hashMap;
        hashMap.put("passenger_newPopup", new AlertConfig());
        f23972a.put("passenger_newSheet", new SheetConfig());
    }

    public static Map<String, IConfig> getMaps() {
        return f23972a;
    }
}
