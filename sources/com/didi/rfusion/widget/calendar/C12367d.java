package com.didi.rfusion.widget.calendar;

import java.util.Calendar;
import java.util.TimeZone;

/* renamed from: com.didi.rfusion.widget.calendar.d */
/* compiled from: TimeSource */
class C12367d {

    /* renamed from: a */
    private static final C12367d f36242a = new C12367d((Long) null, (TimeZone) null);

    /* renamed from: b */
    private final Long f36243b;

    /* renamed from: c */
    private final TimeZone f36244c;

    private C12367d(Long l, TimeZone timeZone) {
        this.f36243b = l;
        this.f36244c = timeZone;
    }

    /* renamed from: a */
    static C12367d m27275a() {
        return f36242a;
    }

    /* renamed from: a */
    static C12367d m27277a(long j, TimeZone timeZone) {
        return new C12367d(Long.valueOf(j), timeZone);
    }

    /* renamed from: a */
    static C12367d m27276a(long j) {
        return new C12367d(Long.valueOf(j), (TimeZone) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Calendar mo94106b() {
        return mo94105a(this.f36244c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Calendar mo94105a(TimeZone timeZone) {
        Calendar instance = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l = this.f36243b;
        if (l != null) {
            instance.setTimeInMillis(l.longValue());
        }
        return instance;
    }
}
