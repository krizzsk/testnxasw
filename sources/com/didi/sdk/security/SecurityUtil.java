package com.didi.sdk.security;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.didi.sdk.net.HttpParamUtils;
import com.didi.sdk.util.MD5;
import com.didi.sdk.util.SUUIDHelper;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.TextUtil;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class SecurityUtil {

    /* renamed from: a */
    private static final String f39870a = "didiwuxiankejiyouxian2013";

    /* renamed from: b */
    private static final String f39871b = "__x_";

    /* renamed from: c */
    private static String f39872c = "";

    /* renamed from: d */
    private static String f39873d;

    /* renamed from: e */
    private static Context f39874e;

    public static String getSUSIGN() {
        return "";
    }

    public static void init(Context context) {
        f39874e = context;
    }

    public static String getDeviceId() {
        if (TextUtil.isEmpty(f39872c)) {
            try {
                f39872c = SecurityLib.getDeviceId(f39874e);
            } catch (Throwable unused) {
            }
        }
        return f39872c;
    }

    public static String getAndroidID() {
        return Settings.Secure.getString(f39874e.getContentResolver(), "android_id");
    }

    public static String getUUID() {
        if (!TextUtils.isEmpty(f39873d)) {
            return f39873d;
        }
        String androidID = getAndroidID();
        String cPUSerialno = SystemUtil.getCPUSerialno();
        String md5 = MD5.toMD5("1_" + androidID + "2_" + SystemUtil.getIMEI() + "3_" + cPUSerialno);
        f39873d = md5;
        return md5;
    }

    public static String getSUUID() {
        return SUUIDHelper.getDiDiSUUID();
    }

    /* renamed from: a */
    private static String m30002a(String str) throws NoSuchAlgorithmException {
        if (str == null || str.length() == 0) {
            return "";
        }
        MessageDigest instance = MessageDigest.getInstance("SHA-1");
        instance.update(str.getBytes());
        return m30003a(instance.digest());
    }

    /* renamed from: a */
    private static String m30003a(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                str = str + "0" + hexString;
            } else {
                str = str + hexString;
            }
        }
        return str;
    }

    public static String generateSignature(Map<String, Object> map) {
        try {
            return m30002a(HttpParamUtils.getSortedParamsString(map));
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static String generateSignature(Map<String, Object> map, String str) {
        try {
            return m30002a(HttpParamUtils.getSortedParamsTrimValue(map, str));
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
