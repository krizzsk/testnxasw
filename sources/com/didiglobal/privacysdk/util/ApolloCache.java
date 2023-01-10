package com.didiglobal.privacysdk.util;

import java.util.HashMap;
import java.util.Map;

public class ApolloCache {

    /* renamed from: a */
    private static Map<String, Map<String, Object>> f53214a = new HashMap();

    public static <T> T getValueFromCache(String str, String str2) {
        T t;
        Map map = f53214a.get(str);
        if (map == null || (t = map.get(str2)) == null) {
            return null;
        }
        return t;
    }

    public static <T> void putValueToCache(String str, String str2, T t) {
        Map map = f53214a.get(str);
        if (map == null) {
            map = new HashMap();
            f53214a.put(str, map);
        }
        if (map != null) {
            map.put(str2, t);
        }
    }
}
