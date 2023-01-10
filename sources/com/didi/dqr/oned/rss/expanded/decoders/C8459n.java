package com.didi.dqr.oned.rss.expanded.decoders;

import com.didi.dqr.FormatException;

/* renamed from: com.didi.dqr.oned.rss.expanded.decoders.n */
/* compiled from: DecodedNumeric */
final class C8459n extends C8460o {

    /* renamed from: a */
    static final int f20723a = 10;

    /* renamed from: b */
    private final int f20724b;

    /* renamed from: c */
    private final int f20725c;

    C8459n(int i, int i2, int i3) throws FormatException {
        super(i);
        if (i2 < 0 || i2 > 10 || i3 < 0 || i3 > 10) {
            throw FormatException.getFormatInstance();
        }
        this.f20724b = i2;
        this.f20725c = i3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo63393a() {
        return this.f20724b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo63394b() {
        return this.f20725c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo63395c() {
        return (this.f20724b * 10) + this.f20725c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo63396d() {
        return this.f20724b == 10;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo63397e() {
        return this.f20725c == 10;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo63398f() {
        return this.f20724b == 10 || this.f20725c == 10;
    }
}
