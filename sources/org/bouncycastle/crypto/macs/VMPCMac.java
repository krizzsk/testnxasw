package org.bouncycastle.crypto.macs;

import com.google.common.base.Ascii;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class VMPCMac implements Mac {

    /* renamed from: P */
    private byte[] f7928P = null;

    /* renamed from: T */
    private byte[] f7929T;

    /* renamed from: g */
    private byte f7930g;

    /* renamed from: n */
    private byte f7931n = 0;

    /* renamed from: s */
    private byte f7932s = 0;
    private byte[] workingIV;
    private byte[] workingKey;

    /* renamed from: x1 */
    private byte f7933x1;

    /* renamed from: x2 */
    private byte f7934x2;

    /* renamed from: x3 */
    private byte f7935x3;

    /* renamed from: x4 */
    private byte f7936x4;

    private void initKey(byte[] bArr, byte[] bArr2) {
        this.f7932s = 0;
        this.f7928P = new byte[256];
        for (int i = 0; i < 256; i++) {
            this.f7928P[i] = (byte) i;
        }
        for (int i2 = 0; i2 < 768; i2++) {
            byte[] bArr3 = this.f7928P;
            int i3 = i2 & 255;
            byte b = bArr3[(this.f7932s + bArr3[i3] + bArr[i2 % bArr.length]) & 255];
            this.f7932s = b;
            byte b2 = bArr3[i3];
            bArr3[i3] = bArr3[b & 255];
            bArr3[b & 255] = b2;
        }
        for (int i4 = 0; i4 < 768; i4++) {
            byte[] bArr4 = this.f7928P;
            int i5 = i4 & 255;
            byte b3 = bArr4[(this.f7932s + bArr4[i5] + bArr2[i4 % bArr2.length]) & 255];
            this.f7932s = b3;
            byte b4 = bArr4[i5];
            bArr4[i5] = bArr4[b3 & 255];
            bArr4[b3 & 255] = b4;
        }
        this.f7931n = 0;
    }

    public int doFinal(byte[] bArr, int i) throws DataLengthException, IllegalStateException {
        for (int i2 = 1; i2 < 25; i2++) {
            byte[] bArr2 = this.f7928P;
            byte b = this.f7932s;
            byte b2 = this.f7931n;
            byte b3 = bArr2[(b + bArr2[b2 & 255]) & 255];
            this.f7932s = b3;
            byte b4 = this.f7936x4;
            byte b5 = this.f7935x3;
            byte b6 = bArr2[(b4 + b5 + i2) & 255];
            this.f7936x4 = b6;
            byte b7 = this.f7934x2;
            byte b8 = bArr2[(b5 + b7 + i2) & 255];
            this.f7935x3 = b8;
            byte b9 = this.f7933x1;
            byte b10 = bArr2[(b7 + b9 + i2) & 255];
            this.f7934x2 = b10;
            byte b11 = bArr2[(b9 + b3 + i2) & 255];
            this.f7933x1 = b11;
            byte[] bArr3 = this.f7929T;
            byte b12 = this.f7930g;
            bArr3[b12 & Ascii.f55151US] = (byte) (b11 ^ bArr3[b12 & Ascii.f55151US]);
            bArr3[(b12 + 1) & 31] = (byte) (b10 ^ bArr3[(b12 + 1) & 31]);
            bArr3[(b12 + 2) & 31] = (byte) (b8 ^ bArr3[(b12 + 2) & 31]);
            bArr3[(b12 + 3) & 31] = (byte) (b6 ^ bArr3[(b12 + 3) & 31]);
            this.f7930g = (byte) ((b12 + 4) & 31);
            byte b13 = bArr2[b2 & 255];
            bArr2[b2 & 255] = bArr2[b3 & 255];
            bArr2[b3 & 255] = b13;
            this.f7931n = (byte) ((b2 + 1) & 255);
        }
        for (int i3 = 0; i3 < 768; i3++) {
            byte[] bArr4 = this.f7928P;
            int i4 = i3 & 255;
            byte b14 = bArr4[(this.f7932s + bArr4[i4] + this.f7929T[i3 & 31]) & 255];
            this.f7932s = b14;
            byte b15 = bArr4[i4];
            bArr4[i4] = bArr4[b14 & 255];
            bArr4[b14 & 255] = b15;
        }
        byte[] bArr5 = new byte[20];
        for (int i5 = 0; i5 < 20; i5++) {
            byte[] bArr6 = this.f7928P;
            int i6 = i5 & 255;
            byte b16 = bArr6[(this.f7932s + bArr6[i6]) & 255];
            this.f7932s = b16;
            bArr5[i5] = bArr6[(bArr6[bArr6[b16 & 255] & 255] + 1) & 255];
            byte b17 = bArr6[i6];
            bArr6[i6] = bArr6[b16 & 255];
            bArr6[b16 & 255] = b17;
        }
        System.arraycopy(bArr5, 0, bArr, i, 20);
        reset();
        return 20;
    }

    public String getAlgorithmName() {
        return "VMPC-MAC";
    }

    public int getMacSize() {
        return 20;
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            KeyParameter keyParameter = (KeyParameter) parametersWithIV.getParameters();
            if (parametersWithIV.getParameters() instanceof KeyParameter) {
                byte[] iv = parametersWithIV.getIV();
                this.workingIV = iv;
                if (iv == null || iv.length < 1 || iv.length > 768) {
                    throw new IllegalArgumentException("VMPC-MAC requires 1 to 768 bytes of IV");
                }
                this.workingKey = keyParameter.getKey();
                reset();
                return;
            }
            throw new IllegalArgumentException("VMPC-MAC Init parameters must include a key");
        }
        throw new IllegalArgumentException("VMPC-MAC Init parameters must include an IV");
    }

    public void reset() {
        initKey(this.workingKey, this.workingIV);
        this.f7931n = 0;
        this.f7936x4 = 0;
        this.f7935x3 = 0;
        this.f7934x2 = 0;
        this.f7933x1 = 0;
        this.f7930g = 0;
        this.f7929T = new byte[32];
        for (int i = 0; i < 32; i++) {
            this.f7929T[i] = 0;
        }
    }

    public void update(byte b) throws IllegalStateException {
        byte[] bArr = this.f7928P;
        byte b2 = this.f7932s;
        byte b3 = this.f7931n;
        byte b4 = bArr[(b2 + bArr[b3 & 255]) & 255];
        this.f7932s = b4;
        byte b5 = this.f7936x4;
        byte b6 = this.f7935x3;
        byte b7 = bArr[(b5 + b6) & 255];
        this.f7936x4 = b7;
        byte b8 = this.f7934x2;
        byte b9 = bArr[(b6 + b8) & 255];
        this.f7935x3 = b9;
        byte b10 = this.f7933x1;
        byte b11 = bArr[(b8 + b10) & 255];
        this.f7934x2 = b11;
        byte b12 = bArr[(b10 + b4 + ((byte) (b ^ bArr[(bArr[bArr[b4 & 255] & 255] + 1) & 255]))) & 255];
        this.f7933x1 = b12;
        byte[] bArr2 = this.f7929T;
        byte b13 = this.f7930g;
        bArr2[b13 & Ascii.f55151US] = (byte) (b12 ^ bArr2[b13 & Ascii.f55151US]);
        bArr2[(b13 + 1) & 31] = (byte) (b11 ^ bArr2[(b13 + 1) & 31]);
        bArr2[(b13 + 2) & 31] = (byte) (b9 ^ bArr2[(b13 + 2) & 31]);
        bArr2[(b13 + 3) & 31] = (byte) (b7 ^ bArr2[(b13 + 3) & 31]);
        this.f7930g = (byte) ((b13 + 4) & 31);
        byte b14 = bArr[b3 & 255];
        bArr[b3 & 255] = bArr[b4 & 255];
        bArr[b4 & 255] = b14;
        this.f7931n = (byte) ((b3 + 1) & 255);
    }

    public void update(byte[] bArr, int i, int i2) throws DataLengthException, IllegalStateException {
        if (i + i2 <= bArr.length) {
            for (int i3 = 0; i3 < i2; i3++) {
                update(bArr[i + i3]);
            }
            return;
        }
        throw new DataLengthException("input buffer too short");
    }
}
