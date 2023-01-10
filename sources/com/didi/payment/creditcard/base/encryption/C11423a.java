package com.didi.payment.creditcard.base.encryption;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.didi.payment.creditcard.base.encryption.a */
/* compiled from: AES */
class C11423a {
    C11423a() {
    }

    /* renamed from: a */
    public static byte[] m24797a(byte[] bArr, byte[] bArr2) {
        C11425c.m24820a(bArr, "data");
        C11425c.m24820a(bArr2, "key");
        if (bArr2.length == 16) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(new SecretKeySpec(bArr2, "AES").getEncoded(), "AES");
                Cipher instance = Cipher.getInstance(C11426d.f32754b);
                instance.init(1, secretKeySpec);
                return instance.doFinal(bArr);
            } catch (Exception e) {
                throw new RuntimeException("encrypt fail!", e);
            }
        } else {
            throw new RuntimeException("Invalid AES key length (must be 16 bytes)");
        }
    }

    /* renamed from: b */
    public static byte[] m24800b(byte[] bArr, byte[] bArr2) {
        C11425c.m24820a(bArr, "data");
        C11425c.m24820a(bArr2, "key");
        if (bArr2.length == 16) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(new SecretKeySpec(bArr2, "AES").getEncoded(), "AES");
                Cipher instance = Cipher.getInstance(C11426d.f32754b);
                instance.init(2, secretKeySpec);
                return instance.doFinal(bArr);
            } catch (Exception e) {
                throw new RuntimeException("decrypt fail!", e);
            }
        } else {
            throw new RuntimeException("Invalid AES key length (must be 16 bytes)");
        }
    }

    /* renamed from: a */
    public static String m24795a(String str, String str2) {
        try {
            return new String(C11424b.m24819h(m24797a(str.getBytes("UTF-8"), str2.getBytes("UTF-8"))));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("encrypt fail!", e);
        }
    }

    /* renamed from: b */
    public static String m24799b(String str, String str2) {
        try {
            return new String(m24800b(C11424b.m24815d(str.getBytes()), str2.getBytes("UTF-8")), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("decrypt fail!", e);
        }
    }

    /* renamed from: c */
    public static String m24801c(String str, String str2) {
        try {
            return new String(C11424b.m24819h(m24797a(str.getBytes("UTF-8"), C11424b.m24815d(str2.getBytes()))));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("encrypt fail!", e);
        }
    }

    /* renamed from: d */
    public static String m24802d(String str, String str2) {
        try {
            return new String(m24800b(C11424b.m24815d(str.getBytes()), C11424b.m24815d(str2.getBytes())), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("decrypt fail!", e);
        }
    }

    /* renamed from: a */
    public static byte[] m24796a() {
        try {
            KeyGenerator instance = KeyGenerator.getInstance(C11426d.f32754b);
            instance.init(new SecureRandom());
            return instance.generateKey().getEncoded();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(" getAESKey fail!", e);
        }
    }

    /* renamed from: b */
    public static String m24798b() {
        return new String(C11424b.m24819h(m24796a()));
    }
}
