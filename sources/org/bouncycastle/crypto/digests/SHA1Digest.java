package org.bouncycastle.crypto.digests;

import com.google.common.base.Ascii;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public class SHA1Digest extends GeneralDigest implements EncodableDigest {
    private static final int DIGEST_LENGTH = 20;

    /* renamed from: Y1 */
    private static final int f7707Y1 = 1518500249;

    /* renamed from: Y2 */
    private static final int f7708Y2 = 1859775393;

    /* renamed from: Y3 */
    private static final int f7709Y3 = -1894007588;

    /* renamed from: Y4 */
    private static final int f7710Y4 = -899497514;

    /* renamed from: H1 */
    private int f7711H1;

    /* renamed from: H2 */
    private int f7712H2;

    /* renamed from: H3 */
    private int f7713H3;

    /* renamed from: H4 */
    private int f7714H4;

    /* renamed from: H5 */
    private int f7715H5;

    /* renamed from: X */
    private int[] f7716X = new int[80];
    private int xOff;

    public SHA1Digest() {
        reset();
    }

    public SHA1Digest(SHA1Digest sHA1Digest) {
        super((GeneralDigest) sHA1Digest);
        copyIn(sHA1Digest);
    }

    public SHA1Digest(byte[] bArr) {
        super(bArr);
        this.f7711H1 = Pack.bigEndianToInt(bArr, 16);
        this.f7712H2 = Pack.bigEndianToInt(bArr, 20);
        this.f7713H3 = Pack.bigEndianToInt(bArr, 24);
        this.f7714H4 = Pack.bigEndianToInt(bArr, 28);
        this.f7715H5 = Pack.bigEndianToInt(bArr, 32);
        this.xOff = Pack.bigEndianToInt(bArr, 36);
        for (int i = 0; i != this.xOff; i++) {
            this.f7716X[i] = Pack.bigEndianToInt(bArr, (i * 4) + 40);
        }
    }

    private void copyIn(SHA1Digest sHA1Digest) {
        this.f7711H1 = sHA1Digest.f7711H1;
        this.f7712H2 = sHA1Digest.f7712H2;
        this.f7713H3 = sHA1Digest.f7713H3;
        this.f7714H4 = sHA1Digest.f7714H4;
        this.f7715H5 = sHA1Digest.f7715H5;
        int[] iArr = sHA1Digest.f7716X;
        System.arraycopy(iArr, 0, this.f7716X, 0, iArr.length);
        this.xOff = sHA1Digest.xOff;
    }

    /* renamed from: f */
    private int m7070f(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    /* renamed from: g */
    private int m7071g(int i, int i2, int i3) {
        return (i & i3) | (i & i2) | (i2 & i3);
    }

    /* renamed from: h */
    private int m7072h(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    public Memoable copy() {
        return new SHA1Digest(this);
    }

    public int doFinal(byte[] bArr, int i) {
        finish();
        Pack.intToBigEndian(this.f7711H1, bArr, i);
        Pack.intToBigEndian(this.f7712H2, bArr, i + 4);
        Pack.intToBigEndian(this.f7713H3, bArr, i + 8);
        Pack.intToBigEndian(this.f7714H4, bArr, i + 12);
        Pack.intToBigEndian(this.f7715H5, bArr, i + 16);
        reset();
        return 20;
    }

    public String getAlgorithmName() {
        return "SHA-1";
    }

    public int getDigestSize() {
        return 20;
    }

    public byte[] getEncodedState() {
        byte[] bArr = new byte[((this.xOff * 4) + 40)];
        super.populateState(bArr);
        Pack.intToBigEndian(this.f7711H1, bArr, 16);
        Pack.intToBigEndian(this.f7712H2, bArr, 20);
        Pack.intToBigEndian(this.f7713H3, bArr, 24);
        Pack.intToBigEndian(this.f7714H4, bArr, 28);
        Pack.intToBigEndian(this.f7715H5, bArr, 32);
        Pack.intToBigEndian(this.xOff, bArr, 36);
        for (int i = 0; i != this.xOff; i++) {
            Pack.intToBigEndian(this.f7716X[i], bArr, (i * 4) + 40);
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public void processBlock() {
        for (int i = 16; i < 80; i++) {
            int[] iArr = this.f7716X;
            int i2 = ((iArr[i - 3] ^ iArr[i - 8]) ^ iArr[i - 14]) ^ iArr[i - 16];
            iArr[i] = (i2 >>> 31) | (i2 << 1);
        }
        int i3 = this.f7711H1;
        int i4 = this.f7712H2;
        int i5 = this.f7713H3;
        int i6 = this.f7714H4;
        int i7 = this.f7715H5;
        int i8 = 0;
        int i9 = 0;
        while (i8 < 4) {
            int i10 = i9 + 1;
            int f = i7 + ((i3 << 5) | (i3 >>> 27)) + m7070f(i4, i5, i6) + this.f7716X[i9] + f7707Y1;
            int i11 = (i4 >>> 2) | (i4 << 30);
            int i12 = i10 + 1;
            int f2 = i6 + ((f << 5) | (f >>> 27)) + m7070f(i3, i11, i5) + this.f7716X[i10] + f7707Y1;
            int i13 = (i3 >>> 2) | (i3 << 30);
            int i14 = i12 + 1;
            int f3 = i5 + ((f2 << 5) | (f2 >>> 27)) + m7070f(f, i13, i11) + this.f7716X[i12] + f7707Y1;
            i7 = (f >>> 2) | (f << 30);
            int i15 = i14 + 1;
            i4 = i11 + ((f3 << 5) | (f3 >>> 27)) + m7070f(f2, i7, i13) + this.f7716X[i14] + f7707Y1;
            i6 = (f2 >>> 2) | (f2 << 30);
            i3 = i13 + ((i4 << 5) | (i4 >>> 27)) + m7070f(f3, i6, i7) + this.f7716X[i15] + f7707Y1;
            i5 = (f3 >>> 2) | (f3 << 30);
            i8++;
            i9 = i15 + 1;
        }
        int i16 = 0;
        while (i16 < 4) {
            int i17 = i9 + 1;
            int h = i7 + ((i3 << 5) | (i3 >>> 27)) + m7072h(i4, i5, i6) + this.f7716X[i9] + f7708Y2;
            int i18 = (i4 >>> 2) | (i4 << 30);
            int i19 = i17 + 1;
            int h2 = i6 + ((h << 5) | (h >>> 27)) + m7072h(i3, i18, i5) + this.f7716X[i17] + f7708Y2;
            int i20 = (i3 >>> 2) | (i3 << 30);
            int i21 = i19 + 1;
            int h3 = i5 + ((h2 << 5) | (h2 >>> 27)) + m7072h(h, i20, i18) + this.f7716X[i19] + f7708Y2;
            i7 = (h >>> 2) | (h << 30);
            int i22 = i21 + 1;
            i4 = i18 + ((h3 << 5) | (h3 >>> 27)) + m7072h(h2, i7, i20) + this.f7716X[i21] + f7708Y2;
            i6 = (h2 >>> 2) | (h2 << 30);
            i3 = i20 + ((i4 << 5) | (i4 >>> 27)) + m7072h(h3, i6, i7) + this.f7716X[i22] + f7708Y2;
            i5 = (h3 >>> 2) | (h3 << 30);
            i16++;
            i9 = i22 + 1;
        }
        int i23 = 0;
        while (i23 < 4) {
            int i24 = i9 + 1;
            int g = i7 + ((i3 << 5) | (i3 >>> 27)) + m7071g(i4, i5, i6) + this.f7716X[i9] + f7709Y3;
            int i25 = (i4 >>> 2) | (i4 << 30);
            int i26 = i24 + 1;
            int g2 = i6 + ((g << 5) | (g >>> 27)) + m7071g(i3, i25, i5) + this.f7716X[i24] + f7709Y3;
            int i27 = (i3 >>> 2) | (i3 << 30);
            int i28 = i26 + 1;
            int g3 = i5 + ((g2 << 5) | (g2 >>> 27)) + m7071g(g, i27, i25) + this.f7716X[i26] + f7709Y3;
            i7 = (g >>> 2) | (g << 30);
            int i29 = i28 + 1;
            i4 = i25 + ((g3 << 5) | (g3 >>> 27)) + m7071g(g2, i7, i27) + this.f7716X[i28] + f7709Y3;
            i6 = (g2 >>> 2) | (g2 << 30);
            i3 = i27 + ((i4 << 5) | (i4 >>> 27)) + m7071g(g3, i6, i7) + this.f7716X[i29] + f7709Y3;
            i5 = (g3 >>> 2) | (g3 << 30);
            i23++;
            i9 = i29 + 1;
        }
        int i30 = 0;
        while (i30 <= 3) {
            int i31 = i9 + 1;
            int h4 = i7 + ((i3 << 5) | (i3 >>> 27)) + m7072h(i4, i5, i6) + this.f7716X[i9] + f7710Y4;
            int i32 = (i4 >>> 2) | (i4 << 30);
            int i33 = i31 + 1;
            int h5 = i6 + ((h4 << 5) | (h4 >>> 27)) + m7072h(i3, i32, i5) + this.f7716X[i31] + f7710Y4;
            int i34 = (i3 >>> 2) | (i3 << 30);
            int i35 = i33 + 1;
            int h6 = i5 + ((h5 << 5) | (h5 >>> 27)) + m7072h(h4, i34, i32) + this.f7716X[i33] + f7710Y4;
            i7 = (h4 >>> 2) | (h4 << 30);
            int i36 = i35 + 1;
            i4 = i32 + ((h6 << 5) | (h6 >>> 27)) + m7072h(h5, i7, i34) + this.f7716X[i35] + f7710Y4;
            i6 = (h5 >>> 2) | (h5 << 30);
            i3 = i34 + ((i4 << 5) | (i4 >>> 27)) + m7072h(h6, i6, i7) + this.f7716X[i36] + f7710Y4;
            i5 = (h6 >>> 2) | (h6 << 30);
            i30++;
            i9 = i36 + 1;
        }
        this.f7711H1 += i3;
        this.f7712H2 += i4;
        this.f7713H3 += i5;
        this.f7714H4 += i6;
        this.f7715H5 += i7;
        this.xOff = 0;
        for (int i37 = 0; i37 < 16; i37++) {
            this.f7716X[i37] = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void processLength(long j) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.f7716X;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) j;
    }

    /* access modifiers changed from: protected */
    public void processWord(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i3 + 1] & 255) | (bArr[i] << Ascii.CAN) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
        int[] iArr = this.f7716X;
        int i5 = this.xOff;
        iArr[i5] = i4;
        int i6 = i5 + 1;
        this.xOff = i6;
        if (i6 == 16) {
            processBlock();
        }
    }

    public void reset() {
        super.reset();
        this.f7711H1 = 1732584193;
        this.f7712H2 = -271733879;
        this.f7713H3 = -1732584194;
        this.f7714H4 = 271733878;
        this.f7715H5 = -1009589776;
        this.xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f7716X;
            if (i != iArr.length) {
                iArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }

    public void reset(Memoable memoable) {
        SHA1Digest sHA1Digest = (SHA1Digest) memoable;
        super.copyIn(sHA1Digest);
        copyIn(sHA1Digest);
    }
}
