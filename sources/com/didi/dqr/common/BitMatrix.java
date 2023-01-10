package com.didi.dqr.common;

import java.util.Arrays;

public final class BitMatrix implements Cloneable {

    /* renamed from: a */
    private final int f20390a;

    /* renamed from: b */
    private final int f20391b;

    /* renamed from: c */
    private final int f20392c;

    /* renamed from: d */
    private final int[] f20393d;

    /* renamed from: e */
    private byte[] f20394e;

    public BitMatrix(int i) {
        this(i, i);
    }

    public BitMatrix(int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f20390a = i;
        this.f20391b = i2;
        int i3 = (i + 31) / 32;
        this.f20392c = i3;
        this.f20393d = new int[(i3 * i2)];
    }

    private BitMatrix(int i, int i2, int i3, int[] iArr) {
        this.f20390a = i;
        this.f20391b = i2;
        this.f20392c = i3;
        this.f20393d = iArr;
    }

    public static BitMatrix parse(boolean[][] zArr) {
        int length = zArr.length;
        int length2 = zArr[0].length;
        BitMatrix bitMatrix = new BitMatrix(length2, length);
        for (int i = 0; i < length; i++) {
            boolean[] zArr2 = zArr[i];
            for (int i2 = 0; i2 < length2; i2++) {
                if (zArr2[i2]) {
                    bitMatrix.set(i2, i);
                }
            }
        }
        return bitMatrix;
    }

    public static BitMatrix parse(String str, String str2, String str3) {
        if (str != null) {
            boolean[] zArr = new boolean[str.length()];
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = -1;
            int i5 = 0;
            while (i < str.length()) {
                if (str.charAt(i) == 10 || str.charAt(i) == 13) {
                    if (i2 > i3) {
                        if (i4 == -1) {
                            i4 = i2 - i3;
                        } else if (i2 - i3 != i4) {
                            throw new IllegalArgumentException("row lengths do not match");
                        }
                        i5++;
                        i3 = i2;
                    }
                    i++;
                } else {
                    if (str.substring(i, str2.length() + i).equals(str2)) {
                        i += str2.length();
                        zArr[i2] = true;
                    } else if (str.substring(i, str3.length() + i).equals(str3)) {
                        i += str3.length();
                        zArr[i2] = false;
                    } else {
                        throw new IllegalArgumentException("illegal character encountered: " + str.substring(i));
                    }
                    i2++;
                }
            }
            if (i2 > i3) {
                if (i4 == -1) {
                    i4 = i2 - i3;
                } else if (i2 - i3 != i4) {
                    throw new IllegalArgumentException("row lengths do not match");
                }
                i5++;
            }
            BitMatrix bitMatrix = new BitMatrix(i4, i5);
            for (int i6 = 0; i6 < i2; i6++) {
                if (zArr[i6]) {
                    bitMatrix.set(i6 % i4, i6 / i4);
                }
            }
            return bitMatrix;
        }
        throw new IllegalArgumentException();
    }

