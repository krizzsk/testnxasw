package com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj;

public final class kkkkhh extends hhkkkh {
    private static final int b00740074t00740074t = 1;
    private static final int b0074t007400740074t = 127;
    public static int b00780078xxxx = 80;
    public static int b0078x0078xxx = 1;
    private static final int btt007400740074t = 128;
    public static int bx00780078xxx = 2;
    public static int bxx0078xxx;

    public static int b007800780078xxx() {
        return 34;
    }

    public static int bxxx0078xx() {
        return 2;
    }

    public int b006A006A006Aj006A006A(int i) {
        try {
            int i2 = i % 127;
            if (i2 < 0) {
                int i3 = b00780078xxxx;
                if ((i3 * (b0078x0078xxx + i3)) % bx00780078xxx != 0) {
                    try {
                        b00780078xxxx = 92;
                        bxx0078xxx = b007800780078xxx();
                    } catch (Exception e) {
                        throw e;
                    }
                }
                i2 += 127;
                int i4 = b00780078xxxx;
                if ((i4 * (b0078x0078xxx + i4)) % bx00780078xxx != 0) {
                    b00780078xxxx = 84;
                    bxx0078xxx = 10;
                }
            }
            return i2 + 1;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public int b006Aj006Aj006A006A(int i) {
        try {
            int i2 = b00780078xxxx;
            if ((i2 * (b0078x0078xxx + i2)) % bx00780078xxx != 0) {
                try {
                    b00780078xxxx = b007800780078xxx();
                    bxx0078xxx = 71;
                } catch (Exception e) {
                    throw e;
                }
            }
            return i - 1;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public boolean bj006A006Aj006A006A(int i) {
        int i2 = b00780078xxxx;
        int bxxx0078xx = ((b0078x0078xxx + i2) * i2) % bxxx0078xx();
        int i3 = bxx0078xxx;
        if (bxxx0078xx != i3) {
            int i4 = b00780078xxxx;
            if (((b0078x0078xxx + i4) * i4) % bx00780078xxx != i3) {
                b00780078xxxx = 57;
                bxx0078xxx = 87;
            }
            b00780078xxxx = b007800780078xxx();
            bxx0078xxx = 66;
        }
        return i >= 1 && i < 128;
    }

    public int bjjj006A006A006A() {
        int i = b00780078xxxx;
        if (((b0078x0078xxx + i) * i) % bx00780078xxx != bxx0078xxx) {
            b00780078xxxx = 48;
            bxx0078xxx = 0;
        }
        try {
            if (((b00780078xxxx + b0078x0078xxx) * b00780078xxxx) % bx00780078xxx != bxx0078xxx) {
                try {
                    b00780078xxxx = b007800780078xxx();
                    bxx0078xxx = b007800780078xxx();
                } catch (Exception e) {
                    throw e;
                }
            }
            return 127;
        } catch (Exception e2) {
            throw e2;
        }
    }
}
