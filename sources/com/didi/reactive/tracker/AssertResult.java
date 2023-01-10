package com.didi.reactive.tracker;

public class AssertResult {

    /* renamed from: OK */
    public static AssertResult f35886OK = new AssertResult(true, (String) null);

    /* renamed from: a */
    private boolean f35887a;

    /* renamed from: b */
    private String f35888b;

    public AssertResult(boolean z, String str) {
        this.f35887a = z;
        this.f35888b = str;
    }

    public boolean isPass() {
        return this.f35887a;
    }

    public String getMessage() {
        return this.f35888b;
    }
}
