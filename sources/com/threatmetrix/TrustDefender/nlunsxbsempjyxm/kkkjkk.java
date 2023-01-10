package com.threatmetrix.TrustDefender.nlunsxbsempjyxm;

import kotlin.jvm.internal.CharCompanionObject;

public final class kkkjkk {
    public static int b00620062bbb00620062 = 41;
    public static int b0062b0062bb00620062 = 1;
    public static final int b00750075uuuu = 55296;
    public static final int b0075u0075uuu = 56320;
    public static int bb00620062bb00620062 = 2;
    public static int bbb0062bb00620062 = 0;
    public static final int bu00750075uuu = 57344;
    public static final int buu0075uuu = 56320;
    private final int b0075uuuuu;
    private final String bj006A006A006A006A006A;
    private int bu0075uuuu;

    public kkkjkk(String str) {
        this.bj006A006A006A006A006A = str;
        this.b0075uuuuu = str.length();
    }

    public static int b006200620062bb00620062() {
        return 51;
    }

    public static int bbbb0062b00620062() {
        return 0;
    }

    public boolean b006200620062bbbb() {
        try {
            if (this.bu0075uuuu >= this.b0075uuuuu) {
                return false;
            }
            int i = b00620062bbb00620062;
            if (((b0062b0062bb00620062 + i) * i) % bb00620062bb00620062 != bbbb0062b00620062()) {
                b00620062bbb00620062 = 4;
                bbb0062bb00620062 = b006200620062bb00620062();
            }
            try {
                int i2 = b00620062bbb00620062;
                if ((i2 * (b0062b0062bb00620062 + i2)) % bb00620062bb00620062 == 0) {
                    return true;
                }
                b00620062bbb00620062 = b006200620062bb00620062();
                bbb0062bb00620062 = b006200620062bb00620062();
                return true;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public int bbbb0062bbb() {
        try {
            String str = this.bj006A006A006A006A006A;
            int i = this.bu0075uuuu;
            if (((b00620062bbb00620062 + b0062b0062bb00620062) * b00620062bbb00620062) % bb00620062bb00620062 != bbb0062bb00620062) {
                try {
                    b00620062bbb00620062 = b006200620062bb00620062();
                    bbb0062bb00620062 = b006200620062bb00620062();
                } catch (Exception e) {
                    throw e;
                }
            }
            char charAt = str.charAt(i);
            this.bu0075uuuu++;
            int i2 = b00620062bbb00620062;
            if ((i2 * (b0062b0062bb00620062 + i2)) % bb00620062bb00620062 != 0) {
                b00620062bbb00620062 = 49;
                bbb0062bb00620062 = 4;
            }
            return charAt & CharCompanionObject.MAX_VALUE;
        } catch (Exception e2) {
            throw e2;
        }
    }
}
