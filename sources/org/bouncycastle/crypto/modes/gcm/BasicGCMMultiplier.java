package org.bouncycastle.crypto.modes.gcm;

public class BasicGCMMultiplier implements GCMMultiplier {

    /* renamed from: H */
    private long[] f7971H;

    public void init(byte[] bArr) {
        this.f7971H = GCMUtil.asLongs(bArr);
    }

    public void multiplyH(byte[] bArr) {
        long[] asLongs = GCMUtil.asLongs(bArr);
        GCMUtil.multiply(asLongs, this.f7971H);
        GCMUtil.asBytes(asLongs, bArr);
    }
}
