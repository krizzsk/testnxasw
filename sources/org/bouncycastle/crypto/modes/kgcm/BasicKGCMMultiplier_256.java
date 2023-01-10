package org.bouncycastle.crypto.modes.kgcm;

public class BasicKGCMMultiplier_256 implements KGCMMultiplier {

    /* renamed from: H */
    private final long[] f7980H = new long[4];

    public void init(long[] jArr) {
        KGCMUtil_256.copy(jArr, this.f7980H);
    }

    public void multiplyH(long[] jArr) {
        KGCMUtil_256.multiply(jArr, this.f7980H, jArr);
    }
}
