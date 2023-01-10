package com.didi.dqr.qrcode.encoder;

import java.lang.reflect.Array;
import java.util.Arrays;

public final class ByteMatrix {

    /* renamed from: a */
    private final byte[][] f20951a;

    /* renamed from: b */
    private final int f20952b;

    /* renamed from: c */
    private final int f20953c;

    public ByteMatrix(int i, int i2) {
        int[] iArr = new int[2];
        iArr[1] = i;
        iArr[0] = i2;
        this.f20951a = (byte[][]) Array.newInstance(byte.class, iArr);
        this.f20952b = i;
        this.f20953c = i2;
    }

    public int getHeight() {
        return this.f20953c;
    }

    public int getWidth() {
        return this.f20952b;
    }

    public byte get(int i, int i2) {
        return this.f20951a[i2][i];
    }

    public byte[][] getArray() {
        return this.f20951a;
    }

    public void set(int i, int i2, byte b) {
        this.f20951a[i2][i] = b;
    }

    public void set(int i, int i2, int i3) {
        this.f20951a[i2][i] = (byte) i3;
    }

    public void set(int i, int i2, boolean z) {
        this.f20951a[i2][i] = z ? (byte) 1 : 0;
    }

    public void clear(byte b) {
        for (byte[] fill : this.f20951a) {
            Arrays.fill(fill, b);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f20952b * 2 * this.f20953c) + 2);
        for (int i = 0; i < this.f20953c; i++) {
            byte[] bArr = this.f20951a[i];
            for (int i2 = 0; i2 < this.f20952b; i2++) {
                byte b = bArr[i2];
                if (b == 0) {
                    sb.append(" 0");
                } else if (b != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append(10);
        }
        return sb.toString();
    }
}
