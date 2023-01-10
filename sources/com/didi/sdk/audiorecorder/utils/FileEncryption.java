package com.didi.sdk.audiorecorder.utils;

import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class FileEncryption {
    public static final int AES_Key_Size = 128;
    public static final String EMPTY_STRING = "";
    public static int PUBLIC_KEY_VERSION = 1;

    /* renamed from: a */
    private static final String f38337a = "FileEncryption -> ";

    /* renamed from: b */
    private static String f38338b = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtikyBUIL5D3dwLUd2VRzvaBqd75RS99jt756beQzg3DAjD+775Cgepp5BCSrPiiS4BMFO4v+/3wBUnIEycog2rh6EpUZC+DqsVeSY2Uh5uhcvMZLX262EJVwtGDL7wV4SSbxRZAKVs3/pbCPcn1HWXxpqbmHyfFVbJehZ5yroI+DCYjmIqMx7g10llR1uoBlEanLEFbXM+1YC5HKwRo0odCCz2AhblA6eLljdouwff1k/v073+8jSonDR7Dtf6YDFleN/4kBTGNQk3ceVAMCWIvXNYPecfxommt/RES5SGNRa6PoO0UjPOokizoKZL1HvCm6BypsAA5ZztJeSRjpJQIDAQAB";

    /* renamed from: c */
    private Cipher f38339c = Cipher.getInstance("AES/CBC/PKCS5Padding");

    /* renamed from: d */
    private SecretKeySpec f38340d;

    /* renamed from: e */
    private IvParameterSpec f38341e;

    public FileEncryption() throws NoSuchPaddingException, NoSuchAlgorithmException {
    }

    public FileEncryption(String str) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.f38340d = new SecretKeySpec(str.getBytes(), "AES");
    }

    public FileEncryption(byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.f38340d = new SecretKeySpec(bArr, "AES");
    }

    public static String getEncryptString(byte[] bArr) {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("ibt_record_voice_public_key");
        if (!(toggle == null || (experiment = toggle.getExperiment()) == null)) {
            String str = (String) experiment.getParam("publicKey", "");
            int intValue = ((Integer) experiment.getParam("version", -1)).intValue();
            if (!TextUtils.isEmpty(str) && intValue != -1) {
                f38338b = str;
                PUBLIC_KEY_VERSION = intValue;
                LogUtil.log("KEYVERSION:" + intValue);
            }
        }
        try {
            return String.format("vault:v%s:%s", new Object[]{Integer.valueOf(PUBLIC_KEY_VERSION), Base64Utils.encode(RSAUtils.encryptByPublicKey(bArr, f38338b))});
        } catch (Exception e) {
            LogUtil.log("FileEncryption -> getEncryptString failed.", e);
            return "";
        }
    }

    public byte[] makeKey() throws NoSuchAlgorithmException {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        instance.init(128);
        byte[] encoded = instance.generateKey().getEncoded();
        this.f38340d = new SecretKeySpec(encoded, "AES");
        this.f38341e = new IvParameterSpec(m28901a());
        return encoded;
    }

    /* renamed from: a */
    private byte[] m28901a() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    public void encrypt(File file, File file2) throws IOException, InvalidKeyException, InvalidAlgorithmParameterException {
        CipherOutputStream cipherOutputStream;
        this.f38339c.init(1, this.f38340d, this.f38341e);
        FileInputStream fileInputStream = null;
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                fileOutputStream.write(this.f38341e.getIV());
                cipherOutputStream = new CipherOutputStream(fileOutputStream, this.f38339c);
                try {
                    m28900a(fileInputStream2, cipherOutputStream);
                    fileInputStream2.close();
                    cipherOutputStream.close();
                    m28899a(fileInputStream2);
                    m28899a(cipherOutputStream);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    m28899a(fileInputStream);
                    m28899a(cipherOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cipherOutputStream = null;
                fileInputStream = fileInputStream2;
                m28899a(fileInputStream);
                m28899a(cipherOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            cipherOutputStream = null;
            m28899a(fileInputStream);
            m28899a(cipherOutputStream);
            throw th;
        }
    }

    public void decrypt(File file, File file2) throws IOException, InvalidKeyException, InvalidAlgorithmParameterException {
        FileOutputStream fileOutputStream;
        CipherInputStream cipherInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[this.f38339c.getBlockSize()];
            fileInputStream.read(bArr);
            this.f38339c.init(2, this.f38340d, new IvParameterSpec(bArr));
            CipherInputStream cipherInputStream2 = new CipherInputStream(fileInputStream, this.f38339c);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    m28900a(cipherInputStream2, fileOutputStream);
                    cipherInputStream2.close();
                    fileOutputStream.close();
                    m28899a(cipherInputStream2);
                    m28899a(fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    cipherInputStream = cipherInputStream2;
                    m28899a(cipherInputStream);
                    m28899a(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                cipherInputStream = cipherInputStream2;
                m28899a(cipherInputStream);
                m28899a(fileOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            m28899a(cipherInputStream);
            m28899a(fileOutputStream);
            throw th;
        }
    }

    /* renamed from: a */
    private void m28899a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    private void m28900a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
