package com.threatmetrix.TrustDefender.nlunsxbsempjyxm;

public final class vwvvwv extends wwwwvv {
    private static final int b006E006En006En006En = 127;
    private static final int b006Enn006En006En = 1;
    private static final int bn006En006En006En = 128;

    public boolean b006En006E006E006E006En(int i) {
        return i >= 1 && i < 128;
    }

    public int b006Enn006E006E006En(int i) {
        return i - 1;
    }

    public int bn006En006E006E006En(int i) {
        int i2 = i % 127;
        if (i2 < 0) {
            i2 += 127;
        }
        return i2 + 1;
    }

    public int bnn006E006E006E006En() {
        return 127;
    }
}
