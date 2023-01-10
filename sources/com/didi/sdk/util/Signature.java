package com.didi.sdk.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Signature {

    /* renamed from: a */
    private static final String f40401a = "__x_";

    /* renamed from: b */
    private static final String f40402b = "didiwuxiankejiyouxian2013";

    public static String generateSignature(Map<String, String> map) {
        Object[] array = new ArrayList(map.keySet()).toArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder(f40402b);
        for (Object obj : array) {
            String str = (String) obj;
            if (!str.startsWith("__x_")) {
                sb.append(str);
                sb.append(map.get(str));
            }
        }
        sb.append(f40402b);
        try {
            return m30388a(sb.toString());
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static String generateSignature2(Map<String, Object> map) {
        Object[] array = new ArrayList(map.keySet()).toArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder(f40402b);
        for (Object obj : array) {
            String str = (String) obj;
            if (!str.startsWith("__x_")) {
                String valueOf = String.valueOf(map.get(str));
                sb.append(str);
                sb.append(valueOf);
            }
        }
        sb.append(f40402b);
        try {
            return m30388a(sb.toString());
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    /* renamed from: a */
    private static String m30388a(String str) throws NoSuchAlgorithmException {
        if (str == null || str.length() == 0) {
            return "";
        }
        MessageDigest instance = MessageDigest.getInstance("SHA-1");
        instance.update(str.getBytes());
        return m30389a(instance.digest());
    }

    /* renamed from: a */
    private static String m30389a(byte[] bArr) {
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
