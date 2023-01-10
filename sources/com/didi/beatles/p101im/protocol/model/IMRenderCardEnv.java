package com.didi.beatles.p101im.protocol.model;

import java.util.Map;

/* renamed from: com.didi.beatles.im.protocol.model.IMRenderCardEnv */
public class IMRenderCardEnv {

    /* renamed from: a */
    private String f11408a;

    /* renamed from: b */
    private Map<String, String> f11409b;
    public final long sessionId;

    public IMRenderCardEnv(long j, String str, Map<String, String> map) {
        this.sessionId = j;
        this.f11408a = str;
        this.f11409b = map;
    }

    public void setOrderId(String str) {
        this.f11408a = str;
    }

    public String getOrderId() {
        return this.f11408a;
    }

    public void setExtraTraceMap(Map<String, String> map) {
        this.f11409b = map;
    }

    public Map<String, String> getExtraTraceMap() {
        return this.f11409b;
    }
}
