package com.didi.dqr.pdf417.decoder.p110ec;

/* renamed from: com.didi.dqr.pdf417.decoder.ec.ModulusGF */
public final class ModulusGF {
    public static final ModulusGF PDF417_GF = new ModulusGF(929, 3);

    /* renamed from: a */
    private final int[] f20813a;

    /* renamed from: b */
    private final int[] f20814b;

    /* renamed from: c */
    private final C8469a f20815c;

    /* renamed from: d */
    private final C8469a f20816d;

    /* renamed from: e */
    private final int f20817e;

    private ModulusGF(int i, int i2) {
        this.f20817e = i;
        this.f20813a = new int[i];
        this.f20814b = new int[i];
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            this.f20813a[i4] = i3;
            i3 = (i3 * i2) % i;
        }
        for (int i5 = 0; i5 < i - 1; i5++) {
            this.f20814b[this.f20813a[i5]] = i5;
        }
        this.f20815c = new C8469a(this, new int[]{0});
        this.f20816d = new C8469a(this, new int[]{1});
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C8469a mo63466a() {
        return this.f20815c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C8469a mo63470b() {
        return this.f20816d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C8469a mo63467a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f20815c;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new C8469a(this, iArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo63469b(int i, int i2) {
        return (i + i2) % this.f20817e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo63473c(int i, int i2) {
        int i3 = this.f20817e;
        return ((i + i3) - i2) % i3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo63465a(int i) {
        return this.f20813a[i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo63468b(int i) {
        if (i != 0) {
            return this.f20814b[i];
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo63472c(int i) {
        if (i != 0) {
            return this.f20813a[(this.f20817e - this.f20814b[i]) - 1];
        }
        throw new ArithmeticException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo63474d(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.f20813a;
        int[] iArr2 = this.f20814b;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.f20817e - 1)];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo63471c() {
        return this.f20817e;
    }
}
