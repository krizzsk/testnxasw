package com.didi.component.config;

import android.text.TextUtils;
import com.didi.sdk.app.DIDIApplication;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentConfig {

    /* renamed from: f */
    private static final String f14420f = "cid";

    /* renamed from: g */
    private static final String f14421g = "cname";

    /* renamed from: h */
    private static final String f14422h = "open";

    /* renamed from: i */
    private static final String f14423i = "desc";

    /* renamed from: j */
    private static final String f14424j = "params";

    /* renamed from: a */
    boolean f14425a;

    /* renamed from: b */
    String f14426b;

    /* renamed from: c */
    String f14427c;

    /* renamed from: d */
    String f14428d;
    @Deprecated

    /* renamed from: e */
    String f14429e;

    public String type() {
        return this.f14428d;
    }

    @Deprecated
    public String name() {
        return this.f14429e;
    }

    public boolean open() {
        return this.f14425a;
    }

    public String desc() {
        return this.f14426b;
    }

    public String params() {
        return this.f14427c;
    }

    public boolean valid() {
        return !TextUtils.isEmpty(this.f14428d);
    }

    public String toString() {
        return "{ " + "cid" + ":" + this.f14428d + ", " + f14421g + ":" + this.f14429e + ", " + "open" + ":" + this.f14425a + ", " + f14423i + ":" + this.f14426b + ", " + "params" + ":" + this.f14427c + "}";
    }

    /* renamed from: a */
    static ComponentConfig m11957a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || !jSONObject.has("cid")) {
            return null;
        }
        int optInt = jSONObject.optInt("cid");
        if (optInt > 0) {
            ComponentConfig componentConfig = new ComponentConfig();
            componentConfig.f14428d = ReflectIds.get(DIDIApplication.getAppContext().getApplicationContext()).type(optInt);
            boolean z = true;
            if (jSONObject.optInt("open") != 1) {
                z = false;
            }
            componentConfig.f14425a = z;
            componentConfig.f14426b = jSONObject.optString(f14423i, (String) null);
            componentConfig.f14427c = jSONObject.optString("params", (String) null);
            return componentConfig;
        }
        throw new JSONException("unknown component cid: " + optInt);
    }
}
