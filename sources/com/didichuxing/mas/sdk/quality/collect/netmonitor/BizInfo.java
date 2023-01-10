package com.didichuxing.mas.sdk.quality.collect.netmonitor;

public class BizInfo {

    /* renamed from: a */
    private int f50721a;

    /* renamed from: b */
    private String f50722b;

    /* renamed from: c */
    private long f50723c;

    public BizInfo(int i, String str) {
        this.f50721a = i;
        this.f50722b = str;
    }

    public int getBizId() {
        return this.f50721a;
    }

    public void setBizId(int i) {
        this.f50721a = i;
    }

    public String getUrl() {
        return this.f50722b;
    }

    public void setUrl(String str) {
        this.f50722b = str;
    }

    public long getReqTime() {
        return this.f50723c;
    }

    public void setReqTime(long j) {
        this.f50723c = j;
    }
}
