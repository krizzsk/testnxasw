package com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj;

import com.google.common.base.Ascii;
import com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhhh;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class hkkhhh {
    private static final String b0066f0066006600660066 = kkhhhh.bj006A006A006Ajj(hkkhhh.class);
    public static int b00710071q007100710071 = 2;
    public static int b0071q0071007100710071 = 1;
    public static int b0071qq007100710071 = bqq0071007100710071();
    @Nullable
    private static final MessageDigest b0074ttttt;
    private static final char[] bf00660066006600660066 = kkhhkh.b006Aj006A006A006A006A("XZ\\^`bdfhj\u0014\u0016\u0018\u001a\u001c\u001e", 'V', 'Q', 3).toCharArray();
    public static int bqqq007100710071 = bqq0071007100710071();
    private static final Pattern bt0074tttt = Pattern.compile(kkhhkh.b006Aj006A006A006A006A("VRW\"Z4\u001f7 \u001c'Jg!\u001ef\f", 214, 175, 1));

    static {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(kkhhkh.bj006A006A006A006A006A("\u001e\u0014\u000ez\u0001\u0005\u0007", '%', 5));
            if (((bqqq007100710071 + bq0071q007100710071()) * bqqq007100710071) % b00710071q007100710071 != b0071qq007100710071) {
            }
        } catch (NoSuchAlgorithmException e) {
            kkhhhh.hhkhhh.bt0074t007400740074(b0066f0066006600660066, kkhhkh.bj006A006A006A006A006A("_UOAEG2w}|{\u000b\r9\u0001|\u0006\n\u0004\u0004", 139, 0), e);
        }
        b0074ttttt = messageDigest;
    }

    private hkkhhh() {
    }

    @Nullable
    public static byte[][] b006A006A006A006A006Aj(@Nullable List<String> list) {
        try {
            byte[][] bArr = null;
            if (list != null && !list.isEmpty()) {
                bArr = new byte[list.size()][];
                int i = 0;
                while (i < list.size()) {
                    try {
                        bArr[i] = b006A006Aj006A006Aj(list.get(i));
                        int i2 = bqqq007100710071;
                        if (((b0071q0071007100710071 + i2) * i2) % b00710071q007100710071 != b0071qq007100710071) {
                            bqqq007100710071 = bqq0071007100710071();
                            b0071qq007100710071 = bqq0071007100710071();
                        }
                        i++;
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
            return bArr;
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Nullable
    public static byte[] b006A006Aj006A006Aj(@Nullable String str) {
        if (b006Aj006A006A006Aj(str)) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        int i = 0;
        while (i < length) {
            int i2 = i * 2;
            try {
                bArr[i] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
                if (((bqq0071007100710071() + b0071q0071007100710071) * bqq0071007100710071()) % b00710071q007100710071 != b0071qq007100710071) {
                    bqqq007100710071 = bqq0071007100710071();
                    b0071qq007100710071 = 90;
                }
                i++;
            } catch (NumberFormatException unused) {
                kkhhhh.hhkhhh.b007400740074t00740074(kkhhkh.b006Aj006A006A006A006A("aef`c^j\u001fhfz#wyxpvpD+\b\u000b", 254, 246, 3), str);
                return null;
            }
        }
        return bArr;
    }

    public static boolean b006Aj006A006A006Aj(@Nullable String str) {
        int i = bqqq007100710071;
        if ((i * (bq0071q007100710071() + i)) % b00710071q007100710071 != 0) {
            bqqq007100710071 = bqq0071007100710071();
            b0071qq007100710071 = 58;
        }
        return str == null || str.isEmpty();
    }

    @Nullable
    public static byte[] bj006A006A006A006Aj(@Nullable byte[] bArr) {
        MessageDigest messageDigest;
        byte[] digest;
        if (bArr == null || bArr.length == 0 || (messageDigest = b0074ttttt) == null) {
            return null;
        }
        synchronized (messageDigest) {
            b0074ttttt.update(bArr);
            digest = b0074ttttt.digest();
            b0074ttttt.reset();
        }
        return digest;
    }

    @Nonnull
    public static String bj006Aj006A006Aj(@Nonnull byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i] & 255;
            int i2 = i * 2;
            char[] cArr2 = bf00660066006600660066;
            cArr[i2] = cArr2[b >>> 4];
            cArr[i2 + 1] = cArr2[b & Ascii.f55148SI];
        }
        return new String(cArr);
    }

    public static boolean bjj006A006A006Aj(@Nullable String str) {
        if (str != null && !str.isEmpty()) {
            return true;
        }
        int i = bqqq007100710071;
        if ((i * (b0071q0071007100710071 + i)) % bq00710071007100710071() == 0) {
            return false;
        }
        bqqq007100710071 = bqq0071007100710071();
        b0071qq007100710071 = bqq0071007100710071();
        return false;
    }

    public static boolean bjjjjj006A(@Nullable String str) {
        try {
            if (!bjj006A006A006Aj(str) || !bt0074tttt.matcher(str).find()) {
                return false;
            }
            int i = bqqq007100710071;
            if (((b0071q0071007100710071 + i) * i) % b00710071q007100710071 == b0071qq007100710071) {
                return true;
            }
            bqqq007100710071 = 65;
            b0071qq007100710071 = bqq0071007100710071();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    public static int bq00710071007100710071() {
        return 2;
    }

    public static int bq0071q007100710071() {
        return 1;
    }

    public static int bqq0071007100710071() {
        return 75;
    }
}
