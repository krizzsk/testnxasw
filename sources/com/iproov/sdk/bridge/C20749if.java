package com.iproov.sdk.bridge;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.iproov.sdk.bridge.if */
/* compiled from: JSDispatchEvent */
public class C20749if implements C20748do {

    /* renamed from: a */
    private final String f56842a;

    /* renamed from: b */
    private final Map<String, Object> f56843b;

    public C20749if(String str, Map<String, Object> map) {
        this.f56842a = str;
        this.f56843b = map;
    }

    /* renamed from: do */
    public String mo171273do() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f56843b != null) {
                jSONObject.put("detail", new JSONObject(this.f56843b));
            }
            return String.format("window.dispatchEvent(new CustomEvent('%s', %s));", new Object[]{"iproov-" + this.f56842a, jSONObject.toString()});
        } catch (JSONException unused) {
            throw new IllegalStateException("Error parsing JSDispatchEvent parameters for type: " + this.f56842a);
        }
    }
}
