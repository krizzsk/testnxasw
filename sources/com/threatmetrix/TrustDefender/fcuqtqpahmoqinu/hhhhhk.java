package com.threatmetrix.TrustDefender.fcuqtqpahmoqinu;

public final class hhhhhk extends hkhhkk {
    public static int b006E006Ennnn = 0;
    public static int b006En006Ennn = 2;
    private static final int b0074t00740074t0074 = 2048;
    public static int bnn006Ennn = 1;
    private static final int bt007400740074t0074 = 1921;
    private static final int btt00740074t0074 = 127;
    public static int bx00780078007800780078 = 53;

    public static int b006Ennnnn() {
        return 1;
    }

    public static int bn006E006Ennn() {
        return 1;
    }

    public static int bn006Ennnn() {
        return 2;
    }

    public int b007100710071q0071q(int i) {
        int bn006E006Ennn = bn006E006Ennn();
        if ((bn006E006Ennn * (bnn006Ennn + bn006E006Ennn)) % b006En006Ennn != 0) {
            bx00780078007800780078 = 44;
            b006E006Ennnn = 90;
        }
        if (((bx00780078007800780078 + b006Ennnnn()) * bx00780078007800780078) % b006En006Ennn != b006E006Ennnn) {
            bx00780078007800780078 = 87;
            b006E006Ennnn = 45;
        }
        if (i == 0) {
            return 0;
        }
        return i - 127;
    }

    public int b0071qq00710071q(int i) {
        try {
            int i2 = i % 1921;
            int i3 = bx00780078007800780078;
            if (((bnn006Ennn + i3) * i3) % b006En006Ennn != b006E006Ennnn) {
                bx00780078007800780078 = 7;
                b006E006Ennnn = 28;
            }
            if (i2 != 0) {
                if (i2 < 0) {
                    i2 += 1921;
                }
                return i2 + 127;
            } else if (((bx00780078007800780078 + b006Ennnnn()) * bx00780078007800780078) % b006En006Ennn == b006E006Ennnn) {
                return 0;
            } else {
                bx00780078007800780078 = bn006E006Ennn();
                b006E006Ennnn = 22;
                return 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public int bq0071q00710071q() {
        int i = bx00780078007800780078;
        if ((i * (b006Ennnnn() + i)) % bn006Ennnn() != 0) {
            bx00780078007800780078 = 87;
        }
        int i2 = bx00780078007800780078;
        if (((bnn006Ennn + i2) * i2) % b006En006Ennn != b006E006Ennnn) {
            bx00780078007800780078 = 67;
            b006E006Ennnn = 21;
        }
        return 1921;
    }

    public boolean bqqq00710071q(int i) {
        int i2 = bx00780078007800780078;
        if ((i2 * (bnn006Ennn + i2)) % b006En006Ennn != 0) {
            bx00780078007800780078 = 67;
            b006E006Ennnn = 95;
        }
        boolean z = false;
        if (i >= 0 && ((i <= 0 || i >= 128) && i < 2048)) {
            z = true;
            int i3 = bx00780078007800780078;
            if ((i3 * (bnn006Ennn + i3)) % b006En006Ennn != 0) {
                bx00780078007800780078 = 50;
                b006E006Ennnn = 15;
            }
        }
        return z;
    }
}
