package com.didi.dqr.oned;

import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.DecodeHintType;
import com.didi.dqr.FormatException;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.Result;
import com.didi.dqr.ResultPoint;
import com.didi.dqr.common.BitArray;
import java.util.Map;

public final class ITFReader extends OneDReader {

    /* renamed from: a */
    private static final float f20604a = 0.38f;

    /* renamed from: b */
    private static final float f20605b = 0.5f;

    /* renamed from: c */
    private static final int f20606c = 3;

    /* renamed from: d */
    private static final int f20607d = 2;

    /* renamed from: e */
    private static final int f20608e = 1;

    /* renamed from: f */
    private static final int[] f20609f = {6, 8, 10, 12, 14};

    /* renamed from: h */
    private static final int[] f20610h = {1, 1, 1, 1};

    /* renamed from: i */
    private static final int[][] f20611i = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};

    /* renamed from: j */
    private static final int[][] f20612j = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* renamed from: g */
    private int f20613g = -1;

    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws FormatException, NotFoundException {
        boolean z;
        int[] a = m17338a(bitArray);
        int[] c = m17341c(bitArray);
        StringBuilder sb = new StringBuilder(20);
        m17337a(bitArray, a[1], c[0], sb);
        String sb2 = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f20609f;
        }
        int length = sb2.length();
        int length2 = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length2) {
                z = false;
                break;
            }
            int i4 = iArr[i2];
            if (length == i4) {
                z = true;
                break;
            }
            if (i4 > i3) {
                i3 = i4;
            }
            i2++;
        }
        if (!z && length > i3) {
            z = true;
        }
        if (z) {
            float f = (float) i;
            return new Result(sb2, (byte[]) null, new ResultPoint[]{new ResultPoint((float) a[1], f), new ResultPoint((float) c[0], f)}, BarcodeFormat.ITF);
        }
        throw FormatException.getFormatInstance();
    }

    /* renamed from: a */
    private static void m17337a(BitArray bitArray, int i, int i2, StringBuilder sb) throws NotFoundException {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i < i2) {
            recordPattern(bitArray, i, iArr);
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = i3 * 2;
                iArr2[i3] = iArr[i4];
                iArr3[i3] = iArr[i4 + 1];
            }
            sb.append((char) (m17335a(iArr2) + 48));
            sb.append((char) (m17335a(iArr3) + 48));
            for (int i5 = 0; i5 < 10; i5++) {
                i += iArr[i5];
            }
        }
    }

    /* renamed from: a */
    private int[] m17338a(BitArray bitArray) throws NotFoundException {
        int[] a = m17339a(bitArray, m17340b(bitArray), f20610h);
        this.f20613g = (a[1] - a[0]) / 4;
        m17336a(bitArray, a[0]);
        return a;
    }

    /* renamed from: a */
    private void m17336a(BitArray bitArray, int i) throws NotFoundException {
        int i2 = this.f20613g * 10;
        if (i2 >= i) {
            i2 = i;
        }
        int i3 = i - 1;
        while (i2 > 0 && i3 >= 0 && !bitArray.get(i3)) {
            i2--;
            i3--;
        }
        if (i2 != 0) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    /* renamed from: b */
    private static int m17340b(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        if (nextSet != size) {
            return nextSet;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r0 = m17339a(r7, r0, f20611i[1]);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0012 */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int[] m17341c(com.didi.dqr.common.BitArray r7) throws com.didi.dqr.NotFoundException {
        /*
            r6 = this;
            r7.reverse()
            int r0 = m17340b(r7)     // Catch:{ all -> 0x0035 }
            r1 = 1
            r2 = 0
            int[][] r3 = f20611i     // Catch:{ NotFoundException -> 0x0012 }
            r3 = r3[r2]     // Catch:{ NotFoundException -> 0x0012 }
            int[] r0 = m17339a(r7, r0, r3)     // Catch:{ NotFoundException -> 0x0012 }
            goto L_0x001a
        L_0x0012:
            int[][] r3 = f20611i     // Catch:{ all -> 0x0035 }
            r3 = r3[r1]     // Catch:{ all -> 0x0035 }
            int[] r0 = m17339a(r7, r0, r3)     // Catch:{ all -> 0x0035 }
        L_0x001a:
            r3 = r0[r2]     // Catch:{ all -> 0x0035 }
            r6.m17336a(r7, r3)     // Catch:{ all -> 0x0035 }
            r3 = r0[r2]     // Catch:{ all -> 0x0035 }
            int r4 = r7.getSize()     // Catch:{ all -> 0x0035 }
            r5 = r0[r1]     // Catch:{ all -> 0x0035 }
            int r4 = r4 - r5
            r0[r2] = r4     // Catch:{ all -> 0x0035 }
            int r2 = r7.getSize()     // Catch:{ all -> 0x0035 }
            int r2 = r2 - r3
            r0[r1] = r2     // Catch:{ all -> 0x0035 }
            r7.reverse()
            return r0
        L_0x0035:
            r0 = move-exception
            r7.reverse()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.oned.ITFReader.m17341c(com.didi.dqr.common.BitArray):int[]");
    }

    /* renamed from: a */
    private static int[] m17339a(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int size = bitArray.getSize();
        int i2 = i;
        boolean z = false;
        int i3 = 0;
        while (i < size) {
            if (bitArray.get(i) != z) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else if (patternMatchVariance(iArr2, iArr, 0.5f) < 0.38f) {
                    return new int[]{i2, i};
                } else {
                    i2 += iArr2[0] + iArr2[1];
                    int i4 = i3 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i4);
                    iArr2[i4] = 0;
                    iArr2[i3] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                z = !z;
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* renamed from: a */
    private static int m17335a(int[] iArr) throws NotFoundException {
        int length = f20612j.length;
        float f = 0.38f;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            float patternMatchVariance = patternMatchVariance(iArr, f20612j[i2], 0.5f);
            if (patternMatchVariance < f) {
                i = i2;
                f = patternMatchVariance;
            } else if (patternMatchVariance == f) {
                i = -1;
            }
        }
        if (i >= 0) {
            return i % 10;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
