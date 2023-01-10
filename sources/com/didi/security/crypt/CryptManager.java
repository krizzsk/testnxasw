package com.didi.security.crypt;

import android.text.TextUtils;
import android.util.Base64;
import com.didi.security.wireless.SecurityLib;

public class CryptManager {

    /* renamed from: a */
    private String f41231a;

    /* renamed from: b */
    private String f41232b;

    public CryptManager(String str, String str2) {
        this.f41231a = str;
        this.f41232b = str2;
    }

    public String encrypt(String str) {
        byte[] encrypt;
        if (!TextUtils.isEmpty(str) && (encrypt = encrypt(str.getBytes())) != null) {
            return Base64.encodeToString(encrypt, 2);
        }
        return null;
    }

    public byte[] encrypt(byte[] bArr) {
        String str;
        String str2 = this.f41231a;
        if (str2 == null || (str = this.f41232b) == null) {
            return null;
        }
        return SecurityLib.nativeEncrypt(str2, str, bArr);
    }

    public String encrypt2(String str, String str2) {
        byte[] encrypt2;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && (encrypt2 = encrypt2(str.getBytes(), str2.getBytes())) != null) {
            return Base64.encodeToString(encrypt2, 2);
        }
        return null;
    }

    public byte[] encrypt2(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length <= 0 || bArr2 == null || bArr2.length <= 0) {
            return null;
        }
        return SecurityLib.nativeEncrypt2(bArr, bArr2);
    }

    public String decrypt2(String str, String str2) {
        byte[] decrypt2;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (decrypt2 = decrypt2(str.getBytes(), Base64.decode(str2, 2))) == null) {
            return null;
        }
        try {
            return new String(decrypt2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] decrypt2(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length <= 0 || bArr2 == null || bArr2.length <= 0) {
            return null;
        }
        return SecurityLib.nativeDecrypt2(bArr, bArr2);
    }
}
