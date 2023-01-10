package com.didi.sdk.util;

import com.didi.sdk.message.NameValuePair;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.BitSet;
import java.util.List;

public class URLEncodedUtils {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    /* renamed from: a */
    private static final char f40406a = '&';

    /* renamed from: b */
    private static final String f40407b = "=";

    /* renamed from: c */
    private static final BitSet f40408c = new BitSet(256);

    /* renamed from: d */
    private static final BitSet f40409d = new BitSet(256);

    /* renamed from: e */
    private static final BitSet f40410e = new BitSet(256);

    /* renamed from: f */
    private static final BitSet f40411f = new BitSet(256);

    /* renamed from: g */
    private static final BitSet f40412g = new BitSet(256);

    /* renamed from: h */
    private static final BitSet f40413h = new BitSet(256);

    /* renamed from: i */
    private static final BitSet f40414i = new BitSet(256);

    /* renamed from: j */
    private static final int f40415j = 16;

    static {
        for (int i = 97; i <= 122; i++) {
            f40409d.set(i);
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            f40409d.set(i2);
        }
        for (int i3 = 48; i3 <= 57; i3++) {
            f40409d.set(i3);
        }
        f40409d.set(95);
        f40409d.set(45);
        f40409d.set(46);
        f40409d.set(42);
        f40408c.or(f40409d);
        f40409d.set(33);
        f40409d.set(126);
        f40409d.set(39);
        f40409d.set(40);
        f40409d.set(41);
        f40410e.set(44);
        f40410e.set(59);
        f40410e.set(58);
        f40410e.set(36);
        f40410e.set(38);
        f40410e.set(43);
        f40410e.set(61);
        f40411f.or(f40409d);
        f40411f.or(f40410e);
        f40412g.or(f40409d);
        f40412g.set(47);
        f40412g.set(59);
        f40412g.set(58);
        f40412g.set(64);
        f40412g.set(38);
        f40412g.set(61);
        f40412g.set(43);
        f40412g.set(36);
        f40412g.set(44);
        f40414i.set(59);
        f40414i.set(47);
        f40414i.set(63);
        f40414i.set(58);
        f40414i.set(64);
        f40414i.set(38);
        f40414i.set(61);
        f40414i.set(43);
        f40414i.set(36);
        f40414i.set(44);
        f40414i.set(91);
        f40414i.set(93);
        f40413h.or(f40414i);
        f40413h.or(f40409d);
    }

    public static String format(List<? extends NameValuePair> list, String str) {
        return format(list, '&', str);
    }

    public static String format(List<? extends NameValuePair> list, char c, String str) {
        StringBuilder sb = new StringBuilder();
        for (NameValuePair nameValuePair : list) {
            String a = m30393a(nameValuePair.getName(), str);
            String a2 = m30393a(nameValuePair.getValue(), str);
            if (sb.length() > 0) {
                sb.append(c);
            }
            sb.append(a);
            if (a2 != null) {
                sb.append("=");
                sb.append(a2);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m30393a(String str, String str2) {
        if (str == null) {
            return null;
        }
        return m30395a(str, str2 != null ? Charset.forName(str2) : UTF_8, f40408c, true);
    }

    /* renamed from: a */
    private static String m30394a(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        if (charset == null) {
            charset = UTF_8;
        }
        return m30395a(str, charset, f40408c, true);
    }

    /* renamed from: a */
    private static String m30395a(String str, Charset charset, BitSet bitSet, boolean z) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ByteBuffer encode = charset.encode(str);
        while (encode.hasRemaining()) {
            byte b = encode.get() & 255;
            if (bitSet.get(b)) {
                sb.append((char) b);
            } else if (!z || b != 32) {
                sb.append("%");
                char upperCase = Character.toUpperCase(Character.forDigit((b >> 4) & 15, 16));
                char upperCase2 = Character.toUpperCase(Character.forDigit(b & Ascii.f55148SI, 16));
                sb.append(upperCase);
                sb.append(upperCase2);
            } else {
                sb.append('+');
            }
        }
        return sb.toString();
    }
}
