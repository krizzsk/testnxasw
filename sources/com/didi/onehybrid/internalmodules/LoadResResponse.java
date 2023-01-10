package com.didi.onehybrid.internalmodules;

import org.json.JSONException;
import org.json.JSONObject;

public class LoadResResponse {

    /* renamed from: a */
    private int f32048a;

    /* renamed from: b */
    private String f32049b;

    /* renamed from: c */
    private String f32050c;

    /* renamed from: d */
    private String f32051d;

    public void setCode(int i) {
        this.f32048a = i;
    }

    public void setVersion(String str) {
        this.f32049b = str;
    }

    public void setMimeType(String str) {
        this.f32050c = str;
    }

    public void setData(String str) {
        this.f32051d = str;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f32048a);
            jSONObject.put("version", this.f32049b);
            jSONObject.put("mimeType", this.f32050c);
            jSONObject.put("data", this.f32051d);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
