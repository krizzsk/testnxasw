package com.didi.dimina.container.p065ui.canvas;

import android.content.Context;
import android.view.View;
import com.didi.dimina.container.bridge.DMServiceJSModuleLazyParameter;
import com.didi.dimina.container.bridge.InternalJSMethod;
import com.didi.dimina.container.bridge.canvas.CanvasSubJsBridge;
import com.didi.dimina.container.bridge.canvas.CanvasViewManager;
import com.didi.dimina.container.p065ui.custom.CustomComponent;
import com.didi.dimina.container.util.LogUtil;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.ui.canvas.CanvasViewComponent */
public class CanvasViewComponent extends CustomComponent {

    /* renamed from: a */
    private CanvasSubJsBridge f19395a;

    /* renamed from: b */
    private String f19396b;

    /* renamed from: a */
    private void m16453a() {
        this.f19395a = ((DMServiceJSModuleLazyParameter) this.mDMPage.getDMMina().invokeServiceJSModuleMethod("DMServiceBridgeModule", InternalJSMethod.GET_JS_MODULE_LAZY_PARAMETER, new Object[0])).getCanvas();
    }

    public View onMounted(Context context, JSONObject jSONObject) {
        LogUtil.m16841i("CanvasComponent onMounted");
        m16453a();
        if (jSONObject == null || !jSONObject.has("id")) {
            return null;
        }
        String optString = jSONObject.optString("id");
        this.f19396b = optString;
        if (optString.isEmpty()) {
            return null;
        }
        int optInt = jSONObject.optInt("width", 0);
        int optInt2 = jSONObject.optInt("height", 0);
        if (optInt <= 0 || optInt2 <= 0) {
            return null;
        }
        if (optInt > this.mWebView.getWebView().getWidth()) {
            optInt = this.mWebView.getWebView().getWidth();
        }
        if (optInt2 > this.mWebView.getWebView().getHeight()) {
            optInt2 = this.mWebView.getWebView().getHeight();
        }
        CanvasViewManager.getCanvasViewManager().createCanvasView(this.f19396b, new CanvasView(context, optInt, optInt2));
        this.f19395a.setCreate(this.f19396b);
        return CanvasViewManager.getCanvasViewManager().getCanvasView(this.f19396b);
    }

    public void onPropertiesUpdate(JSONObject jSONObject) {
        LogUtil.m16841i("CanvasComponent onUpdate");
        super.onPropertiesUpdate(jSONObject);
    }

    public void onDestroyed() {
        LogUtil.m16841i("CanvasComponent onDestroyed");
        CanvasViewManager.getCanvasViewManager().clearCanvasView(this.f19396b);
        this.f19395a.removeCanvasList(this.f19396b);
    }
}
