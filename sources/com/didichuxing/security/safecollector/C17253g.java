package com.didichuxing.security.safecollector;

import android.content.Context;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: com.didichuxing.security.safecollector.g */
/* compiled from: TimeZoneCollector */
final class C17253g {
    C17253g() {
    }

    /* renamed from: a */
    public static int m38739a() {
        try {
            return (TimeZone.getDefault().getOffset(new Date().getTime()) / 1000) / 60;
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* renamed from: a */
    public static String m38740a(Context context) {
        try {
            return context.getResources().getConfiguration().locale.getCountry();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: b */
    public static String m38741b(Context context) {
        try {
            Locale locale = context.getResources().getConfiguration().locale;
            return locale.getLanguage() + "-" + locale.getCountry();
        } catch (Throwable unused) {
            return "";
        }
    }
}
