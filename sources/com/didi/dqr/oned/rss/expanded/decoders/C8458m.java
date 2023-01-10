package com.didi.dqr.oned.rss.expanded.decoders;

/* renamed from: com.didi.dqr.oned.rss.expanded.decoders.m */
/* compiled from: DecodedInformation */
final class C8458m extends C8460o {

    /* renamed from: a */
    private final String f20720a;

    /* renamed from: b */
    private final int f20721b;

    /* renamed from: c */
    private final boolean f20722c;

    C8458m(int i, String str) {
        super(i);
        this.f20720a = str;
        this.f20722c = false;
        this.f20721b = 0;
    }

    C8458m(int i, String str, int i2) {
        super(i);
        this.f20722c = true;
        this.f20721b = i2;
        this.f20720a = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo63390a() {
        return this.f20720a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo63391b() {
        return this.f20722c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo63392c() {
        return this.f20721b;
    }
}
