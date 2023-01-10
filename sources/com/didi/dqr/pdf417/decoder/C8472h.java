package com.didi.dqr.pdf417.decoder;

import com.didi.dqr.common.detector.MathUtils;
import com.didi.dqr.pdf417.PDF417Common;
import java.lang.reflect.Array;

/* renamed from: com.didi.dqr.pdf417.decoder.h */
/* compiled from: PDF417CodewordDecoder */
final class C8472h {

    /* renamed from: a */
    private static final float[][] f20824a;

    static {
        int i;
        int length = PDF417Common.SYMBOL_TABLE.length;
        int[] iArr = new int[2];
        iArr[1] = 8;
        iArr[0] = length;
        f20824a = (float[][]) Array.newInstance(float.class, iArr);
        for (int i2 = 0; i2 < PDF417Common.SYMBOL_TABLE.length; i2++) {
            int i3 = PDF417Common.SYMBOL_TABLE[i2];
            int i4 = i3 & 1;
            int i5 = 0;
            while (i5 < 8) {
                float f = 0.0f;
                while (true) {
                    i = i3 & 1;
                    if (i != i4) {
                        break;
                    }
                    f += 1.0f;
                    i3 >>= 1;
                }
                f20824a[i2][(8 - i5) - 1] = f / 17.0f;
                i5++;
                i4 = i;
            }
        }
    }

    private C8472h() {
    }

    /* renamed from: a */
    static int m17586a(int[] iArr) {
        int c = m17588c(m17587b(iArr));
        if (c != -1) {
            return c;
        }
        return m17590e(iArr);
    }

    /* renamed from: b */
    private static int[] m17587b(int[] iArr) {
        float sum = (float) MathUtils.sum(iArr);
        int[] iArr2 = new int[8];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 17; i3++) {
            if (((float) (iArr[i2] + i)) <= (sum / 34.0f) + ((((float) i3) * sum) / 17.0f)) {
                i += iArr[i2];
                i2++;
            }
            iArr2[i2] = iArr2[i2] + 1;
        }
        return iArr2;
    }

    /* renamed from: c */
    private static int m17588c(int[] iArr) {
        int d = m17589d(iArr);
        if (PDF417Common.getCodeword(d) == -1) {
            return -1;
        }
        return d;
    }

    /* renamed from: d */
    private static int m17589d(int[] iArr) {
        long j = 0;
        for (int i = 0; i < iArr.length; i++) {
            for (int i2 = 0; i2 < iArr[i]; i2++) {
                int i3 = 1;
                long j2 = j << 1;
                if (i % 2 != 0) {
                    i3 = 0;
                }
                j = j2 | ((long) i3);
            }
        }
        return (int) j;
    }

    /* renamed from: e */
    private static int m17590e(int[] iArr) {
        int sum = MathUtils.sum(iArr);
        float[] fArr = new float[8];
        if (sum > 1) {
            for (int i = 0; i < 8; i++) {
                fArr[i] = ((float) iArr[i]) / ((float) sum);
            }
        }
        float f = Float.MAX_VALUE;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            float[][] fArr2 = f20824a;
            if (i3 >= fArr2.length) {
                return i2;
            }
            float f2 = 0.0f;
            float[] fArr3 = fArr2[i3];
            for (int i4 = 0; i4 < 8; i4++) {
                float f3 = fArr3[i4] - fArr[i4];
                f2 += f3 * f3;
                if (f2 >= f) {
                    break;
                }
            }
            if (f2 < f) {
                i2 = PDF417Common.SYMBOL_TABLE[i3];
                f = f2;
            }
            i3++;
        }
    }
}
