package com.didi.unifylogin.utils;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.didi.sdk.util.MD5;
import com.didi.sdk.util.SUUIDHelper;
import com.didi.sdk.util.SystemUtil;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {

    /* renamed from: a */
    private static final String f47599a = "didiwuxiankejiyouxian2013";

    /* renamed from: b */
    private static final String f47600b = "__x_";

    /* renamed from: c */
    private static String f47601c = "";

    /* renamed from: d */
    private static String f47602d;

    public static String getSUSIGN() {
        return "";
    }

    public static String getAndroidID(Context context) {
        return (context == null || context.getContentResolver() == null) ? "" : Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String getUUID(Context context) {
        if (!TextUtils.isEmpty(f47602d)) {
            return f47602d;
        }
        String androidID = getAndroidID(context);
        String cPUSerialno = SystemUtil.getCPUSerialno();
        String md5 = MD5.toMD5("1_" + androidID + "2_" + SystemUtil.getIMEI() + "3_" + cPUSerialno);
        f47602d = md5;
        return md5;
    }

    public static String getSUUID() {
        return SUUIDHelper.getDiDiSUUID();
    }

    /* renamed from: a */
    private static String m35708a(String str) throws NoSuchAlgorithmException {
        if (str == null || str.length() == 0) {
            return "";
        }
        MessageDigest instance = MessageDigest.getInstance("SHA-1");
        instance.update(str.getBytes());
        return m35709a(instance.digest());
    }

    /* renamed from: a */
    private static String m35709a(byte[] bArr) {
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
}
