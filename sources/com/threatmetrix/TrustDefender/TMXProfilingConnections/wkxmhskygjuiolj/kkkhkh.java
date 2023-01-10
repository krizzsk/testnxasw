package com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj;

public class kkkhkh extends hhhkkh {
    public static int b0078x0078x00780078 = 1;
    public static int b0078xxx00780078 = 0;
    public static int bx00780078x00780078 = 2;
    public static int bxx0078x00780078 = 41;

    public static int b00780078xx00780078() {
        return 2;
    }

    public static int bx0078xx00780078() {
        return 1;
    }

    public static int bxxxx00780078() {
        return 88;
    }

    public String bj006Aj006A006A006A(String str, char c, char c2) {
        int[] iArr = new int[str.length()];
        hkhhkh hkhhkh = new hkhhkh(str);
        int i = 0;
        while (hkhhkh.b006A006Aj006A006A006A()) {
            int bjj006A006A006A006A = hkhhkh.bjj006A006A006A006A();
            hhkkkh bq00710071qqq = hhkkkh.bq00710071qqq(bjj006A006A006A006A);
            int b006A006A006Aj006A006A = bq00710071qqq.b006A006A006Aj006A006A(bq00710071qqq.b006Aj006Aj006A006A(bjj006A006A006A006A) + c + i + c2);
            int i2 = bxx0078x00780078;
            if ((i2 * (b0078x0078x00780078 + i2)) % bx00780078x00780078 != 0) {
                bxx0078x00780078 = bxxxx00780078();
                b0078xxx00780078 = bxxxx00780078();
            }
            iArr[i] = b006A006A006Aj006A006A;
            i++;
            if (((bxxxx00780078() + bx0078xx00780078()) * bxxxx00780078()) % b00780078xx00780078() != b0078xxx00780078) {
                b0078xxx00780078 = bxxxx00780078();
            }
        }
        return new String(iArr, 0, i);
    }
}
