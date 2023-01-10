package com.didichuxing.dfbasesdk.webview.bizjscmd;

import com.didichuxing.dfbasesdk.webview.JsCallbackEvent;

public abstract class AbsJsCmdHandler implements IBizJsCmdHandler {

    /* renamed from: a */
    private IJsCallback f49608a;

    public void setCallback(IJsCallback iJsCallback) {
        this.f49608a = iJsCallback;
    }

    public final void onJsCallback(JsCallbackEvent jsCallbackEvent) {
        IJsCallback iJsCallback = this.f49608a;
        if (iJsCallback != null) {
            iJsCallback.onJsCallback(jsCallbackEvent);
        }
    }
}
