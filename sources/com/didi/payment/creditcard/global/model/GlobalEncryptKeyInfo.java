package com.didi.payment.creditcard.global.model;

import android.text.TextUtils;
import com.didi.payment.creditcard.base.encryption.LianLianEncryptUtils;

public class GlobalEncryptKeyInfo {

    /* renamed from: a */
    private static final String f32832a = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDfmZqFs+AVF1XW9XF5ixvcPx4cUP3uY7NYWyPKCpR/58fC5trPyBKigXjpPZxsEMm0LLBmr+JKBxJvIz6i5YCRhGWKDmUXDbYKiO6J92sEOsxYi6/JfHDglIDJwErJhpCI+FeXrHVwCZRF0V3VlI1WR5Jm/6+Jsdkfn4Lc+tJ1FwIDAQAB";

    /* renamed from: b */
    private String f32833b;

    public String getRSAPublicKey() {
        return f32832a;
    }

    public String getAESKey() {
        if (TextUtils.isEmpty(this.f32833b)) {
            this.f32833b = LianLianEncryptUtils.getRandomAESKey();
        }
        return this.f32833b;
    }

    public String encryptWithRSA(String str, String str2) {
        return LianLianEncryptUtils.encryptWithRSA(str, str2);
    }

    public String decryptWithRSA(String str, String str2) {
        return LianLianEncryptUtils.decryptWithRSA(str, str2);
    }
}
