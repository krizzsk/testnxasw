package com.didi.dqr.pdf417.decoder;

/* renamed from: com.didi.dqr.pdf417.decoder.d */
/* compiled from: Codeword */
final class C8467d {

    /* renamed from: a */
    private static final int f20801a = -1;

    /* renamed from: b */
    private final int f20802b;

    /* renamed from: c */
    private final int f20803c;

    /* renamed from: d */
    private final int f20804d;

    /* renamed from: e */
    private final int f20805e;

    /* renamed from: f */
    private int f20806f = -1;

    C8467d(int i, int i2, int i3, int i4) {
        this.f20802b = i;
        this.f20803c = i2;
        this.f20804d = i3;
        this.f20805e = i4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo63444a() {
        return mo63445a(this.f20806f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo63445a(int i) {
        return i != -1 && this.f20804d == (i % 3) * 3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo63446b() {
        this.f20806f = ((this.f20805e / 30) * 3) + (this.f20804d / 3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo63448c() {
        return this.f20803c - this.f20802b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo63449d() {
        return this.f20802b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo63450e() {
        return this.f20803c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo63451f() {
        return this.f20804d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public int mo63452g() {
        return this.f20805e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public int mo63453h() {
        return this.f20806f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo63447b(int i) {
        this.f20806f = i;
    }

    public String toString() {
        return this.f20806f + "|" + this.f20805e;
    }
}
