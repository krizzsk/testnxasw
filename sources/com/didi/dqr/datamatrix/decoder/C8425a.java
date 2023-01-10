package com.didi.dqr.datamatrix.decoder;

import com.didi.dqr.FormatException;
import com.didi.dqr.common.BitMatrix;

/* renamed from: com.didi.dqr.datamatrix.decoder.a */
/* compiled from: BitMatrixParser */
final class C8425a {

    /* renamed from: a */
    private final BitMatrix f20475a;

    /* renamed from: b */
    private final BitMatrix f20476b;

    /* renamed from: c */
    private final Version f20477c;

    C8425a(BitMatrix bitMatrix) throws FormatException {
        int height = bitMatrix.getHeight();
        if (height < 8 || height > 144 || (height & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        this.f20477c = m17206a(bitMatrix);
        BitMatrix b = m17210b(bitMatrix);
        this.f20475a = b;
        this.f20476b = new BitMatrix(b.getWidth(), this.f20475a.getHeight());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Version mo63267a() {
        return this.f20477c;
    }

    /* renamed from: a */
    private static Version m17206a(BitMatrix bitMatrix) throws FormatException {
        return Version.getVersionForDimensions(bitMatrix.getHeight(), bitMatrix.getWidth());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public byte[] mo63268b() throws FormatException {
        byte[] bArr = new byte[this.f20477c.getTotalCodewords()];
        int height = this.f20475a.getHeight();
        int width = this.f20475a.getWidth();
        int i = 0;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i3 = 4;
        while (true) {
            if (i3 == height && i == 0 && !z) {
                bArr[i2] = (byte) m17205a(height, width);
                i3 -= 2;
                i += 2;
                i2++;
                z = true;
            } else {
                int i4 = height - 2;
                if (i3 == i4 && i == 0 && (width & 3) != 0 && !z2) {
                    bArr[i2] = (byte) m17208b(height, width);
                    i3 -= 2;
                    i += 2;
                    i2++;
                    z2 = true;
                } else if (i3 == height + 4 && i == 2 && (width & 7) == 0 && !z3) {
                    bArr[i2] = (byte) m17211c(height, width);
                    i3 -= 2;
                    i += 2;
                    i2++;
                    z3 = true;
                } else if (i3 == i4 && i == 0 && (width & 7) == 4 && !z4) {
                    bArr[i2] = (byte) m17212d(height, width);
                    i3 -= 2;
                    i += 2;
                    i2++;
                    z4 = true;
                } else {
                    do {
                        if (i3 < height && i >= 0 && !this.f20476b.get(i, i3)) {
                            bArr[i2] = (byte) m17209b(i3, i, height, width);
                            i2++;
                        }
                        i3 -= 2;
                        i += 2;
                        if (i3 < 0) {
                            break;
                        }
                    } while (i < width);
                    int i5 = i3 + 1;
                    int i6 = i + 3;
                    do {
                        if (i5 >= 0 && i6 < width && !this.f20476b.get(i6, i5)) {
                            bArr[i2] = (byte) m17209b(i5, i6, height, width);
                            i2++;
                        }
                        i5 += 2;
                        i6 -= 2;
                        if (i5 >= height) {
                            break;
                        }
                    } while (i6 >= 0);
                    i3 = i5 + 3;
                    i = i6 + 1;
                }
            }
            if (i3 >= height && i >= width) {
                break;
            }
        }
        if (i2 == this.f20477c.getTotalCodewords()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    /* renamed from: a */
    private boolean m17207a(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i += i3;
            i2 += 4 - ((i3 + 4) & 7);
        }
        if (i2 < 0) {
            i2 += i4;
            i += 4 - ((i4 + 4) & 7);
        }
        this.f20476b.set(i2, i);
        return this.f20475a.get(i2, i);
    }

    /* renamed from: b */
    private int m17209b(int i, int i2, int i3, int i4) {
        int i5 = i - 2;
        int i6 = i2 - 2;
        int i7 = (m17207a(i5, i6, i3, i4) ? 1 : 0) << 1;
        int i8 = i2 - 1;
        if (m17207a(i5, i8, i3, i4)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i - 1;
        if (m17207a(i10, i6, i3, i4)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (m17207a(i10, i8, i3, i4)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (m17207a(i10, i2, i3, i4)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (m17207a(i, i6, i3, i4)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (m17207a(i, i8, i3, i4)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        return m17207a(i, i2, i3, i4) ? i15 | 1 : i15;
    }

    /* renamed from: a */
    private int m17205a(int i, int i2) {
        int i3 = i - 1;
        int i4 = (m17207a(i3, 0, i, i2) ? 1 : 0) << 1;
        if (m17207a(i3, 1, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (m17207a(i3, 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (m17207a(0, i2 - 2, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        int i8 = i2 - 1;
        if (m17207a(0, i8, i, i2)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        if (m17207a(1, i8, i, i2)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (m17207a(2, i8, i, i2)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        return m17207a(3, i8, i, i2) ? i11 | 1 : i11;
    }

    /* renamed from: b */
    private int m17208b(int i, int i2) {
        int i3 = (m17207a(i + -3, 0, i, i2) ? 1 : 0) << 1;
        if (m17207a(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (m17207a(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (m17207a(0, i2 - 4, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (m17207a(0, i2 - 3, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (m17207a(0, i2 - 2, i, i2)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        int i9 = i2 - 1;
        if (m17207a(0, i9, i, i2)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        return m17207a(1, i9, i, i2) ? i10 | 1 : i10;
    }

    /* renamed from: c */
    private int m17211c(int i, int i2) {
        int i3 = i - 1;
        int i4 = (m17207a(i3, 0, i, i2) ? 1 : 0) << 1;
        int i5 = i2 - 1;
        if (m17207a(i3, i5, i, i2)) {
            i4 |= 1;
        }
        int i6 = i4 << 1;
        int i7 = i2 - 3;
        if (m17207a(0, i7, i, i2)) {
            i6 |= 1;
        }
        int i8 = i6 << 1;
        int i9 = i2 - 2;
        if (m17207a(0, i9, i, i2)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        if (m17207a(0, i5, i, i2)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (m17207a(1, i7, i, i2)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (m17207a(1, i9, i, i2)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        return m17207a(1, i5, i, i2) ? i13 | 1 : i13;
    }

    /* renamed from: d */
    private int m17212d(int i, int i2) {
        int i3 = (m17207a(i + -3, 0, i, i2) ? 1 : 0) << 1;
        if (m17207a(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (m17207a(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (m17207a(0, i2 - 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        int i7 = i2 - 1;
        if (m17207a(0, i7, i, i2)) {
            i6 |= 1;
        }
        int i8 = i6 << 1;
        if (m17207a(1, i7, i, i2)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (m17207a(2, i7, i, i2)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        return m17207a(3, i7, i, i2) ? i10 | 1 : i10;
    }

    /* renamed from: b */
    private BitMatrix m17210b(BitMatrix bitMatrix) {
        int symbolSizeRows = this.f20477c.getSymbolSizeRows();
        int symbolSizeColumns = this.f20477c.getSymbolSizeColumns();
        if (bitMatrix.getHeight() == symbolSizeRows) {
            int dataRegionSizeRows = this.f20477c.getDataRegionSizeRows();
            int dataRegionSizeColumns = this.f20477c.getDataRegionSizeColumns();
            int i = symbolSizeRows / dataRegionSizeRows;
            int i2 = symbolSizeColumns / dataRegionSizeColumns;
            BitMatrix bitMatrix2 = new BitMatrix(i2 * dataRegionSizeColumns, i * dataRegionSizeRows);
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = i3 * dataRegionSizeRows;
                for (int i5 = 0; i5 < i2; i5++) {
                    int i6 = i5 * dataRegionSizeColumns;
                    for (int i7 = 0; i7 < dataRegionSizeRows; i7++) {
                        int i8 = ((dataRegionSizeRows + 2) * i3) + 1 + i7;
                        int i9 = i4 + i7;
                        for (int i10 = 0; i10 < dataRegionSizeColumns; i10++) {
                            if (bitMatrix.get(((dataRegionSizeColumns + 2) * i5) + 1 + i10, i8)) {
                                bitMatrix2.set(i6 + i10, i9);
                            }
                        }
                        BitMatrix bitMatrix3 = bitMatrix;
                    }
                    BitMatrix bitMatrix4 = bitMatrix;
                }
                BitMatrix bitMatrix5 = bitMatrix;
            }
            return bitMatrix2;
        }
        throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
    }
}
