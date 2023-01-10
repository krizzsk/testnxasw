package com.didi.global.globalgenerickit.utils;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {
    public static Map<String, Object> jsonToMap(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return jsonToMap(new JSONObject(str));
    }

    public static Map<String, Object> jsonToMap(JSONObject jSONObject) throws JSONException {
        return jSONObject != JSONObject.NULL ? m19535a(jSONObject) : new HashMap();
    }

    /* renamed from: a */
    private static Map<String, Object> m19535a(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                obj = m19534a((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = m19535a((JSONObject) obj);
            }
            hashMap.put(next, obj);
        }
        return hashMap;
    }

    /* renamed from: a */
    private static List<Object> m19534a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = m19534a((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = m19535a((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }
}
