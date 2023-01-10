package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public class SHA512Digest extends LongDigest {
    private static final int DIGEST_LENGTH = 64;

    public SHA512Digest() {
    }

    public SHA512Digest(SHA512Digest sHA512Digest) {
        super(sHA512Digest);
    }

    public SHA512Digest(byte[] bArr) {
        restoreState(bArr);
    }

    public Memoable copy() {
        return new SHA512Digest(this);
    }

    public int doFinal(byte[] bArr, int i) {
        finish();
        Pack.longToBigEndian(this.f7652H1, bArr, i);
        Pack.longToBigEndian(this.f7653H2, bArr, i + 8);
        Pack.longToBigEndian(this.f7654H3, bArr, i + 16);
        Pack.longToBigEndian(this.f7655H4, bArr, i + 24);
        Pack.longToBigEndian(this.f7656H5, bArr, i + 32);
        Pack.longToBigEndian(this.f7657H6, bArr, i + 40);
        Pack.longToBigEndian(this.f7658H7, bArr, i + 48);
        Pack.longToBigEndian(this.f7659H8, bArr, i + 56);
        reset();
        return 64;
    }

    public String getAlgorithmName() {
        return "SHA-512";
    }

    public int getDigestSize() {
        return 64;
    }

    public byte[] getEncodedState() {
        byte[] bArr = new byte[getEncodedStateSize()];
        super.populateState(bArr);
        return bArr;
    }

    public void reset() {
        super.reset();
        this.f7652H1 = 7640891576956012808L;
        this.f7653H2 = -4942790177534073029L;
        this.f7654H3 = 4354685564936845355L;
        this.f7655H4 = -6534734903238641935L;
        this.f7656H5 = 5840696475078001361L;
        this.f7657H6 = -7276294671716946913L;
        this.f7658H7 = 2270897969802886507L;
        this.f7659H8 = 6620516959819538809L;
    }

    public void reset(Memoable memoable) {
        copyIn((SHA512Digest) memoable);
    }
}
