package com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj;

import kotlin.jvm.internal.CharCompanionObject;

public final class hkhhkh {
    public static final int b00740074ttt0074 = 56320;
    public static final int b0074tttt0074 = 55296;
    public static int b00780078xx0078x = 0;
    public static int b0078x0078x0078x = 2;
    public static final int bt0074ttt0074 = 56320;
    public static final int btt0074tt0074 = 57344;
    public static int bx0078xx0078x = 56;
    public static int bxx0078x0078x = 1;
    private final int b00740074007400740074t;
    private final String bt0074007400740074t;
    private int bttttt0074;

    public hkhhkh(String str) {
        this.bt0074007400740074t = str;
        this.b00740074007400740074t = str.length();
    }

    public static int b007800780078x0078x() {
        return 1;
    }

    public static int bx00780078x0078x() {
        return 28;
    }

    public boolean b006A006Aj006A006A006A() {
        try {
            try {
                if (this.bttttt0074 >= this.b00740074007400740074t) {
                    return false;
                }
                if (((bx00780078x0078x() + b007800780078x0078x()) * bx00780078x0078x()) % b0078x0078x0078x == b00780078xx0078x) {
                    return true;
                }
                bx0078xx0078x = 52;
                b00780078xx0078x = 77;
                return true;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public int bjj006A006A006A006A() {
        char charAt = this.bt0074007400740074t.charAt(this.bttttt0074);
        int i = this.bttttt0074;
        int i2 = bx0078xx0078x;
        if ((i2 * (b007800780078x0078x() + i2)) % b0078x0078x0078x != 0) {
            bx0078xx0078x = 55;
            b00780078xx0078x = bx00780078x0078x();
        }
        int i3 = bx0078xx0078x;
        if (((bxx0078x0078x + i3) * i3) % b0078x0078x0078x != b00780078xx0078x) {
            bx0078xx0078x = 45;
            b00780078xx0078x = bx00780078x0078x();
        }
        this.bttttt0074 = i + 1;
        return charAt & CharCompanionObject.MAX_VALUE;
    }
}
