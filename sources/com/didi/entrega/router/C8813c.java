package com.didi.entrega.router;

/* renamed from: com.didi.entrega.router.c */
/* compiled from: StringUtil */
class C8813c {
    C8813c() {
    }

    /* renamed from: a */
    public static boolean m18846a(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: b */
    public static int m18848b(String str) {
        if (str == null) {
            return -1;
        }
        return str.length();
    }

    /* renamed from: a */
    public static boolean m18847a(String str, String str2) {
        if (m18846a(str) && m18846a(str2)) {
            return true;
        }
        if (m18848b(str) != m18848b(str2)) {
            return false;
        }
        return str.equals(str2);
    }
}
