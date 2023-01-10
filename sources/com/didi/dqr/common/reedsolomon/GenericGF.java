package com.didi.dqr.common.reedsolomon;

import org.osgi.framework.VersionRange;

public final class GenericGF {
    public static final GenericGF DATA_MATRIX_FIELD_256 = new GenericGF(301, 256, 1);
    public static final GenericGF QR_CODE_FIELD_256 = new GenericGF(285, 256, 0);

    /* renamed from: a */
    private final int[] f20446a;

    /* renamed from: b */
    private final int[] f20447b;

    /* renamed from: c */
    private final C8422a f20448c;

    /* renamed from: d */
    private final C8422a f20449d;

    /* renamed from: e */
    private final int f20450e;

    /* renamed from: f */
    private final int f20451f;

    /* renamed from: g */
    private final int f20452g;

    /* renamed from: b */
    static int m17167b(int i, int i2) {
        return i ^ i2;
    }

    public GenericGF(int i, int i2, int i3) {
        this.f20451f = i;
        this.f20450e = i2;
        this.f20452g = i3;
        this.f20446a = new int[i2];
        this.f20447b = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.f20446a[i5] = i4;
            i4 *= 2;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.f20447b[this.f20446a[i6]] = i6;
        }
        this.f20448c = new C8422a(this, new int[]{0});
        this.f20449d = new C8422a(this, new int[]{1});
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C8422a mo63230a() {
        return this.f20448c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C8422a mo63233b() {
        return this.f20449d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C8422a mo63231a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f20448c;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new C8422a(this, iArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo63229a(int i) {
        return this.f20446a[i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo63232b(int i) {
        if (i != 0) {
            return this.f20447b[i];
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo63234c(int i) {
        if (i != 0) {
            return this.f20446a[(this.f20450e - this.f20447b[i]) - 1];
        }
        throw new ArithmeticException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo63235c(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.f20446a;
        int[] iArr2 = this.f20447b;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.f20450e - 1)];
    }

    public int getSize() {
        return this.f20450e;
    }

    public int getGeneratorBase() {
        return this.f20452g;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f20451f) + ',' + this.f20450e + VersionRange.RIGHT_OPEN;
    }
}
