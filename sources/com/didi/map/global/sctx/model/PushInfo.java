package com.didi.map.global.sctx.model;

public class PushInfo {

    /* renamed from: a */
    private String f30099a;

    /* renamed from: b */
    private String f30100b;

    public String getIp() {
        return this.f30099a;
    }

    public void setIp(String str) {
        this.f30099a = str;
    }

    public String getPort() {
        return this.f30100b;
    }

    public void setPort(String str) {
        this.f30100b = str;
    }

    public String toString() {
        return "PushInfo{ip='" + this.f30099a + '\'' + ", port='" + this.f30100b + '\'' + '}';
    }
}
