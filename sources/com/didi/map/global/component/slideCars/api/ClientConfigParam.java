package com.didi.map.global.component.slideCars.api;

public class ClientConfigParam {

    /* renamed from: a */
    private String f28432a;

    /* renamed from: b */
    private String f28433b;

    /* renamed from: c */
    private String f28434c;

    /* renamed from: d */
    private String f28435d;

    /* renamed from: e */
    private int f28436e;

    /* renamed from: f */
    private String f28437f;

    public ClientConfigParam(String str, String str2, String str3, String str4, int i, String str5) {
        this.f28432a = str;
        this.f28433b = str2;
        this.f28434c = str3;
        this.f28435d = str4;
        this.f28436e = i;
        this.f28437f = str5;
    }

    public String getLocale() {
        return this.f28432a;
    }

    public void setLocale(String str) {
        this.f28432a = str;
    }

    public String getMapType() {
        return this.f28433b;
    }

    public void setMapType(String str) {
        this.f28433b = str;
    }

    public String getIdfa() {
        return this.f28434c;
    }

    public void setIdfa(String str) {
        this.f28434c = str;
    }

    public String getOriginId() {
        return this.f28435d;
    }

    public void setOriginId(String str) {
        this.f28435d = str;
    }

    public int getMixFlag() {
        return this.f28436e;
    }

    public void setMixFlag(int i) {
        this.f28436e = i;
    }

    public String getA3Token() {
        return this.f28437f;
    }

    public void setA3Token(String str) {
        this.f28437f = str;
    }
}
