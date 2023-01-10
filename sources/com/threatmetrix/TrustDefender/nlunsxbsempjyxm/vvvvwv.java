package com.threatmetrix.TrustDefender.nlunsxbsempjyxm;

public final class vvvvwv extends wwwwvv {
    private static final int b006E006Ennn006En = 127;
    private static final int b006En006Enn006En = 1921;
    private static final int bnn006Enn006En = 2048;

    public boolean b006En006E006E006E006En(int i) {
        if (i >= 0) {
            return (i <= 0 || i >= 128) && i < 2048;
        }
        return false;
    }

    public int b006Enn006E006E006En(int i) {
        if (i == 0) {
            return 0;
        }
        return i - 127;
    }

    public int bn006En006E006E006En(int i) {
        int i2 = i % 1921;
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            i2 += 1921;
        }
        return i2 + 127;
    }

    public int bnn006E006E006E006En() {
        return 1921;
    }
}
