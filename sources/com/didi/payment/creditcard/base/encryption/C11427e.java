package com.didi.payment.creditcard.base.encryption;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: com.didi.payment.creditcard.base.encryption.e */
/* compiled from: ConvertUtils */
abstract class C11427e {

    /* renamed from: a */
    private static final DecimalFormat f32756a = new DecimalFormat("####");

    /* renamed from: a */
    public static final boolean m24833a(Object obj) {
        if (obj != null) {
            return Boolean.valueOf(obj.toString()).booleanValue();
        }
        return false;
    }

    /* renamed from: b */
    public static final int m24834b(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        if (obj == null) {
            return -1;
        }
        try {
            return Integer.parseInt(obj.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* renamed from: c */
    public static final short m24844c(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).shortValue();
        }
        if (obj == null) {
            return -1;
        }
        try {
            return Short.parseShort(obj.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* renamed from: d */
    public static final double m24845d(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        if (obj == null) {
            return -1.0d;
        }
        try {
            return Double.parseDouble(obj.toString());
        } catch (NumberFormatException unused) {
            return -1.0d;
        }
    }

    /* renamed from: e */
    public static final long m24848e(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        if (obj == null) {
            return -1;
        }
        try {
            return Long.parseLong(obj.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* renamed from: a */
    public static final String m24824a(Object obj, DecimalFormat decimalFormat) {
        decimalFormat.setDecimalSeparatorAlwaysShown(false);
        if (obj instanceof Double) {
            return decimalFormat.format(((Double) obj).doubleValue());
        }
        if (obj instanceof Long) {
            return decimalFormat.format(((Long) obj).longValue());
        }
        return obj.toString();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:3|4|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        return java.lang.Double.valueOf(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        return r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0005 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m24822a(java.lang.String r0) {
        /*
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ NumberFormatException -> 0x0005 }
            return r0
        L_0x0005:
            java.lang.Double r0 = java.lang.Double.valueOf(r0)     // Catch:{ NumberFormatException -> 0x0009 }
        L_0x0009:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.creditcard.base.encryption.C11427e.m24822a(java.lang.String):java.lang.Object");
    }

    /* renamed from: a */
    public static String m24823a(long j) {
        return f32756a.format(j);
    }

    /* renamed from: a */
    public static String m24828a(byte[] bArr) {
        return m24838b(bArr);
    }

    /* renamed from: b */
    public static String m24838b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            byte b2 = b & 255;
            if (b2 < 16) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Integer.toString(b2, 16));
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    public static byte[] m24840b(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            bArr[i] = (byte) Integer.parseInt(str.substring(i * 2, i2 * 2), 16);
            i = i2;
        }
        return bArr;
    }

    /* renamed from: a */
    public static String m24825a(String str, String str2) throws UnsupportedEncodingException {
        if (str != null) {
            return m24838b(str.getBytes(str2));
        }
        return null;
    }

    /* renamed from: c */
    public static String m24842c(String str) {
        try {
            return m24825a(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new IllegalStateException("UTF-8 encoding is not supported by JVM");
        }
    }

    /* renamed from: b */
    public static String m24835b(String str, String str2) throws UnsupportedEncodingException {
        if (str != null) {
            return new String(m24840b(str), str2);
        }
        return null;
    }

    /* renamed from: d */
    public static String m24846d(String str) {
        try {
            return m24835b(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new IllegalStateException("UTF-8 encoding is not supported by JVM");
        }
    }

    /* renamed from: a */
    public static String m24827a(TimeZone timeZone) {
        return m24837b(timeZone);
    }

    /* renamed from: e */
    public static TimeZone m24850e(String str) {
        return m24851f(str);
    }

    /* renamed from: b */
    public static String m24837b(TimeZone timeZone) {
        return timeZone != null ? timeZone.getID() : "";
    }

    /* renamed from: f */
    public static TimeZone m24851f(String str) {
        if (str == null) {
            str = "";
        }
        return TimeZone.getTimeZone(str);
    }

    /* renamed from: a */
    public static String m24826a(Locale locale) {
        return m24836b(locale);
    }

    /* renamed from: g */
    public static Locale m24852g(String str) {
        return m24853h(str);
    }

    /* renamed from: b */
    public static String m24836b(Locale locale) {
        return locale != null ? locale.toString() : "";
    }

    /* renamed from: h */
    public static Locale m24853h(String str) {
        String trim = str != null ? str.trim() : "";
        if (trim.equals("")) {
            return new Locale("", "", "");
        }
        int indexOf = trim.indexOf(95);
        if (indexOf == -1) {
            return new Locale(trim, "", "");
        }
        String substring = trim.substring(0, indexOf);
        String substring2 = trim.substring(indexOf + 1);
        int indexOf2 = substring2.indexOf(95);
        if (indexOf2 == -1) {
            return new Locale(substring, substring2, "");
        }
        return new Locale(substring, substring2.substring(0, indexOf2), substring2.substring(indexOf2 + 1));
    }

    /* renamed from: a */
    public static Date m24829a(java.util.Date date) {
        if (date != null) {
            return new Date(date.getTime());
        }
        return null;
    }

    /* renamed from: b */
    public static Time m24839b(java.util.Date date) {
        if (date != null) {
            return new Time(date.getTime());
        }
        return null;
    }

    /* renamed from: c */
    public static Timestamp m24843c(java.util.Date date) {
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    /* renamed from: a */
    public static java.util.Date m24832a(Timestamp timestamp) {
        if (timestamp != null) {
            return new java.util.Date(Math.round(((double) timestamp.getTime()) + (((double) timestamp.getNanos()) / 1000000.0d)));
        }
        return null;
    }

    /* renamed from: a */
    public static Timestamp m24830a() {
        Calendar instance = Calendar.getInstance();
        instance.set(instance.get(1), instance.get(2), instance.get(5), 0, 0, 0);
        Timestamp timestamp = new Timestamp(instance.getTime().getTime());
        timestamp.setNanos(0);
        return timestamp;
    }

    /* renamed from: a */
    public static java.util.Date m24831a(int i, int i2, int i3, boolean z) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        if (instance.getActualMinimum(1) > i || i > instance.getActualMaximum(1)) {
            return null;
        }
        instance.set(1, i);
        if (instance.getActualMinimum(2) <= i2 && i2 <= instance.getActualMaximum(2)) {
            instance.set(2, i2);
            if (instance.getActualMinimum(5) <= i3 && i3 <= instance.getActualMaximum(5)) {
                instance.set(5, i3);
            }
        }
        if (z) {
            instance.add(5, 1);
            instance.add(14, -1);
        }
        return instance.getTime();
    }

    /* renamed from: d */
    public static java.util.Date m24847d(java.util.Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.clear();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.setTime(date);
        gregorianCalendar.set(5, gregorianCalendar2.get(5));
        gregorianCalendar.set(2, gregorianCalendar2.get(2));
        gregorianCalendar.set(1, gregorianCalendar2.get(1));
        return gregorianCalendar.getTime();
    }

    /* renamed from: e */
    public static java.util.Date m24849e(java.util.Date date) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date);
        instance.set(5, instance2.get(5));
        instance.set(2, instance2.get(2));
        instance.set(1, instance2.get(1));
        instance.add(5, 1);
        instance.add(14, -1);
        return instance.getTime();
    }

    /* renamed from: a */
    public static double m24821a(double d, int i) {
        double pow = Math.pow(10.0d, (double) i);
        return ((double) Math.round(d * pow)) / pow;
    }

    /* renamed from: c */
    public static Object m24841c(String str, String str2) throws Exception {
        String lowerCase = str.toLowerCase();
        if (TypedValues.Custom.S_BOOLEAN.equals(lowerCase)) {
            return Boolean.valueOf(str2);
        }
        if ("byte".equals(lowerCase)) {
            return Byte.valueOf(str2);
        }
        if ("short".equals(lowerCase)) {
            return Short.valueOf(str2);
        }
        if ("char".equals(lowerCase)) {
            if (str2.length() == 1) {
                return Character.valueOf(str2.toCharArray()[0]);
            }
            throw new NumberFormatException("Argument is not a character!");
        } else if ("int".equals(lowerCase)) {
            return Integer.valueOf(str2);
        } else {
            if ("long".equals(lowerCase)) {
                return Long.valueOf(str2);
            }
            if ("float".equals(lowerCase)) {
                return Float.valueOf(str2);
            }
            if ("double".equals(lowerCase)) {
                return Double.valueOf(str2);
            }
            if (TypedValues.Custom.S_STRING.equals(lowerCase)) {
                return str2;
            }
            return Class.forName(lowerCase).getConstructor(new Class[]{String.class}).newInstance(new String[]{str2});
        }
    }

    private C11427e() {
    }
}
