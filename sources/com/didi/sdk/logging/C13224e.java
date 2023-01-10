package com.didi.sdk.logging;

/* renamed from: com.didi.sdk.logging.e */
/* compiled from: RecoveryCoordinator */
class C13224e {

    /* renamed from: a */
    public static final long f39309a = 20;

    /* renamed from: b */
    static long f39310b = 327680;

    /* renamed from: e */
    private static long f39311e = -1;

    /* renamed from: c */
    long f39312c = (System.currentTimeMillis() + m29625c());

    /* renamed from: d */
    private long f39313d = 20;

    /* renamed from: f */
    private long f39314f = f39311e;

    C13224e() {
    }

    /* renamed from: a */
    public boolean mo99024a() {
        long b = m29624b();
        if (b <= this.f39312c) {
            return true;
        }
        this.f39312c = b + m29625c();
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo99023a(long j) {
        this.f39314f = j;
    }

    /* renamed from: b */
    private long m29624b() {
        long j = this.f39314f;
        if (j != f39311e) {
            return j;
        }
        return System.currentTimeMillis();
    }

    /* renamed from: c */
    private long m29625c() {
        long j = this.f39313d;
        if (j < f39310b) {
            this.f39313d = 4 * j;
        }
        return j;
    }
}
