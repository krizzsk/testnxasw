package com.didi.dimina.webview.container;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.didi.dimina.webview.BusinessAgent;
import com.didi.dimina.webview.FusionEngine;
import com.didi.dimina.webview.adapter.OldJavascriptBridgeAdapter;
import com.didi.dimina.webview.jsbridge.BridgeHelper;
import com.didi.dimina.webview.jsbridge.WebViewJavascriptBridge;
import com.didi.dimina.webview.log.apollo.ApolloLog;
import com.didi.dimina.webview.util.C8407Util;
import org.json.JSONObject;

public class FusionWebChromeClient extends WebChromeClient {

    /* renamed from: a */
    private static final String f20100a = "FusionWebChromeClient";

    /* renamed from: b */
    private final FusionWebView f20101b;

    /* renamed from: c */
    private final WebViewJavascriptBridge f20102c;

    /* renamed from: d */
    private final OldJavascriptBridgeAdapter f20103d;

    /* renamed from: e */
    private boolean f20104e = false;

    public FusionWebChromeClient(FusionWebView fusionWebView) {
        this.f20101b = fusionWebView;
        this.f20102c = fusionWebView.getJavascriptBridge();
        this.f20103d = new OldJavascriptBridgeAdapter(fusionWebView);
    }

    public void onProgressChanged(WebView webView, int i) {
        if (i < 25) {
            if (this.f20104e) {
                this.f20104e = false;
            }
        } else if (!this.f20104e) {
            BridgeHelper.webViewLoadLocalJs(webView, BridgeHelper.ASSET_BRIDGE4_JS);
            this.f20104e = true;
        }
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("fusion");
            if (TextUtils.isEmpty(optString) || !optString.equals("loadJSModules")) {
                Context context = webView.getContext();
                BusinessAgent businessAgent = FusionEngine.getBusinessAgent();
                if (!C8407Util.isApkDebug(context)) {
                    if (!businessAgent.isWhiteUrl(context, str)) {
                        jsPromptResult.confirm("please put this url into white list");
                    }
                }
                if (this.f20103d.matchPreviousBridgeProtocol(jSONObject)) {
                    this.f20103d.handleInvokeOfPreviousJS(jSONObject);
                    jsPromptResult.confirm("prompt ok");
                } else {
                    jsPromptResult.confirm(this.f20103d.handleInvokeFromAncientJS(str2));
                }
            } else {
                jsPromptResult.confirm(this.f20102c.getExportModules().toString());
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            jsPromptResult.confirm("");
            return true;
        }
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        try {
            ApolloLog.uploadJsError(this.f20101b, consoleMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onConsoleMessage(consoleMessage);
    }
}
