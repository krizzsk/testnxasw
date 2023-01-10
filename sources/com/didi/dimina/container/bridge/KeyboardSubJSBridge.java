package com.didi.dimina.container.bridge;

import android.app.Activity;
import android.content.Context;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.KeyboardUtils;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.PixUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import java.util.WeakHashMap;
import org.json.JSONObject;

class KeyboardSubJSBridge {

    /* renamed from: a */
    private static final WeakHashMap<Activity, SoftInputChangedListener> f18491a = new WeakHashMap<>();

    /* renamed from: b */
    private final Activity f18492b;

    /* renamed from: c */
    private final WebViewEngine f18493c;

    public KeyboardSubJSBridge(Activity activity, WebViewEngine webViewEngine) {
        LogUtil.m16841i("KeyboardSubJSBridge init");
        this.f18492b = activity;
        this.f18493c = webViewEngine;
        m15654a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo59426a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("KeyboardSubJSBridge hideKeyboard: " + jSONObject);
        KeyboardUtils.hideSoftInput(this.f18492b);
        if (callbackFunction != null) {
            CallBackUtil.onSuccess(callbackFunction);
        }
    }

    /* renamed from: a */
    private void m15654a() {
        LogUtil.m16841i("KeyboardSubJSBridge registerSoftInputChangedListener");
        if (f18491a.get(this.f18492b) == null) {
            SoftInputChangedListener softInputChangedListener = new SoftInputChangedListener(this.f18492b);
            f18491a.put(this.f18492b, softInputChangedListener);
            KeyboardUtils.registerSoftInputChangedListener(this.f18492b, (KeyboardUtils.OnSoftInputChangedListener) softInputChangedListener);
        }
    }

    /* renamed from: b */
    public void mo59427b(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("KeyboardSubJSBridge showKeyboard: " + jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("inputBoundingRect");
        if (optJSONObject != null) {
            KeyboardUtils.focusedComponentY = (int) (((float) (optJSONObject.optInt("top") + optJSONObject.optInt("height"))) * this.f18493c.getWebView().getContext().getResources().getDisplayMetrics().density);
        } else {
            KeyboardUtils.focusedComponentY = 0;
        }
        KeyboardUtils.showSoftInput(this.f18493c.getWebView());
    }

    private static class SoftInputChangedListener implements KeyboardUtils.OnSoftInputChangedListener {
        private final Context ctx;

        private SoftInputChangedListener(Activity activity) {
            this.ctx = activity.getApplication();
        }

        public void onSoftInputChanged(int i) {
            JSONUtil.put(new JSONObject(), "height", PixUtil.px2dip(this.ctx, (float) i));
        }
    }
}
