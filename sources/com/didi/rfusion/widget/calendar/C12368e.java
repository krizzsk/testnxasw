package com.didi.rfusion.widget.calendar;

import android.icu.text.DateFormat;
import com.didi.rfusion.RFusion;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.didi.rfusion.widget.calendar.e */
/* compiled from: UtcDates */
class C12368e {

    /* renamed from: a */
    static final String f36245a = "UTC";

    /* renamed from: b */
    static AtomicReference<C12367d> f36246b = new AtomicReference<>();

    /* renamed from: a */
    static void m27288a(C12367d dVar) {
        f36246b.set(dVar);
    }

    /* renamed from: a */
    static C12367d m27284a() {
        C12367d dVar = f36246b.get();
        return dVar == null ? C12367d.m27275a() : dVar;
    }

    private C12368e() {
    }

    /* renamed from: g */
    private static TimeZone m27303g() {
        return TimeZone.getTimeZone(f36245a);
    }

    /* renamed from: h */
    private static android.icu.util.TimeZone m27304h() {
        return android.icu.util.TimeZone.getTimeZone(f36245a);
    }

    /* renamed from: b */
    static Calendar m27292b() {
        Calendar b = m27284a().mo94106b();
        b.set(11, 0);
        b.set(12, 0);
        b.set(13, 0);
        b.set(14, 0);
        b.setTimeZone(m27303g());
        return b;
    }

    /* renamed from: c */
    static Calendar m27295c() {
        return m27287a((Calendar) null);
    }

    /* renamed from: a */
    static Calendar m27287a(Calendar calendar) {
        Calendar instance = Calendar.getInstance(m27303g());
        if (calendar == null) {
            instance.clear();
        } else {
            instance.setTimeInMillis(calendar.getTimeInMillis());
        }
        return instance;
    }

    /* renamed from: b */
    static Calendar m27293b(Calendar calendar) {
        Calendar a = m27287a(calendar);
        Calendar c = m27295c();
        c.set(a.get(1), a.get(2), a.get(5));
        return c;
    }

    /* renamed from: a */
    static long m27281a(long j) {
        Calendar c = m27295c();
        c.setTimeInMillis(j);
        return m27293b(c).getTimeInMillis();
    }

    /* renamed from: a */
    private static DateFormat m27282a(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(m27304h());
        return instanceForSkeleton;
    }

    /* renamed from: a */
    private static java.text.DateFormat m27285a(int i, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i, locale);
        dateInstance.setTimeZone(m27303g());
        return dateInstance;
    }

    /* renamed from: a */
    static SimpleDateFormat m27286a(String str) {
        return m27291b(str, RFusion.getLocale());
    }

    /* renamed from: b */
    private static SimpleDateFormat m27291b(String str, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(m27303g());
        return simpleDateFormat;
    }

    /* renamed from: a */
    static DateFormat m27283a(Locale locale) {
        return m27282a("yMMMd", locale);
    }

    /* renamed from: b */
    static DateFormat m27289b(Locale locale) {
        return m27282a("MMMd", locale);
    }

    /* renamed from: c */
    static DateFormat m27294c(Locale locale) {
        return m27282a("MMMEd", locale);
    }

    /* renamed from: d */
    static DateFormat m27296d(Locale locale) {
        return m27282a("yMMMEd", locale);
    }

    /* renamed from: d */
    static java.text.DateFormat m27297d() {
        return m27299e(RFusion.getLocale());
    }

    /* renamed from: e */
    static java.text.DateFormat m27299e(Locale locale) {
        return m27285a(2, locale);
    }

    /* renamed from: e */
    static java.text.DateFormat m27298e() {
        return m27301f(RFusion.getLocale());
    }

    /* renamed from: f */
    static java.text.DateFormat m27301f(Locale locale) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) m27299e(locale);
        simpleDateFormat.applyPattern(m27290b(simpleDateFormat.toPattern()));
        return simpleDateFormat;
    }

    /* renamed from: f */
    static java.text.DateFormat m27300f() {
        return m27302g(RFusion.getLocale());
    }

    /* renamed from: g */
    static java.text.DateFormat m27302g(Locale locale) {
        return m27285a(0, locale);
    }

    /* renamed from: b */
    private static String m27290b(String str) {
        int a = m27280a(str, "yY", 1, 0);
        if (a >= str.length()) {
            return str;
        }
        String str2 = "EMd";
        int a2 = m27280a(str, str2, 1, a);
        if (a2 < str.length()) {
            str2 = str2 + ",";
        }
        return str.replace(str.substring(m27280a(str, str2, -1, a) + 1, a2), " ").trim();
    }

    /* renamed from: a */
    private static int m27280a(String str, String str2, int i, int i2) {
        while (i2 >= 0 && i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
            if (str.charAt(i2) == '\'') {
                do {
                    i2 += i;
                    if (i2 < 0) {
                        break;
                    } else if (i2 >= str.length()) {
                        break;
                    }
                } while (str.charAt(i2) == '\'');
            }
            i2 += i;
        }
        return i2;
    }
}
