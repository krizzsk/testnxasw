package com.threatmetrix.TrustDefender.fcuqtqpahmoqinu;

import com.google.common.base.Ascii;
import com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkkhhh;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import kotlin.text.Typography;

public class hkhkhh {
    public static int b006C006C006C006Cl006C = 91;
    public static int b006Clll006C006C = bll006C006Cl006C();
    @Nullable
    private static final MessageDigest b00740074tt0074t;
    private static final String b0074ttt0074t;
    public static int bl006C006C006Cl006C = 2;
    public static int bllll006C006C = 1;
    private static final char[] bt0074tt0074t;

    static {
        try {
            b0074ttt0074t = hkkhhh.bjjjjj006A(hkhkhh.class);
            bt0074tt0074t = khhkhk.b00710071007100710071q("|~\u0001\u0003\u0005\u0007\t\u000b\r\u000f8:<>@B", Typography.half, 141, 3).toCharArray();
            MessageDigest messageDigest = null;
            try {
                hkkhhh.m44481i(b0074ttt0074t, khhkhk.bqqqqq0071("Lk{|rxr,`VPA1v|{z\n\f", ',', 1));
                if (!hhhkhh.b006Aj006Ajj006A().b006Ajj006Aj006A()) {
                    hkkhhh.m44481i(b0074ttt0074t, khhkhk.bqqqqq0071("\u00185CB6:2i\u001c\u0010\bwyyb&*'$11", 185, 4));
                    try {
                        messageDigest = MessageDigest.getInstance(khhkhk.b00710071007100710071q("wmgTZ^`", 'F', 161, 0));
                        int i = b006Clll006C006C;
                        if ((i * (bllll006C006C + i)) % bl006Cll006C006C() != 0) {
                        }
                    } catch (NoSuchAlgorithmException e) {
                        hkkhhh.kkkhhh.m44488e(b0074ttt0074t, khhkhk.bqqqqq0071("\u001b\u000f\u0007vxxa%)&#00Z \u001a!#\u001b\u0019", 155, 2), (Throwable) e);
                    }
                }
                b00740074tt0074t = messageDigest;
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    private hkhkhh() {
    }

    @Nullable
    public static String b006A006A006A006Aj006A(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, boolean z) {
        String str4;
        try {
            if (b006Ajjj006A006A(str) || b006Ajjj006A006A(str3)) {
                return null;
            }
            try {
                if (b006Ajjj006A006A(str2)) {
                    return str;
                }
                if (z) {
                    str4 = str.toLowerCase();
                    str2 = str2.toLowerCase();
                } else {
                    str4 = str;
                }
                int indexOf = str4.indexOf(str2);
                if (indexOf == -1) {
                    int i = b006Clll006C006C;
                    if (((bllll006C006C + i) * i) % bl006C006C006Cl006C != b006C006C006C006Cl006C) {
                        b006Clll006C006C = 83;
                        b006C006C006C006Cl006C = 16;
                    }
                    return null;
                }
                int indexOf2 = str4.indexOf(str3, indexOf + 1);
                return indexOf2 != -1 ? str.substring(indexOf, indexOf2) : str.substring(indexOf);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static boolean b006Ajjj006A006A(@Nullable String str) {
        if (str != null) {
            if (((bll006C006Cl006C() + bllll006C006C) * bll006C006Cl006C()) % bl006C006C006Cl006C != b006C006C006C006Cl006C) {
                b006C006C006C006Cl006C = 30;
            }
            return str.isEmpty();
        }
    }

    public static int b006Cl006C006Cl006C() {
        return 1;
    }

    @Nonnull
    public static String bj006A006A006Aj006A(@Nonnull byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i] & 255;
            int i2 = i * 2;
            char[] cArr2 = bt0074tt0074t;
            cArr[i2] = cArr2[b >>> 4];
            cArr[i2 + 1] = cArr2[b & Ascii.f55148SI];
        }
        return new String(cArr);
    }

    @Nullable
    public static String bj006Ajj006A006A(@Nullable byte[] bArr) {
        String bj006A006A006Aj006A;
        if (!(bArr == null || bArr.length == 0)) {
            if (hhhkhh.b006Aj006Ajj006A().b006Ajj006Aj006A()) {
                return hhhkhh.b006Aj006Ajj006A().b006A006Aj006Aj006A(bArr);
            }
            MessageDigest messageDigest = b00740074tt0074t;
            if (messageDigest != null) {
                synchronized (messageDigest) {
                    b00740074tt0074t.update(bArr);
                    byte[] digest = b00740074tt0074t.digest();
                    b00740074tt0074t.reset();
                    bj006A006A006Aj006A = bj006A006A006Aj006A(digest);
                }
                return bj006A006A006Aj006A;
            }
        }
        return null;
    }

    public static boolean bjjjj006A006A(@Nullable String str) {
        return str != null && !str.isEmpty();
    }

    public static int bl006Cll006C006C() {
        return 2;
    }

    public static int bll006C006Cl006C() {
        return 47;
    }
}
