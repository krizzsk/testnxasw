package org.bouncycastle.crypto.modes.gcm;

import java.lang.reflect.Array;
import org.bouncycastle.util.Pack;

public class Tables4kGCMMultiplier implements GCMMultiplier {

    /* renamed from: H */
    private byte[] f7973H;

    /* renamed from: T */
    private long[][] f7974T;

    public void init(byte[] bArr) {
        if (this.f7974T == null) {
            this.f7974T = (long[][]) Array.newInstance(long.class, new int[]{256, 2});
        } else if (GCMUtil.areEqual(this.f7973H, bArr) != 0) {
            return;
        }
        byte[] bArr2 = new byte[16];
        this.f7973H = bArr2;
        GCMUtil.copy(bArr, bArr2);
        GCMUtil.asLongs(this.f7973H, this.f7974T[1]);
        long[][] jArr = this.f7974T;
        GCMUtil.multiplyP7(jArr[1], jArr[1]);
        for (int i = 2; i < 256; i += 2) {
            long[][] jArr2 = this.f7974T;
            GCMUtil.divideP(jArr2[i >> 1], jArr2[i]);
            long[][] jArr3 = this.f7974T;
            GCMUtil.xor(jArr3[i], jArr3[1], jArr3[i + 1]);
        }
    }

    public void multiplyH(byte[] bArr) {
        byte[] bArr2 = bArr;
        long[] jArr = this.f7974T[bArr2[15] & 255];
        long j = jArr[0];
        long j2 = jArr[1];
        for (int i = 14; i >= 0; i--) {
            long[] jArr2 = this.f7974T[bArr2[i] & 255];
            long j3 = j2 << 56;
            j2 = ((j2 >>> 8) | (j << 56)) ^ jArr2[1];
            j = (((((j >>> 8) ^ jArr2[0]) ^ j3) ^ (j3 >>> 1)) ^ (j3 >>> 2)) ^ (j3 >>> 7);
        }
        Pack.longToBigEndian(j, bArr2, 0);
        Pack.longToBigEndian(j2, bArr2, 8);
    }
}
