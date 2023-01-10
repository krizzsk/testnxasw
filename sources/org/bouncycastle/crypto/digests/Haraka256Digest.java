package org.bouncycastle.crypto.digests;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Array;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Arrays;

public class Haraka256Digest extends HarakaBase {

    /* renamed from: RC */
    private static final byte[][] f7648RC = {new byte[]{6, -124, 112, 76, -26, 32, -64, 10, -78, -59, -2, -16, 117, -127, 123, -99}, new byte[]{-117, 102, -76, -31, -120, -13, -96, 107, 100, Ascii.f55148SI, 107, -92, 47, 8, -9, Ascii.ETB}, new byte[]{52, 2, -34, 45, 83, -14, -124, -104, -49, 2, -99, 96, -97, 2, -111, Ascii.DC4}, new byte[]{Ascii.f55149SO, -42, -22, -26, 46, 123, 79, 8, -69, -13, PSSSigner.TRAILER_IMPLICIT, -81, -3, 91, 79, 121}, new byte[]{-53, -49, -80, -53, 72, 114, 68, -117, 121, -18, -51, Ascii.f55142FS, -66, 57, 112, 68}, new byte[]{126, -22, -51, -18, 110, -112, 50, -73, -115, 83, 53, -19, 43, -118, 5, 123}, new byte[]{103, -62, -113, 67, 94, 46, 124, -48, -30, 65, 39, 97, -38, 79, -17, Ascii.ESC}, new byte[]{41, 36, -39, -80, -81, -54, -52, 7, 103, 95, -3, -30, Ascii.f55151US, -57, 11, 59}, new byte[]{-85, 77, 99, -15, -26, -122, Byte.MAX_VALUE, -23, -20, -37, -113, -54, -71, -44, 101, -18}, new byte[]{Ascii.f55142FS, 48, -65, -124, -44, -73, -51, 100, 91, 42, SignedBytes.MAX_POWER_OF_TWO, 79, -83, 3, 126, 51}, new byte[]{-78, -52, 11, -71, -108, Ascii.ETB, 35, -65, 105, 2, -117, 46, -115, -10, -104, 0}, new byte[]{-6, 4, 120, -90, -34, 111, 85, 114, 74, -86, -98, -56, 92, -99, 45, -118}, new byte[]{-33, -76, -97, 43, 107, 119, 42, Ascii.DC2, Ascii.f55149SO, -6, 79, 46, 41, Ascii.DC2, -97, -44}, new byte[]{Ascii.f55147RS, -95, 3, 68, -12, 73, -94, 54, 50, -42, 17, -82, -69, 106, Ascii.DC2, -18}, new byte[]{-81, 4, 73, -120, 75, 5, 0, -124, 95, -106, 0, -55, -100, -88, -20, -90}, new byte[]{33, 2, 94, -40, -99, Ascii.f55140EM, -100, 79, 120, -94, -57, -29, 39, -27, -109, -20}, new byte[]{-65, 58, -86, -8, -89, 89, -55, -73, -71, 40, 46, -51, -126, -44, 1, 115}, new byte[]{98, 96, 112, Ascii.f55139CR, 97, -122, -80, Ascii.ETB, 55, -14, -17, -39, 16, 48, 125, 107}, new byte[]{90, -54, 69, -62, 33, 48, 4, 67, -127, -62, -111, 83, -10, -4, -102, -58}, new byte[]{-110, 35, -105, 60, 34, 107, 104, -69, 44, -81, -110, -24, 54, -47, -108, 58}};
    private final byte[] buffer;
    private int off;

    public Haraka256Digest() {
        this.buffer = new byte[32];
    }

    public Haraka256Digest(Haraka256Digest haraka256Digest) {
        this.buffer = Arrays.clone(haraka256Digest.buffer);
        this.off = haraka256Digest.off;
    }

