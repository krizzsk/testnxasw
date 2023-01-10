package com.threatmetrix.TrustDefender.fcuqtqpahmoqinu;

public final class gggghg extends hhhhgg {
    private static final int b006700670067g00670067 = 2048;
    private static final int bg00670067g00670067 = 127;
    private static final int bggg006700670067 = 1921;

    public int b0068006800680068hh(int i) {
        int i2 = i % 1921;
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            i2 += 1921;
        }
        return i2 + 127;
    }

    public int b0068hhh0068h() {
        return 1921;
    }

    public int bh006800680068hh(int i) {
        if (i == 0) {
            return 0;
        }
        return i - 127;
    }

    public boolean bh0068hh0068h(int i) {
        if (i >= 0) {
            return (i <= 0 || i >= 128) && i < 2048;
        }
        return false;
    }
}
