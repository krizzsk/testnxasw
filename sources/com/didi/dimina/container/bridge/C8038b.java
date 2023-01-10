package com.didi.dimina.container.bridge;

import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.util.LogUtil;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.bridge.b */
/* compiled from: LogSubJSBridge */
class C8038b {
    C8038b() {
        LogUtil.m16841i("LogSubJSBridge init");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo59536a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("LogSubJSBridge logDebug: " + jSONObject);
        if (jSONObject.has("msg")) {
            LogUtil.m16841i(jSONObject.optString("msg"));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo59537b(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("LogSubJSBridge logInfo: " + jSONObject);
        if (jSONObject.has("msg")) {
            LogUtil.m16841i(jSONObject.optString("msg"));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo59538c(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("LogSubJSBridge logWarn: " + jSONObject);
        if (jSONObject.has("msg")) {
            LogUtil.m16843w(jSONObject.optString("msg"));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo59539d(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("LogSubJSBridge logError: " + jSONObject);
        if (jSONObject.has("msg")) {
            LogUtil.m16839e(jSONObject.optString("msg"));
        }
    }
}
