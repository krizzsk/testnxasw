package com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj;

public class hhkkhh extends hkkkhh {
    public static int b006C006C006Cl006C006C = 1;
    public static int b006Cl006Cl006C006C = 40;
    public static int bl006C006Cl006C006C = 0;
    public static int bl006Cl006C006C006C = 2;

    public static int b006C006Cl006C006C006C() {
        return 91;
    }

    public static int b006Cll006C006C006C() {
        return 1;
    }

    public static int blll006C006C006C() {
        return 2;
    }

    public String b006Ajj006A006A006A(String str, char c) {
        try {
            int length = str.length();
            int i = b006Cl006Cl006C006C;
            if ((i * (b006Cll006C006C006C() + i)) % bl006Cl006C006C006C != 0) {
                b006Cl006Cl006C006C = 34;
                bl006C006Cl006C006C = b006C006Cl006C006C006C();
            }
            int[] iArr = new int[length];
            hkhhkh hkhhkh = new hkhhkh(str);
            int i2 = 0;
            while (hkhhkh.b006A006Aj006A006A006A()) {
                int bjj006A006A006A006A = hkhhkh.bjj006A006A006A006A();
                hhkkkh bq00710071qqq = hhkkkh.bq00710071qqq(bjj006A006A006A006A);
                try {
                    iArr[i2] = bq00710071qqq.b006A006A006Aj006A006A(bq00710071qqq.b006Aj006Aj006A006A(bjj006A006A006A006A) - (c + i2));
                    i2++;
                    if (((b006Cl006Cl006C006C + b006C006C006Cl006C006C) * b006Cl006Cl006C006C) % blll006C006C006C() != bl006C006Cl006C006C) {
                        b006Cl006Cl006C006C = 15;
                        bl006C006Cl006C006C = 15;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
            return new String(iArr, 0, i2);
        } catch (Exception e2) {
            throw e2;
        }
    }
}
