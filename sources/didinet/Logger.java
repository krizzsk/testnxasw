package didinet;

import android.content.Context;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;
import utils.ContextUtil;
import utils.FileUtil;

public final class Logger {

    /* renamed from: a */
    private static final String f59846a = "didihttp";

    /* renamed from: b */
    private static int f59847b = 2;

    /* renamed from: c */
    private static final String f59848c = "loglevel.txt";

    private Logger() {
        throw new RuntimeException();
    }

    /* renamed from: v */
    public static int m45053v(String str, String str2) {
        if (f59847b > 2) {
            return 0;
        }
        return SystemUtils.log(2, str, str2, (Throwable) null, "didinet.Logger", 32);
    }

    /* renamed from: v */
    public static int m45054v(String str, String str2, Throwable th) {
        if (f59847b > 2) {
            return 0;
        }
        return SystemUtils.log(2, str, str2, th, "didinet.Logger", 45);
    }

    /* renamed from: d */
    public static int m45047d(String str, String str2) {
        if (f59847b > 3) {
            return 0;
        }
        return SystemUtils.log(3, str, str2, (Throwable) null, "didinet.Logger", 57);
    }

    /* renamed from: d */
    public static int m45048d(String str, String str2, Throwable th) {
        if (f59847b > 3) {
            return 0;
        }
        return SystemUtils.log(3, str, str2, th, "didinet.Logger", 70);
    }

    /* renamed from: i */
    public static int m45051i(String str, String str2) {
        if (f59847b > 4) {
            return 0;
        }
        return SystemUtils.log(4, str, str2, (Throwable) null, "didinet.Logger", 82);
    }

    /* renamed from: i */
    public static int m45052i(String str, String str2, Throwable th) {
        if (f59847b > 4) {
            return 0;
        }
        return SystemUtils.log(4, str, str2, th, "didinet.Logger", 95);
    }

    /* renamed from: w */
    public static int m45055w(String str, String str2) {
        if (f59847b > 5) {
            return 0;
        }
        return SystemUtils.log(5, str, str2, (Throwable) null, "didinet.Logger", 107);
    }

    /* renamed from: w */
    public static int m45056w(String str, String str2, Throwable th) {
        if (f59847b > 5) {
            return 0;
        }
        return SystemUtils.log(5, str, str2, th, "didinet.Logger", 120);
    }

    /* renamed from: w */
    public static int m45057w(String str, Throwable th) {
        if (f59847b > 5) {
            return 0;
        }
        return Log.w(str, th);
    }

    /* renamed from: e */
    public static int m45049e(String str, String str2) {
        if (f59847b > 6) {
            return 0;
        }
        return SystemUtils.log(6, str, str2, (Throwable) null, "didinet.Logger", 143);
    }

    /* renamed from: e */
    public static int m45050e(String str, String str2, Throwable th) {
        if (f59847b > 6) {
            return 0;
        }
        return SystemUtils.log(6, str, str2, th, "didinet.Logger", 156);
    }

    public static void logClassAndMethod(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj.hashCode());
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        if (!(stackTrace == null || stackTrace.length < 2 || stackTrace[1] == null)) {
            sb.append("|");
            sb.append(stackTrace[1].getMethodName());
        }
        m45047d(obj.getClass().getSimpleName(), sb.toString());
    }

    public static void setLevel(int i) {
        if (m45046b()) {
            f59847b = 2;
        } else {
            f59847b = i;
        }
    }

    /* renamed from: b */
    private static boolean m45046b() {
        Context applicationContext = ContextUtil.getApplicationContext();
        if (applicationContext != null && new File(applicationContext.getExternalFilesDir((String) null), f59848c).exists()) {
            return true;
        }
        return false;
    }

    @Deprecated
    /* renamed from: a */
    static boolean m45045a() {
        Context applicationContext = ContextUtil.getApplicationContext();
        if (applicationContext == null) {
            return false;
        }
        return FileUtil.createOrExistFile(new File(applicationContext.getExternalFilesDir((String) null), f59848c));
    }
}
