package com.didichuxing.mlcp.drtc.p192a;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.didichuxing.mlcp.drtc.enums.DrtcMessageType;
import com.didichuxing.mlcp.drtc.enums.DrtcSupportedPlugins;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16691a;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16694d;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16699i;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didichuxing.mlcp.drtc.a.a */
/* compiled from: DrtcAttachPluginTransaction */
class C16674a implements C16699i {

    /* renamed from: a */
    private final C16691a f50860a;

    /* renamed from: b */
    private final DrtcSupportedPlugins f50861b;

    /* renamed from: c */
    private final C16694d f50862c;

    public C16674a(C16691a aVar, DrtcSupportedPlugins drtcSupportedPlugins, C16694d dVar) {
        this.f50860a = aVar;
        this.f50861b = drtcSupportedPlugins;
        this.f50862c = dVar;
    }

    /* renamed from: a */
    public void mo125394a(JSONObject jSONObject) {
        try {
            if (DrtcMessageType.fromString(jSONObject.getString(SDKConsts.getSysConfig().f50902c)) != DrtcMessageType.success) {
                this.f50860a.mo125409c(jSONObject, this.f50861b, this.f50862c);
            } else {
                this.f50860a.mo125410d(jSONObject, this.f50861b, this.f50862c);
            }
        } catch (JSONException e) {
            this.f50860a.mo125407c(e.getMessage());
        }
    }
}
