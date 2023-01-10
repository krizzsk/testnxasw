package com.didi.payment.creditcard.base.encryption;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* renamed from: com.didi.payment.creditcard.base.encryption.g */
/* compiled from: RSA */
class C11429g {

    /* renamed from: a */
    private static int f32758a = 1024;

    C11429g() {
    }

    /* renamed from: a */
    public static Map<String, String> m24865a() throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
        instance.initialize(f32758a, secureRandom);
        KeyPair generateKeyPair = instance.generateKeyPair();
        String str = new String(C11424b.m24811b(generateKeyPair.getPublic().getEncoded()), "UTF-8");
        String str2 = new String(C11424b.m24811b(generateKeyPair.getPrivate().getEncoded()), "UTF-8");
        HashMap hashMap = new HashMap();
        hashMap.put("publicKey", str);
        hashMap.put("privateKey", str2);
        hashMap.put("modulus", new String(C11424b.m24811b(((RSAPublicKey) generateKeyPair.getPublic()).getModulus().toByteArray())));
        return hashMap;
    }

    /* renamed from: a */
    public static String m24863a(String str, String str2) throws Exception {
        PublicKey a = m24864a(str2);
        Cipher instance = Cipher.getInstance(C11426d.f32755c);
        instance.init(1, a);
        return new String(C11424b.m24811b(instance.doFinal(str.getBytes())), "UTF-8");
    }

    /* renamed from: b */
    public static String m24867b(String str, String str2) throws Exception {
        PrivateKey b = m24868b(str2);
        Cipher instance = Cipher.getInstance(C11426d.f32755c);
        instance.init(2, b);
        return new String(instance.doFinal(C11424b.m24816e(str.getBytes())));
    }

    /* renamed from: a */
    public static PublicKey m24864a(String str) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(C11424b.m24816e(str.getBytes())));
    }

    /* renamed from: b */
    public static PrivateKey m24868b(String str) throws Exception {
        return KeyFactory.getInstance("RSA", BouncyCastleProvider.PROVIDER_NAME).generatePrivate(new PKCS8EncodedKeySpec(C11424b.m24816e(str.getBytes())));
    }

    /* renamed from: c */
    public static String m24869c(String str, String str2) {
        try {
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(C11424b.m24816e(str2.getBytes())));
            Signature instance = Signature.getInstance("SHA1WithRSA");
            instance.initSign(generatePrivate);
            instance.update(str.getBytes("UTF-8"));
            return new String(C11424b.m24811b(instance.sign()));
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: d */
    public static String m24870d(String str, String str2) {
        try {
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(C11424b.m24816e(str2.getBytes())));
            Signature instance = Signature.getInstance("SHA256WithRSA");
            instance.initSign(generatePrivate);
            instance.update(str.getBytes("UTF-8"));
            return new String(C11424b.m24811b(instance.sign()));
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m24866a(String str, String str2, String str3) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(C11424b.m24813c(str3)));
            Signature instance = Signature.getInstance("SHA1WithRSA");
            instance.initVerify(generatePublic);
            instance.update(str.getBytes("utf-8"));
            return instance.verify(C11424b.m24813c(str2));
        } catch (Exception unused) {
            return false;
        }
    }
}
