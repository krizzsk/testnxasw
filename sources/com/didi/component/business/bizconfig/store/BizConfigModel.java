package com.didi.component.business.bizconfig.store;

import org.json.JSONObject;

public class BizConfigModel {
    public static final String KEY_SERVICE_PHONE = "service_phone";
    public static final String KEY_VERSION = "version";
    public static final String KEY_k2 = "k2";

    /* renamed from: a */
    private String f13007a;

    /* renamed from: b */
    private int f13008b;

    /* renamed from: c */
    private String f13009c;

    /* renamed from: d */
    private String f13010d;

    private BizConfigModel() {
    }

    public static BizConfigModel parseFromJSON(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        BizConfigModel bizConfigModel = new BizConfigModel();
        bizConfigModel.f13007a = str;
        bizConfigModel.f13008b = jSONObject.optInt("version");
        bizConfigModel.f13009c = jSONObject.optString(KEY_SERVICE_PHONE);
        bizConfigModel.f13010d = jSONObject.optString(KEY_k2);
        return bizConfigModel;
    }

    public String toString() {
        return "BizConfigModel{bid='" + this.f13007a + '\'' + ", version=" + this.f13008b + ", servicePhone='" + this.f13009c + '\'' + ", k2='" + this.f13010d + '\'' + '}';
    }

    public String getBid() {
        return this.f13007a;
    }

    public int getVersion() {
        return this.f13008b;
    }

    public String getServicePhone() {
        return this.f13009c;
    }

    public String getK2() {
        return this.f13010d;
    }
}
