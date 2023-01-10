package com.didi.dqr.common;

public final class BitSource {

    /* renamed from: a */
    private final byte[] f20395a;

    /* renamed from: b */
    private int f20396b;

    /* renamed from: c */
    private int f20397c;

    public BitSource(byte[] bArr) {
        this.f20395a = bArr;
    }

    public int getBitOffset() {
        return this.f20397c;
    }

    public int getByteOffset() {
        return this.f20396b;
    }

    public int readBits(int i) {
        if (i < 1 || i > 32 || i > available()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i2 = this.f20397c;
        byte b = 0;
        if (i2 > 0) {
            int i3 = 8 - i2;
            int i4 = i < i3 ? i : i3;
            int i5 = i3 - i4;
            byte[] bArr = this.f20395a;
            int i6 = this.f20396b;
            int i7 = (((255 >> (8 - i4)) << i5) & bArr[i6]) >> i5;
            i -= i4;
            int i8 = this.f20397c + i4;
            this.f20397c = i8;
            if (i8 == 8) {
                this.f20397c = 0;
                this.f20396b = i6 + 1;
            }
            b = i7;
        }
        if (i <= 0) {
            return b;
        }
        while (i >= 8) {
            int i9 = b << 8;
            byte[] bArr2 = this.f20395a;
            int i10 = this.f20396b;
            b = (bArr2[i10] & 255) | i9;
            this.f20396b = i10 + 1;
            i -= 8;
        }
        if (i <= 0) {
            return b;
        }
        int i11 = 8 - i;
        int i12 = (b << i) | ((((255 >> i11) << i11) & this.f20395a[this.f20396b]) >> i11);
        this.f20397c += i;
        return i12;
    }

    public int available() {
        return ((this.f20395a.length - this.f20396b) * 8) - this.f20397c;
    }
}
