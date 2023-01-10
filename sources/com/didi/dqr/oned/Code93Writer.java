package com.didi.dqr.oned;

import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.EncodeHintType;
import com.didi.dqr.WriterException;
import com.didi.dqr.common.BitMatrix;
import java.util.Map;

public class Code93Writer extends OneDimensionalCodeWriter {
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_93) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got " + barcodeFormat);
    }

    public boolean[] encode(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            m17331a(Code93Reader.f20594b[47], iArr);
            boolean[] zArr = new boolean[(((str.length() + 2 + 2) * 9) + 1)];
            int a = m17330a(zArr, 0, iArr);
            for (int i = 0; i < length; i++) {
                m17331a(Code93Reader.f20594b["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i))], iArr);
                a += m17330a(zArr, a, iArr);
            }
            int a2 = m17329a(str, 20);
            m17331a(Code93Reader.f20594b[a2], iArr);
            int a3 = a + m17330a(zArr, a, iArr);
            m17331a(Code93Reader.f20594b[m17329a(str + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(a2), 15)], iArr);
            int a4 = a3 + m17330a(zArr, a3, iArr);
            m17331a(Code93Reader.f20594b[47], iArr);
            zArr[a4 + m17330a(zArr, a4, iArr)] = true;
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }

    /* renamed from: a */
    private static void m17331a(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) == 0) {
                i3 = 0;
            }
            iArr[i2] = i3;
        }
    }

    @Deprecated
    protected static int appendPattern(boolean[] zArr, int i, int[] iArr, boolean z) {
        return m17330a(zArr, i, iArr);
    }

    /* renamed from: a */
    private static int m17330a(boolean[] zArr, int i, int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i + 1;
            zArr[i] = iArr[i2] != 0;
            i2++;
            i = i3;
        }
        return 9;
    }

    /* renamed from: a */
    private static int m17329a(String str, int i) {
        int i2 = 0;
        int i3 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i2 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i3;
            i3++;
            if (i3 > i) {
                i3 = 1;
            }
        }
        return i2 % 47;
    }
}
