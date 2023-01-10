package com.didi.dimina.container.bridge;

import android.app.Activity;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class ScreenSubJSBridge {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Activity f18542a;

    public ScreenSubJSBridge(Activity activity) {
        this.f18542a = activity;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo59501a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject.has("value")) {
            final float optDouble = (float) jSONObject.optDouble("value");
            if (optDouble > 1.0f || optDouble < 0.0f) {
                CallBackUtil.onFail("error parameter", callbackFunction);
                return;
            }
            UIHandlerUtil.post(new Runnable() {
                public void run() {
                    Window window = ScreenSubJSBridge.this.f18542a.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.screenBrightness = optDouble;
                    window.setAttributes(attributes);
                }
            });
            CallBackUtil.onSuccess(callbackFunction);
            return;
        }
        CallBackUtil.onFail("error parameter", callbackFunction);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo59502b(final JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable() {
            public void run() {
                if (jSONObject.optBoolean("keepScreenOn")) {
                    ScreenSubJSBridge.this.f18542a.getWindow().addFlags(128);
                } else {
                    ScreenSubJSBridge.this.f18542a.getWindow().clearFlags(128);
                }
            }
        });
        CallBackUtil.onSuccess(callbackFunction);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo59503c(JSONObject jSONObject, CallbackFunction callbackFunction) {
        HashMap hashMap = new HashMap();
        float f = this.f18542a.getWindow().getAttributes().screenBrightness;
        if (f < 0.0f) {
            f = (((float) Settings.System.getInt(this.f18542a.getContentResolver(), "screen_brightness", 125)) * 1.0f) / 255.0f;
        }
        hashMap.put("value", Float.valueOf(f));
        CallBackUtil.onSuccess((Map<String, ? extends Object>) hashMap, callbackFunction);
    }
}
