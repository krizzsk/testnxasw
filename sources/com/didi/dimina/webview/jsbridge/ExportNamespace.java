package com.didi.dimina.webview.jsbridge;

import com.didi.dimina.container.bridge.base.JsInterface;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

public class ExportNamespace {

    /* renamed from: a */
    private static final String f20144a = ExportNamespace.class.getName();

    /* renamed from: b */
    private final String f20145b;

    /* renamed from: c */
    private final Class f20146c;

    /* renamed from: d */
    private Map<String, Method> f20147d;

    public ExportNamespace(String str, Class cls) {
        this.f20145b = str;
        this.f20146c = cls;
    }

    public String getExportModuleName() {
        return this.f20145b;
    }

    public Class getExportClass() {
        return this.f20146c;
    }

    public Method getTargetMethod(String str) {
        if (this.f20147d == null) {
            this.f20147d = m17024a();
        }
        return this.f20147d.get(str);
    }

    public JSONArray getExportMethodNames() {
        JSONArray jSONArray = new JSONArray();
        if (this.f20147d == null) {
            this.f20147d = m17024a();
        }
        for (String put : this.f20147d.keySet()) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    /* renamed from: a */
    private Map<String, Method> m17024a() {
        HashMap hashMap = new HashMap();
        for (Method method : this.f20146c.getMethods()) {
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
