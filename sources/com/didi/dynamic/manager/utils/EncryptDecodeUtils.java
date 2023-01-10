package com.didi.dynamic.manager.utils;

import android.text.TextUtils;

public class EncryptDecodeUtils {

    /* renamed from: a */
    private static final char f21216a = 'A';

    /* renamed from: b */
    private static final char f21217b = 'Z';

    /* renamed from: c */
    private static final char f21218c = 'a';

    /* renamed from: d */
    private static final char f21219d = 'z';

    /* renamed from: a */
    private static boolean m17914a(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    /* renamed from: b */
    private static char m17915b(char c) {
        return c == 'Z' ? f21216a : c == 'z' ? f21218c : (char) (c + 1);
    }

    /* renamed from: c */
    private static char m17916c(char c) {
        if (c == 'A') {
            return 'Z';
        }
        return c == 'a' ? f21219d : (char) (c - 1);
    }

    public static String encrypt(String str) {
        return m17913a(str, true);
    }

    public static String decode(String str) {
        return m17913a(str, false);
    }

    /* renamed from: a */
    private static String m17913a(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            return sb.toString();
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (m17914a(charArray[i])) {
                char c = charArray[i];
                if (z) {
                    sb.append(m17915b(c));
                } else {
                    sb.append(m17916c(c));
                }
            } else {
                sb.append(charArray[i] + "");
            }
        }
        return sb.toString();
    }
}
