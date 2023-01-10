package com.didi.sdk.security;

import android.util.Base64;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.google.common.base.Ascii;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AESCrypt {
    public static boolean DEBUG_LOG_ENABLED = false;

    /* renamed from: a */
    private static final String f39865a = "AESCrypt";

    /* renamed from: b */
    private static final String f39866b = "AES/CBC/PKCS7Padding";

    /* renamed from: c */
    private static final String f39867c = "UTF-8";

    /* renamed from: d */
    private static final String f39868d = "SHA-256";

    /* renamed from: e */
    private static final byte[] f39869e = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: a */
    private static SecretKeySpec m29999a(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes("UTF-8");
        instance.update(bytes, 0, bytes.length);
        byte[] digest = instance.digest();
        m30001a("SHA-256 key ", digest);
        return new SecretKeySpec(digest, "AES");
    }

    public static String encrypt(String str, String str2) throws GeneralSecurityException {
        try {
            return Base64.encodeToString(encrypt(new SecretKeySpec(Base64.decode(str, 0), "AES"), f39869e, str2.getBytes("UTF-8")), 2);
        } catch (UnsupportedEncodingException e) {
            if (DEBUG_LOG_ENABLED) {
                SystemUtils.log(6, f39865a, "UnsupportedEncodingException ", e, "com.didi.sdk.security.AESCrypt", 78);
            }
            throw new GeneralSecurityException(e);
        }
    }

    public static byte[] encrypt(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher instance = Cipher.getInstance(f39866b);
        instance.init(1, secretKeySpec, new IvParameterSpec(bArr));
        byte[] doFinal = instance.doFinal(bArr2);
        m30001a("cipherText", doFinal);
        return doFinal;
    }

    public static String decrypt(String str, String str2) throws GeneralSecurityException {
        try {
            SecretKeySpec a = m29999a(str);
            m30000a("base64EncodedCipherText", str2);
            byte[] decode = Base64.decode(str2, 2);
            m30001a("decodedCipherText", decode);
            byte[] decrypt = decrypt(a, f39869e, decode);
            m30001a("decryptedBytes", decrypt);
            String str3 = new String(decrypt, "UTF-8");
            m30000a("message", str3);
            return str3;
        } catch (UnsupportedEncodingException e) {
            if (DEBUG_LOG_ENABLED) {
                SystemUtils.log(6, f39865a, "UnsupportedEncodingException ", e, "com.didi.sdk.security.AESCrypt", 134);
            }
            throw new GeneralSecurityException(e);
        }
    }

    public static byte[] decrypt(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher instance = Cipher.getInstance(f39866b);
        instance.init(2, secretKeySpec, new IvParameterSpec(bArr));
        byte[] doFinal = instance.doFinal(bArr2);
        m30001a("decryptedBytes", doFinal);
        return doFinal;
    }

    /* renamed from: a */
    private static void m30001a(String str, byte[] bArr) {
        if (DEBUG_LOG_ENABLED) {
            SystemUtils.log(3, f39865a, str + Const.jaLeft + bArr.length + "] [" + m29998a(bArr) + Const.jaRight, (Throwable) null, "com.didi.sdk.security.AESCrypt", 165);
        }
    }

    /* renamed from: a */
    private static void m30000a(String str, String str2) {
        if (DEBUG_LOG_ENABLED) {
            SystemUtils.log(3, f39865a, str + Const.jaLeft + str2.length() + "] [" + str2 + Const.jaRight, (Throwable) null, "com.didi.sdk.security.AESCrypt", 170);
        }
    }

    /* renamed from: a */
    private static String m29998a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i] & 255;
            int i2 = i * 2;
            cArr2[i2] = cArr[b >>> 4];
            cArr2[i2 + 1] = cArr[b & Ascii.f55148SI];
        }
        return new String(cArr2);
    }

    private AESCrypt() {
    }
}
