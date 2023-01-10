package org.bouncycastle.crypto.modes.gcm;

public class BasicGCMExponentiator implements GCMExponentiator {

    /* renamed from: x */
    private long[] f7970x;

    public void exponentiateX(long j, byte[] bArr) {
        long[] oneAsLongs = GCMUtil.oneAsLongs();
        if (j > 0) {
            long[] jArr = new long[2];
            GCMUtil.copy(this.f7970x, jArr);
            do {
                if ((1 & j) != 0) {
                    GCMUtil.multiply(oneAsLongs, jArr);
                }
                GCMUtil.square(jArr, jArr);
                j >>>= 1;
            } while (j > 0);
        }
        GCMUtil.asBytes(oneAsLongs, bArr);
    }

    public void init(byte[] bArr) {
        this.f7970x = GCMUtil.asLongs(bArr);
    }
}
