package com.threatmetrix.TrustDefender.fcuqtqpahmoqinu;

import kotlin.jvm.internal.CharCompanionObject;

public final class hhhkhk {
    public static int b006Enn006En006E = 63;
    public static final int b007400740074t00740074 = 56320;
    public static final int b0074t0074t00740074 = 55296;
    public static int bn006E006E006En006E = 2;
    public static int bn006En006En006E = 1;
    public static final int bt00740074t00740074 = 56320;
    public static final int bttt007400740074 = 57344;
    private final int b00740074tt00740074;
    private final String bt0074tt00740074;
    private int btt0074t00740074;

    public hhhkhk(String str) {
        this.bt0074tt00740074 = str;
        this.b00740074tt00740074 = str.length();
    }

    public static int b006E006E006E006En006E() {
        return 0;
    }

    public static int b006E006En006En006E() {
        return 2;
    }

    public static int b006En006E006En006E() {
        return 1;
    }

    public static int bnn006E006En006E() {
        return 99;
    }

    public boolean b0071q007100710071q() {
        try {
            if (this.btt0074t00740074 >= this.b00740074tt00740074) {
                return false;
            }
            try {
                if (((b006Enn006En006E + b006En006E006En006E()) * b006Enn006En006E) % bn006E006E006En006E == b006E006E006E006En006E()) {
                    return true;
                }
                b006Enn006En006E = 68;
                bn006En006En006E = bnn006E006En006E();
                int bnn006E006En006E = bnn006E006En006E();
                if ((bnn006E006En006E * (bn006En006En006E + bnn006E006En006E)) % bn006E006E006En006E == 0) {
                    return true;
                }
                b006Enn006En006E = bnn006E006En006E();
                bn006En006En006E = 13;
                return true;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        } catch (Exception e3) {
            throw e3;
        } catch (Exception e4) {
            throw e4;
        }
    }

    public int bq0071007100710071q() {
        char charAt = this.bt0074tt00740074.charAt(this.btt0074t00740074);
        this.btt0074t00740074++;
        int i = b006Enn006En006E;
        if ((i * (bn006En006En006E + i)) % b006E006En006En006E() != 0) {
            b006Enn006En006E = bnn006E006En006E();
            bn006En006En006E = 20;
        }
        char c = charAt & CharCompanionObject.MAX_VALUE;
        int i2 = b006Enn006En006E;
        if ((i2 * (b006En006E006En006E() + i2)) % bn006E006E006En006E != 0) {
            b006Enn006En006E = 15;
            bn006En006En006E = 53;
        }
        return c;
    }
}
