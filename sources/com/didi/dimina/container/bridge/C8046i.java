package com.didi.dimina.container.bridge;

import android.content.Context;
import android.text.TextUtils;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.p065ui.custom.SameLayerRenderingUtil;
import com.didi.dimina.container.p065ui.webview.TouchInterceptFrame;
import com.didi.dimina.container.p065ui.webview.TouchInterceptFrameLayout;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.bridge.i */
/* compiled from: TouchViewSubJSBridge */
class C8046i {

    /* renamed from: a */
    private final WebViewEngine f18623a;

    /* renamed from: b */
    private final Map<String, List<TouchInterceptFrame>> f18624b = new HashMap();

    /* renamed from: c */
    private final Context f18625c;

    C8046i(Context context, WebViewEngine webViewEngine) {
        this.f18625c = context;
        this.f18623a = webViewEngine;
        LogUtil.m16841i("TouchViewSubJSBridge init");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo59690a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        mo59691b(jSONObject, callbackFunction);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo59691b(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("TouchViewSubJSBridge updated: " + jSONObject);
        if (jSONObject.has("id")) {
            String optString = jSONObject.optString("id", "");
            ArrayList arrayList = new ArrayList();
            if (jSONObject.has("subFrames")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("subFrames");
                int i = 0;
                while (optJSONArray != null && i < optJSONArray.length()) {
                    try {
                        TouchInterceptFrame a = m15870a(optString, optJSONArray.getJSONObject(i));
                        if (a != null) {
                            arrayList.add(a);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
            } else if (jSONObject.has("frame")) {
                arrayList.add(m15870a(optString, jSONObject.optJSONObject("frame")));
            }
            this.f18624b.put(optString, arrayList);
            m15871a();
        }
    }

    /* renamed from: a */
    private TouchInterceptFrame m15870a(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int optInt = jSONObject.optInt("x", -1);
        int optInt2 = jSONObject.optInt(SameLayerRenderingUtil.KEY_COMP_Y, -1);
        int optInt3 = jSONObject.optInt("height", -1);
        int optInt4 = jSONObject.optInt("width", -1);
        if (optInt2 < 0 || optInt < 0 || optInt3 < 0 || optInt4 < 0) {
            return null;
        }
        TouchInterceptFrame touchInterceptFrame = new TouchInterceptFrame();
        touchInterceptFrame.f19737id = str;
        float f = this.f18625c.getResources().getDisplayMetrics().density;
        touchInterceptFrame.height = (int) ((((float) optInt3) * f) + 0.5f);
        touchInterceptFrame.width = (int) ((((float) optInt4) * f) + 0.5f);
        touchInterceptFrame.f19738x = (int) ((((float) optInt) * f) + 0.5f);
        touchInterceptFrame.f19739y = (int) ((((float) optInt2) * f) + 0.5f);
        return touchInterceptFrame;
    }

    /* renamed from: a */
    private void m15871a() {
        TouchInterceptFrameLayout touchInterceptFrameLayout = this.f18623a.getContainer().getTouchInterceptFrameLayout();
        if (touchInterceptFrameLayout != null) {
            touchInterceptFrameLayout.updateInterceptFrame(this.f18624b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo59692c(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("TouchViewSubJSBridge destroyed: " + jSONObject);
        if (jSONObject.has("id")) {
            String optString = jSONObject.optString("id", "");
            if (!TextUtils.isEmpty(optString)) {
                this.f18624b.remove(optString);
                m15871a();
            }
        }
    }
}
