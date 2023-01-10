package com.didi.dqr.oned;

import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.Result;
import com.didi.dqr.ResultMetadataType;
import com.didi.dqr.ResultPoint;
import com.didi.dqr.common.BitArray;
import java.util.EnumMap;
import java.util.Map;

/* renamed from: com.didi.dqr.oned.b */
/* compiled from: UPCEANExtension2Support */
final class C8439b {

    /* renamed from: a */
    private final int[] f20639a = new int[4];

    /* renamed from: b */
    private final StringBuilder f20640b = new StringBuilder();

    C8439b() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Result mo63328a(int i, BitArray bitArray, int[] iArr) throws NotFoundException {
        StringBuilder sb = this.f20640b;
        sb.setLength(0);
        int a = m17359a(bitArray, iArr, sb);
        String sb2 = sb.toString();
        Map<ResultMetadataType, Object> a2 = m17360a(sb2);
        float f = (float) i;
        Result result = new Result(sb2, (byte[]) null, new ResultPoint[]{new ResultPoint(((float) (iArr[0] + iArr[1])) / 2.0f, f), new ResultPoint((float) a, f)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (a2 != null) {
            result.putAllMetadata(a2);
        }
        return result;
    }

    /* renamed from: a */
    private int m17359a(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f20639a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i = iArr[1];
        int i2 = 0;
        for (int i3 = 0; i3 < 2 && i < size; i3++) {
            int a = UPCEANReader.m17347a(bitArray, iArr2, i, UPCEANReader.f20628f);
            sb.append((char) ((a % 10) + 48));
            for (int i4 : iArr2) {
                i += i4;
            }
            if (a >= 10) {
                i2 |= 1 << (1 - i3);
            }
            if (i3 != 1) {
                i = bitArray.getNextUnset(bitArray.getNextSet(i));
            }
        }
        if (sb.length() != 2) {
            throw NotFoundException.getNotFoundInstance();
        } else if (Integer.parseInt(sb.toString()) % 4 == i2) {
            return i;
        } else {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    /* renamed from: a */
    private static Map<ResultMetadataType, Object> m17360a(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put(ResultMetadataType.ISSUE_NUMBER, Integer.valueOf(str));
        return enumMap;
    }
}
