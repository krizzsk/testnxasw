package org.bouncycastle.crypto.digests;

import com.google.common.base.Ascii;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public class SHA224Digest extends GeneralDigest implements EncodableDigest {
    private static final int DIGEST_LENGTH = 28;

    /* renamed from: K */
    static final int[] f7717K = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};

    /* renamed from: H1 */
    private int f7718H1;

    /* renamed from: H2 */
    private int f7719H2;

    /* renamed from: H3 */
    private int f7720H3;

    /* renamed from: H4 */
    private int f7721H4;

    /* renamed from: H5 */
    private int f7722H5;

    /* renamed from: H6 */
    private int f7723H6;

    /* renamed from: H7 */
    private int f7724H7;

    /* renamed from: H8 */
    private int f7725H8;

    /* renamed from: X */
    private int[] f7726X = new int[64];
    private int xOff;

    public SHA224Digest() {
        reset();
    }

    public SHA224Digest(SHA224Digest sHA224Digest) {
        super((GeneralDigest) sHA224Digest);
        doCopy(sHA224Digest);
    }

    public SHA224Digest(byte[] bArr) {
        super(bArr);
        this.f7718H1 = Pack.bigEndianToInt(bArr, 16);
        this.f7719H2 = Pack.bigEndianToInt(bArr, 20);
        this.f7720H3 = Pack.bigEndianToInt(bArr, 24);
        this.f7721H4 = Pack.bigEndianToInt(bArr, 28);
        this.f7722H5 = Pack.bigEndianToInt(bArr, 32);
        this.f7723H6 = Pack.bigEndianToInt(bArr, 36);
        this.f7724H7 = Pack.bigEndianToInt(bArr, 40);
        this.f7725H8 = Pack.bigEndianToInt(bArr, 44);
        this.xOff = Pack.bigEndianToInt(bArr, 48);
        for (int i = 0; i != this.xOff; i++) {
            this.f7726X[i] = Pack.bigEndianToInt(bArr, (i * 4) + 52);
        }
    }

    /* renamed from: Ch */
    private int m7073Ch(int i, int i2, int i3) {
        return ((~i) & i3) ^ (i2 & i);
    }

    private int Maj(int i, int i2, int i3) {
        return ((i & i3) ^ (i & i2)) ^ (i2 & i3);
    }

    private int Sum0(int i) {
        return ((i << 10) | (i >>> 22)) ^ (((i >>> 2) | (i << 30)) ^ ((i >>> 13) | (i << 19)));
    }

    private int Sum1(int i) {
        return ((i << 7) | (i >>> 25)) ^ (((i >>> 6) | (i << 26)) ^ ((i >>> 11) | (i << 21)));
    }

    private int Theta0(int i) {
        return (i >>> 3) ^ (((i >>> 7) | (i << 25)) ^ ((i >>> 18) | (i << 14)));
    }

    private int Theta1(int i) {
        return (i >>> 10) ^ (((i >>> 17) | (i << 15)) ^ ((i >>> 19) | (i << 13)));
    }

    private void doCopy(SHA224Digest sHA224Digest) {
        super.copyIn(sHA224Digest);
        this.f7718H1 = sHA224Digest.f7718H1;
        this.f7719H2 = sHA224Digest.f7719H2;
        this.f7720H3 = sHA224Digest.f7720H3;
        this.f7721H4 = sHA224Digest.f7721H4;
        this.f7722H5 = sHA224Digest.f7722H5;
        this.f7723H6 = sHA224Digest.f7723H6;
        this.f7724H7 = sHA224Digest.f7724H7;
        this.f7725H8 = sHA224Digest.f7725H8;
        int[] iArr = sHA224Digest.f7726X;
        System.arraycopy(iArr, 0, this.f7726X, 0, iArr.length);
        this.xOff = sHA224Digest.xOff;
    }

    public Memoable copy() {
        return new SHA224Digest(this);
    }

    public int doFinal(byte[] bArr, int i) {
        finish();
        Pack.intToBigEndian(this.f7718H1, bArr, i);
        Pack.intToBigEndian(this.f7719H2, bArr, i + 4);
        Pack.intToBigEndian(this.f7720H3, bArr, i + 8);
        Pack.intToBigEndian(this.f7721H4, bArr, i + 12);
        Pack.intToBigEndian(this.f7722H5, bArr, i + 16);
        Pack.intToBigEndian(this.f7723H6, bArr, i + 20);
        Pack.intToBigEndian(this.f7724H7, bArr, i + 24);
        reset();
        return 28;
    }

    public String getAlgorithmName() {
        return McElieceCCA2KeyGenParameterSpec.SHA224;
    }

    public int getDigestSize() {
        return 28;
    }

    public byte[] getEncodedState() {
        byte[] bArr = new byte[((this.xOff * 4) + 52)];
        super.populateState(bArr);
        Pack.intToBigEndian(this.f7718H1, bArr, 16);
        Pack.intToBigEndian(this.f7719H2, bArr, 20);
        Pack.intToBigEndian(this.f7720H3, bArr, 24);
        Pack.intToBigEndian(this.f7721H4, bArr, 28);
        Pack.intToBigEndian(this.f7722H5, bArr, 32);
        Pack.intToBigEndian(this.f7723H6, bArr, 36);
        Pack.intToBigEndian(this.f7724H7, bArr, 40);
        Pack.intToBigEndian(this.f7725H8, bArr, 44);
        Pack.intToBigEndian(this.xOff, bArr, 48);
        for (int i = 0; i != this.xOff; i++) {
            Pack.intToBigEndian(this.f7726X[i], bArr, (i * 4) + 52);
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public void processBlock() {
        for (int i = 16; i <= 63; i++) {
            int[] iArr = this.f7726X;
            int Theta1 = Theta1(iArr[i - 2]);
            int[] iArr2 = this.f7726X;
            iArr[i] = Theta1 + iArr2[i - 7] + Theta0(iArr2[i - 15]) + this.f7726X[i - 16];
        }
        int i2 = this.f7718H1;
        int i3 = this.f7719H2;
        int i4 = this.f7720H3;
        int i5 = this.f7721H4;
        int i6 = this.f7722H5;
        int i7 = this.f7723H6;
        int i8 = this.f7724H7;
        int i9 = this.f7725H8;
        int i10 = 0;
        for (int i11 = 0; i11 < 8; i11++) {
            int Sum1 = i9 + Sum1(i6) + m7073Ch(i6, i7, i8) + f7717K[i10] + this.f7726X[i10];
            int i12 = i5 + Sum1;
            int Sum0 = Sum1 + Sum0(i2) + Maj(i2, i3, i4);
            int i13 = i10 + 1;
            int Sum12 = i8 + Sum1(i12) + m7073Ch(i12, i6, i7) + f7717K[i13] + this.f7726X[i13];
            int i14 = i4 + Sum12;
            int Sum02 = Sum12 + Sum0(Sum0) + Maj(Sum0, i2, i3);
            int i15 = i13 + 1;
            int Sum13 = i7 + Sum1(i14) + m7073Ch(i14, i12, i6) + f7717K[i15] + this.f7726X[i15];
            int i16 = i3 + Sum13;
            int Sum03 = Sum13 + Sum0(Sum02) + Maj(Sum02, Sum0, i2);
            int i17 = i15 + 1;
            int Sum14 = i6 + Sum1(i16) + m7073Ch(i16, i14, i12) + f7717K[i17] + this.f7726X[i17];
            int i18 = i2 + Sum14;
            int Sum04 = Sum14 + Sum0(Sum03) + Maj(Sum03, Sum02, Sum0);
            int i19 = i17 + 1;
            int Sum15 = i12 + Sum1(i18) + m7073Ch(i18, i16, i14) + f7717K[i19] + this.f7726X[i19];
            i9 = Sum0 + Sum15;
            i5 = Sum15 + Sum0(Sum04) + Maj(Sum04, Sum03, Sum02);
            int i20 = i19 + 1;
            int Sum16 = i14 + Sum1(i9) + m7073Ch(i9, i18, i16) + f7717K[i20] + this.f7726X[i20];
            i8 = Sum02 + Sum16;
            i4 = Sum16 + Sum0(i5) + Maj(i5, Sum04, Sum03);
            int i21 = i20 + 1;
            int Sum17 = i16 + Sum1(i8) + m7073Ch(i8, i9, i18) + f7717K[i21] + this.f7726X[i21];
            i7 = Sum03 + Sum17;
            i3 = Sum17 + Sum0(i4) + Maj(i4, i5, Sum04);
            int i22 = i21 + 1;
            int Sum18 = i18 + Sum1(i7) + m7073Ch(i7, i8, i9) + f7717K[i22] + this.f7726X[i22];
            i6 = Sum04 + Sum18;
            i2 = Sum18 + Sum0(i3) + Maj(i3, i4, i5);
            i10 = i22 + 1;
        }
        this.f7718H1 += i2;
        this.f7719H2 += i3;
        this.f7720H3 += i4;
        this.f7721H4 += i5;
        this.f7722H5 += i6;
        this.f7723H6 += i7;
        this.f7724H7 += i8;
        this.f7725H8 += i9;
        this.xOff = 0;
        for (int i23 = 0; i23 < 16; i23++) {
            this.f7726X[i23] = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void processLength(long j) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.f7726X;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) (j & -1);
    }

    /* access modifiers changed from: protected */
    public void processWord(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i3 + 1] & 255) | (bArr[i] << Ascii.CAN) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
        int[] iArr = this.f7726X;
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
        this.f7718H1 = -1056596264;
        this.f7719H2 = 914150663;
        this.f7720H3 = 812702999;
        this.f7721H4 = -150054599;
        this.f7722H5 = -4191439;
        this.f7723H6 = 1750603025;
        this.f7724H7 = 1694076839;
        this.f7725H8 = -1090891868;
        this.xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f7726X;
            if (i != iArr.length) {
                iArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }

    public void reset(Memoable memoable) {
        doCopy((SHA224Digest) memoable);
    }
}
