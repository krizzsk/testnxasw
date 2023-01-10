package com.didichuxing.mlcp.drtc.p192a;

import android.content.Context;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16698h;
import com.didichuxing.mlcp.drtc.models.C16700a;
import org.json.JSONObject;
import org.webrtc.EglBase;

/* renamed from: com.didichuxing.mlcp.drtc.a.h */
/* compiled from: PluginHandleWebRTCCallbacks */
public class C16685h implements C16698h {

    /* renamed from: a */
    private final C16700a f50889a;

    /* renamed from: b */
    private final JSONObject f50890b;

    /* renamed from: c */
    private final boolean f50891c;

    public C16685h(C16700a aVar, JSONObject jSONObject, boolean z) {
        this.f50889a = aVar;
        this.f50890b = jSONObject;
        this.f50891c = z;
    }

    /* renamed from: a */
    public void mo125425a(JSONObject jSONObject) {
    }

    /* renamed from: b */
    public Context mo125426b() {
        return null;
    }

    /* renamed from: c */
    public void mo125407c(String str) {
    }

    /* renamed from: j */
    public JSONObject mo125427j() {
        return this.f50890b;
    }

    /* renamed from: m */
    public EglBase.Context mo125428m() {
        return null;
    }

    /* renamed from: r */
    public C16700a mo125429r() {
        return this.f50889a;
    }

    /* renamed from: s */
    public Boolean mo125430s() {
        return Boolean.valueOf(this.f50891c);
    }
}
