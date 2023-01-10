package com.didi.dimina.container.bridge;

import android.content.Context;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.toast.ToastServiceManager;
import com.didi.dimina.container.bridge.toast.ToastType;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.bridge.h */
/* compiled from: ToastSubJSBridge */
class C8045h {

    /* renamed from: a */
    private final Context f18621a;

    /* renamed from: b */
    private final ToastServiceManager f18622b;

    public C8045h(Context context) {
        this.f18621a = context;
        this.f18622b = new ToastServiceManager(context);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo59688a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("ToastSubJSBridge showToast");
        ToastType toastType = ToastType.SUCCESS;
        if (jSONObject.has("title")) {
            String optString = jSONObject.optString("title");
            if (jSONObject.has("icon")) {
                String optString2 = jSONObject.optString("icon");
                if ("error".equals(optString2)) {
                    toastType = ToastType.ERROR;
                } else if ("loading".equals(optString2)) {
                    toastType = ToastType.LOADING;
                } else if ("none".equals(optString2)) {
                    toastType = ToastType.NONE;
                }
            }
            this.f18622b.showToast(toastType, optString, jSONObject.has("duration") ? jSONObject.optInt("duration") : 1500);
            CallBackUtil.onSuccess(callbackFunction);
            return;
        }
        CallBackUtil.onFail("参数出错", callbackFunction);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo59689b(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ToastServiceManager toastServiceManager = this.f18622b;
        if (toastServiceManager != null) {
            toastServiceManager.hideToast();
        }
        if (callbackFunction != null) {
            CallBackUtil.onSuccess(callbackFunction);
        }
    }
}
