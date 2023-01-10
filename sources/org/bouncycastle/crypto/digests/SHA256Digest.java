package org.bouncycastle.crypto.digests;

import com.google.common.base.Ascii;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public class SHA256Digest extends GeneralDigest implements EncodableDigest {
    private static final int DIGEST_LENGTH = 32;

    /* renamed from: K */
    static final int[] f7727K = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};

    /* renamed from: H1 */
    private int f7728H1;

    /* renamed from: H2 */
    private int f7729H2;

    /* renamed from: H3 */
    private int f7730H3;

    /* renamed from: H4 */
    private int f7731H4;

    /* renamed from: H5 */
    private int f7732H5;

    /* renamed from: H6 */
    private int f7733H6;

    /* renamed from: H7 */
    private int f7734H7;

    /* renamed from: H8 */
    private int f7735H8;

    /* renamed from: X */
    private int[] f7736X = new int[64];
    private int xOff;

    public SHA256Digest() {
        reset();
    }

    public SHA256Digest(SHA256Digest sHA256Digest) {
        super((GeneralDigest) sHA256Digest);
        copyIn(sHA256Digest);
    }

    public SHA256Digest(byte[] bArr) {
        super(bArr);
        this.f7728H1 = Pack.bigEndianToInt(bArr, 16);
        this.f7729H2 = Pack.bigEndianToInt(bArr, 20);
        this.f7730H3 = Pack.bigEndianToInt(bArr, 24);
        this.f7731H4 = Pack.bigEndianToInt(bArr, 28);
        this.f7732H5 = Pack.bigEndianToInt(bArr, 32);
        this.f7733H6 = Pack.bigEndianToInt(bArr, 36);
        this.f7734H7 = Pack.bigEndianToInt(bArr, 40);
        this.f7735H8 = Pack.bigEndianToInt(bArr, 44);
        this.xOff = Pack.bigEndianToInt(bArr, 48);
        for (int i = 0; i != this.xOff; i++) {
            this.f7736X[i] = Pack.bigEndianToInt(bArr, (i * 4) + 52);
        }
    }

    /* renamed from: Ch */
    private static int m7074Ch(int i, int i2, int i3) {
        return ((~i) & i3) ^ (i2 & i);
    }

    private static int Maj(int i, int i2, int i3) {
        return ((i ^ i2) & i3) | (i & i2);
    }

    private static int Sum0(int i) {
        return ((i << 10) | (i >>> 22)) ^ (((i >>> 2) | (i << 30)) ^ ((i >>> 13) | (i << 19)));
    }

    private static int Sum1(int i) {
        return ((i << 7) | (i >>> 25)) ^ (((i >>> 6) | (i << 26)) ^ ((i >>> 11) | (i << 21)));
    }

    private static int Theta0(int i) {
        return (i >>> 3) ^ (((i >>> 7) | (i << 25)) ^ ((i >>> 18) | (i << 14)));
    }

    private static int Theta1(int i) {
        return (i >>> 10) ^ (((i >>> 17) | (i << 15)) ^ ((i >>> 19) | (i << 13)));
    }

    private void copyIn(SHA256Digest sHA256Digest) {
        super.copyIn(sHA256Digest);
        this.f7728H1 = sHA256Digest.f7728H1;
        this.f7729H2 = sHA256Digest.f7729H2;
        this.f7730H3 = sHA256Digest.f7730H3;
        this.f7731H4 = sHA256Digest.f7731H4;
        this.f7732H5 = sHA256Digest.f7732H5;
        this.f7733H6 = sHA256Digest.f7733H6;
        this.f7734H7 = sHA256Digest.f7734H7;
        this.f7735H8 = sHA256Digest.f7735H8;
        int[] iArr = sHA256Digest.f7736X;
        System.arraycopy(iArr, 0, this.f7736X, 0, iArr.length);
        this.xOff = sHA256Digest.xOff;
    }

    public Memoable copy() {
        return new SHA256Digest(this);
    }

    public int doFinal(byte[] bArr, int i) {
        finish();
        Pack.intToBigEndian(this.f7728H1, bArr, i);
        Pack.intToBigEndian(this.f7729H2, bArr, i + 4);
        Pack.intToBigEndian(this.f7730H3, bArr, i + 8);
        Pack.intToBigEndian(this.f7731H4, bArr, i + 12);
        Pack.intToBigEndian(this.f7732H5, bArr, i + 16);
        Pack.intToBigEndian(this.f7733H6, bArr, i + 20);
        Pack.intToBigEndian(this.f7734H7, bArr, i + 24);
        Pack.intToBigEndian(this.f7735H8, bArr, i + 28);
        reset();
        return 32;
    }

    public String getAlgorithmName() {
        return "SHA-256";
    }

    public int getDigestSize() {
        return 32;
    }

    public byte[] getEncodedState() {
        byte[] bArr = new byte[((this.xOff * 4) + 52)];
        super.populateState(bArr);
        Pack.intToBigEndian(this.f7728H1, bArr, 16);
        Pack.intToBigEndian(this.f7729H2, bArr, 20);
        Pack.intToBigEndian(this.f7730H3, bArr, 24);
        Pack.intToBigEndian(this.f7731H4, bArr, 28);
        Pack.intToBigEndian(this.f7732H5, bArr, 32);
        Pack.intToBigEndian(this.f7733H6, bArr, 36);
        Pack.intToBigEndian(this.f7734H7, bArr, 40);
        Pack.intToBigEndian(this.f7735H8, bArr, 44);
        Pack.intToBigEndian(this.xOff, bArr, 48);
        for (int i = 0; i != this.xOff; i++) {
            Pack.intToBigEndian(this.f7736X[i], bArr, (i * 4) + 52);
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public void processBlock() {
        for (int i = 16; i <= 63; i++) {
            int[] iArr = this.f7736X;
            int Theta1 = Theta1(iArr[i - 2]);
            int[] iArr2 = this.f7736X;
            iArr[i] = Theta1 + iArr2[i - 7] + Theta0(iArr2[i - 15]) + this.f7736X[i - 16];
        }
        int i2 = this.f7728H1;
        int i3 = this.f7729H2;
        int i4 = this.f7730H3;
        int i5 = this.f7731H4;
        int i6 = this.f7732H5;
        int i7 = this.f7733H6;
        int i8 = this.f7734H7;
        int i9 = this.f7735H8;
        int i10 = 0;
        for (int i11 = 0; i11 < 8; i11++) {
            int Sum1 = i9 + Sum1(i6) + m7074Ch(i6, i7, i8) + f7727K[i10] + this.f7736X[i10];
            int i12 = i5 + Sum1;
            int Sum0 = Sum1 + Sum0(i2) + Maj(i2, i3, i4);
            int i13 = i10 + 1;
            int Sum12 = i8 + Sum1(i12) + m7074Ch(i12, i6, i7) + f7727K[i13] + this.f7736X[i13];
            int i14 = i4 + Sum12;
            int Sum02 = Sum12 + Sum0(Sum0) + Maj(Sum0, i2, i3);
            int i15 = i13 + 1;
            int Sum13 = i7 + Sum1(i14) + m7074Ch(i14, i12, i6) + f7727K[i15] + this.f7736X[i15];
            int i16 = i3 + Sum13;
            int Sum03 = Sum13 + Sum0(Sum02) + Maj(Sum02, Sum0, i2);
            int i17 = i15 + 1;
            int Sum14 = i6 + Sum1(i16) + m7074Ch(i16, i14, i12) + f7727K[i17] + this.f7736X[i17];
            int i18 = i2 + Sum14;
            int Sum04 = Sum14 + Sum0(Sum03) + Maj(Sum03, Sum02, Sum0);
            int i19 = i17 + 1;
            int Sum15 = i12 + Sum1(i18) + m7074Ch(i18, i16, i14) + f7727K[i19] + this.f7736X[i19];
            i9 = Sum0 + Sum15;
            i5 = Sum15 + Sum0(Sum04) + Maj(Sum04, Sum03, Sum02);
            int i20 = i19 + 1;
            int Sum16 = i14 + Sum1(i9) + m7074Ch(i9, i18, i16) + f7727K[i20] + this.f7736X[i20];
            i8 = Sum02 + Sum16;
            i4 = Sum16 + Sum0(i5) + Maj(i5, Sum04, Sum03);
            int i21 = i20 + 1;
            int Sum17 = i16 + Sum1(i8) + m7074Ch(i8, i9, i18) + f7727K[i21] + this.f7736X[i21];
            i7 = Sum03 + Sum17;
            i3 = Sum17 + Sum0(i4) + Maj(i4, i5, Sum04);
            int i22 = i21 + 1;
            int Sum18 = i18 + Sum1(i7) + m7074Ch(i7, i8, i9) + f7727K[i22] + this.f7736X[i22];
            i6 = Sum04 + Sum18;
            i2 = Sum18 + Sum0(i3) + Maj(i3, i4, i5);
            i10 = i22 + 1;
        }
        this.f7728H1 += i2;
        this.f7729H2 += i3;
        this.f7730H3 += i4;
        this.f7731H4 += i5;
        this.f7732H5 += i6;
        this.f7733H6 += i7;
        this.f7734H7 += i8;
        this.f7735H8 += i9;
        this.xOff = 0;
        for (int i23 = 0; i23 < 16; i23++) {
            this.f7736X[i23] = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void processLength(long j) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.f7736X;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) (j & -1);
    }

    /* access modifiers changed from: protected */
    public void processWord(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i3 + 1] & 255) | (bArr[i] << Ascii.CAN) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
        int[] iArr = this.f7736X;
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
        this.f7728H1 = 1779033703;
        this.f7729H2 = -1150833019;
        this.f7730H3 = 1013904242;
        this.f7731H4 = -1521486534;
        this.f7732H5 = 1359893119;
        this.f7733H6 = -1694144372;
        this.f7734H7 = 528734635;
        this.f7735H8 = 1541459225;
        this.xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f7736X;
            if (i != iArr.length) {
                iArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }

    public void reset(Memoable memoable) {
        copyIn((SHA256Digest) memoable);
    }
}
