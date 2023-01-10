package com.didi.globalsafetoolkit.omega;

import android.text.TextUtils;
import com.didi.globalsafetoolkit.GlobalSfBusinessInterface;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class SfOmegaUtil {
    public static OmgEventAdder addEventId(String str) {
        return new OmgEventAdder(str);
    }

    public static class OmgEventAdder {
        String mEventId;
        Map<String, Object> params = new HashMap(4);

        OmgEventAdder(String str) {
            this.mEventId = str;
        }

        public OmgEventAdder addKeyValue(String str, Object obj) {
            if (obj != null) {
                this.params.put(str, obj);
            }
            return this;
        }

        public OmgEventAdder addKeyValue(Map<String, Object> map) {
            if (map != null) {
                this.params.putAll(map);
            }
            return this;
        }

        public void report() {
            SfOmegaUtil.m20135b(this.mEventId, this.params);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m20135b(String str, Map<String, Object> map) {
        if (!TextUtils.isEmpty(str)) {
            GlobalSfBusinessInterface.addOmegaEvent(str, map);
        }
    }

    public static Map<String, Object> getJsonObjectMap(JsonObject jsonObject) {
        HashMap hashMap = new HashMap(4);
        if (jsonObject != null) {
            try {
                JSONObject jSONObject = new JSONObject(jsonObject.toString());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object opt = jSONObject.opt(next);
                    if (opt != null) {
                        hashMap.put(next, opt);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }
}
