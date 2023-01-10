package com.iproov.sdk.core;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.iproov.sdk.core.a */
/* compiled from: AES256 */
class C20780a {
    /* renamed from: a */
    static byte[] m43058a(String str, byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        int i = 24;
        if (bArr2.length >= 32) {
            i = 32;
        } else if (bArr2.length < 24) {
            i = 16;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, 0, i, C20786catch.m43246s());
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        Cipher instance = Cipher.getInstance(C20786catch.m43247t());
        instance.init(1, secretKeySpec, ivParameterSpec);
        return instance.doFinal(str.getBytes(StandardCharsets.UTF_8));
    }
}
