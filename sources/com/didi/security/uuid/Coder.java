package com.didi.security.uuid;

public class Coder {

    /* renamed from: a */
    private static char[] f41236a = "ABCDEF0123456789".toCharArray();

    /* renamed from: a */
    private static int m30968a(byte b) {
        int i = 0;
        while (true) {
            char[] cArr = f41236a;
            if (i >= cArr.length) {
                return 0;
            }
            if (b == cArr[i]) {
                return i;
            }
            i++;
        }
    }

    /* renamed from: a */
    private static byte[] m30969a(String str) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            byte b = bytes[i];
            byte b2 = bytes[i + 1];
            bArr[i / 2] = (byte) (((m30968a(b) & 15) << 4) | (m30968a(b2) & 15));
        }
        return bArr;
    }

    public static String decode(String str) {
        if (str == null) {
            return null;
        }
        byte[] a = m30969a(str);
        byte[] bArr = new byte[a.length];
        for (int i = 0; i < a.length; i++) {
            bArr[i] = a[(a.length - 1) - i];
        }
        return new String(bArr);
    }
}
