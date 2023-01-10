package com.didichuxing.security.safecollector;

import android.content.Context;
import android.text.TextUtils;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class WsgSecInfo {

    /* renamed from: a */
    private static volatile Context f51559a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static int f51560b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static StringBuffer f51561c = new StringBuffer();

    /* renamed from: d */
    private static ExecutorService f51562d = Executors.newSingleThreadExecutor();

    /* renamed from: b */
    static /* synthetic */ int m38663b() {
        int i = f51560b;
        f51560b = i + 1;
        return i;
    }

    public static void init(Context context) {
        if (f51559a == null) {
            if (context != null) {
                f51559a = context.getApplicationContext();
                return;
            }
            throw new NullPointerException("context is null when init mysdk");
        }
    }

    public static void setsContext(Context context) {
        if (f51559a == null && context != null) {
            f51559a = context.getApplicationContext();
        }
    }

    public static String appName(Context context) {
        setsContext(context);
        return C17252f.m38708a(context);
    }

    public static String appName() {
        return appName(f51559a);
    }

    public static String packageName(Context context) {
        setsContext(context);
        m38662a("packageName", context);
        return C17252f.m38710b(context);
    }

    public static String packageName() {
        return packageName(f51559a);
    }

    public static int appVersionCode(Context context) {
        setsContext(context);
        return C17252f.m38711c(context);
    }

    public static int appVersionCode() {
        return appVersionCode(f51559a);
    }

    public static String appVersionName(Context context) {
        setsContext(context);
        return C17252f.m38714d(context);
    }

    public static String appVersionName() {
        return appVersionName(f51559a);
    }

    public static String appVersionIssue(Context context) {
        setsContext(context);
        return C17252f.m38716e(context);
    }

    public static String appVersionIssue() {
        return appVersionIssue(f51559a);
    }

    public static String osType(Context context) {
        return C17252f.m38707a();
    }

    public static String osType() {
        return osType(f51559a);
    }

    public static String osVersion(Context context) {
        setsContext(context);
        return C17252f.m38709b();
    }

    public static String osVersion() {
        return osVersion(f51559a);
    }

    public static String model(Context context) {
        setsContext(context);
        return C17252f.m38712c();
    }

    public static String model() {
        return model(f51559a);
    }

    public static String brand(Context context) {
        setsContext(context);
        return C17252f.m38713d();
    }

    public static String brand() {
        return brand(f51559a);
    }

    public static String cpu(Context context) {
        setsContext(context);
        m38662a("cpu", context);
        return C17252f.m38715e();
    }

    public static String cpu() {
        return cpu(f51559a);
    }

    public static String cpuSerialNo(Context context) {
        setsContext(context);
        m38662a("cpuSerialNo", context);
        return C17252f.m38717f();
    }

    public static String cpuSerialNo() {
        return cpuSerialNo(f51559a);
    }

    public static String pixels(Context context) {
        setsContext(context);
        return C17252f.m38718f(context);
    }

    public static String pixels() {
        return pixels(f51559a);
    }

    public static int screenHeight() {
        return C17252f.m38719g(f51559a);
    }

    public static int screenWidth() {
        return C17252f.m38721h(f51559a);
    }

    public static String totalSpace(Context context) {
        setsContext(context);
        return C17252f.m38720g();
    }

    public static String totalDisk() {
        setsContext(f51559a);
        return C17252f.m38724i(f51559a);
    }

    public static String totalSpace() {
        return totalSpace(f51559a);
    }

    public static String isRoot(Context context) {
        setsContext(context);
        return C17252f.m38723i();
    }

    public static boolean isRootBoolean(Context context) {
        setsContext(context);
        return C17252f.m38722h();
    }

    public static boolean isRoot() {
        return isRootBoolean(f51559a);
    }

    public static String androidId(Context context) {
        setsContext(context);
        m38662a("androidId", context);
        return C17252f.m38726j(context);
    }

    public static String androidId() {
        return androidId(f51559a);
    }

    public static String imsi(Context context) {
        setsContext(context);
        m38662a("imsi", context);
        return C17252f.m38728l(context);
    }

    public static String imsi() {
        return imsi(f51559a);
    }

    public static String customId(Context context) {
        setsContext(context);
        m38662a("customId", context);
        return C17252f.m38729m(context);
    }

    public static String customId() {
        return customId(f51559a);
    }

    public static String screenSize(Context context) {
        setsContext(context);
        return C17252f.m38731o(context);
    }

    public static String screenSize() {
        return screenSize(f51559a);
    }

    public static int emulatorType(Context context) {
        setsContext(context);
        return C17252f.m38732p(context);
    }

    public static int emulatorType() {
        return emulatorType(f51559a);
    }

    public static int utcOffset(Context context) {
        setsContext(context);
        m38662a("utcOffset", context);
        return C17252f.m38725j();
    }

    public static int utcOffset() {
        return utcOffset(f51559a);
    }

    public static String countryCode(Context context) {
        setsContext(context);
        m38662a("countryCode", context);
        return C17252f.m38733q(context);
    }

    public static String countryCode() {
        return countryCode(f51559a);
    }

    public static String locale(Context context) {
        setsContext(context);
        m38662a("locale", context);
        return C17250d.m38702f(context);
    }

    public static String locale() {
        return locale(f51559a);
    }

    public static String mcc(Context context) {
        setsContext(context);
        m38662a("mcc", context);
        return C17252f.m38735s(context);
    }

    public static String mcc() {
        return mcc(f51559a);
    }

    public static String mnc(Context context) {
        setsContext(context);
        m38662a("mnc", context);
        return C17252f.m38736t(context);
    }

    public static String mnc() {
        return mnc(f51559a);
    }

    public static String networkOperator(Context context) {
        setsContext(context);
        return C17252f.m38737u(context);
    }

    public static String networkOperator() {
        return networkOperator(f51559a);
    }

    public static String simCarrier(Context context) {
        setsContext(context);
        return C17252f.m38738v(context);
    }

    public static String simCarrier() {
        return simCarrier(f51559a);
    }

    public static String networkType(Context context) {
        setsContext(context);
        m38662a("networkType", context);
        return C17250d.m38695a(context);
    }

    public static String networkType() {
        return networkType(f51559a);
    }

    public static String localIp(Context context) {
        setsContext(context);
        m38662a("localIp", context);
        return C17250d.m38694a();
    }

    public static String localIp() {
        return localIp(f51559a);
    }

    public static String batteryLevel(Context context) {
        setsContext(context);
        m38662a("batteryLevel", context);
        return C17250d.m38697b(context);
    }

    public static String batteryLevel() {
        return batteryLevel(f51559a);
    }

    public static String phoneTime(Context context) {
        return C17250d.m38696b();
    }

    public static String phoneTime() {
        return phoneTime(f51559a);
    }

    public static long phoneTimeLong(Context context) {
        setsContext(context);
        return C17250d.m38698c();
    }

    public static long phoneTimeLong() {
        return phoneTimeLong(f51559a);
    }

    public static String isDebug(Context context) {
        setsContext(context);
        return C17250d.m38699c(context);
    }

    public static boolean isDebugBoolean(Context context) {
        setsContext(context);
        m38662a("isDebug", context);
        return C17250d.m38700d(context);
    }

    public static boolean isDebug() {
        return C17250d.m38700d(f51559a);
    }

    public static String isBackground(Context context) {
        setsContext(context);
        m38662a("isBackground", context);
        return C17250d.m38701e(context);
    }

    public static boolean isBackgroundBoolean(Context context) {
        setsContext(context);
        m38662a("isBackground", context);
        return C17250d.m38701e(context).equals("1");
    }

    public static boolean isBackground() {
        return isBackgroundBoolean(f51559a);
    }

    /* renamed from: a */
    private static void m38662a(final String str, final Context context) {
        try {
            final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            f51562d.submit(new Runnable() {
                public void run() {
                    HashMap hashMap = new HashMap();
                    hashMap.put("bundleid", C17252f.m38710b(context));
                    hashMap.put("caller", WsgSecInfo.m38664b(stackTrace));
                    hashMap.put("key", str);
                    hashMap.put("sdkversion", BuildConfig.VERSION_NAME);
                    hashMap.put("timestamp", C17250d.m38696b());
                    StringBuffer a = WsgSecInfo.f51561c;
                    a.append(hashMap.toString());
                    a.append(";");
                    WsgSecInfo.m38663b();
                    if (WsgSecInfo.f51560b > 49) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("params", WsgSecInfo.f51561c.toString());
                        OmegaSDKAdapter.trackEvent("tech_wsg_safe_collect", (Map<String, Object>) hashMap2);
                        int unused = WsgSecInfo.f51560b = 0;
                        StringBuffer unused2 = WsgSecInfo.f51561c = new StringBuffer();
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m38664b(StackTraceElement[] stackTraceElementArr) {
        String str = "";
        if (stackTraceElementArr == null) {
            return str;
        }
        try {
            if (stackTraceElementArr.length <= 3) {
                return str;
            }
            int i = 2;
            StackTraceElement stackTraceElement = stackTraceElementArr[2];
            while (true) {
                if (i >= stackTraceElementArr.length) {
                    break;
                }
                StackTraceElement stackTraceElement2 = stackTraceElementArr[i];
                if (!stackTraceElement2.getClassName().equals(stackTraceElement.getClassName())) {
                    str = stackTraceElement2.getClassName() + "." + stackTraceElement2.getMethodName();
                    break;
                }
                i++;
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            return stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
        } catch (Throwable unused) {
            return str;
        }
    }
}
