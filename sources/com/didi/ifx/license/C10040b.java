package com.didi.ifx.license;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.Base64;
import java.security.MessageDigest;
import java.util.Locale;

/* renamed from: com.didi.ifx.license.b */
/* compiled from: DeviceIdUtil */
class C10040b {
    C10040b() {
    }

    /* renamed from: a */
    static String m21124a(Context context) {
        String a;
        StringBuilder sb = new StringBuilder();
        String b = m21128b(context);
        String a2 = m21123a();
        String b2 = m21127b();
        if (b != null && b.length() > 0) {
            sb.append(b);
            sb.append("|");
        }
        if (a2 != null && a2.length() > 0) {
            sb.append(a2);
            sb.append("|");
        }
        if (b2 != null && b2.length() > 0) {
            sb.append(b2);
        }
        if (sb.length() <= 0 || (a = m21125a(m21126a(sb.toString()))) == null || a.length() <= 0) {
            return null;
        }
        return a;
    }

    /* renamed from: b */
    private static String m21128b(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: b */
    private static String m21127b() {
        try {
            return Base64.encodeToString(("3883756" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.DEVICE.length() % 10) + (Build.HARDWARE.length() % 10) + (Build.ID.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.SERIAL.length() % 10)).getBytes(), 0);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    private static byte[] m21126a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            instance.reset();
            instance.update(str.getBytes("UTF-8"));
            return instance.digest();
        } catch (Exception unused) {
            return "".getBytes();
        }
    }

    /* renamed from: a */
    private static String m21125a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
        }
        return sb.toString().toUpperCase(Locale.CHINA);
    }

    /* renamed from: a */
    private static String m21123a() {
        try {
            return Build.SERIAL;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
