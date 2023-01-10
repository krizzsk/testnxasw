package com.didichuxing.dfbasesdk.webview.bizjscmd;

import org.json.JSONObject;

public class DummyJsCommandHandler extends AbsJsCmdHandler {

    /* renamed from: a */
    private IBizJsCmdHandler f49609a = new DummyJsCmdHandler();

    public boolean handleJsCmd(String str, JSONObject jSONObject) {
        return this.f49609a.handleJsCmd(str, jSONObject);
    }

    public void onUserCancel() {
        this.f49609a.onUserCancel();
    }
}
