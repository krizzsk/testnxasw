package com.didi.sdk.audiorecorder.utils.log;

/* renamed from: com.didi.sdk.audiorecorder.utils.log.a */
/* compiled from: RecoveryCoordinator */
final class C12950a {

    /* renamed from: a */
    private static final long f38366a = 20;

    /* renamed from: b */
    private static final long f38367b = 327680;

    /* renamed from: c */
    private static final long f38368c = -1;

    /* renamed from: d */
    private long f38369d = 20;

    /* renamed from: e */
    private long f38370e = -1;

    /* renamed from: f */
    private long f38371f = (System.currentTimeMillis() + m28935c());

    C12950a() {
    }

    /* renamed from: a */
    public boolean mo97690a() {
        long b = m28934b();
        if (b <= this.f38371f) {
            return true;
        }
        this.f38371f = b + m28935c();
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo97689a(long j) {
        this.f38370e = j;
    }

    /* renamed from: b */
    private long m28934b() {
        long j = this.f38370e;
        return j != -1 ? j : System.currentTimeMillis();
    }

    /* renamed from: c */
    private long m28935c() {
        long j = this.f38369d;
        if (j < f38367b) {
            this.f38369d = 4 * j;
        }
        return j;
    }
}
