package com.threatmetrix.TrustDefender;

import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class yyyyqy {
    private static final boolean b007000700070ppp = false;
    private static final int b0070p0070ppp = 23;
    private static boolean b0070pp0070pp = false;
    private static final String bp00700070ppp = "TrustDefender";
    private static final Pattern bppp0070pp = Pattern.compile("\\{\\}");

    public static class qyyyqy {
        private qyyyqy() {
        }

        public static void b0074007400740074tt(String str, String str2) {
        }

        public static void b007400740074ttt(String str, String str2, Object obj) {
            bt00740074ttt(str, yyyyqy.b0074tt00740074t(str2, obj));
        }

        public static void b00740074t0074tt(String str, String str2) {
        }

        public static void b00740074tt0074t(String str, String str2) {
        }

        public static void b00740074tttt(String str, String str2, Object obj) {
            bt0074tttt(str, yyyyqy.b0074tt00740074t(str2, obj));
        }

        public static void b0074t00740074tt(String str, String str2, Object obj, Object obj2) {
            b00740074t0074tt(str, yyyyqy.b0074tt00740074t(str2, obj, obj2));
        }

        public static void b0074t0074t0074t(String str, String str2, Object obj, Object obj2) {
            b00740074tt0074t(str, yyyyqy.b0074tt00740074t(str2, obj, obj2));
        }

        public static void b0074t0074ttt(String str, String str2, Throwable th) {
        }

        public static void b0074tt0074tt(String str, String str2, Throwable th) {
        }

        public static void b0074ttt0074t(String str, String str2, Object obj, Object obj2) {
            b0074007400740074tt(str, yyyyqy.b0074tt00740074t(str2, obj, obj2));
        }

        public static void bt007400740074tt(String str, String str2, Throwable th) {
        }

        public static void bt00740074t0074t(String str, String str2, Throwable th) {
        }

        public static void bt00740074ttt(String str, String str2) {
        }

        @Nonnull
        private static String bt0074t0074tt(String str) {
            return str + ".DEV";
        }

        public static void bt0074tt0074t(String str, String str2, Throwable th) {
        }

        public static void bt0074tttt(String str, String str2) {
        }

        public static void btt00740074tt(String str, String str2, Object obj) {
            b00740074t0074tt(str, yyyyqy.b0074tt00740074t(str2, obj));
        }

        public static void btt0074t0074t(String str, String str2, Object obj) {
            b00740074tt0074t(str, yyyyqy.b0074tt00740074t(str2, obj));
        }

        public static void btt0074ttt(String str, String str2, Object obj, Object obj2) {
            bt0074tttt(str, yyyyqy.b0074tt00740074t(str2, obj, obj2));
        }

        public static void bttt0074tt(String str, String str2, Object obj, Object obj2) {
            bt00740074ttt(str, yyyyqy.b0074tt00740074t(str2, obj, obj2));
        }

        public static void btttt0074t(String str, String str2, Object obj) {
            b0074007400740074tt(str, yyyyqy.b0074tt00740074t(str2, obj));
        }
    }

    private yyyyqy() {
    }

    public static void b00740074007400740074t(String str, String str2, Throwable th) {
        if (bt0074ttt0074(str, 4)) {
            SystemUtils.log(4, str, str2, th, "com.threatmetrix.TrustDefender.yyyyqy", -1);
        }
    }

    public static boolean b007400740074t0074t() {
        return !b0070pp0070pp;
    }

    public static void b007400740074tt0074(String str, String str2) {
        SystemUtils.log(5, str, "Unexpected ERROR: " + str2, (Throwable) null, "com.threatmetrix.TrustDefender.yyyyqy", -1);
    }

    public static void b00740074t00740074t(String str, String str2, Throwable th) {
        if (Log.isLoggable(str, 6)) {
            SystemUtils.log(6, str, str2, th, "com.threatmetrix.TrustDefender.yyyyqy", -1);
        }
    }

    public static void b00740074ttt0074(boolean z) {
        b0070pp0070pp = z;
    }

    @Nonnull
    public static String b0074t007400740074t(@Nonnull Class cls) {
        String str = "c.t.tdm." + cls.getSimpleName();
        return str.length() > 23 ? str.substring(0, 23) : str;
    }

    public static void b0074t0074tt0074(String str, String str2, Throwable th) {
        if (bt0074ttt0074(str, 5)) {
            SystemUtils.log(5, str, str2, th, "com.threatmetrix.TrustDefender.yyyyqy", -1);
        }
    }

    public static String b0074tt00740074t(@Nullable String str, @Nullable Object... objArr) {
        if (str == null || objArr == null) {
            return "";
        }
        Matcher matcher = bppp0070pp.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            Object obj = objArr[i];
            if (matcher.find()) {
                matcher.appendReplacement(stringBuffer, obj != null ? String.valueOf(obj) : "null");
                i++;
            } else {
                throw new InvalidParameterException("Incorrect number of arguments for this format string");
            }
        }
        if (!matcher.find()) {
            return matcher.appendTail(stringBuffer).toString();
        }
        throw new InvalidParameterException("Incorrect number of arguments for this format string");
    }

    public static boolean b0074tttt0074() {
        return false;
    }

    public static void bt0074007400740074t(String str, String str2) {
        if (bt0074ttt0074(str, 4)) {
            SystemUtils.log(4, str, str2, (Throwable) null, "com.threatmetrix.TrustDefender.yyyyqy", -1);
        }
    }

    public static void bt00740074tt0074(String str, String str2, String... strArr) {
        btt0074tt0074(str, b0074tt00740074t(str2, (Object[]) strArr));
    }

    public static void bt0074t00740074t(String str, String str2) {
        if (Log.isLoggable(str, 6)) {
            SystemUtils.log(6, str, str2, (Throwable) null, "com.threatmetrix.TrustDefender.yyyyqy", -1);
        }
    }

    private static boolean bt0074ttt0074(String str, int i) {
        return !b0070pp0070pp && Log.isLoggable(str, i);
    }

    public static void btt007400740074t(String str, String str2, String... strArr) {
        bt0074t00740074t(str, b0074tt00740074t(str2, (Object[]) strArr));
    }

    public static void btt0074tt0074(String str, String str2) {
        if (bt0074ttt0074(str, 5)) {
            SystemUtils.log(5, str, str2, (Throwable) null, "com.threatmetrix.TrustDefender.yyyyqy", -1);
        }
    }

    public static boolean bttt00740074t() {
        qqqyqy bg00670067g0067g;
        boolean z;
        if (bt0074ttt0074(bp00700070ppp, 2)) {
            bg00670067g0067g = qqqyqy.bg00670067g0067g();
            z = true;
        } else {
            bg00670067g0067g = qqqyqy.bg00670067g0067g();
            z = false;
        }
        bg00670067g0067g.b006700670067gg0067(z ? 1 : 0);
        return z;
    }

    public static void bttt0074t0074(String str, String str2, String... strArr) {
        SystemUtils.log(5, str, b0074tt00740074t("Unexpected ERROR: " + str2, (Object[]) strArr), (Throwable) null, "com.threatmetrix.TrustDefender.yyyyqy", -1);
    }

    public static void bttttt0074(String str, String str2, String... strArr) {
        if (bt0074ttt0074(str, 4)) {
            SystemUtils.log(4, str, b0074tt00740074t(str2, (Object[]) strArr), (Throwable) null, "com.threatmetrix.TrustDefender.yyyyqy", -1);
        }
    }
}
