package com.didichuxing.mas.sdk.quality.collect.duration;

public class SubDurationEvent {

    /* renamed from: a */
    private String f50647a;

    /* renamed from: b */
    private long f50648b = System.currentTimeMillis();

    /* renamed from: c */
    private long f50649c;

    public SubDurationEvent(String str) {
        this.f50647a = str;
    }

    public void end() {
        this.f50649c = System.currentTimeMillis() - this.f50648b;
    }

    public String getSubEventName() {
        return this.f50647a;
    }

    public long getSubEventTime() {
        return this.f50649c;
    }
}
