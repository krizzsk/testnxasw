package com.didi.sdk.logging;

/* renamed from: com.didi.sdk.logging.b */
/* compiled from: DefaultInvocationGate */
class C13221b implements InvocationGate {

    /* renamed from: a */
    static final int f39286a = 2;

    /* renamed from: b */
    static final int f39287b = 15;

    /* renamed from: e */
    private static final int f39288e = 65535;

    /* renamed from: h */
    private static final long f39289h = 100;

    /* renamed from: i */
    private static final long f39290i = 800;

    /* renamed from: c */
    long f39291c;

    /* renamed from: d */
    long f39292d;

    /* renamed from: f */
    private volatile long f39293f;

    /* renamed from: g */
    private long f39294g;

    /* renamed from: j */
    private long f39295j;

    /* renamed from: k */
    private long f39296k;

    C13221b() {
        this(100, 800, System.currentTimeMillis());
    }

    C13221b(long j, long j2, long j3) {
        this.f39293f = 15;
        this.f39294g = 0;
        this.f39295j = j;
        this.f39296k = j2;
        this.f39291c = j + j3;
        this.f39292d = j3 + j2;
    }

    public final boolean isTooSoon(long j) {
        long j2 = this.f39294g;
        this.f39294g = 1 + j2;
        boolean z = (j2 & this.f39293f) == this.f39293f;
        if (z) {
            if (j < this.f39291c) {
                m29611c();
            }
            m29610a(j);
        } else if (j > this.f39292d) {
            m29612d();
            m29610a(j);
            return false;
        }
        return !z;
    }

    /* renamed from: a */
    private void m29610a(long j) {
        this.f39291c = this.f39295j + j;
        this.f39292d = j + this.f39296k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo99018a() {
        return this.f39293f;
    }

    /* renamed from: c */
    private void m29611c() {
        if (this.f39293f < 65535) {
            this.f39293f = (this.f39293f << 1) | 1;
        }
    }

    /* renamed from: d */
    private void m29612d() {
        this.f39293f >>>= 2;
    }

    /* renamed from: b */
    public long mo99019b() {
        return this.f39294g;
    }
}
