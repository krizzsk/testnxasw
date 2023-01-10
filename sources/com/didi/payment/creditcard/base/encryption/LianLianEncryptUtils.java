package com.didi.payment.creditcard.base.encryption;

import android.text.TextUtils;
import com.didi.sdk.util.MD5;

public class LianLianEncryptUtils {
    public static String encryptWithAES(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : C11423a.m24795a(str, str2);
    }

    public static String decryptWithAES(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : C11423a.m24799b(str, str2);
    }

    public static String encryptWithRSA(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return C11429g.m24863a(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String decryptWithRSA(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return C11429g.m24867b(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getRandomAESKey() {
        return C11430h.m24871a(16);
    }

    public static String MD5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return MD5.toMD5(str);
    }
}
