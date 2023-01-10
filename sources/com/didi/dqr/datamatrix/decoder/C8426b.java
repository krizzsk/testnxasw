package com.didi.dqr.datamatrix.decoder;

import com.didi.dqr.datamatrix.decoder.Version;

/* renamed from: com.didi.dqr.datamatrix.decoder.b */
/* compiled from: DataBlock */
final class C8426b {

    /* renamed from: a */
    private final int f20478a;

    /* renamed from: b */
    private final byte[] f20479b;

    private C8426b(int i, byte[] bArr) {
        this.f20478a = i;
        this.f20479b = bArr;
    }

    /* renamed from: a */
    static C8426b[] m17215a(byte[] bArr, Version version) {
        Version.ECBlocks a = version.mo63255a();
        Version.ECB[] eCBlocks = a.getECBlocks();
        int i = 0;
        for (Version.ECB count : eCBlocks) {
            i += count.getCount();
        }
        C8426b[] bVarArr = new C8426b[i];
        int i2 = 0;
        for (Version.ECB ecb : eCBlocks) {
            int i3 = 0;
            while (i3 < ecb.getCount()) {
                int dataCodewords = ecb.getDataCodewords();
                bVarArr[i2] = new C8426b(dataCodewords, new byte[(a.getECCodewords() + dataCodewords)]);
                i3++;
                i2++;
            }
        }
        int length = bVarArr[0].f20479b.length - a.getECCodewords();
        int i4 = length - 1;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = 0;
            while (i7 < i2) {
                bVarArr[i7].f20479b[i6] = bArr[i5];
                i7++;
                i5++;
            }
        }
        boolean z = version.getVersionNumber() == 24;
        int i8 = z ? 8 : i2;
        int i9 = 0;
        while (i9 < i8) {
            bVarArr[i9].f20479b[i4] = bArr[i5];
            i9++;
            i5++;
        }
        int length2 = bVarArr[0].f20479b.length;
        while (length < length2) {
            int i10 = 0;
            while (i10 < i2) {
                int i11 = z ? (i10 + 8) % i2 : i10;
                bVarArr[i11].f20479b[(!z || i11 <= 7) ? length : length - 1] = bArr[i5];
                i10++;
                i5++;
            }
            length++;
        }
        if (i5 == bArr.length) {
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo63269a() {
        return this.f20478a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public byte[] mo63270b() {
        return this.f20479b;
    }
}
