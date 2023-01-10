package com.didi.dimina.webview.jsbridge;

import com.didi.dimina.container.bridge.base.CallbackFunction;
import org.json.JSONException;
import org.json.JSONObject;

public class PreviousCallbackToJS implements CallbackFunction {
    public static final String FUSION_PACKAGED = "fusion_packaged";
    public static final String FUSION_RESULT = "result";

    /* renamed from: a */
    private static final String f20155a = "javascript:%s(%s);";

    /* renamed from: b */
    private final WebViewJavascriptBridge f20156b;

    /* renamed from: c */
    private final String f20157c;

    /* renamed from: d */
    private final String f20158d;

    /* renamed from: e */
    private final String f20159e;

    public PreviousCallbackToJS(WebViewJavascriptBridge webViewJavascriptBridge, String str, String str2, String str3) {
        this.f20156b = webViewJavascriptBridge;
        this.f20157c = str;
        this.f20158d = str2;
        this.f20159e = str3;
    }

    public void onCallBack(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            JSONObject jSONObject = objArr[0];
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("id", this.f20157c);
                jSONObject2.put("errno", 0);
                jSONObject2.put("errmsg", "");
                if (jSONObject instanceof JSONObject ? jSONObject.optBoolean("fusion_packaged") : false) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("result");
                    if (optJSONObject != null) {
                        jSONObject2.put("result", optJSONObject);
                    }
                } else {
                    jSONObject2.put("result", jSONObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.f20156b.executeCallJS(String.format(f20155a, new Object[]{this.f20158d, jSONObject2.toString()}));
        }
    }
}
