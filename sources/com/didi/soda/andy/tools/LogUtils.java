package com.didi.soda.andy.tools;

import android.util.Log;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import org.osgi.framework.VersionRange;

public final class LogUtils {
    public static boolean S_OPEN_LOG = true;

    /* renamed from: a */
    static volatile long f41521a = System.currentTimeMillis();

    /* renamed from: b */
    static volatile int f41522b = 0;

    /* renamed from: c */
    private static final String f41523c = "_AndyTest_";

    private LogUtils() {
    }

    /* renamed from: d */
    public static void m31173d(String str, CharSequence charSequence) {
        m31174d(str, charSequence, 2);
    }

    /* renamed from: d */
    public static void m31175d(String str, CharSequence charSequence, Object... objArr) {
        m31174d(str, (CharSequence) charSequence.toString() + objArr, 2);
    }

    /* renamed from: d */
    public static void m31174d(String str, CharSequence charSequence, int i) {
        if (S_OPEN_LOG) {
            Log.d(str, m31169a(charSequence, new Throwable().getStackTrace()[i]));
        }
    }

    /* renamed from: d */
    public static void m31172d(CharSequence charSequence) {
        if (S_OPEN_LOG) {
            Log.d(f41523c, m31169a(charSequence, new Throwable().getStackTrace()[1]));
        }
    }

    /* renamed from: i */
    public static void m31180i(String str, CharSequence charSequence, int i) {
        if (S_OPEN_LOG) {
            Log.i(str, m31169a(charSequence, new Throwable().getStackTrace()[i]));
        }
    }

    /* renamed from: i */
    public static void m31179i(String str, CharSequence charSequence) {
        m31180i(str, charSequence, 2);
    }

    /* renamed from: v */
    public static void m31183v(String str, CharSequence charSequence, int i) {
        if (S_OPEN_LOG) {
            Log.v(str, m31169a(charSequence, new Throwable().getStackTrace()[i]));
        }
    }

    /* renamed from: v */
    public static void m31182v(String str, CharSequence charSequence) {
        m31183v(str, charSequence, 2);
    }

    /* renamed from: w */
    public static void m31184w(String str, CharSequence charSequence) {
        if (S_OPEN_LOG) {
            Log.w(str, m31170a(str, charSequence, new Throwable().getStackTrace()[1]));
        }
    }

    /* renamed from: e */
    public static void m31178e(String str, Throwable th) {
        if (S_OPEN_LOG) {
            Log.e(str, m31171a(str, "", new Throwable().getStackTrace()[1], th), th);
        }
    }

    /* renamed from: e */
    public static void m31176e(String str, CharSequence charSequence) {
        if (S_OPEN_LOG) {
            Log.e(str, m31170a(str, charSequence, new Throwable().getStackTrace()[1]));
        }
    }

    /* renamed from: e */
    public static void m31177e(String str, CharSequence charSequence, Throwable th) {
        if (S_OPEN_LOG) {
            Log.d(str, m31170a(str, charSequence, new Throwable().getStackTrace()[1]), th);
        }
    }

    /* renamed from: t */
    public static void m31181t(String str, CharSequence charSequence) {
        if (S_OPEN_LOG) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            StringBuilder sb = new StringBuilder();
            if (stackTrace.length > 0) {
                sb.append(m31169a(charSequence, stackTrace[1]));
                sb.append(10);
            } else {
                sb.append(charSequence);
            }
            for (int i = 2; i < stackTrace.length; i++) {
                sb.append(stackTrace[i]);
                sb.append(10);
            }
            Log.i(str, sb.toString());
        }
    }

    public static void timeSinceLast() {
        StringBuilder sb = new StringBuilder();
        sb.append("⚠️");
        int i = f41522b;
        f41522b = i + 1;
        sb.append(i);
        sb.append("spend:");
        sb.append(System.currentTimeMillis() - f41521a);
        sb.append(" ");
        m31174d(f41523c, (CharSequence) sb.toString(), 2);
        f41521a = System.currentTimeMillis();
    }

    public static String getLineText(String str, int i) {
        return S_OPEN_LOG ? m31169a(str, new Throwable().getStackTrace()[i]) : str;
    }

    public static String getLineText(String str) {
        return S_OPEN_LOG ? m31169a(str, new Throwable().getStackTrace()[1]) : str;
    }

    /* renamed from: a */
    private static String m31169a(CharSequence charSequence, StackTraceElement stackTraceElement) {
        StringBuilder sb = new StringBuilder();
        sb.append(Const.jaLeft);
        sb.append(Thread.currentThread().getId());
        sb.append(Const.jaRight);
        if (stackTraceElement.isNativeMethod()) {
            sb.append("(Native Method)");
        } else {
            String fileName = stackTraceElement.getFileName();
            if (fileName == null) {
                sb.append("(Unknown Source)");
            } else {
                int lineNumber = stackTraceElement.getLineNumber();
                sb.append(VersionRange.LEFT_OPEN);
                sb.append(fileName);
                if (lineNumber >= 0) {
                    sb.append(':');
                    sb.append(lineNumber);
                }
                sb.append("):");
            }
        }
        sb.append(charSequence);
        return sb.toString();
    }

    /* renamed from: a */
    private static String m31170a(String str, CharSequence charSequence, StackTraceElement stackTraceElement) {
        return Const.jaLeft + str + Const.jaRight + m31169a(charSequence, stackTraceElement);
    }

    /* renamed from: a */
    private static String m31171a(String str, CharSequence charSequence, StackTraceElement stackTraceElement, Throwable th) {
        return Const.jaLeft + str + Const.jaRight + stackTraceElement.toString() + ":" + charSequence + "\r\n" + "e:" + th.getMessage();
    }
}
