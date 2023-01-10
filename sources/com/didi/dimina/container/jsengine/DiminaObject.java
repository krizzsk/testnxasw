package com.didi.dimina.container.jsengine;

import android.text.TextUtils;
import com.didi.dimina.p109v8.C8369V8;
import com.didi.dimina.p109v8.V8Array;
import com.didi.dimina.p109v8.V8Function;
import com.didi.dimina.p109v8.V8Object;
import com.didi.dimina.p109v8.V8Value;
import org.json.JSONObject;

public class DiminaObject implements JSObject {

    /* renamed from: a */
    private static final String f18698a = "JSON";

    /* renamed from: b */
    private static final String f18699b = "stringify";

    /* renamed from: c */
    private V8Object f18700c;

    /* renamed from: d */
    private JSONObject f18701d;

    /* renamed from: e */
    private String f18702e;

    /* renamed from: f */
    private C8369V8 f18703f;

    public DiminaObject(C8369V8 v8, V8Object v8Object) {
        this.f18703f = v8;
        this.f18700c = v8Object;
    }

    public String[] getKeys() {
        m15894a();
        return this.f18700c.getKeys();
    }

    public Object get(String str) {
        m15894a();
        return this.f18700c.get(str);
    }

    public Integer getInteger(String str) {
        m15894a();
        return Integer.valueOf(this.f18700c.getInteger(str));
    }

    public Boolean getBoolean(String str) {
        m15894a();
        return Boolean.valueOf(this.f18700c.getBoolean(str));
    }

    public Double getDouble(String str) {
        m15894a();
        return Double.valueOf(this.f18700c.getDouble(str));
    }

    public String getString(String str) {
        m15894a();
        return this.f18700c.getString(str);
    }

    public JSArray getArray(String str) {
        m15894a();
        return new DiminaArray(this.f18703f, this.f18700c.getArray(str));
    }

    public JSObject getObject(String str) {
        m15894a();
        return new DiminaObject(this.f18703f, this.f18700c.getObject(str));
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = this.f18701d;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            this.f18701d = new JSONObject(toJSONString());
        } catch (Exception unused) {
        }
        return this.f18701d;
    }

    public String toJSONString() {
        V8Function v8Function;
        if (TextUtils.isEmpty(this.f18702e) && (v8Function = this.f18703f.getV8Function(f18698a, f18699b)) != null) {
            V8Array push = new V8Array(this.f18703f).push((V8Value) this.f18700c);
            this.f18702e = (String) v8Function.call(this.f18703f.getV8Object(f18698a), push);
            push.close();
        }
        return this.f18702e;
    }

    public void release() {
        V8Object v8Object = this.f18700c;
        if (v8Object != null) {
            v8Object.close();
        }
    }

    /* renamed from: a */
    private void m15894a() {
        if (this.f18700c == null) {
            throw new IllegalArgumentException("V8Object 为空");
        }
    }
}
