package com.google.android.play.core.assetpacks;

import java.util.Arrays;

/* renamed from: com.google.android.play.core.assetpacks.dd */
final class C19973dd {

    /* renamed from: a */
    private byte[] f55929a = new byte[4096];

    /* renamed from: b */
    private int f55930b;

    /* renamed from: c */
    private long f55931c;

    /* renamed from: d */
    private long f55932d;

    /* renamed from: e */
    private int f55933e;

    /* renamed from: f */
    private int f55934f;

    /* renamed from: g */
    private int f55935g;

    /* renamed from: h */
    private boolean f55936h;

    /* renamed from: i */
    private String f55937i;

    public C19973dd() {
        mo164195c();
    }

    /* renamed from: a */
    private final int m42021a(int i, byte[] bArr, int i2, int i3) {
        int i4 = this.f55930b;
        if (i4 >= i) {
            return 0;
        }
        int min = Math.min(i3, i - i4);
        System.arraycopy(bArr, i2, this.f55929a, this.f55930b, min);
        int i5 = this.f55930b + min;
        this.f55930b = i5;
        if (i5 < i) {
            return -1;
        }
        return min;
    }

    /* renamed from: a */
    public final int mo164192a(byte[] bArr, int i, int i2) {
        int a = m42021a(30, bArr, i, i2);
        if (a == -1) {
            return -1;
        }
        if (this.f55931c == -1) {
            long b = C19971db.m42016b(this.f55929a, 0);
            this.f55931c = b;
            if (b == 67324752) {
                this.f55936h = false;
                this.f55932d = C19971db.m42016b(this.f55929a, 18);
                this.f55935g = C19971db.m42018c(this.f55929a, 8);
                this.f55933e = C19971db.m42018c(this.f55929a, 26);
                int c = this.f55933e + 30 + C19971db.m42018c(this.f55929a, 28);
                this.f55934f = c;
                int length = this.f55929a.length;
                if (length < c) {
                    do {
                        length += length;
                    } while (length < c);
                    this.f55929a = Arrays.copyOf(this.f55929a, length);
                }
            } else {
                this.f55936h = true;
            }
        }
        int a2 = m42021a(this.f55934f, bArr, i + a, i2 - a);
        if (a2 == -1) {
            return -1;
        }
        int i3 = a + a2;
        if (!this.f55936h && this.f55937i == null) {
            this.f55937i = new String(this.f55929a, 30, this.f55933e);
        }
        return i3;
    }

    /* renamed from: a */
    public final C19993dx mo164193a() {
        int i = this.f55930b;
        int i2 = this.f55934f;
        if (i < i2) {
            return C19993dx.m42061a(this.f55937i, this.f55932d, this.f55935g, true, Arrays.copyOf(this.f55929a, i), this.f55936h);
        }
        C19993dx a = C19993dx.m42061a(this.f55937i, this.f55932d, this.f55935g, false, Arrays.copyOf(this.f55929a, i2), this.f55936h);
        mo164195c();
        return a;
    }

    /* renamed from: b */
    public final int mo164194b() {
        return this.f55934f;
    }

    /* renamed from: c */
    public final void mo164195c() {
        this.f55930b = 0;
        this.f55933e = -1;
        this.f55931c = -1;
        this.f55936h = false;
        this.f55934f = 30;
        this.f55932d = -1;
        this.f55935g = -1;
        this.f55937i = null;
    }
}
