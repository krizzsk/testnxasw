package com.didi.dqr.common;

import java.util.Arrays;

public final class BitArray implements Cloneable {

    /* renamed from: a */
    private int[] f20388a;

    /* renamed from: b */
    private int f20389b;

    public BitArray() {
        this.f20389b = 0;
        this.f20388a = new int[1];
    }

    public BitArray(int i) {
        this.f20389b = i;
        this.f20388a = m17154b(i);
    }

    BitArray(int[] iArr, int i) {
        this.f20388a = iArr;
        this.f20389b = i;
    }

    public int getSize() {
        return this.f20389b;
    }

    public int getSizeInBytes() {
        return (this.f20389b + 7) / 8;
    }

    /* renamed from: a */
    private void m17153a(int i) {
        if (i > this.f20388a.length * 32) {
            int[] b = m17154b(i);
            int[] iArr = this.f20388a;
            System.arraycopy(iArr, 0, b, 0, iArr.length);
            this.f20388a = b;
        }
    }

    public boolean get(int i) {
        return ((1 << (i & 31)) & this.f20388a[i / 32]) != 0;
    }

    public void set(int i) {
        int[] iArr = this.f20388a;
        int i2 = i / 32;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    public void flip(int i) {
        int[] iArr = this.f20388a;
        int i2 = i / 32;
        iArr[i2] = (1 << (i & 31)) ^ iArr[i2];
    }

    public int getNextSet(int i) {
        int i2 = this.f20389b;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        int i4 = (~((1 << (i & 31)) - 1)) & this.f20388a[i3];
        while (i4 == 0) {
            i3++;
            int[] iArr = this.f20388a;
            if (i3 == iArr.length) {
                return this.f20389b;
            }
            i4 = iArr[i3];
        }
        int numberOfTrailingZeros = (i3 * 32) + Integer.numberOfTrailingZeros(i4);
        int i5 = this.f20389b;
        return numberOfTrailingZeros > i5 ? i5 : numberOfTrailingZeros;
    }

    public int getNextUnset(int i) {
        int i2 = this.f20389b;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        int i4 = (~((1 << (i & 31)) - 1)) & (~this.f20388a[i3]);
        while (i4 == 0) {
            i3++;
            int[] iArr = this.f20388a;
            if (i3 == iArr.length) {
                return this.f20389b;
            }
            i4 = ~iArr[i3];
        }
        int numberOfTrailingZeros = (i3 * 32) + Integer.numberOfTrailingZeros(i4);
        int i5 = this.f20389b;
        return numberOfTrailingZeros > i5 ? i5 : numberOfTrailingZeros;
    }

    public void setBulk(int i, int i2) {
        this.f20388a[i / 32] = i2;
    }

    public void setRange(int i, int i2) {
        if (i2 < i || i < 0 || i2 > this.f20389b) {
            throw new IllegalArgumentException();
        } else if (i2 != i) {
            int i3 = i2 - 1;
            int i4 = i / 32;
            int i5 = i3 / 32;
            int i6 = i4;
            while (i6 <= i5) {
                int i7 = 31;
                int i8 = i6 > i4 ? 0 : i & 31;
                if (i6 >= i5) {
                    i7 = 31 & i3;
                }
                int i9 = (2 << i7) - (1 << i8);
                int[] iArr = this.f20388a;
                iArr[i6] = i9 | iArr[i6];
                i6++;
            }
        }
    }

    public void clear() {
        int length = this.f20388a.length;
        for (int i = 0; i < length; i++) {
            this.f20388a[i] = 0;
        }
    }

    public boolean isRange(int i, int i2, boolean z) {
        if (i2 < i || i < 0 || i2 > this.f20389b) {
            throw new IllegalArgumentException();
        } else if (i2 == i) {
            return true;
        } else {
            int i3 = i2 - 1;
            int i4 = i / 32;
            int i5 = i3 / 32;
            int i6 = i4;
            while (i6 <= i5) {
                int i7 = 31;
                int i8 = i6 > i4 ? 0 : i & 31;
                if (i6 >= i5) {
                    i7 = 31 & i3;
                }
                int i9 = (2 << i7) - (1 << i8);
                int i10 = this.f20388a[i6] & i9;
                if (!z) {
                    i9 = 0;
                }
                if (i10 != i9) {
                    return false;
                }
                i6++;
            }
            return true;
        }
    }

    public boolean isRange2(int i, int i2, boolean z) {
        if (i2 >= i && i >= 0 && i2 <= this.f20389b) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    public void appendBit(boolean z) {
        m17153a(this.f20389b + 1);
        if (z) {
            int[] iArr = this.f20388a;
            int i = this.f20389b;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.f20389b++;
    }

    public void appendBits(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        m17153a(this.f20389b + i2);
        while (i2 > 0) {
            boolean z = true;
            if (((i >> (i2 - 1)) & 1) != 1) {
                z = false;
            }
            appendBit(z);
            i2--;
        }
    }

    public void appendBitArray(BitArray bitArray) {
        int i = bitArray.f20389b;
        m17153a(this.f20389b + i);
        for (int i2 = 0; i2 < i; i2++) {
            appendBit(bitArray.get(i2));
        }
    }

    public void xor(BitArray bitArray) {
        if (this.f20389b == bitArray.f20389b) {
            int i = 0;
            while (true) {
                int[] iArr = this.f20388a;
                if (i < iArr.length) {
                    iArr[i] = iArr[i] ^ bitArray.f20388a[i];
                    i++;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Sizes don't match");
        }
    }

    public void toBytes(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < 8; i6++) {
                if (get(i)) {
                    i5 |= 1 << (7 - i6);
                }
                i++;
            }
            bArr[i2 + i4] = (byte) i5;
        }
    }

    public int[] getBitArray() {
        return this.f20388a;
    }

    public void reverse() {
        int[] iArr = new int[this.f20388a.length];
        int i = (this.f20389b - 1) / 32;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            long j = (long) this.f20388a[i3];
            long j2 = ((j & 1431655765) << 1) | ((j >> 1) & 1431655765);
            long j3 = ((j2 & 858993459) << 2) | ((j2 >> 2) & 858993459);
            long j4 = ((j3 & 252645135) << 4) | ((j3 >> 4) & 252645135);
            long j5 = ((j4 & 16711935) << 8) | ((j4 >> 8) & 16711935);
            iArr[i - i3] = (int) (((j5 & 65535) << 16) | ((j5 >> 16) & 65535));
        }
        int i4 = this.f20389b;
        int i5 = i2 * 32;
        if (i4 != i5) {
            int i6 = i5 - i4;
            int i7 = iArr[0] >>> i6;
            for (int i8 = 1; i8 < i2; i8++) {
                int i9 = iArr[i8];
                iArr[i8 - 1] = i7 | (i9 << (32 - i6));
                i7 = i9 >>> i6;
            }
            iArr[i2 - 1] = i7;
        }
        this.f20388a = iArr;
    }

    /* renamed from: b */
    private static int[] m17154b(int i) {
        return new int[((i + 31) / 32)];
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitArray)) {
            return false;
        }
        BitArray bitArray = (BitArray) obj;
        if (this.f20389b != bitArray.f20389b || !Arrays.equals(this.f20388a, bitArray.f20388a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f20389b * 31) + Arrays.hashCode(this.f20388a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f20389b);
        for (int i = 0; i < this.f20389b; i++) {
            if ((i & 7) == 0) {
                sb.append(' ');
            }
            sb.append(get(i) ? 'X' : '.');
        }
        return sb.toString();
    }

    public BitArray clone() {
        return new BitArray((int[]) this.f20388a.clone(), this.f20389b);
    }
}
