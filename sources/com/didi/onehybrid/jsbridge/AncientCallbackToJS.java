package com.didi.onehybrid.jsbridge;

import com.didi.onehybrid.devmode.FusionRuntimeInfo;
import com.didichuxing.bigdata.p174dp.locsdk.Const;

public class AncientCallbackToJS implements CallbackFunction {

    /* renamed from: a */
    private static final String f32054a = "javascript:%s.callback(%d, %d %s);";

    /* renamed from: b */
    private WebViewJavascriptBridge f32055b;

    /* renamed from: c */
    private final String f32056c = "DidiJSBridge";

    /* renamed from: d */
    private final Integer f32057d;

    /* renamed from: e */
    private FusionRuntimeInfo f32058e;

    /* renamed from: f */
    private String f32059f;

    public AncientCallbackToJS(WebViewJavascriptBridge webViewJavascriptBridge, Integer num, String str) {
        this.f32055b = webViewJavascriptBridge;
        this.f32057d = num;
        this.f32059f = str;
        this.f32058e = webViewJavascriptBridge.getFusionRuntimeInfo();
    }

    public void onCallBack(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(",");
            boolean z = obj instanceof String;
            if (z) {
                sb.append(Const.jsQuote);
            }
            sb.append(String.valueOf(obj));
            if (z) {
                sb.append(Const.jsQuote);
            }
        }
        String format = String.format(f32054a, new Object[]{this.f32056c, this.f32057d, 0, sb.toString()});
        this.f32055b.executeCallJS(format);
        this.f32058e.recordBridgeCallback(this.f32059f, format);
    }
}
