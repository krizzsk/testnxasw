package net.lingala.zip4j.crypto;

import java.security.SecureRandom;
import net.lingala.zip4j.crypto.PBKDF2.MacBasedPRF;
import net.lingala.zip4j.crypto.engine.AESEngine;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.enums.AesKeyStrength;

public class AESEncrypter implements Encrypter {

    /* renamed from: a */
    private AESEngine f6650a;

    /* renamed from: b */
    private MacBasedPRF f6651b;

    /* renamed from: c */
    private final SecureRandom f6652c = new SecureRandom();

    /* renamed from: d */
    private boolean f6653d;

    /* renamed from: e */
    private int f6654e = 1;

    /* renamed from: f */
    private int f6655f = 0;

    /* renamed from: g */
    private final byte[] f6656g;

    /* renamed from: h */
    private final byte[] f6657h;

    /* renamed from: i */
    private byte[] f6658i;

    /* renamed from: j */
    private byte[] f6659j;

    public AESEncrypter(char[] cArr, AesKeyStrength aesKeyStrength) throws ZipException {
        if (cArr == null || cArr.length == 0) {
            throw new ZipException("input password is empty or null");
        } else if (aesKeyStrength == AesKeyStrength.KEY_STRENGTH_128 || aesKeyStrength == AesKeyStrength.KEY_STRENGTH_256) {
            this.f6653d = false;
            this.f6657h = new byte[16];
            this.f6656g = new byte[16];
            m6445a(cArr, aesKeyStrength);
        } else {
            throw new ZipException("Invalid AES key strength");
        }
    }

    /* renamed from: a */
    private void m6445a(char[] cArr, AesKeyStrength aesKeyStrength) throws ZipException {
        byte[] a = m6446a(aesKeyStrength.getSaltLength());
        this.f6659j = a;
        byte[] derivePasswordBasedKey = AesCipherUtil.derivePasswordBasedKey(a, cArr, aesKeyStrength);
        this.f6658i = AesCipherUtil.derivePasswordVerifier(derivePasswordBasedKey, aesKeyStrength);
        this.f6650a = AesCipherUtil.getAESEngine(derivePasswordBasedKey, aesKeyStrength);
        this.f6651b = AesCipherUtil.getMacBasedPRF(derivePasswordBasedKey, aesKeyStrength);
    }

    public int encryptData(byte[] bArr) throws ZipException {
        if (bArr != null) {
            return encryptData(bArr, 0, bArr.length);
        }
        throw new ZipException("input bytes are null, cannot perform AES encryption");
    }

    public int encryptData(byte[] bArr, int i, int i2) throws ZipException {
        int i3;
        if (!this.f6653d) {
            if (i2 % 16 != 0) {
                this.f6653d = true;
            }
            int i4 = i;
            while (true) {
                int i5 = i + i2;
                if (i4 >= i5) {
                    return i2;
                }
                int i6 = i4 + 16;
                this.f6655f = i6 <= i5 ? 16 : i5 - i4;
                AesCipherUtil.prepareBuffAESIVBytes(this.f6656g, this.f6654e);
                this.f6650a.processBlock(this.f6656g, this.f6657h);
                int i7 = 0;
                while (true) {
                    i3 = this.f6655f;
                    if (i7 >= i3) {
                        break;
                    }
                    int i8 = i4 + i7;
                    bArr[i8] = (byte) (bArr[i8] ^ this.f6657h[i7]);
                    i7++;
                }
                this.f6651b.update(bArr, i4, i3);
                this.f6654e++;
                i4 = i6;
            }
        } else {
            throw new ZipException("AES Encrypter is in finished state (A non 16 byte block has already been passed to encrypter)");
        }
    }

    /* renamed from: a */
    private byte[] m6446a(int i) throws ZipException {
        if (i == 8 || i == 16) {
            int i2 = i == 8 ? 2 : 4;
            byte[] bArr = new byte[i];
            for (int i3 = 0; i3 < i2; i3++) {
                int nextInt = this.f6652c.nextInt();
                int i4 = i3 * 4;
                bArr[i4] = (byte) (nextInt >> 24);
                bArr[i4 + 1] = (byte) (nextInt >> 16);
                bArr[i4 + 2] = (byte) (nextInt >> 8);
                bArr[i4 + 3] = (byte) nextInt;
            }
            return bArr;
        }
        throw new ZipException("invalid salt size, cannot generate salt");
    }

    public byte[] getFinalMac() {
        byte[] bArr = new byte[10];
        System.arraycopy(this.f6651b.doFinal(), 0, bArr, 0, 10);
        return bArr;
    }

    public byte[] getDerivedPasswordVerifier() {
        return this.f6658i;
    }

    public byte[] getSaltBytes() {
        return this.f6659j;
    }
}
