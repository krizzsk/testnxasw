package com.didichuxing.mas.sdk.quality.collect.cdnmonitor.ping;

public class PingResult {

    /* renamed from: a */
    private String f50348a;

    /* renamed from: b */
    private float f50349b;

    /* renamed from: c */
    private float f50350c;

    /* renamed from: d */
    private String f50351d;

    public String getDetectIp() {
        return this.f50348a;
    }

    public String getPingResponse() {
        return this.f50351d;
    }

    public float getPingTime() {
        return this.f50349b;
    }

    public float getPingErrorRadio() {
        return this.f50350c;
    }

    PingResult(String str, float f, float f2, String str2) {
        this.f50348a = str;
        this.f50349b = f;
        this.f50350c = f2;
        this.f50351d = str2;
    }
}
