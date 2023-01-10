package com.didi.map.global.component.line.data.param;

import com.didichuxing.routesearchsdk.CallFrom;

public class BaseLineRequest {

    /* renamed from: a */
    private String f28069a;

    /* renamed from: b */
    private CallFrom f28070b;

    public BaseLineRequest(CallFrom callFrom, String str) {
        this.f28070b = callFrom;
        this.f28069a = str;
    }

    public String getProductId() {
        return this.f28069a;
    }

    public void setProductId(String str) {
        this.f28069a = str;
    }

    public CallFrom getCallFrom() {
        return this.f28070b;
    }

    public void setCallFrom(CallFrom callFrom) {
        this.f28070b = callFrom;
    }
}
