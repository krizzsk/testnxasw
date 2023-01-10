package org.bouncycastle.crypto.modes.gcm;

import com.google.common.base.Ascii;
import java.lang.reflect.Array;
import org.bouncycastle.util.Pack;

public class Tables8kGCMMultiplier implements GCMMultiplier {

    /* renamed from: H */
    private byte[] f7977H;

    /* renamed from: T */
    private long[][][] f7978T;

    public void init(byte[] bArr) {
        if (this.f7978T == null) {
            this.f7978T = (long[][][]) Array.newInstance(long.class, new int[]{32, 16, 2});
        } else if (GCMUtil.areEqual(this.f7977H, bArr) != 0) {
            return;
        }
        byte[] bArr2 = new byte[16];
        this.f7977H = bArr2;
        GCMUtil.copy(bArr, bArr2);
        for (int i = 0; i < 32; i++) {
            long[][][] jArr = this.f7978T;
            long[][] jArr2 = jArr[i];
            if (i == 0) {
                GCMUtil.asLongs(this.f7977H, jArr2[1]);
                GCMUtil.multiplyP3(jArr2[1], jArr2[1]);
            } else {
                GCMUtil.multiplyP4(jArr[i - 1][1], jArr2[1]);
            }
            for (int i2 = 2; i2 < 16; i2 += 2) {
                GCMUtil.divideP(jArr2[i2 >> 1], jArr2[i2]);
                GCMUtil.xor(jArr2[i2], jArr2[1], jArr2[i2 + 1]);
            }
        }
    }

    public void multiplyH(byte[] bArr) {
        long j = 0;
        long j2 = 0;
        for (int i = 15; i >= 0; i--) {
            long[][][] jArr = this.f7978T;
            int i2 = i + i;
            long[] jArr2 = jArr[i2 + 1][bArr[i] & Ascii.f55148SI];
            long[] jArr3 = jArr[i2][(bArr[i] & 240) >>> 4];
            j ^= jArr2[0] ^ jArr3[0];
            j2 ^= jArr3[1] ^ jArr2[1];
        }
        Pack.longToBigEndian(j, bArr, 0);
        Pack.longToBigEndian(j2, bArr, 8);
    }
}
