package com.didi.dqr.oned;

import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.common.BitArray;

public final class EAN13Reader extends UPCEANReader {

    /* renamed from: a */
    static final int[] f20599a = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* renamed from: g */
    private final int[] f20600g = new int[4];

    /* access modifiers changed from: protected */
    public int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f20600g;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i = iArr[1];
        int i2 = 0;
        for (int i3 = 0; i3 < 6 && i < size; i3++) {
            int a = m17347a(bitArray, iArr2, i, f20628f);
            sb.append((char) ((a % 10) + 48));
            for (int i4 : iArr2) {
                i += i4;
            }
            if (a >= 10) {
                i2 |= 1 << (5 - i3);
            }
        }
        m17332a(sb, i2);
        int i5 = m17350a(bitArray, i, true, f20625c)[1];
        for (int i6 = 0; i6 < 6 && i5 < size; i6++) {
            sb.append((char) (m17347a(bitArray, iArr2, i5, f20627e) + 48));
            for (int i7 : iArr2) {
                i5 += i7;
            }
        }
        return i5;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public BarcodeFormat mo63321a() {
        return BarcodeFormat.EAN_13;
    }

    /* renamed from: a */
    private static void m17332a(StringBuilder sb, int i) throws NotFoundException {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == f20599a[i2]) {
                sb.insert(0, (char) (i2 + 48));
                return;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
