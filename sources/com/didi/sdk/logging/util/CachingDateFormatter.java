package com.didi.sdk.logging.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class CachingDateFormatter {

    /* renamed from: a */
    private long f39417a;

    /* renamed from: b */
    private String f39418b;

    /* renamed from: c */
    private final SimpleDateFormat f39419c;

    public CachingDateFormatter(String str) {
        this(str, Locale.getDefault());
    }

    public CachingDateFormatter(String str, Locale locale) {
        this.f39417a = -1;
        this.f39418b = null;
        this.f39419c = new SimpleDateFormat(str, locale);
    }

    public final String format(long j) {
        String str;
        synchronized (this) {
            if (j != this.f39417a) {
                this.f39417a = j;
                this.f39418b = this.f39419c.format(new Date(j));
            }
            str = this.f39418b;
        }
        return str;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.f39419c.setTimeZone(timeZone);
    }
}
