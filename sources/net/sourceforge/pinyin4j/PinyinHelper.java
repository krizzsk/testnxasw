package net.sourceforge.pinyin4j;

import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinyinHelper {
    public static String[] toHanyuPinyinStringArray(char c) {
        return m6671a(c);
    }

    public static String[] toHanyuPinyinStringArray(char c, HanyuPinyinOutputFormat hanyuPinyinOutputFormat) throws BadHanyuPinyinOutputFormatCombination {
        return m6673a(c, hanyuPinyinOutputFormat);
    }

    /* renamed from: a */
    private static String[] m6673a(char c, HanyuPinyinOutputFormat hanyuPinyinOutputFormat) throws BadHanyuPinyinOutputFormatCombination {
        String[] a = m6671a(c);
        if (a == null) {
            return null;
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = C2969b.m6682a(a[i], hanyuPinyinOutputFormat);
        }
        return a;
    }

    /* renamed from: a */
    private static String[] m6671a(char c) {
        return ChineseToPinyinResource.m6660a().mo29782a(c);
    }

    public static String[] toTongyongPinyinStringArray(char c) {
        return m6672a(c, C2971d.f6918e);
    }

    public static String[] toWadeGilesPinyinStringArray(char c) {
        return m6672a(c, C2971d.f6915b);
    }

    public static String[] toMPS2PinyinStringArray(char c) {
        return m6672a(c, C2971d.f6916c);
    }

    public static String[] toYalePinyinStringArray(char c) {
        return m6672a(c, C2971d.f6917d);
    }

    /* renamed from: a */
    private static String[] m6672a(char c, C2971d dVar) {
        String[] a = m6671a(c);
        if (a == null) {
            return null;
        }
        String[] strArr = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            strArr[i] = C2970c.m6683a(a[i], C2971d.f6914a, dVar);
        }
        return strArr;
    }

    public static String[] toGwoyeuRomatzyhStringArray(char c) {
        return m6675b(c);
    }

    /* renamed from: b */
    private static String[] m6675b(char c) {
        String[] a = m6671a(c);
        if (a == null) {
            return null;
        }
        String[] strArr = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            strArr[i] = C2968a.m6680a(a[i]);
        }
        return strArr;
    }

    public static String toHanyuPinyinString(String str, HanyuPinyinOutputFormat hanyuPinyinOutputFormat, String str2) throws BadHanyuPinyinOutputFormatCombination {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            String b = m6674b(str.charAt(i), hanyuPinyinOutputFormat);
            if (b != null) {
                stringBuffer.append(b);
                if (i != str.length() - 1) {
                    stringBuffer.append(str2);
                }
            } else {
                stringBuffer.append(str.charAt(i));
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    private static String m6674b(char c, HanyuPinyinOutputFormat hanyuPinyinOutputFormat) throws BadHanyuPinyinOutputFormatCombination {
        String[] a = m6673a(c, hanyuPinyinOutputFormat);
        if (a == null || a.length <= 0) {
            return null;
        }
        return a[0];
    }

    private PinyinHelper() {
    }
}
