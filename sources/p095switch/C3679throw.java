package p095switch;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: switch.throw */
/* compiled from: Utils */
public class C3679throw {

    /* renamed from: a */
    private static final Handler f8795a = new Handler(Looper.getMainLooper());

    /* renamed from: do */
    public static int m7437do(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    /* renamed from: do */
    public static <T> T m7439do(T t, T t2) {
        return t != null ? t : t2;
    }

    /* renamed from: if */
    public static String m7444if(Context context) {
        try {
            return SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    /* renamed from: do */
    public static double m7436do(double d, double d2, double d3) {
        return Math.max(d2, Math.min(d3, d));
    }

    /* renamed from: do */
    public static void m7442do(Runnable runnable) {
        f8795a.post(runnable);
    }

    /* renamed from: do */
    public static void m7441do(long j, Runnable runnable) {
        f8795a.postDelayed(runnable, j);
    }

    /* renamed from: do */
    public static boolean m7443do(String str) {
        return str == null || str.isEmpty();
    }

    /* renamed from: do */
    public static String m7440do(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }

    /* renamed from: do */
    public static int m7438do(Context context) {
        try {
            return SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }
}
