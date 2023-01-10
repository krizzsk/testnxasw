package com.didichuxing.mlcp.drtc.p192a;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.didichuxing.mlcp.drtc.enums.DrtcMessageType;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16695e;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16699i;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didichuxing.mlcp.drtc.a.b */
/* compiled from: DrtcCreateSessionTransaction */
class C16675b implements C16699i {

    /* renamed from: a */
    private final C16695e f50863a;

    public C16675b(C16695e eVar) {
        this.f50863a = eVar;
    }

    /* renamed from: a */
    public void mo125394a(JSONObject jSONObject) {
        try {
            if (DrtcMessageType.fromString(jSONObject.getString(SDKConsts.getSysConfig().f50902c)) != DrtcMessageType.success) {
                this.f50863a.mo125408c(jSONObject.getJSONObject("error"));
            } else {
                this.f50863a.mo125405b(jSONObject);
            }
        } catch (JSONException e) {
            this.f50863a.mo125407c(e.getMessage());
        }
    }
}
