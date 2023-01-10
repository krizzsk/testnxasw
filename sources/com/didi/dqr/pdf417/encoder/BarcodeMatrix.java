package com.didi.dqr.pdf417.encoder;

import java.lang.reflect.Array;

public final class BarcodeMatrix {

    /* renamed from: a */
    private final C8473a[] f20838a;

    /* renamed from: b */
    private int f20839b;

    /* renamed from: c */
    private final int f20840c;

    /* renamed from: d */
    private final int f20841d;

    BarcodeMatrix(int i, int i2) {
        C8473a[] aVarArr = new C8473a[i];
        this.f20838a = aVarArr;
        int length = aVarArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f20838a[i3] = new C8473a(((i2 + 4) * 17) + 1);
        }
        this.f20841d = i2 * 17;
        this.f20840c = i;
        this.f20839b = -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo63501a(int i, int i2, byte b) {
        this.f20838a[i2].mo63515a(i, b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo63500a() {
        this.f20839b++;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C8473a mo63502b() {
        return this.f20838a[this.f20839b];
    }

    public byte[][] getMatrix() {
        return getScaledMatrix(1, 1);
    }

    public byte[][] getScaledMatrix(int i, int i2) {
        int[] iArr = new int[2];
        iArr[1] = this.f20841d * i;
        iArr[0] = this.f20840c * i2;
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, iArr);
        int i3 = this.f20840c * i2;
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[(i3 - i4) - 1] = this.f20838a[i4 / i2].mo63517a(i);
        }
        return bArr;
    }
}
