package org.bouncycastle.crypto.modes.gcm;

import java.lang.reflect.Array;
import org.bouncycastle.util.Pack;

public class Tables64kGCMMultiplier implements GCMMultiplier {

    /* renamed from: H */
    private byte[] f7975H;

    /* renamed from: T */
    private long[][][] f7976T;

    public void init(byte[] bArr) {
        if (this.f7976T == null) {
            this.f7976T = (long[][][]) Array.newInstance(long.class, new int[]{16, 256, 2});
        } else if (GCMUtil.areEqual(this.f7975H, bArr) != 0) {
            return;
        }
        byte[] bArr2 = new byte[16];
        this.f7975H = bArr2;
        GCMUtil.copy(bArr, bArr2);
        for (int i = 0; i < 16; i++) {
            long[][][] jArr = this.f7976T;
            long[][] jArr2 = jArr[i];
            if (i == 0) {
                GCMUtil.asLongs(this.f7975H, jArr2[1]);
                GCMUtil.multiplyP7(jArr2[1], jArr2[1]);
            } else {
                GCMUtil.multiplyP8(jArr[i - 1][1], jArr2[1]);
            }
            for (int i2 = 2; i2 < 256; i2 += 2) {
                GCMUtil.divideP(jArr2[i2 >> 1], jArr2[i2]);
                GCMUtil.xor(jArr2[i2], jArr2[1], jArr2[i2 + 1]);
            }
        }
    }

    public void multiplyH(byte[] bArr) {
        long[] jArr = this.f7976T[15][bArr[15] & 255];
        long j = jArr[0];
        long j2 = jArr[1];
        for (int i = 14; i >= 0; i--) {
            long[] jArr2 = this.f7976T[i][bArr[i] & 255];
            j ^= jArr2[0];
            j2 ^= jArr2[1];
        }
        Pack.longToBigEndian(j, bArr, 0);
        Pack.longToBigEndian(j2, bArr, 8);
    }
}
