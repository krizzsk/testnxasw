package com.didichuxing.afanty.common;

import java.util.HashMap;
import java.util.Map;

public class AfantyConfig {

    /* renamed from: a */
    private static Map<String, Object> f48210a = new HashMap();
    public static IGetLanguage iGetLanguage;

    public interface IGetLanguage {
        String getLanguage();
    }

    public static void putCustomInfo(Map<String, Object> map) {
        f48210a.clear();
        if (map != null && !map.isEmpty()) {
            f48210a.putAll(map);
        }
    }

    public static Map<String, Object> getCustomInfo() {
        return f48210a;
    }
}
