package com.didi.soda.router;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;

/* renamed from: com.didi.soda.router.b */
/* compiled from: SchemeUtils */
class C14946b {

    /* renamed from: a */
    static final String f46233a = "^-?[1-9]\\d*$";

    /* renamed from: b */
    static final String f46234b = "^[-]?[1-9]\\d*\\.\\d*|-0\\.\\d*[1-9]\\d*$";

    C14946b() {
    }

    /* renamed from: a */
    static String m34375a(String str) {
        int indexOf = str.indexOf("?&");
        if (indexOf > 0) {
            indexOf += 2;
        }
        if (indexOf == -1 && (indexOf = str.indexOf("?")) > 0) {
            indexOf++;
        }
        if (indexOf > 0) {
            return str.substring(indexOf);
        }
        return null;
    }

    /* renamed from: a */
    static void m34378a(String str, Bundle bundle) {
        for (String split : str.trim().split(ParamKeys.SIGN_AND)) {
            String[] split2 = split.split("=");
            String str2 = null;
            String str3 = (split2 == null || split2.length <= 0) ? null : split2[0];
            if (split2 != null && split2.length > 1) {
                str2 = split2[1];
            }
            m34377a(bundle, str3, str2);
        }
    }

    /* renamed from: a */
    static String m34376a(String str, String str2, int i) {
        int length = str.length() + 1;
        for (int i2 = 0; i2 <= i; i2++) {
            int indexOf = str2.indexOf("/", length);
            if (indexOf == -1) {
                return null;
            }
            length = indexOf + 1;
        }
        return str2.substring(0, length);
    }

    /* renamed from: a */
    private static void m34377a(Bundle bundle, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            bundle.putString(str, str2);
        }
    }

    /* renamed from: b */
    static String m34379b(String str) {
        return str.substring(str.startsWith("/") ? 1 : 0, str.endsWith("/") ? str.length() - 1 : str.length());
    }
}
