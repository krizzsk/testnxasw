package com.didi.rfusion.widget.calendar;

import android.content.Context;
import android.icu.text.DateIntervalFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.text.format.DateFormat;
import androidx.core.util.Pair;
import com.didi.rfusion.RFusion;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.didi.rfusion.widget.calendar.a */
/* compiled from: DateStrings */
class C12364a {

    /* renamed from: a */
    private static final String f36230a = "yMMMM";

    private C12364a() {
    }

    /* renamed from: a */
    static String m27251a(Context context, long j) {
        if (Build.VERSION.SDK_INT >= 24) {
            DateIntervalFormat instance = DateIntervalFormat.getInstance(f36230a, RFusion.getLocale());
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(j);
            return instance.format(instance2, instance2, new StringBuffer(), new FieldPosition(0)).toString();
        } else if (Build.VERSION.SDK_INT >= 18) {
            return new SimpleDateFormat(DateFormat.getBestDateTimePattern(RFusion.getLocale(), f36230a), RFusion.getLocale()).format(new Date(j));
        } else {
            return DateFormat.getDateFormat(context).format(new Date(j));
        }
    }

    /* renamed from: a */
    static String m27248a(long j) {
        return m27250a(j, RFusion.getLocale());
    }

    /* renamed from: a */
    static String m27250a(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return C12368e.m27283a(locale).format(new Date(j));
        }
        return C12368e.m27299e(locale).format(new Date(j));
    }

    /* renamed from: b */
    static String m27252b(long j) {
        return m27253b(j, RFusion.getLocale());
    }

    /* renamed from: b */
    static String m27253b(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return C12368e.m27289b(locale).format(new Date(j));
        }
        return C12368e.m27301f(locale).format(new Date(j));
    }

    /* renamed from: c */
    static String m27254c(long j) {
        return m27255c(j, RFusion.getLocale());
    }

    /* renamed from: c */
    static String m27255c(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return C12368e.m27294c(locale).format(new Date(j));
        }
        return C12368e.m27302g(locale).format(new Date(j));
    }

    /* renamed from: d */
    static String m27256d(long j) {
        return m27257d(j, RFusion.getLocale());
    }

    /* renamed from: d */
    static String m27257d(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return C12368e.m27296d(locale).format(new Date(j));
        }
        return C12368e.m27302g(locale).format(new Date(j));
    }

    /* renamed from: e */
    static String m27258e(long j) {
        return m27249a(j, (SimpleDateFormat) null);
    }

    /* renamed from: a */
    static String m27249a(long j, SimpleDateFormat simpleDateFormat) {
        java.util.Calendar b = C12368e.m27292b();
        java.util.Calendar c = C12368e.m27295c();
        c.setTimeInMillis(j);
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j));
        }
        if (b.get(1) == c.get(1)) {
            return m27252b(j);
        }
        return m27248a(j);
    }

    /* renamed from: a */
    static Pair<String, String> m27246a(Long l, Long l2) {
        return m27247a(l, l2, (SimpleDateFormat) null);
    }

    /* renamed from: a */
    static Pair<String, String> m27247a(Long l, Long l2, SimpleDateFormat simpleDateFormat) {
        if (l == null && l2 == null) {
            return Pair.create(null, null);
        }
        if (l == null) {
            return Pair.create(null, m27249a(l2.longValue(), simpleDateFormat));
        }
        if (l2 == null) {
            return Pair.create(m27249a(l.longValue(), simpleDateFormat), null);
        }
        java.util.Calendar b = C12368e.m27292b();
        java.util.Calendar c = C12368e.m27295c();
        c.setTimeInMillis(l.longValue());
        java.util.Calendar c2 = C12368e.m27295c();
        c2.setTimeInMillis(l2.longValue());
        if (simpleDateFormat != null) {
            return Pair.create(simpleDateFormat.format(new Date(l.longValue())), simpleDateFormat.format(new Date(l2.longValue())));
        } else if (c.get(1) != c2.get(1)) {
            return Pair.create(m27250a(l.longValue(), RFusion.getLocale()), m27250a(l2.longValue(), RFusion.getLocale()));
        } else {
            if (c.get(1) == b.get(1)) {
                return Pair.create(m27253b(l.longValue(), RFusion.getLocale()), m27253b(l2.longValue(), RFusion.getLocale()));
            }
            return Pair.create(m27253b(l.longValue(), RFusion.getLocale()), m27250a(l2.longValue(), RFusion.getLocale()));
        }
    }
}
