package com.didichuxing.sdk.alphaface.utils;

public class SkipFrame {

    /* renamed from: a */
    private final long f51325a;

    /* renamed from: b */
    private long f51326b;

    /* renamed from: c */
    private int f51327c;

    public SkipFrame(long j) {
        this.f51325a = j;
    }

    public boolean skip() {
        if (System.currentTimeMillis() - this.f51326b <= this.f51325a) {
            return true;
        }
        this.f51326b = System.currentTimeMillis();
        this.f51327c++;
        return false;
    }

    public void reset() {
        this.f51326b = 0;
        this.f51327c = 0;
    }

    public int getFrame() {
        return this.f51327c;
    }
}
