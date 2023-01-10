package com.didi.onehybrid.jsbridge;

import com.didi.onehybrid.devmode.FusionRuntimeInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class PreviousCallbackToJS implements CallbackFunction {
    public static final String FUSION_PACKAGED = "fusion_packaged";
    public static final String FUSION_RESULT = "result";

    /* renamed from: a */
    private static final String f32080a = "javascript:%s(%s);";

    /* renamed from: b */
    private WebViewJavascriptBridge f32081b;

    /* renamed from: c */
    private String f32082c;

    /* renamed from: d */
    private String f32083d;

    /* renamed from: e */
    private FusionRuntimeInfo f32084e;

    /* renamed from: f */
    private String f32085f;

    public PreviousCallbackToJS(WebViewJavascriptBridge webViewJavascriptBridge, String str, String str2, String str3) {
        this.f32081b = webViewJavascriptBridge;
        this.f32082c = str;
        this.f32083d = str2;
        this.f32085f = str3;
        this.f32084e = webViewJavascriptBridge.getFusionRuntimeInfo();
    }

    public void onCallBack(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            JSONObject jSONObject = objArr[0];
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("id", this.f32082c);
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
            String format = String.format(f32080a, new Object[]{this.f32083d, jSONObject2.toString()});
            this.f32081b.executeCallJS(format);
            this.f32084e.recordBridgeCallback(this.f32085f, format);
        }
    }
}
