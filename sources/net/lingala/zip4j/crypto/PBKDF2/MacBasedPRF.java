package net.lingala.zip4j.crypto.PBKDF2;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class MacBasedPRF implements C2950c {

    /* renamed from: a */
    private Mac f6661a;

    /* renamed from: b */
    private int f6662b;

    /* renamed from: c */
    private String f6663c;

    public MacBasedPRF(String str) {
        this.f6663c = str;
        try {
            Mac instance = Mac.getInstance(str);
            this.f6661a = instance;
            this.f6662b = instance.getMacLength();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] doFinal(byte[] bArr) {
        return this.f6661a.doFinal(bArr);
    }

    public byte[] doFinal() {
        return this.f6661a.doFinal();
    }

    public int getHLen() {
        return this.f6662b;
    }

    public void init(byte[] bArr) {
        try {
            this.f6661a.init(new SecretKeySpec(bArr, this.f6663c));
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(byte[] bArr) {
        try {
            this.f6661a.update(bArr);
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(byte[] bArr, int i, int i2) {
        try {
            this.f6661a.update(bArr, i, i2);
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }
}
