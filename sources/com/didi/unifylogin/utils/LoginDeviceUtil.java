package com.didi.unifylogin.utils;

import com.didi.sdk.util.SystemUtil;
import com.google.common.base.Ascii;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class LoginDeviceUtil {

    /* renamed from: a */
    private static volatile String f47584a;

    /* renamed from: a */
    private static final char m35701a(int i) {
        return (char) (i < 10 ? i + 48 : (i + 65) - 10);
    }

    public static String getIMEI() {
        return SystemUtil.getIMEI() + m35702a();
    }

    /* renamed from: a */
    private static final String m35702a() {
        String str;
        if (f47584a != null) {
            return f47584a;
        }
        try {
            char[] a = m35703a(Long.valueOf(new File("/system/build.prop").lastModified()).toString());
            if (a == null) {
                str = "";
            } else {
                str = new String(a);
            }
            f47584a = str;
        } catch (Exception unused) {
            f47584a = "";
        }
        return f47584a;
    }

    /* renamed from: a */
    private static final char[] m35703a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            int length = digest.length << 1;
            char[] cArr = new char[length];
            byte b = 0;
            for (int i = 0; i < length; i += 2) {
                byte b2 = digest[b] & 255;
                b = (byte) (b + 1);
                if (b2 < 16) {
                    cArr[i] = '0';
                    cArr[i + 1] = m35701a((int) b2);
                } else {
                    cArr[i] = m35701a(b2 >> 4);
                    cArr[i + 1] = m35701a((int) b2 & Ascii.f55148SI);
                }
            }
            return cArr;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
