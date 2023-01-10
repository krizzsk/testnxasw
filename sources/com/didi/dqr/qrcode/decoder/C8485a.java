package com.didi.dqr.qrcode.decoder;

import com.didi.dqr.FormatException;
import com.didi.dqr.common.BitMatrix;
import com.didi.dqrutil.analysis.AnalysisManager;
import com.didi.dqrutil.analysis.EventId;

/* renamed from: com.didi.dqr.qrcode.decoder.a */
/* compiled from: BitMatrixParser */
final class C8485a {

    /* renamed from: a */
    private final BitMatrix f20901a;

    /* renamed from: b */
    private Version f20902b;

    /* renamed from: c */
    private C8487c f20903c;

    /* renamed from: d */
    private boolean f20904d;

    C8485a(BitMatrix bitMatrix) throws FormatException {
        int height = bitMatrix.getHeight();
        if (height < 21 || (height & 3) != 1) {
            AnalysisManager.report(EventId.QRCODE_VERSION_ERROR);
            throw FormatException.getFormatInstance();
        } else {
            this.f20901a = bitMatrix;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C8487c mo63545a() throws FormatException {
        C8487c cVar = this.f20903c;
        if (cVar != null) {
            return cVar;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            i2 = m17646a(i3, 8, i2);
        }
        int a = m17646a(8, 7, m17646a(8, 8, m17646a(7, 8, i2)));
        for (int i4 = 5; i4 >= 0; i4--) {
            a = m17646a(8, i4, a);
        }
        int height = this.f20901a.getHeight();
        int i5 = height - 7;
        for (int i6 = height - 1; i6 >= i5; i6--) {
            i = m17646a(8, i6, i);
        }
        for (int i7 = height - 8; i7 < height; i7++) {
            i = m17646a(i7, 8, i);
        }
        C8487c b = C8487c.m17657b(a, i);
        this.f20903c = b;
        if (b != null) {
            return b;
        }
        AnalysisManager.report(EventId.QRCODE_FORMAT_INFO_ERROR);
        throw FormatException.getFormatInstance();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Version mo63547b() throws FormatException {
        Version version = this.f20902b;
        if (version != null) {
            return version;
        }
        int height = this.f20901a.getHeight();
        int i = (height - 17) / 4;
        if (i <= 6) {
            return Version.getVersionForNumber(i);
        }
        int i2 = height - 11;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 5; i5 >= 0; i5--) {
            for (int i6 = height - 9; i6 >= i2; i6--) {
                i4 = m17646a(i6, i5, i4);
            }
        }
        Version a = Version.m17643a(i4);
        if (a == null || a.getDimensionForVersion() != height) {
            for (int i7 = 5; i7 >= 0; i7--) {
                for (int i8 = height - 9; i8 >= i2; i8--) {
                    i3 = m17646a(i7, i8, i3);
                }
            }
            Version a2 = Version.m17643a(i3);
            if (a2 == null || a2.getDimensionForVersion() != height) {
                AnalysisManager.report(EventId.QRCODE_VERSION_ERROR);
                throw FormatException.getFormatInstance();
            }
            this.f20902b = a2;
            return a2;
        }
        this.f20902b = a;
        return a;
    }

    /* renamed from: a */
    private int m17646a(int i, int i2, int i3) {
        return this.f20904d ? this.f20901a.get(i2, i) : this.f20901a.get(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public byte[] mo63548c() throws FormatException {
        C8487c a = mo63545a();
        Version b = mo63547b();
        DataMask dataMask = DataMask.values()[a.mo63554b()];
        int height = this.f20901a.getHeight();
        dataMask.unmaskBitMatrix(this.f20901a, height);
        BitMatrix a2 = b.mo63532a();
        byte[] bArr = new byte[b.getTotalCodewords()];
        int i = height - 1;
        boolean z = true;
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 > 0) {
            if (i2 == 6) {
                i2--;
            }
            for (int i6 = 0; i6 < height; i6++) {
                int i7 = z ? i - i6 : i6;
                for (int i8 = 0; i8 < 2; i8++) {
                    int i9 = i2 - i8;
                    if (!a2.get(i9, i7)) {
                        i4++;
                        i5 <<= 1;
                        if (this.f20901a.get(i9, i7)) {
                            i5 |= 1;
                        }
                        if (i4 == 8) {
                            bArr[i3] = (byte) i5;
                            i3++;
                            i4 = 0;
                            i5 = 0;
                        }
                    }
                }
            }
            z = !z;
            i2 -= 2;
        }
        if (i3 == b.getTotalCodewords()) {
            return bArr;
        }
        AnalysisManager.report(EventId.QRCODE_CODE_WORDS_ERROR);
        throw FormatException.getFormatInstance();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo63549d() {
        if (this.f20903c != null) {
            DataMask.values()[this.f20903c.mo63554b()].unmaskBitMatrix(this.f20901a, this.f20901a.getHeight());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo63546a(boolean z) {
        this.f20902b = null;
        this.f20903c = null;
        this.f20904d = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo63550e() {
        int i = 0;
        while (i < this.f20901a.getWidth()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.f20901a.getHeight(); i3++) {
                if (this.f20901a.get(i, i3) != this.f20901a.get(i3, i)) {
                    this.f20901a.flip(i3, i);
                    this.f20901a.flip(i, i3);
                }
            }
            i = i2;
        }
    }
}