    public boolean get(int i, int i2) {
        return ((this.f20393d[(i2 * this.f20392c) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    public void set(int i, int i2) {
        int i3 = (i2 * this.f20392c) + (i / 32);
        int[] iArr = this.f20393d;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    public void unset(int i, int i2) {
        int i3 = (i2 * this.f20392c) + (i / 32);
        int[] iArr = this.f20393d;
        iArr[i3] = (~(1 << (i & 31))) & iArr[i3];
    }

    public void flip(int i, int i2) {
        int i3 = (i2 * this.f20392c) + (i / 32);
        int[] iArr = this.f20393d;
        iArr[i3] = (1 << (i & 31)) ^ iArr[i3];
    }

    public void xor(BitMatrix bitMatrix) {
        if (this.f20390a == bitMatrix.getWidth() && this.f20391b == bitMatrix.getHeight() && this.f20392c == bitMatrix.getRowSize()) {
            BitArray bitArray = new BitArray((this.f20390a / 32) + 1);
            for (int i = 0; i < this.f20391b; i++) {
                int i2 = this.f20392c * i;
                int[] bitArray2 = bitMatrix.getRow(i, bitArray).getBitArray();
                for (int i3 = 0; i3 < this.f20392c; i3++) {
                    int[] iArr = this.f20393d;
                    int i4 = i2 + i3;
                    iArr[i4] = iArr[i4] ^ bitArray2[i3];
                }
            }
            return;
        }
        throw new IllegalArgumentException("input matrix dimensions do not match");
    }

    public void clear() {
        int length = this.f20393d.length;
        for (int i = 0; i < length; i++) {
            this.f20393d[i] = 0;
        }
    }

    public void setRegion(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i4 < 1 || i3 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i5 = i3 + i;
            int i6 = i4 + i2;
            if (i6 > this.f20391b || i5 > this.f20390a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i6) {
                int i7 = this.f20392c * i2;
                for (int i8 = i; i8 < i5; i8++) {
                    int[] iArr = this.f20393d;
                    int i9 = (i8 / 32) + i7;
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
        }
    }

    public BitArray getRow(int i, BitArray bitArray) {
        if (bitArray == null || bitArray.getSize() < this.f20390a) {
            bitArray = new BitArray(this.f20390a);
        } else {
            bitArray.clear();
        }
        int i2 = i * this.f20392c;
        for (int i3 = 0; i3 < this.f20392c; i3++) {
            bitArray.setBulk(i3 * 32, this.f20393d[i2 + i3]);
        }
        return bitArray;
    }

    public void setRow(int i, BitArray bitArray) {
        int[] bitArray2 = bitArray.getBitArray();
        int[] iArr = this.f20393d;
        int i2 = this.f20392c;
        System.arraycopy(bitArray2, 0, iArr, i * i2, i2);
    }

    public void rotate180() {
        int width = getWidth();
        int height = getHeight();
        BitArray bitArray = new BitArray(width);
        BitArray bitArray2 = new BitArray(width);
        for (int i = 0; i < (height + 1) / 2; i++) {
            bitArray = getRow(i, bitArray);
            int i2 = (height - 1) - i;
            bitArray2 = getRow(i2, bitArray2);
            bitArray.reverse();
            bitArray2.reverse();
            setRow(i, bitArray2);
            setRow(i2, bitArray);
        }
    }

    public int[] getEnclosingRectangle() {
        int i = this.f20390a;
        int i2 = this.f20391b;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < this.f20391b; i5++) {
            int i6 = 0;
            while (true) {
                int i7 = this.f20392c;
                if (i6 >= i7) {
                    break;
                }
                int i8 = this.f20393d[(i7 * i5) + i6];
                if (i8 != 0) {
                    if (i5 < i2) {
                        i2 = i5;
                    }
                    if (i5 > i4) {
                        i4 = i5;
                    }
                    int i9 = i6 * 32;
                    if (i9 < i) {
                        int i10 = 0;
                        while ((i8 << (31 - i10)) == 0) {
                            i10++;
                        }
                        int i11 = i10 + i9;
                        if (i11 < i) {
                            i = i11;
                        }
                    }
                    if (i9 + 31 > i3) {
                        int i12 = 31;
                        while ((i8 >>> i12) == 0) {
                            i12--;
                        }
                        int i13 = i9 + i12;
                        if (i13 > i3) {
                            i3 = i13;
                        }
                    }
                }
                i6++;
            }
        }
        if (i3 < i || i4 < i2) {
            return null;
        }
        return new int[]{i, i2, (i3 - i) + 1, (i4 - i2) + 1};
    }

    public int[] getTopLeftOnBit() {
        int i = 0;
        while (true) {
            int[] iArr = this.f20393d;
            if (i >= iArr.length || iArr[i] != 0) {
                int[] iArr2 = this.f20393d;
            } else {
                i++;
            }
        }
        int[] iArr22 = this.f20393d;
        if (i == iArr22.length) {
            return null;
        }
        int i2 = this.f20392c;
        int i3 = i / i2;
        int i4 = (i % i2) * 32;
        int i5 = iArr22[i];
        int i6 = 0;
        while ((i5 << (31 - i6)) == 0) {
            i6++;
        }
        return new int[]{i4 + i6, i3};
    }

    public int[] getBottomRightOnBit() {
        int length = this.f20393d.length - 1;
        while (length >= 0 && this.f20393d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = this.f20392c;
        int i2 = length / i;
        int i3 = (length % i) * 32;
        int i4 = 31;
        while ((this.f20393d[length] >>> i4) == 0) {
            i4--;
        }
        return new int[]{i3 + i4, i2};
    }

    public int getWidth() {
        return this.f20390a;
    }

    public int getHeight() {
        return this.f20391b;
    }

    public int getRowSize() {
        return this.f20392c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitMatrix)) {
            return false;
        }
        BitMatrix bitMatrix = (BitMatrix) obj;
        if (this.f20390a == bitMatrix.f20390a && this.f20391b == bitMatrix.f20391b && this.f20392c == bitMatrix.f20392c && Arrays.equals(this.f20393d, bitMatrix.f20393d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.f20390a;
        return (((((((i * 31) + i) * 31) + this.f20391b) * 31) + this.f20392c) * 31) + Arrays.hashCode(this.f20393d);
    }

    public String toString() {
        return toString("X ", "  ");
    }

    public String toString(String str, String str2) {
        return m17155a(str, str2, "\n");
    }

    @Deprecated
    public String toString(String str, String str2, String str3) {
        return m17155a(str, str2, str3);
    }

    /* renamed from: a */
    private String m17155a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f20391b * (this.f20390a + 1));
        for (int i = 0; i < this.f20391b; i++) {
            for (int i2 = 0; i2 < this.f20390a; i2++) {
                sb.append(get(i2, i) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    public BitMatrix clone() {
        return new BitMatrix(this.f20390a, this.f20391b, this.f20392c, (int[]) this.f20393d.clone());
    }

    public byte[] getSource() {
        return this.f20394e;
    }

    public void setSource(byte[] bArr) {
        this.f20394e = bArr;
    }
}