    private int haraka256256(byte[] bArr, byte[] bArr2, int i) {
        Class<byte> cls = byte.class;
        byte[][] bArr3 = (byte[][]) Array.newInstance(cls, new int[]{2, 16});
        byte[][] bArr4 = (byte[][]) Array.newInstance(cls, new int[]{2, 16});
        System.arraycopy(bArr, 0, bArr3[0], 0, 16);
        System.arraycopy(bArr, 16, bArr3[1], 0, 16);
        bArr3[0] = aesEnc(bArr3[0], f7648RC[0]);
        bArr3[1] = aesEnc(bArr3[1], f7648RC[1]);
        bArr3[0] = aesEnc(bArr3[0], f7648RC[2]);
        bArr3[1] = aesEnc(bArr3[1], f7648RC[3]);
        mix256(bArr3, bArr4);
        bArr3[0] = aesEnc(bArr4[0], f7648RC[4]);
        bArr3[1] = aesEnc(bArr4[1], f7648RC[5]);
        bArr3[0] = aesEnc(bArr3[0], f7648RC[6]);
        bArr3[1] = aesEnc(bArr3[1], f7648RC[7]);
        mix256(bArr3, bArr4);
        bArr3[0] = aesEnc(bArr4[0], f7648RC[8]);
        bArr3[1] = aesEnc(bArr4[1], f7648RC[9]);
        bArr3[0] = aesEnc(bArr3[0], f7648RC[10]);
        bArr3[1] = aesEnc(bArr3[1], f7648RC[11]);
        mix256(bArr3, bArr4);
        bArr3[0] = aesEnc(bArr4[0], f7648RC[12]);
        bArr3[1] = aesEnc(bArr4[1], f7648RC[13]);
        bArr3[0] = aesEnc(bArr3[0], f7648RC[14]);
        bArr3[1] = aesEnc(bArr3[1], f7648RC[15]);
        mix256(bArr3, bArr4);
        bArr3[0] = aesEnc(bArr4[0], f7648RC[16]);
        bArr3[1] = aesEnc(bArr4[1], f7648RC[17]);
        bArr3[0] = aesEnc(bArr3[0], f7648RC[18]);
        bArr3[1] = aesEnc(bArr3[1], f7648RC[19]);
        mix256(bArr3, bArr4);
        bArr3[0] = xor(bArr4[0], bArr, 0);
        bArr3[1] = xor(bArr4[1], bArr, 16);
        System.arraycopy(bArr3[0], 0, bArr2, i, 16);
        System.arraycopy(bArr3[1], 0, bArr2, i + 16, 16);
        return 32;
    }

    private void mix256(byte[][] bArr, byte[][] bArr2) {
        System.arraycopy(bArr[0], 0, bArr2[0], 0, 4);
        System.arraycopy(bArr[1], 0, bArr2[0], 4, 4);
        System.arraycopy(bArr[0], 4, bArr2[0], 8, 4);
        System.arraycopy(bArr[1], 4, bArr2[0], 12, 4);
        System.arraycopy(bArr[0], 8, bArr2[1], 0, 4);
        System.arraycopy(bArr[1], 8, bArr2[1], 4, 4);
        System.arraycopy(bArr[0], 12, bArr2[1], 8, 4);
        System.arraycopy(bArr[1], 12, bArr2[1], 12, 4);
    }

    public int doFinal(byte[] bArr, int i) {
        if (this.off != 32) {
            throw new IllegalStateException("input must be exactly 32 bytes");
        } else if (bArr.length - i >= 32) {
            int haraka256256 = haraka256256(this.buffer, bArr, i);
            reset();
            return haraka256256;
        } else {
            throw new IllegalArgumentException("output too short to receive digest");
        }
    }

    public String getAlgorithmName() {
        return "Haraka-256";
    }

    public void reset() {
        this.off = 0;
        Arrays.clear(this.buffer);
    }

    public void update(byte b) {
        int i = this.off;
        if (i + 1 <= 32) {
            byte[] bArr = this.buffer;
            this.off = i + 1;
            bArr[i] = b;
            return;
        }
        throw new IllegalArgumentException("total input cannot be more than 32 bytes");
    }

    public void update(byte[] bArr, int i, int i2) {
        int i3 = this.off;
        if (i3 + i2 <= 32) {
            System.arraycopy(bArr, i, this.buffer, i3, i2);
            this.off += i2;
            return;
        }
        throw new IllegalArgumentException("total input cannot be more than 32 bytes");
    }
}
