package com.didi.payment.utilities;

import android.text.TextUtils;

public class CsBoletoCheckUtil {
    public static final int BARCODE_MIN_LENGTH = 44;
    public static final int BARCODE_MIN_LENGTH_OLD = 40;
    public static final int BOLETO_ERROR_CONTENT = 2;
    public static final int BOLETO_ERROR_LENGTH = 1;
    public static final int BOLETO_ERROR_NO_FOUND = 0;
    public static final int MEXICO_MIN_LENGTH = 7;

    /* renamed from: a */
    private static final int f34066a = 1001;

    /* renamed from: b */
    private static final int f34067b = 1002;

    /* renamed from: c */
    private static final int f34068c = 1003;

    /* renamed from: d */
    private static final int f34069d = 2001;

    /* renamed from: e */
    private static final int f34070e = 2002;

    /* renamed from: f */
    private static final int f34071f = 2003;

    /* renamed from: g */
    private static final int f34072g = 2004;

    /* renamed from: h */
    private static final int f34073h = 2005;

    /* renamed from: i */
    private static final int f34074i = 2006;

    /* renamed from: j */
    private static final int f34075j = 2007;

    /* renamed from: k */
    private static final int f34076k = 2008;

    /* renamed from: l */
    private static final int f34077l = 2009;

    /* renamed from: m */
    private static final int f34078m = 47;

    /* renamed from: n */
    private static final int f34079n = 48;

    public static boolean checkMexicoLength(String str) {
        return str != null && str.length() >= 7;
    }

    public static boolean checkBoletoTypableLength(String str) {
        return str != null && str.length() >= 47 && str.length() <= 48;
    }

    public static boolean checkBoletoBarcodeLength(String str) {
        return str != null && str.length() >= 44;
    }

    public static boolean checkBoletoLength(String str) {
        return str != null && str.length() >= 40;
    }

    public static int validBoletoCode(String str) {
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        int a = m25945a(str);
        if (str.length() == 36) {
            str = str + "00000000000";
        } else if (str.length() == 46) {
            str = str + '0';
        }
        if (str.length() != 44 && str.length() != 47 && str.length() != 48) {
            return 1;
        }
        if ((!"8".equals(str.substring(0, 1)) || str.length() != 47) && m25947a(str, a)) {
            return 0;
        }
        return 2;
    }

    /* renamed from: a */
    private static boolean m25947a(String str, int i) {
        String str2;
        String str3;
        String str4;
        String str5 = "";
        if (i == 1002) {
            int b = m25948b(str);
            if (b == 2009 || b == 2001) {
                str5 = (str.substring(0, 9) + m25950d(str.substring(0, 9))) + (str.substring(10, 20) + m25950d(str.substring(10, 20))) + (str.substring(21, 31) + m25950d(str.substring(21, 31))) + str.substring(32, 33) + str.substring(33);
            } else {
                int c = m25949c(str);
                if (c == 10) {
                    str5 = str.substring(0, 11) + m25950d(str.substring(0, 11));
                    str4 = str.substring(12, 23) + m25950d(str.substring(12, 23));
                    str3 = str.substring(24, 35) + m25950d(str.substring(24, 35));
                    str2 = str.substring(36, 47) + m25950d(str.substring(36, 47));
                } else if (c == 11) {
                    String substring = str.substring(0, 11);
                    String substring2 = str.substring(12, 23);
                    String substring3 = str.substring(24, 35);
                    String substring4 = str.substring(36, 47);
                    int parseInt = Integer.parseInt(String.valueOf(str.charAt(11)));
                    int parseInt2 = Integer.parseInt(String.valueOf(str.charAt(23)));
                    int parseInt3 = Integer.parseInt(String.valueOf(str.charAt(35)));
                    int parseInt4 = Integer.parseInt(String.valueOf(str.charAt(47)));
                    if (m25951e(substring) == parseInt && m25951e(substring2) == parseInt2 && m25951e(substring3) == parseInt3 && m25951e(substring4) == parseInt4) {
                        return true;
                    }
                    return false;
                } else {
                    str4 = str5;
                    str3 = str4;
                    str2 = str3;
                }
                str5 = str5 + str4 + str3 + str2;
            }
        }
        if (i == 1001) {
            int b2 = m25948b(str);
            if (b2 == 2009 || b2 == 2001) {
                str5 = str.substring(0, 4) + m25946a(str, 4, 11) + str.substring(5);
            } else {
                int c2 = m25949c(str);
                StringBuilder sb = new StringBuilder(str);
                sb.deleteCharAt(3);
                String sb2 = sb.toString();
                str5 = sb2.substring(0, 3) + m25946a(str, 3, c2) + sb2.substring(3);
            }
        }
        return TextUtils.equals(str, str5);
    }

    /* renamed from: a */
    private static int m25945a(String str) {
        if (str.length() == 44) {
            return 1001;
        }
        return (str.length() == 46 || str.length() == 47 || str.length() == 48) ? 1002 : 1003;
    }

    /* renamed from: b */
    private static int m25948b(String str) {
        if (str.endsWith("00000000000000") || "00000000000000".equals(str.substring(5, 19))) {
            return 2001;
        }
        if (str.charAt(0) != '8') {
            return 2009;
        }
        if (str.charAt(1) == '1') {
            return 2002;
        }
        if (str.charAt(1) == '2') {
            return 2005;
        }
        if (str.charAt(1) == '3') {
            return 2006;
        }
        if (str.charAt(1) == '4') {
            return 2007;
        }
        if (str.charAt(1) == '5') {
            return 2003;
        }
        if (str.charAt(1) == '6' || str.charAt(1) == '9') {
            return 2008;
        }
        return str.charAt(1) == '7' ? 2004 : 2009;
    }

    /* renamed from: c */
    private static int m25949c(String str) {
        switch (str.charAt(2)) {
            case '6':
            case '7':
                return 10;
            case '8':
            case '9':
                return 11;
            default:
                return 0;
        }
    }

    /* renamed from: d */
    private static int m25950d(String str) {
        String str2 = "";
        int i = 2;
        for (int length = str.length() - 1; length >= 0; length--) {
            str2 = (Integer.parseInt(String.valueOf(str.charAt(length))) * i) + str2;
            i--;
            if (i < 1) {
                i = 2;
            }
        }
        int i2 = 0;
        for (int i3 = 0; i3 < str2.length(); i3++) {
            i2 += Integer.parseInt(String.valueOf(str2.charAt(i3)));
        }
        int i4 = i2 % 10;
        return i4 != 0 ? 10 - i4 : i4;
    }

    /* renamed from: e */
    private static int m25951e(String str) {
        int[] iArr = {4, 3, 2, 9, 8, 7, 6, 5};
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            int i4 = iArr[i2];
            i2 = (i2 + 1) % 8;
            i += i4 * Integer.parseInt(String.valueOf(str.charAt(i3)));
        }
        int i5 = i % 11;
        if (i5 == 0 || i5 == 1) {
            return 0;
        }
        if (i5 == 10) {
            return 1;
        }
        return 11 - i5;
    }

    /* renamed from: a */
    private static int m25946a(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(str);
        sb.deleteCharAt(i);
        String sb2 = sb.toString();
        if (i2 == 10) {
            return m25950d(sb2);
        }
        if (i2 == 11) {
            return m25951e(sb2);
        }
        return 0;
    }
}
