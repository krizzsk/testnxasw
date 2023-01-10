package com.didi.dimina.container.bridge;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.TraceUtil;
import org.json.JSONObject;

public class ReportMiniProgramSubJSBridge {

    /* renamed from: a */
    private final DMMina f18541a;

    public ReportMiniProgramSubJSBridge(DMMina dMMina) {
        this.f18541a = dMMina;
    }

    public void report(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject == null) {
            CallBackUtil.onSuccess(callbackFunction);
            return;
        }
        TraceUtil.trackReportMiniProgramEvent(this.f18541a.getMinaIndex(), jSONObject);
        CallBackUtil.onSuccess(callbackFunction);
    }
}
