package com.didi.dimina.starbox.module.jsbridge;

import android.content.Context;
import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.jsengine.JSEngine;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.sdk.util.ToastUtil;
import org.json.JSONObject;

public class GCSubJSBridge {

    /* renamed from: a */
    private final Context f19877a;

    GCSubJSBridge(Context context) {
        LogUtil.m16841i("GCSubJSBridge init");
        this.f19877a = context;
    }

    /* renamed from: gc */
    public void mo62030gc(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("GCSubJSBridge GC");
        LogUtil.m16841i("PageInfoSubJSBridge getPageInfo");
        String optString = jSONObject.optString("appId", "");
        if (TextUtils.isEmpty(optString)) {
            CallBackUtil.onFail("appId 为空", callbackFunction);
            return;
        }
        DMMina findDMMinaByAppId = DMMinaPool.findDMMinaByAppId(optString);
        if (findDMMinaByAppId == null) {
            CallBackUtil.onFail("小程序实例不存在", callbackFunction);
            return;
        }
        if (findDMMinaByAppId.getJSEngine() != null) {
            findDMMinaByAppId.getJSEngine().onLowMemory();
            findDMMinaByAppId.getJSEngine().notifyMemoryPress(JSEngine.PressLevel.CRITICAL);
        }
        ToastUtil.show(this.f19877a, (CharSequence) "小程序触发GC");
        CallBackUtil.onSuccess(callbackFunction);
    }
}
