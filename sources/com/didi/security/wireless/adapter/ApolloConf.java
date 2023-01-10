package com.didi.security.wireless.adapter;

import com.didi.security.wireless.ISecurityConf;
import com.didichuxing.apollo.sdk.Apollo;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApolloConf implements ISecurityConf {

    /* renamed from: a */
    private static final String f41297a = "wsg_sdk_config";

    /* renamed from: b */
    private static final String f41298b = "wsg_sensor_data";

    /* renamed from: c */
    private static final String f41299c = "wsg_priority_switch";

    /* renamed from: d */
    private static final String f41300d = "on";

    /* renamed from: e */
    private static final String f41301e = "capacity";

    /* renamed from: f */
    private static final String f41302f = "expire";

    /* renamed from: g */
    private static final String f41303g = "cache";

    /* renamed from: h */
    private static final String f41304h = "touch";

    /* renamed from: i */
    private static final String f41305i = "denyEvent";

    /* renamed from: j */
    private static final int f41306j = 128;

    /* renamed from: k */
    private static final long f41307k = 60000;

    /* renamed from: l */
    private static final int f41308l = 512;

    /* renamed from: m */
    private ArrayList<String> f41309m;

    /* renamed from: n */
    private JSONObject f41310n;

    /* renamed from: o */
    private JSONObject f41311o;

    /* renamed from: p */
    private HashMap<String, String> f41312p;

    public void addConfig(String str, String str2) {
    }

    /* renamed from: a */
    private void m31002a() {
        String str = (String) Apollo.getToggle(f41297a).getExperiment().getParam("cache", "");
        if (str != null) {
            try {
                this.f41311o = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
    }

    /* renamed from: b */
    private void m31003b() {
        String str = (String) Apollo.getToggle(f41297a).getExperiment().getParam("touch", "");
        if (str != null) {
            try {
                this.f41310n = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
    }

    /* renamed from: c */
    private void m31004c() {
        if (this.f41312p == null) {
            this.f41312p = new HashMap<>();
        }
        if (Apollo.getToggle(f41298b, false).allow()) {
            this.f41312p.put(ISecurityConf.KEY_SENSOR, "allow");
        }
    }

    public boolean isCacheOn() {
        if (this.f41311o == null) {
            m31002a();
        }
        JSONObject jSONObject = this.f41311o;
        if (jSONObject != null) {
            return jSONObject.optBoolean("on", false);
        }
        return false;
    }

    public int cacheCapacity() {
        if (this.f41311o == null) {
            m31002a();
        }
        JSONObject jSONObject = this.f41311o;
        if (jSONObject != null) {
            return jSONObject.optInt(f41301e, 128);
        }
        return 128;
    }

    public long cacheExpire() {
        if (this.f41311o == null) {
            m31002a();
        }
        JSONObject jSONObject = this.f41311o;
        if (jSONObject != null) {
            return jSONObject.optLong("expire", 60000);
        }
        return 60000;
    }

    public boolean isTouchOn() {
        if (this.f41310n == null) {
            m31003b();
        }
        JSONObject jSONObject = this.f41310n;
        if (jSONObject != null) {
            return jSONObject.optBoolean("on", false);
        }
        return false;
    }

    public int touchCapacity() {
        if (this.f41310n == null) {
            m31003b();
        }
        JSONObject jSONObject = this.f41310n;
        if (jSONObject != null) {
            return jSONObject.optInt(f41301e, 512);
        }
        return 512;
    }

    public boolean isAllow(String str) {
        if (this.f41309m == null) {
            try {
                String str2 = (String) Apollo.getToggle(f41297a).getExperiment().getParam(f41305i, "");
                if (str2 != null) {
                    JSONArray jSONArray = new JSONArray(str2);
                    this.f41309m = new ArrayList<>(jSONArray.length());
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.f41309m.add(jSONArray.getString(i));
                    }
                }
            } catch (JSONException unused) {
            }
        }
        ArrayList<String> arrayList = this.f41309m;
        if (arrayList == null || !arrayList.contains(str)) {
            return true;
        }
        return false;
    }

    public boolean isPriorityOn() {
        return Apollo.getToggle(f41299c, false).allow();
    }

    public String getConfig(String str) {
        if (this.f41312p == null) {
            m31004c();
        }
        return this.f41312p.get(str);
    }
}
