package com.didi.soda.router;

/* renamed from: com.didi.soda.router.c */
/* compiled from: StringUtil */
class C14947c {
    C14947c() {
    }

    /* renamed from: a */
    public static boolean m34380a(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: b */
    public static int m34382b(String str) {
        if (str == null) {
            return -1;
        }
        return str.length();
    }

    /* renamed from: a */
    public static boolean m34381a(String str, String str2) {
        if (m34380a(str) && m34380a(str2)) {
            return true;
        }
        if (m34382b(str) != m34382b(str2)) {
            return false;
        }
        return str.equals(str2);
    }
}
