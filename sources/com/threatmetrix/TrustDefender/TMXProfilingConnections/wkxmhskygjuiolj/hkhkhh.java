package com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj;

public final class hkhkhh extends hhkkkh {
    public static int b006Cl006C006Cl006C = 1;
    private static final int b0074tt00740074t = 2048;
    public static int bl006Cl006Cl006C = 2;
    public static int bll006C006Cl006C = 0;
    public static int blll006Cl006C = 25;
    private static final int bt0074t00740074t = 1921;
    private static final int bttt00740074t = 127;

    public static int b006C006Cl006Cl006C() {
        return 53;
    }

    public static int b006Cll006Cl006C() {
        return 1;
    }

    public static int bl006C006C006Cl006C() {
        return 2;
    }

    public int b006A006A006Aj006A006A(int i) {
        try {
            int i2 = i % 1921;
            int i3 = blll006Cl006C;
            if ((i3 * (b006Cl006C006Cl006C + i3)) % bl006C006C006Cl006C() != 0) {
                blll006Cl006C = b006C006Cl006Cl006C();
                bll006C006Cl006C = b006C006Cl006Cl006C();
            }
            if (i2 == 0) {
                return 0;
            }
            if (i2 < 0) {
                i2 += 1921;
                try {
                    if (((blll006Cl006C + b006Cll006Cl006C()) * blll006Cl006C) % bl006C006C006Cl006C() != bll006C006Cl006C) {
                        blll006Cl006C = 29;
                        bll006C006Cl006C = b006C006Cl006Cl006C();
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
            return i2 + 127;
        } catch (Exception e2) {
            throw e2;
        } catch (Exception e3) {
            throw e3;
        }
    }

    public int b006Aj006Aj006A006A(int i) {
        if (i == 0) {
            int i2 = blll006Cl006C;
            if ((i2 * (b006Cll006Cl006C() + i2)) % bl006Cl006Cl006C == 0) {
                return 0;
            }
            blll006Cl006C = b006C006Cl006Cl006C();
            bll006C006Cl006C = b006C006Cl006Cl006C();
            return 0;
        }
        int i3 = blll006Cl006C;
        if ((i3 * (b006Cl006C006Cl006C + i3)) % bl006Cl006Cl006C != 0) {
            blll006Cl006C = b006C006Cl006Cl006C();
            bll006C006Cl006C = b006C006Cl006Cl006C();
        }
        return i - 127;
    }

    public boolean bj006A006Aj006A006A(int i) {
        boolean z = false;
        if (i >= 0 && ((i <= 0 || i >= 128) && i < 2048)) {
            z = true;
            int i2 = blll006Cl006C;
            if ((i2 * (b006Cl006C006Cl006C + i2)) % bl006Cl006Cl006C != 0) {
                blll006Cl006C = b006C006Cl006Cl006C();
                bll006C006Cl006C = b006C006Cl006Cl006C();
            }
            int i3 = blll006Cl006C;
            if (((b006Cl006C006Cl006C + i3) * i3) % bl006Cl006Cl006C != bll006C006Cl006C) {
                blll006Cl006C = b006C006Cl006Cl006C();
                bll006C006Cl006C = 49;
            }
        }
        return z;
    }

    public int bjjj006A006A006A() {
        int i = blll006Cl006C;
        int b006Cll006Cl006C = i * (b006Cll006Cl006C() + i);
        int i2 = bl006Cl006Cl006C;
        if (b006Cll006Cl006C % i2 == 0) {
            return 1921;
        }
        int i3 = blll006Cl006C;
        if (((b006Cl006C006Cl006C + i3) * i3) % i2 != bll006C006Cl006C) {
            blll006Cl006C = 89;
            bll006C006Cl006C = b006C006Cl006Cl006C();
        }
        blll006Cl006C = b006C006Cl006Cl006C();
        bl006Cl006Cl006C = 83;
        return 1921;
    }
}
