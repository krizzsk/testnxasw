package com.threatmetrix.TrustDefender.nlunsxbsempjyxm;

public final class wwvvwv extends wwwwvv {
    private static final int b006En006E006En006En = 65536;
    private static final int bn006E006E006En006En = 63488;
    private static final int bnn006E006En006En = 2048;

    private static int bn006E006E006E006E006En(int i, int i2) {
        int i3 = i % i2;
        return i3 < 0 ? i3 + i2 : i3;
    }

    public boolean b006En006E006E006E006En(int i) {
        return i >= 2048 && i < 65536;
    }

    public int b006Enn006E006E006En(int i) {
        return i - 2048;
    }

    public int bn006En006E006E006En(int i) {
        return bn006E006E006E006E006En(i, bn006E006E006En006En) + 2048;
    }

    public int bnn006E006E006E006En() {
        return bn006E006E006En006En;
    }
}
