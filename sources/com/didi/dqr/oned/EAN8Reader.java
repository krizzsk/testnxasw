package com.didi.dqr.oned;

import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.common.BitArray;

public final class EAN8Reader extends UPCEANReader {

    /* renamed from: a */
    private final int[] f20602a = new int[4];

    /* access modifiers changed from: protected */
    public int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f20602a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i = iArr[1];
        for (int i2 = 0; i2 < 4 && i < size; i2++) {
            sb.append((char) (m17347a(bitArray, iArr2, i, f20627e) + 48));
            for (int i3 : iArr2) {
                i += i3;
            }
        }
        int i4 = m17350a(bitArray, i, true, f20625c)[1];
        for (int i5 = 0; i5 < 4 && i4 < size; i5++) {
            sb.append((char) (m17347a(bitArray, iArr2, i4, f20627e) + 48));
            for (int i6 : iArr2) {
                i4 += i6;
            }
        }
        return i4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public BarcodeFormat mo63321a() {
        return BarcodeFormat.EAN_8;
    }
}
