package com.didi.onehybrid.jsbridge;

import com.didi.onehybrid.devmode.FusionRuntimeInfo;

public class DefaultCallbackToJS implements CallbackFunction {

    /* renamed from: a */
    private WebViewJavascriptBridge f32065a;

    /* renamed from: b */
    private String f32066b;

    /* renamed from: c */
    private FusionRuntimeInfo f32067c;

    /* renamed from: d */
    private String f32068d;

    public DefaultCallbackToJS(WebViewJavascriptBridge webViewJavascriptBridge, String str, String str2) {
        this.f32066b = str;
        this.f32065a = webViewJavascriptBridge;
        this.f32068d = str2;
        this.f32067c = webViewJavascriptBridge.getFusionRuntimeInfo();
    }

    public void onCallBack(Object... objArr) {
        CallbackMessage callbackMessage = new CallbackMessage();
        callbackMessage.setCallbackId(this.f32066b);
        callbackMessage.setCallbackArguments(objArr);
        this.f32065a.mo86625a(callbackMessage);
        this.f32067c.recordBridgeCallback(this.f32068d, callbackMessage.toString());
    }
}
