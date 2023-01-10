package com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj;

public final class hhkhkh extends hhkkkh {
    private static final int b00740074t0074t0074 = 1048576;
    private static final int b0074tt0074t0074 = 65536;
    public static int b00780078007800780078x = 1;
    public static int b00780078xxx0078 = 0;
    private static final int bt0074t0074t0074 = 1114112;
    public static int bx0078007800780078x = 18;
    public static int bxxxxx0078 = 2;

    public static int b0078xxxx0078() {
        return 2;
    }

    public static int bx0078xxx0078() {
        return 59;
    }

    public static int bxx0078xx0078() {
        return 0;
    }

    public int b006A006A006Aj006A006A(int i) {
        try {
            int i2 = i % 1048576;
            try {
                if (((bx0078007800780078x + b00780078007800780078x) * bx0078007800780078x) % bxxxxx0078 != bxx0078xx0078()) {
                    bx0078007800780078x = bx0078xxx0078();
                    b00780078xxx0078 = bx0078xxx0078();
                }
                if (i2 < 0) {
                    int i3 = bx0078007800780078x;
                    if (((b00780078007800780078x + i3) * i3) % bxxxxx0078 != b00780078xxx0078) {
                        bx0078007800780078x = 81;
                        b00780078xxx0078 = 21;
                    }
                    i2 += 1048576;
                }
                return i2 + 65536;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public int b006Aj006Aj006A006A(int i) {
        int i2 = bx0078007800780078x;
        if (((b00780078007800780078x + i2) * i2) % b0078xxxx0078() != b00780078xxx0078) {
            bx0078007800780078x = bx0078xxx0078();
            b00780078xxx0078 = 83;
        }
        return i - 65536;
    }

    public boolean bj006A006Aj006A006A(int i) {
        boolean z = false;
        if (i < 65536) {
            return false;
        }
        if (i < 1114112) {
            z = true;
            if (((bx0078xxx0078() + b00780078007800780078x) * bx0078xxx0078()) % bxxxxx0078 != bxx0078xx0078()) {
                bx0078007800780078x = 56;
                int bx0078xxx0078 = bx0078xxx0078();
                b00780078xxx0078 = bx0078xxx0078;
                int i2 = bx0078007800780078x;
                if (((b00780078007800780078x + i2) * i2) % bxxxxx0078 != bx0078xxx0078) {
                    bx0078007800780078x = 43;
                    b00780078xxx0078 = bx0078xxx0078();
                }
            }
        }
        return z;
    }

    public int bjjj006A006A006A() {
        int i = bx0078007800780078x;
        if ((i * (b00780078007800780078x + i)) % bxxxxx0078 != 0) {
            bx0078007800780078x = 34;
            b00780078007800780078x = 69;
        }
        return 1048576;
    }
}
