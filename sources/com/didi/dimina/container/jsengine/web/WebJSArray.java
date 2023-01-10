package com.didi.dimina.container.jsengine.web;

import android.text.TextUtils;
import com.didi.dimina.container.jsengine.JSArray;
import com.didi.dimina.container.jsengine.JSObject;
import org.json.JSONArray;

public class WebJSArray implements JSArray {

    /* renamed from: a */
    private final JSONArray f18730a;

    /* renamed from: b */
    private String f18731b;

    public void release() {
    }

    public WebJSArray(JSONArray jSONArray, String str) {
        this.f18730a = jSONArray;
        this.f18731b = str;
    }

    public WebJSArray(JSONArray jSONArray) {
        this.f18730a = jSONArray;
    }

    public int length() {
        return this.f18730a.length();
    }

    public Object get(int i) {
        return this.f18730a.opt(i);
    }

    public Integer getInteger(int i) {
        return Integer.valueOf(this.f18730a.optInt(i));
    }

    public Boolean getBoolean(int i) {
        return Boolean.valueOf(this.f18730a.optBoolean(i));
    }

    public Double getDouble(int i) {
        return Double.valueOf(this.f18730a.optDouble(i));
    }

    public String getString(int i) {
        return this.f18730a.optString(i);
    }

    public JSArray getArray(int i) {
        return new WebJSArray(this.f18730a.optJSONArray(i));
    }

    public JSObject getObject(int i) {
        return new WebJSObject(this.f18730a.optJSONObject(i));
    }

    public JSONArray toJSONArray() {
        return this.f18730a;
    }

    public String toJSONString() {
        if (TextUtils.isEmpty(this.f18731b)) {
            this.f18731b = this.f18730a.toString();
        }
        return this.f18731b;
    }
}
