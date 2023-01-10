package com.didi.dimina.webview.jsbridge;

import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didichuxing.bigdata.p174dp.locsdk.Const;

public class AncientCallbackToJS implements CallbackFunction {

    /* renamed from: a */
    private static final String f20132a = "javascript:%s.callback(%d, %d %s);";

    /* renamed from: b */
    private final WebViewJavascriptBridge f20133b;

    /* renamed from: c */
    private final String f20134c = "DidiJSBridge";

    /* renamed from: d */
    private final Integer f20135d;

    /* renamed from: e */
    private final String f20136e;

    public AncientCallbackToJS(WebViewJavascriptBridge webViewJavascriptBridge, Integer num, String str) {
        this.f20133b = webViewJavascriptBridge;
        this.f20135d = num;
        this.f20136e = str;
    }

    public void onCallBack(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(",");
            boolean z = obj instanceof String;
            if (z) {
                sb.append(Const.jsQuote);
            }
            sb.append(obj);
            if (z) {
                sb.append(Const.jsQuote);
            }
        }
        this.f20133b.executeCallJS(String.format(f20132a, new Object[]{this.f20134c, this.f20135d, 0, sb.toString()}));
    }
}
