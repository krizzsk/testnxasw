package com.didi.dimina.container.jsengine;

import android.text.TextUtils;
import com.didi.dimina.p109v8.C8369V8;
import com.didi.dimina.p109v8.V8Array;
import com.didi.dimina.p109v8.V8Function;
import com.didi.dimina.p109v8.V8ResultUndefined;
import com.didi.dimina.p109v8.V8Value;
import org.json.JSONArray;

public class DiminaArray implements JSArray {

    /* renamed from: a */
    private static final String f18692a = "JSON";

    /* renamed from: b */
    private static final String f18693b = "stringify";

    /* renamed from: c */
    private V8Array f18694c;

    /* renamed from: d */
    private JSONArray f18695d;

    /* renamed from: e */
    private String f18696e;

    /* renamed from: f */
    private C8369V8 f18697f;

    public DiminaArray(C8369V8 v8, V8Array v8Array) {
        this.f18697f = v8;
        this.f18694c = v8Array;
    }

    public int length() {
        m15893a();
        return this.f18694c.length();
    }

    public Object get(int i) {
        m15893a();
        return this.f18694c.get(i);
    }

    public Integer getInteger(int i) {
        m15893a();
        return Integer.valueOf(this.f18694c.getInteger(i));
    }

    public Boolean getBoolean(int i) {
        m15893a();
        return Boolean.valueOf(this.f18694c.getBoolean(i));
    }

    public Double getDouble(int i) {
        m15893a();
        return Double.valueOf(this.f18694c.getDouble(i));
    }

    public String getString(int i) {
        m15893a();
        try {
            return this.f18694c.getString(i);
        } catch (V8ResultUndefined unused) {
            return "";
        }
    }

    public JSArray getArray(int i) {
        m15893a();
        return new DiminaArray(this.f18697f, this.f18694c.getArray(i));
    }

    public JSObject getObject(int i) {
        m15893a();
        return new DiminaObject(this.f18697f, this.f18694c.getObject(i));
    }

    public JSONArray toJSONArray() {
        JSONArray jSONArray = this.f18695d;
        if (jSONArray != null) {
            return jSONArray;
        }
        try {
            this.f18695d = new JSONArray(toJSONString());
        } catch (Exception unused) {
        }
        return this.f18695d;
    }

    public String toJSONString() {
        V8Function v8Function;
        if (TextUtils.isEmpty(this.f18696e) && (v8Function = this.f18697f.getV8Function(f18692a, f18693b)) != null) {
            V8Array push = new V8Array(this.f18697f).push((V8Value) this.f18694c);
            this.f18696e = (String) v8Function.call(this.f18697f.getV8Object(f18692a), push);
            push.close();
        }
        return this.f18696e;
    }

    public void release() {
        V8Array v8Array = this.f18694c;
        if (v8Array != null) {
            v8Array.close();
        }
    }

    /* renamed from: a */
    private void m15893a() {
        if (this.f18694c == null) {
            throw new IllegalArgumentException("V8Array 为空");
        }
    }
}
