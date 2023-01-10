package com.didichuxing.dfbasesdk.webview;

import org.json.JSONObject;

class JsBridgeImpl$1 implements Runnable {
    final /* synthetic */ C16146d this$0;
    final /* synthetic */ String val$command;
    final /* synthetic */ JSONObject val$jsonObject;

    JsBridgeImpl$1(C16146d dVar, String str, JSONObject jSONObject) {
        this.this$0 = dVar;
        this.val$command = str;
        this.val$jsonObject = jSONObject;
    }

    public void run() {
        this.this$0.f49618e.handleJsInvoke(this.val$command, this.val$jsonObject);
    }
}
