package com.didi.component.evaluate.model;

public class EvaluateTag {

    /* renamed from: a */
    private String f15152a;

    /* renamed from: b */
    private long f15153b;

    /* renamed from: c */
    private String f15154c;

    public EvaluateTag(String str) {
        this.f15152a = str;
    }

    public EvaluateTag(String str, long j, String str2) {
        this.f15152a = str;
        this.f15153b = j;
        this.f15154c = str2;
    }

    public String getText() {
        return this.f15152a;
    }

    public long getId() {
        return this.f15153b;
    }

    public String getIcon() {
        return this.f15154c;
    }
}
