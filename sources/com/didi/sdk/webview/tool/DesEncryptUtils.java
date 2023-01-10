package com.didi.sdk.webview.tool;

import com.didi.sdk.util.Base64;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DesEncryptUtils {
    /* renamed from: a */
    private static Key m30947a(String str) throws Exception {
        return SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes()));
    }

    public static String encode(String str, String str2) {
        if (str2 == null) {
            return "";
        }
        try {
            return Base64.encode(m30948a(str, str2.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static byte[] m30948a(String str, byte[] bArr) {
        try {
            Cipher instance = Cipher.getInstance("DES");
            instance.init(1, m30947a(str));
            return instance.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decode(String str, String str2) {
        try {
            return new String(m30949b(str, Base64.decode(str2)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private static byte[] m30949b(String str, byte[] bArr) {
        try {
            Cipher instance = Cipher.getInstance("DES");
            instance.init(2, m30947a(str));
            return instance.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
