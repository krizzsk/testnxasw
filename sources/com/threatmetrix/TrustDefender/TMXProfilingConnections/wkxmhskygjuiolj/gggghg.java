package com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj;

public final class gggghg extends hhhhgg {
    private static final int b006E006E006Enn006E = 2048;
    private static final int bn006E006Enn006E = 127;
    private static final int bnnn006En006E = 1921;

    public int b0067ggggg() {
        return 1921;
    }

    public int b006En006E006E006E006E(int i) {
        int i2 = i % 1921;
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            i2 += 1921;
        }
        return i2 + 127;
    }

    public boolean bg0067gggg(int i) {
        if (i >= 0) {
            return (i <= 0 || i >= 128) && i < 2048;
        }
        return false;
    }

    public int bnn006E006E006E006E(int i) {
        if (i == 0) {
            return 0;
        }
        return i - 127;
    }
}
