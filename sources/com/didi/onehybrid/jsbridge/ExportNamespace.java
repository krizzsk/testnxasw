package com.didi.onehybrid.jsbridge;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

public class ExportNamespace {

    /* renamed from: a */
    private static final String f32069a = ExportNamespace.class.getName();

    /* renamed from: b */
    private String f32070b;

    /* renamed from: c */
    private Class f32071c;

    /* renamed from: d */
    private Map<String, Method> f32072d;

    public ExportNamespace(String str, Class cls) {
        this.f32070b = str;
        this.f32071c = cls;
    }

    public String getExportModuleName() {
        return this.f32070b;
    }

    public Class getExportClass() {
        return this.f32071c;
    }

    public Method getTargetMethod(String str) {
        if (this.f32072d == null) {
            this.f32072d = m24413a();
        }
        return this.f32072d.get(str);
    }

    public JSONArray getExportMethodNames() {
        JSONArray jSONArray = new JSONArray();
        if (this.f32072d == null) {
            this.f32072d = m24413a();
        }
        for (String put : this.f32072d.keySet()) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    /* renamed from: a */
    private Map<String, Method> m24413a() {
        HashMap hashMap = new HashMap();
        for (Method method : this.f32071c.getMethods()) {
            JsInterface jsInterface = (JsInterface) method.getAnnotation(JsInterface.class);
            if (jsInterface != null) {
                for (String put : jsInterface.value()) {
                    hashMap.put(put, method);
                }
            }
        }
        return hashMap;
    }
}
