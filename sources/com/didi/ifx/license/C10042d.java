package com.didi.ifx.license;

import com.facebook.internal.security.OidcSecurityUtil;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/* renamed from: com.didi.ifx.license.d */
/* compiled from: RSAUtils */
class C10042d {
    C10042d() {
    }

    /* renamed from: a */
    static boolean m21131a(byte[] bArr, String str, String str2) {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(C10039a.m21122b(str.replace("-----BEGIN PUBLIC KEY-----\n", "").replace("-----END PUBLIC KEY-----\n", "").getBytes())));
        Signature instance = Signature.getInstance(OidcSecurityUtil.SIGNATURE_ALGORITHM_SHA256);
        instance.initVerify(generatePublic);
        instance.update(bArr);
        return instance.verify(C10039a.m21122b(str2.getBytes()));
    }
}
