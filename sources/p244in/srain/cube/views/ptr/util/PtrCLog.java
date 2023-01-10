package p244in.srain.cube.views.ptr.util;

import android.util.Log;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: in.srain.cube.views.ptr.util.PtrCLog */
public class PtrCLog {
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_FATAL = 5;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    private static int sLevel;

    public static void setLogLevel(int i) {
        sLevel = i;
    }

    /* renamed from: v */
    public static void m45245v(String str, String str2) {
        if (sLevel <= 0) {
            SystemUtils.log(2, str, str2, (Throwable) null, "in.srain.cube.views.ptr.util.PtrCLog", 40);
        }
    }

    /* renamed from: v */
    public static void m45246v(String str, String str2, Throwable th) {
        if (sLevel <= 0) {
            SystemUtils.log(2, str, str2, th, "in.srain.cube.views.ptr.util.PtrCLog", 54);
        }
    }

    /* renamed from: v */
    public static void m45247v(String str, String str2, Object... objArr) {
        if (sLevel <= 0) {
            if (objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            SystemUtils.log(2, str, str2, (Throwable) null, "in.srain.cube.views.ptr.util.PtrCLog", 71);
        }
    }

    /* renamed from: d */
    public static void m45233d(String str, String str2) {
        if (sLevel <= 1) {
            SystemUtils.log(3, str, str2, (Throwable) null, "in.srain.cube.views.ptr.util.PtrCLog", 84);
        }
    }

    /* renamed from: d */
    public static void m45235d(String str, String str2, Object... objArr) {
        if (sLevel <= 1) {
            if (objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            SystemUtils.log(3, str, str2, (Throwable) null, "in.srain.cube.views.ptr.util.PtrCLog", 101);
        }
    }

    /* renamed from: d */
    public static void m45234d(String str, String str2, Throwable th) {
        if (sLevel <= 1) {
            SystemUtils.log(3, str, str2, th, "in.srain.cube.views.ptr.util.PtrCLog", 115);
        }
    }

    /* renamed from: i */
    public static void m45242i(String str, String str2) {
        if (sLevel <= 2) {
            SystemUtils.log(4, str, str2, (Throwable) null, "in.srain.cube.views.ptr.util.PtrCLog", 128);
        }
    }

    /* renamed from: i */
    public static void m45244i(String str, String str2, Object... objArr) {
        if (sLevel <= 2) {
            if (objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            SystemUtils.log(4, str, str2, (Throwable) null, "in.srain.cube.views.ptr.util.PtrCLog", 145);
        }
    }

    /* renamed from: i */
    public static void m45243i(String str, String str2, Throwable th) {
        if (sLevel <= 2) {
            SystemUtils.log(4, str, str2, th, "in.srain.cube.views.ptr.util.PtrCLog", 158);
        }
    }

    /* renamed from: w */
    public static void m45248w(String str, String str2) {
        if (sLevel <= 3) {
            SystemUtils.log(5, str, str2, (Throwable) null, "in.srain.cube.views.ptr.util.PtrCLog", 171);
        }
    }

    /* renamed from: w */
    public static void m45250w(String str, String str2, Object... objArr) {
        if (sLevel <= 3) {
            if (objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            SystemUtils.log(5, str, str2, (Throwable) null, "in.srain.cube.views.ptr.util.PtrCLog", 188);
        }
    }

    /* renamed from: w */
    public static void m45249w(String str, String str2, Throwable th) {
        if (sLevel <= 3) {
            SystemUtils.log(5, str, str2, th, "in.srain.cube.views.ptr.util.PtrCLog", 202);
        }
    }

    /* renamed from: e */
    public static void m45236e(String str, String str2) {
        if (sLevel <= 4) {
            SystemUtils.log(6, str, str2, (Throwable) null, "in.srain.cube.views.ptr.util.PtrCLog", 215);
        }
    }

    /* renamed from: e */
    public static void m45238e(String str, String str2, Object... objArr) {
        if (sLevel <= 4) {
            if (objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            SystemUtils.log(6, str, str2, (Throwable) null, "in.srain.cube.views.ptr.util.PtrCLog", 232);
        }
    }

    /* renamed from: e */
    public static void m45237e(String str, String str2, Throwable th) {
        if (sLevel <= 4) {
            SystemUtils.log(6, str, str2, th, "in.srain.cube.views.ptr.util.PtrCLog", 246);
        }
    }

    /* renamed from: f */
    public static void m45239f(String str, String str2) {
        if (sLevel <= 5) {
            Log.wtf(str, str2);
        }
    }

    /* renamed from: f */
    public static void m45241f(String str, String str2, Object... objArr) {
        if (sLevel <= 5) {
            if (objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            Log.wtf(str, str2);
        }
    }

    /* renamed from: f */
    public static void m45240f(String str, String str2, Throwable th) {
        if (sLevel <= 5) {
            Log.wtf(str, str2, th);
        }
    }
}
