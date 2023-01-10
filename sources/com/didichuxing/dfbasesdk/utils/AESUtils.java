package com.didichuxing.dfbasesdk.utils;

import com.google.common.base.Ascii;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class AESUtils {

    /* renamed from: a */
    private static final String f49347a = "UTF-8";
    public static final String aesPadding = new String(aesXor("SWA=WQP=BYQA'Bsvv{|u".getBytes()));

    public static byte[] aesXor(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) (bArr[i] ^ Ascii.DC2);
        }
        return bArr;
    }

    private AESUtils() {
    }

    public static String aesEncrypt(String str, String str2) throws Exception {
        return Base64Utils.encode(aesEncrypt(str.getBytes("UTF-8"), str2.getBytes("UTF-8")));
    }

    public static byte[] aesEncrypt(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher instance = Cipher.getInstance(aesPadding);
        instance.init(1, new SecretKeySpec(bArr2, "AES"));
        return instance.doFinal(bArr);
    }

    public static String aesDecrypt(String str, String str2) throws Exception {
        return new String(aesDecrypt(Base64Utils.decode(str), str2.getBytes("UTF-8")), "UTF-8");
    }

    public static byte[] aesDecrypt(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher instance = Cipher.getInstance(aesPadding);
        instance.init(2, new SecretKeySpec(bArr2, "AES"));
        return instance.doFinal(bArr);
    }
}
