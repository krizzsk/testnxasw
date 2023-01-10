package com.threatmetrix.TrustDefender;

import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.google.common.base.Ascii;
import com.threatmetrix.TrustDefender.yyyyqy;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class yqqyqq {
    private static final int b0062006200620062b0062 = 262144;
    public static final int b006200620062b00620062 = 255;
    @Nullable
    private static final MessageDigest b00620062b0062b0062;
    private static final Pattern b00620062bb00620062 = Pattern.compile("^[0-]+$");
    @Nullable
    private static final MessageDigest b0062b00620062b0062;
    @Nullable
    private static final SecureRandom b0062b0062b00620062 = new SecureRandom();
    private static final int b0062bb006200620062 = 5;
    private static final String b0062bb0062b0062 = yyyyqy.b0074t007400740074t(yqqyqq.class);
    private static final Pattern b0062bbb00620062 = Pattern.compile("^([0-9A-Fa-f]{2}[:])*([0-9A-Fa-f]{2})$");
    private static final int bb006200620062b0062 = 128;
    public static final int bb00620062b00620062 = -1;
    private static final int bb0062b006200620062 = 8;
    private static final char[] bb0062b0062b0062 = "0123456789abcdef".toCharArray();
    private static final Pattern bb0062bb00620062 = Pattern.compile("^([0]{1,2}[:])*([0]{1,2})$");
    @Nullable
    private static final MessageDigest bbb00620062b0062;
    private static final String bbb0062b00620062 = "special promotion";
    private static final char[] bbbb006200620062 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '2', '3', '4', '5', '6', '7', '='};
    private static final Pattern bbbbb00620062 = Pattern.compile("^[a-fA-F0-9]{64}$");

    /* JADX WARNING: Removed duplicated region for block: B:15:0x007e  */
    static {
        /*
            java.lang.Class<com.threatmetrix.TrustDefender.yqqyqq> r0 = com.threatmetrix.TrustDefender.yqqyqq.class
            java.lang.String r0 = com.threatmetrix.TrustDefender.yyyyqy.b0074t007400740074t(r0)
            b0062bb0062b0062 = r0
            java.lang.String r0 = "0123456789abcdef"
            char[] r0 = r0.toCharArray()
            bb0062b0062b0062 = r0
            java.lang.String r0 = "^[a-fA-F0-9]{64}$"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            bbbbb00620062 = r0
            java.lang.String r0 = "^([0-9A-Fa-f]{2}[:])*([0-9A-Fa-f]{2})$"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            b0062bbb00620062 = r0
            java.lang.String r0 = "^([0]{1,2}[:])*([0]{1,2})$"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            bb0062bb00620062 = r0
            java.lang.String r0 = "^[0-]+$"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            b00620062bb00620062 = r0
            java.security.SecureRandom r0 = new java.security.SecureRandom
            r0.<init>()
            b0062b0062b00620062 = r0
            java.lang.String r0 = b0062bb0062b0062
            java.lang.String r1 = "Getting SHA1 digest"
            com.threatmetrix.TrustDefender.yyyyqy.bt0074007400740074t(r0, r1)
            r0 = 0
            java.lang.String r1 = "SHA1"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ NoSuchAlgorithmException -> 0x0046 }
            goto L_0x004f
        L_0x0046:
            r1 = move-exception
            java.lang.String r2 = b0062bb0062b0062
            java.lang.String r3 = "SHA1 digest failed"
            com.threatmetrix.TrustDefender.yyyyqy.qyyyqy.b0074tt0074tt(r2, r3, r1)
            r1 = r0
        L_0x004f:
            bbb00620062b0062 = r1
            com.threatmetrix.TrustDefender.qqqyqy r1 = com.threatmetrix.TrustDefender.qqqyqy.bg00670067g0067g()
            boolean r1 = r1.b00670067ggg0067()
            if (r1 != 0) goto L_0x0071
            java.lang.String r1 = b0062bb0062b0062
            java.lang.String r2 = "Getting MD5 digest"
            com.threatmetrix.TrustDefender.yyyyqy.bt0074007400740074t(r1, r2)
            java.lang.String r1 = "MD5"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ NoSuchAlgorithmException -> 0x0069 }
            goto L_0x0072
        L_0x0069:
            r1 = move-exception
            java.lang.String r2 = b0062bb0062b0062
            java.lang.String r3 = "MD5 digest failed"
            com.threatmetrix.TrustDefender.yyyyqy.qyyyqy.b0074tt0074tt(r2, r3, r1)
        L_0x0071:
            r1 = r0
        L_0x0072:
            b00620062b0062b0062 = r1
            com.threatmetrix.TrustDefender.qqqyqy r1 = com.threatmetrix.TrustDefender.qqqyqy.bg00670067g0067g()
            boolean r1 = r1.b00670067ggg0067()
            if (r1 != 0) goto L_0x0094
            java.lang.String r1 = b0062bb0062b0062
            java.lang.String r2 = "Getting SHA256 digest"
            com.threatmetrix.TrustDefender.yyyyqy.bt0074007400740074t(r1, r2)
            java.lang.String r1 = "SHA-256"
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r1)     // Catch:{ NoSuchAlgorithmException -> 0x008c }
            goto L_0x0094
        L_0x008c:
            r1 = move-exception
            java.lang.String r2 = b0062bb0062b0062
            java.lang.String r3 = "SHA256 digest failed"
            com.threatmetrix.TrustDefender.yyyyqy.qyyyqy.b0074tt0074tt(r2, r3, r1)
        L_0x0094:
            b0062b00620062b0062 = r0
            r0 = 33
            char[] r0 = new char[r0]
            r0 = {97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 50, 51, 52, 53, 54, 55, 61} // fill-array
            bbbb006200620062 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.yqqyqq.<clinit>():void");
    }

    private yqqyqq() {
    }

    public static String b00690069006900690069i(Map<String, Object> map, boolean z, int i) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return "";
        }
        if (i > 262144) {
            i = 262144;
        }
        StringBuilder sb = new StringBuilder(i <= 0 ? 128 : i);
        int i2 = 1;
        for (Map.Entry next : map.entrySet()) {
            if (i != -1 && i2 >= i) {
                break;
            }
            String str = ",\"" + ((String) next.getKey()) + "\":";
            Object value = next.getValue();
            if (z) {
                value = b00690069ii00690069(String.valueOf(value).getBytes());
            }
            if (!(value instanceof Number)) {
                value = Const.jsQuote + value + Const.jsQuote;
            }
            String str2 = str + String.valueOf(value);
            if (i != -1 && str2.length() + i2 > i) {
                break;
            }
            sb.append(str2);
            i2 += str2.length();
        }
        sb.replace(0, 1, Const.joLeft).append("}");
        return sb.toString();
    }

    public static String b0069006900690069i0069(@Nonnull String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int i2 = 0; i2 < str.length() && i < 128; i2++) {
            char charAt = str.charAt(i2);
            if ((charAt < '0' || charAt > '9') && !((charAt >= 'a' && charAt <= 'z') || charAt == '_' || charAt == '/' || charAt == '-')) {
                if (charAt >= 'A' && charAt <= 'Z') {
                    charAt = Character.toLowerCase(charAt);
                }
            }
            sb.append(charAt);
            i++;
        }
        return sb.toString();
    }

    public static String b006900690069i00690069(String str) {
        return str != null ? str.toLowerCase(Locale.US) : str;
    }

    public static boolean b006900690069ii0069(@Nullable String str) {
        return b0069ii0069i0069(str) && !str.equals(bbb0062b00620062) && !b00620062bb00620062.matcher(str).find();
    }

    public static boolean b00690069i006900690069(@Nullable String str) {
        return b0069ii0069i0069(str) && bbbbb00620062.matcher(str).find();
    }

    @Nonnull
    public static String b00690069i00690069i(@Nonnull byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i] & 255;
            int i2 = i * 2;
            char[] cArr2 = bb0062b0062b0062;
            cArr[i2] = cArr2[b >>> 4];
            cArr[i2 + 1] = cArr2[b & Ascii.f55148SI];
        }
        return new String(cArr);
    }

    @Nonnull
    public static String b00690069i0069i0069(@Nonnull List<String> list, @Nonnull String str) {
        return bii00690069i0069(list, str, false);
    }

    @Nullable
    public static String b00690069ii00690069(@Nullable byte[] bArr) {
        String b00690069i00690069i;
        if (!(bArr == null || bArr.length == 0)) {
            if (qqqyqy.bg00670067g0067g().b00670067ggg0067()) {
                return qqqyqy.bg00670067g0067g().bgg00670067g0067(bArr);
            }
            MessageDigest messageDigest = bbb00620062b0062;
            if (messageDigest != null) {
                synchronized (messageDigest) {
                    bbb00620062b0062.update(bArr);
                    byte[] digest = bbb00620062b0062.digest();
                    bbb00620062b0062.reset();
                    b00690069i00690069i = b00690069i00690069i(digest);
                }
                return b00690069i00690069i;
            }
        }
        return null;
    }

    @Nullable
    public static String b00690069iii0069(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, boolean z) {
        String str4;
        if (bi0069i0069i0069(str) || bi0069i0069i0069(str3)) {
            return null;
        }
        if (bi0069i0069i0069(str2)) {
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
            return null;
        }
        int indexOf2 = str4.indexOf(str3, indexOf + 1);
        return indexOf2 != -1 ? str.substring(indexOf, indexOf2) : str.substring(indexOf);
    }

    @Nullable
    public static String b0069i006900690069i(Map<String, Object> map) {
        return bi0069006900690069i(map, false);
    }

    @Nullable
    public static String b0069i00690069i0069(@Nullable String str) {
        String b00690069i00690069i;
        if (bi0069i0069i0069(str)) {
            return null;
        }
        if (qqqyqy.bg00670067g0067g().b00670067ggg0067()) {
            return qqqyqy.bg00670067g0067g().bg00670067gg0067(str);
        }
        MessageDigest messageDigest = b00620062b0062b0062;
        if (messageDigest == null) {
            return null;
        }
        synchronized (messageDigest) {
            b00620062b0062b0062.update(str.getBytes());
            byte[] digest = b00620062b0062b0062.digest();
            b00620062b0062b0062.reset();
            b00690069i00690069i = b00690069i00690069i(digest);
        }
        return b00690069i00690069i;
    }

    @Nullable
    public static String b0069i0069i00690069(@Nullable byte[] bArr) {
        String b00690069i00690069i;
        if (!(bArr == null || bArr.length == 0)) {
            if (qqqyqy.bg00670067g0067g().b00670067ggg0067()) {
                return qqqyqy.bg00670067g0067g().b0067g00670067g0067(bArr);
            }
            MessageDigest messageDigest = b0062b00620062b0062;
            if (messageDigest != null) {
                synchronized (messageDigest) {
                    b0062b00620062b0062.update(bArr);
                    byte[] digest = b0062b00620062b0062.digest();
                    b0062b00620062b0062.reset();
                    b00690069i00690069i = b00690069i00690069i(digest);
                }
                return b00690069i00690069i;
            }
        }
        return null;
    }

    private static byte b0069i0069ii0069(char c) throws IllegalArgumentException {
        switch (c) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                switch (c) {
                    case 'A':
                        return 10;
                    case 'B':
                        return 11;
                    case 'C':
                        return Ascii.f55141FF;
                    case 'D':
                        return Ascii.f55139CR;
                    case 'E':
                        return Ascii.f55149SO;
                    case 'F':
                        return Ascii.f55148SI;
                    default:
                        switch (c) {
                            case 'a':
                                return 10;
                            case 'b':
                                return 11;
                            case 'c':
                                return Ascii.f55141FF;
                            case 'd':
                                return Ascii.f55139CR;
                            case 'e':
                                return Ascii.f55149SO;
                            case 'f':
                                return Ascii.f55148SI;
                            default:
                                throw new IllegalArgumentException(Const.jsQuote + c + "\" is not a valid hexidecimal character");
                        }
                }
        }
    }

    public static String b0069ii006900690069(String str) {
        if (bi0069i0069i0069(str)) {
            return null;
        }
        if (qqqyqy.bg00670067g0067g().b00670067ggg0067()) {
            return qqqyqy.bg00670067g0067g().bg006700670067g0067(str);
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            yyyyqy.qyyyqy.b0074tt0074tt(b0062bb0062b0062, "Failed url encoding", e);
            return null;
        }
    }

    public static boolean b0069ii0069i0069(@Nullable String str) {
        return str != null && !str.isEmpty();
    }

    @Nullable
    public static String b0069iii00690069(@Nullable String str) {
        if (bi0069i0069i0069(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : str.getBytes(StandardCharsets.UTF_8)) {
            if (b < 32) {
                sb.append("\\x");
                sb.append(String.format("%02x", new Object[]{Byte.valueOf(b)}));
            } else {
                sb.append((char) b);
            }
        }
        return sb.toString();
    }

    @Nonnull
    public static String b0069iiii0069(int i) {
        String b00670067g00670067g;
        yyyyqy.qyyyqy.b00740074tttt(b0062bb0062b0062, "getting a random string with length of {} ", Integer.valueOf(i));
        if (qqqyqy.bg00670067g0067g().b00670067ggg0067() && (b00670067g00670067g = qqqyqy.bg00670067g0067g().b00670067g00670067g(i)) != null) {
            return b00670067g00670067g;
        }
        byte[] bArr = new byte[((i + 1) / 2)];
        b0062b0062b00620062.nextBytes(bArr);
        String b00690069i00690069i = b00690069i00690069i(bArr);
        return b00690069i00690069i.length() <= i ? b00690069i00690069i : b00690069i00690069i.substring(0, i);
    }

    public static String bi0069006900690069i(Map<String, Object> map, boolean z) {
        return b00690069006900690069i(map, z, 255);
    }

    @Nonnull
    public static String bi006900690069i0069() {
        yyyyqy.qyyyqy.bt0074tttt(b0062bb0062b0062, "getting UUID");
        return b0069iiii0069(32);
    }

    @Nonnull
    public static List<String> bi00690069i00690069(@Nonnull String str, @Nonnull String str2) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            int indexOf = str.indexOf(str2);
            if (indexOf == -1) {
                break;
            }
            if (indexOf >= 1) {
                arrayList.add(str.substring(0, indexOf));
            }
            str = str.substring(indexOf + str2.length());
        }
        if (!str.isEmpty()) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Nonnull
    public static byte[] bi00690069ii0069(@Nonnull String str) throws IllegalArgumentException {
        int length = str.length() / 2;
        if (length * 2 == str.length()) {
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) (b0069i0069ii0069(str.charAt(i2 + 1)) | (b0069i0069ii0069(str.charAt(i2)) << 4));
            }
            return bArr;
        }
        throw new IllegalArgumentException(Const.jsQuote + str + "\" has an odd number of characters");
    }

    public static void bi0069i006900690069(String str, String str2, @Nonnull Map<String, String> map) {
        if (b0069ii0069i0069(str)) {
            map.put(str2, str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String bi0069i00690069i(byte[] r19) {
        /*
            r0 = r19
            if (r0 == 0) goto L_0x00f6
            int r1 = r0.length
            if (r1 != 0) goto L_0x0009
            goto L_0x00f6
        L_0x0009:
            int r1 = r0.length
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r3 = r1 + 5
            r4 = 1
            int r3 = r3 - r4
            r5 = 5
            int r3 = r3 / r5
            int r3 = r3 * 8
            int r3 = r3 + r4
            r2.<init>(r3)
            r6 = 0
        L_0x0019:
            if (r1 < r4) goto L_0x00f1
            if (r1 >= r5) goto L_0x001f
            r7 = r1
            goto L_0x0020
        L_0x001f:
            r7 = 5
        L_0x0020:
            r8 = 4
            r9 = 2
            r10 = 3
            if (r7 == r4) goto L_0x0088
            if (r7 == r9) goto L_0x006c
            if (r7 == r10) goto L_0x0058
            if (r7 == r8) goto L_0x0043
            if (r7 == r5) goto L_0x0037
            r3 = 0
            r5 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            goto L_0x009d
        L_0x0037:
            int r11 = r6 + 4
            byte r12 = r0[r11]
            r12 = r12 & 31
            byte r11 = r0[r11]
            r11 = r11 & 224(0xe0, float:3.14E-43)
            int r11 = r11 >> r5
            goto L_0x0045
        L_0x0043:
            r11 = 0
            r12 = 0
        L_0x0045:
            int r13 = r6 + 3
            byte r14 = r0[r13]
            r14 = r14 & r10
            int r14 = r14 << r10
            r11 = r11 | r14
            byte r14 = r0[r13]
            r14 = r14 & 124(0x7c, float:1.74E-43)
            int r14 = r14 >> r9
            byte r13 = r0[r13]
            r13 = r13 & 128(0x80, float:1.794E-43)
            int r13 = r13 >> 7
            goto L_0x005c
        L_0x0058:
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x005c:
            int r15 = r6 + 2
            byte r16 = r0[r15]
            r16 = r16 & 15
            int r16 = r16 << 1
            r13 = r13 | r16
            byte r15 = r0[r15]
            r15 = r15 & 240(0xf0, float:3.36E-43)
            int r15 = r15 >> r8
            goto L_0x0071
        L_0x006c:
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x0071:
            int r16 = r6 + 1
            byte r17 = r0[r16]
            r17 = r17 & 1
            int r17 = r17 << 4
            r15 = r15 | r17
            byte r17 = r0[r16]
            r17 = r17 & 62
            int r17 = r17 >> 1
            byte r3 = r0[r16]
            r3 = r3 & 192(0xc0, float:2.69E-43)
            int r3 = r3 >> 6
            goto L_0x0090
        L_0x0088:
            r3 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = 0
        L_0x0090:
            byte r16 = r0[r6]
            r16 = r16 & 7
            int r16 = r16 << 2
            r3 = r3 | r16
            byte r5 = r0[r6]
            r5 = r5 & 248(0xf8, float:3.48E-43)
            int r5 = r5 >> r10
        L_0x009d:
            int r6 = r6 + r7
            int r1 = r1 - r7
            r18 = 32
            if (r7 == r4) goto L_0x00aa
            if (r7 == r9) goto L_0x00ae
            if (r7 == r10) goto L_0x00b0
            if (r7 == r8) goto L_0x00b4
            goto L_0x00b6
        L_0x00aa:
            r15 = 32
            r17 = 32
        L_0x00ae:
            r13 = 32
        L_0x00b0:
            r11 = 32
            r14 = 32
        L_0x00b4:
            r12 = 32
        L_0x00b6:
            char[] r7 = bbbb006200620062
            char r5 = r7[r5]
            r2.append(r5)
            char[] r5 = bbbb006200620062
            char r3 = r5[r3]
            r2.append(r3)
            char[] r3 = bbbb006200620062
            char r3 = r3[r17]
            r2.append(r3)
            char[] r3 = bbbb006200620062
            char r3 = r3[r15]
            r2.append(r3)
            char[] r3 = bbbb006200620062
            char r3 = r3[r13]
            r2.append(r3)
            char[] r3 = bbbb006200620062
            char r3 = r3[r14]
            r2.append(r3)
            char[] r3 = bbbb006200620062
            char r3 = r3[r11]
            r2.append(r3)
            char[] r3 = bbbb006200620062
            char r3 = r3[r12]
            r2.append(r3)
            r5 = 5
            goto L_0x0019
        L_0x00f1:
            java.lang.String r0 = r2.toString()
            return r0
        L_0x00f6:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.yqqyqq.bi0069i00690069i(byte[]):java.lang.String");
    }

    public static boolean bi0069i0069i0069(@Nullable String str) {
        return str == null || str.isEmpty();
    }

    public static String bi0069ii00690069(@Nullable byte[] bArr) {
        String bi0069i00690069i;
        if (!(bArr == null || bArr.length == 0)) {
            if (qqqyqy.bg00670067g0067g().b00670067ggg0067()) {
                return qqqyqy.bg00670067g0067g().b00670067g0067g0067(bArr);
            }
            MessageDigest messageDigest = bbb00620062b0062;
            if (messageDigest != null) {
                synchronized (messageDigest) {
                    bbb00620062b0062.update(bArr);
                    byte[] digest = bbb00620062b0062.digest();
                    bbb00620062b0062.reset();
                    bi0069i00690069i = bi0069i00690069i(digest);
                }
                return bi0069i00690069i;
            }
        }
        return null;
    }

    public static int bi0069iii0069(String str) {
        if (str == null) {
            return 0;
        }
        int i = 0;
        for (byte b : str.getBytes(StandardCharsets.UTF_8)) {
            i += b;
        }
        return i;
    }

    public static String bii0069006900690069(@Nullable String str, @Nullable String str2) {
        if (str == null || str.length() > 262144 || str2 == null) {
            return null;
        }
        if (qqqyqy.bg00670067g0067g().b00670067ggg0067()) {
            return qqqyqy.bg00670067g0067g().b0067ggg00670067(str, str2);
        }
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        byte[] bytes2 = str2.getBytes(StandardCharsets.UTF_8);
        byte[] bytes3 = (bytes.length + ParamKeys.SIGN_AND).getBytes(StandardCharsets.UTF_8);
        byte[] bArr = new byte[(bytes.length + bytes3.length)];
        int length = bytes2.length;
        int length2 = bytes3.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length2) {
            int i4 = i2 + 1;
            int i5 = i3 + 1;
            bArr[i2] = (byte) ((bytes2[i3] & 10) ^ bytes3[i]);
            i3 = i5 >= length ? 0 : i5;
            i++;
            i2 = i4;
        }
        int length3 = bytes.length;
        int i6 = 0;
        while (i6 < length3) {
            int i7 = i2 + 1;
            int i8 = i3 + 1;
            bArr[i2] = (byte) (bytes[i6] ^ (bytes2[i3] & 10));
            i3 = i8 >= length ? 0 : i8;
            i6++;
            i2 = i7;
        }
        return b00690069i00690069i(bArr);
    }

    @Nonnull
    public static String bii006900690069i(@Nonnull byte[] bArr) {
        char[] cArr = new char[((bArr.length * 3) - 1)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i] & 255;
            int i2 = i * 3;
            char[] cArr2 = bb0062b0062b0062;
            cArr[i2] = cArr2[b >>> 4];
            cArr[i2 + 1] = cArr2[b & Ascii.f55148SI];
            if (i < bArr.length - 1) {
                cArr[i2 + 2] = ':';
            }
        }
        return new String(cArr);
    }

    @Nonnull
    public static String bii00690069i0069(@Nonnull List<String> list, @Nonnull String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (String next : list) {
            if (!next.isEmpty()) {
                if (sb.length() > 0) {
                    sb.append(str);
                }
                sb.append(next);
            }
        }
        if (z && sb.length() > 0) {
            sb.append(str);
        }
        return sb.toString();
    }

    @Nullable
    public static byte[] bii0069i00690069(@Nullable byte[] bArr) {
        MessageDigest messageDigest;
        byte[] digest;
        if (bArr == null || bArr.length == 0 || (messageDigest = b0062b00620062b0062) == null) {
            return null;
        }
        synchronized (messageDigest) {
            b0062b00620062b0062.update(bArr);
            digest = b0062b00620062b0062.digest();
            b0062b00620062b0062.reset();
        }
        return digest;
    }

    @Nonnull
    public static List<URI> bii0069ii0069(@Nonnull List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String uri : list) {
            try {
                URI uri2 = new URI(uri);
                if (uri2.getScheme() != null) {
                    arrayList.add(uri2);
                } else {
                    String str = b0062bb0062b0062;
                    yyyyqy.qyyyqy.bt0074tttt(str, "Failed to get url scheme from: " + uri2);
                }
            } catch (URISyntaxException e) {
                yyyyqy.qyyyqy.b0074tt0074tt(b0062bb0062b0062, "malformed check url", e);
            }
        }
        return arrayList;
    }

    public static String biii006900690069(String str, int i) {
        return (str == null || i < 0 || str.length() <= i) ? str : str.substring(0, i);
    }

    public static boolean biii0069i0069(@Nullable String str) {
        return b0069ii0069i0069(str) && !"02:00:00:00:00:00".equals(str) && b0062bbb00620062.matcher(str).find() && !bb0062bb00620062.matcher(str).find();
    }

    public static String biiii00690069(@Nonnull String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int i2 = 0; i2 < str.length() && i < 128; i2++) {
            char charAt = str.charAt(i2);
            if ((charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == '_' || charAt == '/' || charAt == '-'))) {
                sb.append(charAt);
                i++;
            }
        }
        return sb.toString();
    }

    @Nullable
    public static String biiiii0069(String... strArr) {
        if (strArr == null || strArr.length % 2 > 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder("{\"");
        for (int i = 0; i < strArr.length - 1; i += 2) {
            int i2 = i + 1;
            if (b0069ii0069i0069(strArr[i2])) {
                if (i > 0) {
                    sb.append("\",\"");
                }
                sb.append(strArr[i]);
                sb.append("\":\"");
                sb.append(strArr[i2]);
            }
        }
        sb.append("\"}");
        return sb.toString();
    }
}
