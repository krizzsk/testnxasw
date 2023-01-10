package com.didichuxing.dfbasesdk.webview;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.UIHandler;
import org.json.JSONObject;

/* renamed from: com.didichuxing.dfbasesdk.webview.d */
/* compiled from: JsBridgeImpl */
class C16146d {

    /* renamed from: a */
    static final String f49614a = "Webview";

    /* renamed from: b */
    private static final String f49615b = "undefined";

    /* renamed from: c */
    private static final String f49616c = "javascript:";

    /* renamed from: d */
    private static final String f49617d = "_diface_callback_handler";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final C16145c f49618e;

    C16146d(C16145c cVar) {
        this.f49618e = cVar;
    }

    @JavascriptInterface
    public void invoke(String str, String str2, String str3) {
        LogUtils.m37052d(f49614a, "invoke from js, command=" + str + ", params=" + str2 + ", callback=" + str3);
        if (!TextUtils.isEmpty(str) && !"undefined".equals(str) && !TextUtils.isEmpty(str2) && !"undefined".equals(str2)) {
            try {
                UIHandler.post(new JsBridgeImpl$1(this, str, new JSONObject(str2)));
            } catch (Exception e) {
                LogUtils.logStackTrace(e);
                BusUtils.post(new JsCallbackEvent(str, 1002, e.getMessage()).build());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo122571a(WebView webView, JsCallbackEvent jsCallbackEvent) {
        String str = "javascript:_diface_callback_handler('" + jsCallbackEvent.command + "', '" + jsCallbackEvent.mo122558a() + "')";
        LogUtils.m37052d(f49614a, "callback to js, js=" + str);
        m37143a(webView, str);
    }

    /* renamed from: a */
    static void m37143a(WebView webView, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.startsWith(f49616c)) {
                str = f49616c + str;
            }
            if (Build.VERSION.SDK_INT < 19) {
                webView.loadUrl(str);
            } else {
                webView.evaluateJavascript(str, new JsBridgeImpl$2());
            }
        }
    }
}
