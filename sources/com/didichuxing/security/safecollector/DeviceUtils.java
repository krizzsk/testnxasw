package com.didichuxing.security.safecollector;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.google.common.base.Ascii;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

final class DeviceUtils {

    /* renamed from: a */
    public static final String f51551a = "imei_";

    /* renamed from: b */
    public static final String f51552b = "android_";

    /* renamed from: c */
    private static final String f51553c = "virtual_device_id_";

    /* renamed from: d */
    private static AtomicBoolean f51554d = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static Context f51555e;

    /* renamed from: f */
    private static String f51556f;

    /* renamed from: g */
    private static String f51557g;

    /* renamed from: h */
    private static CustomIdSupplier f51558h;

    public interface CustomIdSupplier {
        String getCustomId();
    }

    DeviceUtils() {
    }

    /* renamed from: a */
    public static void m38648a(Context context) {
        m38649a(context, true);
    }

    /* renamed from: a */
    public static void m38649a(Context context, boolean z) {
        if (!f51554d.getAndSet(true)) {
            m38646a(context);
            Context applicationContext = context.getApplicationContext();
            f51555e = applicationContext;
            if (applicationContext != null) {
                context = applicationContext;
            }
            f51555e = context;
            if (z) {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                    public void run() {
                        DeviceUtils.m38656c(DeviceUtils.f51555e);
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m38650a(CustomIdSupplier customIdSupplier) {
        synchronized (DeviceUtils.class) {
            f51558h = customIdSupplier;
        }
    }

    /* renamed from: a */
    public static synchronized String m38647a() {
        String c;
        synchronized (DeviceUtils.class) {
            if (f51554d.get()) {
                c = m38656c(f51555e);
            } else {
                throw new IllegalStateException("Init not called");
            }
        }
        return c;
    }

    /* renamed from: b */
    public static synchronized String m38653b(Context context) {
        synchronized (DeviceUtils.class) {
            if (!TextUtils.isEmpty(f51557g)) {
                String str = f51557g;
                return str;
            }
            SharedPreferences defaultSharedPreferences = SystemUtils.getDefaultSharedPreferences(context);
            String str2 = null;
            String string = defaultSharedPreferences.getString(f51552b, (String) null);
            if (!TextUtils.isEmpty(string)) {
                f51557g = string;
                return string;
            }
            if (TextUtils.isEmpty((CharSequence) null)) {
                str2 = m38657d(context);
            }
            defaultSharedPreferences.edit().putString(f51552b, str2).apply();
            f51557g = str2;
            return str2;
        }
    }

    /* renamed from: c */
    public static synchronized String m38656c(Context context) {
        synchronized (DeviceUtils.class) {
            m38646a(context);
            if (f51558h != null) {
                String customId = f51558h.getCustomId();
                return customId;
            } else if (!TextUtils.isEmpty(f51556f)) {
                String str = f51556f;
                return str;
            } else {
                SharedPreferences defaultSharedPreferences = SystemUtils.getDefaultSharedPreferences(context);
                String str2 = null;
                String string = defaultSharedPreferences.getString("imei_", (String) null);
                if (!TextUtils.isEmpty(string)) {
                    f51556f = string;
                    return string;
                }
                if (TextUtils.isEmpty((CharSequence) null)) {
                    str2 = m38657d(context);
                }
                defaultSharedPreferences.edit().putString("imei_", str2).apply();
                f51556f = str2;
                return str2;
            }
        }
    }

    /* renamed from: a */
    static boolean m38651a(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str) || str.length() < 15) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= str.length() - 1) {
                z = true;
                break;
            }
            char charAt = str.charAt(i);
            i++;
            if (charAt != str.charAt(i)) {
                break;
            }
        }
        return !z;
    }

    /* renamed from: b */
    private static String m38654b(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : instance.digest()) {
                sb.append(Integer.toHexString((b >> 4) & 15).toLowerCase());
                sb.append(Integer.toHexString(b & Ascii.f55148SI).toLowerCase());
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* renamed from: c */
    private static String m38655c() {
        SecureRandom secureRandom = new SecureRandom();
        String b = m38654b(Build.BRAND + Build.MODEL + Build.FINGERPRINT + System.nanoTime() + secureRandom.nextLong());
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        return DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_NO + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
    }

    /* renamed from: d */
    private static String m38657d(Context context) {
        SharedPreferences defaultSharedPreferences = SystemUtils.getDefaultSharedPreferences(context);
        String string = defaultSharedPreferences.getString(f51553c, (String) null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String c = m38655c();
        defaultSharedPreferences.edit().putString(f51553c, c).apply();
        return c;
    }

    /* renamed from: a */
    private static <T> T m38646a(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }
}
