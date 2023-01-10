package com.didi.dimina.container.bridge;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.SnapShotUtil;
import org.json.JSONObject;

public class SnapshotSubJSBridge {
    public SnapshotSubJSBridge() {
        LogUtil.m16841i("SnapshotSubJSBridge init");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo59511a(DMMina dMMina, JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (dMMina != null && dMMina.getCurNavigator() != null && dMMina.getCurNavigator().getCurrentPage() != null) {
            SnapShotUtil.getInstance().saveSnapshot(dMMina.getCurNavigator().getCurrentPage().getPage());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo59512b(DMMina dMMina, JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (dMMina != null && dMMina.getCurNavigator() != null && dMMina.getCurNavigator().getCurrentPage() != null) {
            SnapShotUtil.getInstance().hideSnapshot(dMMina.getCurNavigator().getCurrentPage().getPage());
            CallBackUtil.onSuccess(callbackFunction);
        }
    }
}
