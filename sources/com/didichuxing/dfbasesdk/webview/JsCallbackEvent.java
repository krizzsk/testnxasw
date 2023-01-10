package com.didichuxing.dfbasesdk.webview;

import com.didichuxing.dfbasesdk.utils.LogUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class JsCallbackEvent {

    /* renamed from: a */
    static final int f49599a = 1000;

    /* renamed from: b */
    static final int f49600b = 1001;

    /* renamed from: c */
    static final int f49601c = 1002;

    /* renamed from: d */
    static final int f49602d = 1003;
    public final String command;

    /* renamed from: e */
    private String f49603e;

    /* renamed from: f */
    private final int f49604f;

    /* renamed from: g */
    private final String f49605g;

    /* renamed from: h */
    private final Map<String, Object> f49606h;

    public JsCallbackEvent(String str) {
        this(str, 1000, "SUCCESS");
    }

    public JsCallbackEvent(String str, int i, String str2) {
        this.command = str;
        this.f49604f = i;
        this.f49605g = str2;
        this.f49606h = new HashMap();
    }

    public JsCallbackEvent append(String str, Object obj) {
        this.f49606h.put(str, obj);
        return this;
    }

    public JsCallbackEvent build() {
        String str = "{}";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", this.f49604f);
            jSONObject.put("message", this.f49605g);
            if (this.f49606h.isEmpty()) {
                jSONObject.put("result", str);
            } else {
                jSONObject.put("result", new JSONObject(this.f49606h));
            }
            str = jSONObject.toString();
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
        this.f49603e = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo122558a() {
        return this.f49603e;
    }
}
