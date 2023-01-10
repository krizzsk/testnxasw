package org.bouncycastle.crypto.modes.kgcm;

public class BasicKGCMMultiplier_128 implements KGCMMultiplier {

    /* renamed from: H */
    private final long[] f7979H = new long[2];

    public void init(long[] jArr) {
        KGCMUtil_128.copy(jArr, this.f7979H);
    }

    public void multiplyH(long[] jArr) {
        KGCMUtil_128.multiply(jArr, this.f7979H, jArr);
    }
}
