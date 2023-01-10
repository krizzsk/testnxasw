package com.didi.dimina.container.jsengine.web;

import android.text.TextUtils;
import com.didi.dimina.container.jsengine.JSArray;
import com.didi.dimina.container.jsengine.JSObject;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class WebJSObject implements JSObject {

    /* renamed from: a */
    private final JSONObject f18732a;

    /* renamed from: b */
    private String f18733b;

    public void release() {
    }

    public WebJSObject(JSONObject jSONObject, String str) {
        this.f18732a = jSONObject;
        this.f18733b = str;
    }

    public WebJSObject(JSONObject jSONObject) {
        this.f18732a = jSONObject;
    }

    public String[] getKeys() {
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = this.f18732a.keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public Object get(String str) {
        try {
            return this.f18732a.get(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer getInteger(String str) {
        return Integer.valueOf(this.f18732a.optInt(str));
    }

    public Boolean getBoolean(String str) {
        return Boolean.valueOf(this.f18732a.optBoolean(str));
    }

    public Double getDouble(String str) {
        return Double.valueOf(this.f18732a.optDouble(str));
    }

    public String getString(String str) {
        return this.f18732a.optString(str);
    }

    public JSArray getArray(String str) {
        try {
            return new WebJSArray(this.f18732a.getJSONArray(str));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSObject getObject(String str) {
        try {
            return new WebJSObject(this.f18732a.getJSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject toJSONObject() {
        return this.f18732a;
    }

    public String toJSONString() {
        if (TextUtils.isEmpty(this.f18733b)) {
            this.f18733b = this.f18732a.toString();
        }
        return this.f18733b;
    }
}
