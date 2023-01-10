package com.didichuxing.mlcp.drtc.p192a;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.didichuxing.mlcp.drtc.enums.DrtcMessageType;
import com.didichuxing.mlcp.drtc.enums.DrtcSupportedPlugins;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16693c;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16694d;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16699i;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didichuxing.mlcp.drtc.a.c */
/* compiled from: DrtcDetachPluginTransaction */
class C16676c implements C16699i {

    /* renamed from: a */
    private final C16693c f50864a;

    /* renamed from: b */
    private final DrtcSupportedPlugins f50865b;

    /* renamed from: c */
    private final C16694d f50866c;

    public C16676c(C16693c cVar, DrtcSupportedPlugins drtcSupportedPlugins, C16694d dVar) {
        this.f50864a = cVar;
        this.f50865b = drtcSupportedPlugins;
        this.f50866c = dVar;
    }

    /* renamed from: a */
    public void mo125394a(JSONObject jSONObject) {
        try {
            if (DrtcMessageType.fromString(jSONObject.getString(SDKConsts.getSysConfig().f50902c)) != DrtcMessageType.success) {
                this.f50864a.mo125406b(jSONObject, this.f50865b, this.f50866c);
            } else {
                this.f50864a.mo125401a(jSONObject, this.f50865b, this.f50866c);
            }
        } catch (JSONException e) {
            this.f50864a.mo125407c(e.getMessage());
        }
    }
}
