package didihttp.internal.http;

import didihttp.internal.C21750Util;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class HttpDate {
    public static final long MAX_DATE = 253402300799999L;

    /* renamed from: a */
    private static final ThreadLocal<DateFormat> f59464a = new ThreadLocal<DateFormat>() {
        /* access modifiers changed from: protected */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(C21750Util.UTC);
            return simpleDateFormat;
        }
    };

    /* renamed from: b */
    private static final String[] f59465b;

    /* renamed from: c */
    private static final DateFormat[] f59466c;

    static {
        String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f59465b = strArr;
        f59466c = new DateFormat[strArr.length];
    }

    public static Date parse(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = f59464a.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        synchronized (f59465b) {
            int length = f59465b.length;
            for (int i = 0; i < length; i++) {
                DateFormat dateFormat = f59466c[i];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(f59465b[i], Locale.US);
                    dateFormat.setTimeZone(C21750Util.UTC);
                    f59466c[i] = dateFormat;
                }
                parsePosition.setIndex(0);
                Date parse2 = dateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse2;
                }
            }
            return null;
        }
    }

    public static String format(Date date) {
        return f59464a.get().format(date);
    }

    private HttpDate() {
    }
}
