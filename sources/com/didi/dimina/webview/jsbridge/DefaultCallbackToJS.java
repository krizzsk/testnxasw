package com.didi.dimina.webview.jsbridge;

import com.didi.dimina.container.bridge.base.CallbackFunction;

public class DefaultCallbackToJS implements CallbackFunction {

    /* renamed from: a */
    private final WebViewJavascriptBridge f20142a;

    /* renamed from: b */
    private final String f20143b;

    public DefaultCallbackToJS(WebViewJavascriptBridge webViewJavascriptBridge, String str, String str2) {
        this.f20143b = str;
        this.f20142a = webViewJavascriptBridge;
    }

    public void onCallBack(Object... objArr) {
        CallbackMessage callbackMessage = new CallbackMessage();
        callbackMessage.setCallbackId(this.f20143b);
        callbackMessage.setCallbackArguments(objArr);
        this.f20142a.mo62915a(callbackMessage);
    }
}
