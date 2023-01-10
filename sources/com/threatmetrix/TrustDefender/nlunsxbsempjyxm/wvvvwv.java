package com.threatmetrix.TrustDefender.nlunsxbsempjyxm;

public final class wvvvwv extends wwwwvv {
    private static final int b006E006E006Enn006En = 1114112;
    private static final int bn006E006Enn006En = 65536;
    private static final int bnnn006En006En = 1048576;

    public boolean b006En006E006E006E006En(int i) {
        return i >= 65536 && i < 1114112;
    }

    public int b006Enn006E006E006En(int i) {
        return i - 65536;
    }

    public int bn006En006E006E006En(int i) {
        int i2 = i % 1048576;
        if (i2 < 0) {
            i2 += 1048576;
        }
        return i2 + 65536;
    }

    public int bnn006E006E006E006En() {
        return 1048576;
    }
}
