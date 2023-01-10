package com.didi.component.common.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class DynamicConfigModel {

    /* renamed from: a */
    private int f13481a;

    /* renamed from: b */
    private Map<String, Boolean> f13482b = new HashMap();

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f13482b.clear();
                this.f13481a = jSONObject.optInt("product_id");
                JSONObject optJSONObject = jSONObject.optJSONObject("functions");
                Iterator<String> keys = optJSONObject.keys();
                if (keys != null) {
                    while (keys.hasNext()) {
                        String next = keys.next();
                        boolean z = true;
                        if (optJSONObject.getInt(next) != 1) {
                            z = false;
                        }
                        this.f13482b.put(next, Boolean.valueOf(z));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getProductId() {
        return this.f13481a;
    }

    public void setProductId(int i) {
        this.f13481a = i;
    }

    public Map<String, Boolean> getFunctionSwitchMap() {
        return this.f13482b;
    }

    public void setFunctionSwitchMap(Map<String, Boolean> map) {
        this.f13482b = map;
    }
}
