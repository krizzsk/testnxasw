package com.didi.dimina.container.bridge;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.mina.IDMVConsole;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import org.json.JSONObject;

public class VConsoleJSBridge {

    /* renamed from: a */
    private final WebViewEngine f18554a;

    /* renamed from: b */
    private final IDMVConsole f18555b;

    /* renamed from: c */
    private final boolean f18556c;

    public VConsoleJSBridge(WebViewEngine webViewEngine) {
        this.f18554a = webViewEngine;
        DMMina dmMina = webViewEngine.getDmMina();
        this.f18555b = dmMina.getVConsoleManager();
        this.f18556c = !(dmMina.getVConsoleManager() instanceof IDMVConsole.NOVConsole);
        LogUtil.m16841i("VConsoleJSBridge init");
    }

    public void ifOpenVConsole(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("VConsoleJSBridge ifOpenVconsole");
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("open", this.f18556c);
            CallBackUtil.onSuccess(jSONObject2, callbackFunction);
        } catch (Exception unused) {
            CallBackUtil.onFail("获取VConsole开启信息失败", callbackFunction);
        }
    }

    public void vConsoleReady(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("VConsoleJSBridge vConsoleReady");
        if (this.f18556c) {
            this.f18555b.inspectVConsole(this.f18554a);
        }
        CallBackUtil.onSuccess(callbackFunction);
    }
}
