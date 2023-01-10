package com.iproov.sdk.core;

/* renamed from: com.iproov.sdk.core.c */
/* compiled from: SupplementaryImageryManager */
class C20784c {

    /* renamed from: a */
    private int f56937a = 0;

    /* renamed from: b */
    private int f56938b = 0;

    /* renamed from: c */
    private Long f56939c;

    /* renamed from: d */
    private boolean f56940d = false;

    /* renamed from: e */
    private volatile boolean f56941e = false;

    C20784c() {
    }

    /* renamed from: a */
    public void mo171367a() {
        this.f56941e = true;
    }

    /* renamed from: a */
    public void mo171368a(boolean z) {
        this.f56940d = z;
    }

    /* renamed from: b */
    public synchronized boolean mo171369b() {
        Long l;
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f56940d || (((l = this.f56939c) != null && l.longValue() >= currentTimeMillis) || this.f56941e || (i = this.f56938b) >= 10)) {
            return false;
        }
        this.f56937a++;
        this.f56938b = i + 1;
        this.f56939c = Long.valueOf(currentTimeMillis + 1000);
        return true;
    }

    /* renamed from: c */
    public synchronized boolean mo171370c() {
        int i;
        if (!this.f56940d || (i = this.f56937a) <= 0) {
            return false;
        }
        this.f56937a = i - 1;
        return true;
    }
}
