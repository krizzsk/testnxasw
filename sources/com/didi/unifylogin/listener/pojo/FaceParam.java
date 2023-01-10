package com.didi.unifylogin.listener.pojo;

public class FaceParam {

    /* renamed from: a */
    private String f47475a;

    /* renamed from: b */
    private String f47476b;

    /* renamed from: c */
    private int f47477c;

    public String getSessionId() {
        return this.f47475a;
    }

    public FaceParam setSessionId(String str) {
        this.f47475a = str;
        return this;
    }

    public String getAccessToken() {
        return this.f47476b;
    }

    public FaceParam setAccessToken(String str) {
        this.f47476b = str;
        return this;
    }

    public void setBizCode(int i) {
        this.f47477c = i;
    }

    public int getBizCode() {
        return this.f47477c;
    }
}
