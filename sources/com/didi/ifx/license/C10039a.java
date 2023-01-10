package com.didi.ifx.license;

import android.util.Base64;
import com.google.common.base.Ascii;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

/* renamed from: com.didi.ifx.license.a */
/* compiled from: Common */
class C10039a {

    /* renamed from: a */
    static long f26630a = 777855877777L;

    /* renamed from: b */
    static long f26631b = 65637656371231L;

    /* renamed from: c */
    static int f26632c = 2;

    /* renamed from: d */
    static int f26633d = 67;

    /* renamed from: e */
    static int f26634e = 100;

    /* renamed from: f */
    static String f26635f = "b3b9ca1474334e85a2baf43be1ac3595";

    /* renamed from: g */
    static int f26636g = 96;

    C10039a() {
    }

    /* renamed from: a */
    public static int m21112a(int i, int i2) {
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        while (true) {
            int i3 = abs2;
            int i4 = abs;
            abs = i3;
            if (abs == 0) {
                return i4;
            }
            abs2 = i4 % abs;
        }
    }

    /* renamed from: a */
    static int m21114a(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* renamed from: a */
    static byte[] m21119a(int i) {
        byte[] bArr = new byte[4];
        bArr[3] = (byte) ((i >> 24) & 255);
        bArr[2] = (byte) ((i >> 16) & 255);
        bArr[1] = (byte) ((i >> 8) & 255);
        bArr[0] = (byte) (i & 255);
        return bArr;
    }

    /* renamed from: b */
    static byte[] m21122b(byte[] bArr) {
        return Base64.decode(bArr, 0);
    }

    /* renamed from: a */
    static int m21113a(InputStream inputStream) {
        byte[] bArr = new byte[4];
        inputStream.read(bArr);
        return m21114a(bArr, 0) ^ 35658128;
    }

    /* renamed from: a */
    static int m21111a() {
        return new Random().nextInt();
    }

    /* renamed from: a */
    static String m21116a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new String(bArr);
    }

    /* renamed from: b */
    static String m21121b(String str) {
        return m21115a(str).substring(8, 24);
    }

    /* renamed from: b */
    static String m21120b(int i) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(random.nextInt(62)));
        }
        return sb.toString();
    }

    /* renamed from: a */
    static String m21115a(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                byte b2 = b & 255;
                if (b2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(b2));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("NoSuchAlgorithmException", e);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UnsupportedEncodingException", e2);
        }
    }

    /* renamed from: a */
    private static void m21118a(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    /* renamed from: a */
    static void m21117a(int[] iArr) {
        Random random = new Random();
        for (int length = iArr.length; length > 1; length--) {
            m21118a(iArr, length - 1, random.nextInt(length));
        }
    }
}
