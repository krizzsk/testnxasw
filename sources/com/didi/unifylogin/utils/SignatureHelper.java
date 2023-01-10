package com.didi.unifylogin.utils;

import com.google.common.base.Ascii;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class SignatureHelper {
    public static String getParamSig(String str) {
        try {
            return m35710a("didiwuxiankejiyouxian2013q" + str);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    /* renamed from: a */
    private static String m35710a(String str) throws NoSuchAlgorithmException {
        if (str == null || str.length() == 0) {
            return "";
        }
        MessageDigest instance = MessageDigest.getInstance("SHA-1");
        instance.update(str.getBytes());
        return m35711a(instance.digest());
    }

    public static String toMD5(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.reset();
            instance.update(str.getBytes("UTF-8"));
            byte[] digest = instance.digest();
            for (int i = 0; i < digest.length; i++) {
                stringBuffer.append(String.format("%02X", new Object[]{Byte.valueOf(digest[i])}));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static String m35711a(byte[] bArr) {
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

    public static String md5Encode(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bArr);
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer(digest.length * 2);
            for (int i = 0; i < digest.length; i++) {
                stringBuffer.append(Character.forDigit((digest[i] & 240) >> 4, 16));
                stringBuffer.append(Character.forDigit(digest[i] & Ascii.f55148SI, 16));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String encode(String str) {
        if (str != null && !"".equals(str)) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return str;
    }
}
