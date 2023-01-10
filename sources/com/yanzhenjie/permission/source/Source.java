package com.yanzhenjie.permission.source;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import java.lang.reflect.Method;

public abstract class Source {

    /* renamed from: a */
    private static final int f59024a = 4;

    /* renamed from: b */
    private static final String f59025b = "checkOpNoThrow";

    /* renamed from: c */
    private static final String f59026c = "OP_REQUEST_INSTALL_PACKAGES";

    /* renamed from: d */
    private static final String f59027d = "OP_SYSTEM_ALERT_WINDOW";

    /* renamed from: e */
    private static final String f59028e = "OP_POST_NOTIFICATION";

    /* renamed from: f */
    private static final String f59029f = "OP_ACCESS_NOTIFICATIONS";

    /* renamed from: g */
    private static final String f59030g = "OP_WRITE_SETTINGS";

    /* renamed from: h */
    private int f59031h;

    /* renamed from: i */
    private String f59032i;

    /* renamed from: j */
    private PackageManager f59033j;

    /* renamed from: k */
    private AppOpsManager f59034k;

    /* renamed from: l */
    private NotificationManager f59035l;

    public abstract Context getContext();

    public abstract boolean isShowRationalePermission(String str);

    public abstract void startActivity(Intent intent);

    public abstract void startActivityForResult(Intent intent, int i);

    /* renamed from: a */
    private int m44644a() {
        if (this.f59031h < 14) {
            this.f59031h = getContext().getApplicationInfo().targetSdkVersion;
        }
        return this.f59031h;
    }

    public String getPackageName() {
        if (this.f59032i == null) {
            this.f59032i = getContext().getApplicationContext().getPackageName();
        }
        return this.f59032i;
    }

    /* renamed from: b */
    private PackageManager m44646b() {
        if (this.f59033j == null) {
            this.f59033j = getContext().getPackageManager();
        }
        return this.f59033j;
    }

    /* renamed from: c */
    private AppOpsManager m44647c() {
        if (this.f59034k == null) {
            this.f59034k = (AppOpsManager) getContext().getSystemService("appops");
        }
        return this.f59034k;
    }

    /* renamed from: d */
    private NotificationManager m44648d() {
        if (this.f59035l == null) {
            this.f59035l = (NotificationManager) getContext().getSystemService("notification");
        }
        return this.f59035l;
    }

    public final boolean canRequestPackageInstalls() {
        if (Build.VERSION.SDK_INT < 23 || Build.VERSION.SDK_INT < 26) {
            return true;
        }
        if (m44644a() < 26) {
            return m44645a(f59026c);
        }
        return m44646b().canRequestPackageInstalls();
    }

    public final boolean canDrawOverlays() {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        Context context = getContext();
        if (m44644a() >= 23) {
            return Settings.canDrawOverlays(context);
        }
        return m44645a(f59027d);
    }

    public final boolean canNotify() {
        if (Build.VERSION.SDK_INT >= 24) {
            return m44648d().areNotificationsEnabled();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return m44645a(f59028e);
        }
        return true;
    }

    public final boolean canListenerNotification() {
        if (Build.VERSION.SDK_INT >= 19) {
            return m44645a(f59029f);
        }
        String string = Settings.Secure.getString(getContext().getContentResolver(), "enabled_notification_listeners");
        return string != null && string.contains(getPackageName());
    }

    public final boolean canWriteSetting() {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        Context context = getContext();
        if (m44644a() >= 23) {
            return Settings.System.canWrite(context);
        }
        return m44645a(f59030g);
    }

    /* renamed from: a */
    private boolean m44645a(String str) {
        int i = getContext().getApplicationInfo().uid;
        Class<AppOpsManager> cls = AppOpsManager.class;
        try {
            Method method = cls.getMethod(f59025b, new Class[]{Integer.TYPE, Integer.TYPE, String.class});
            int intValue = ((Integer) cls.getDeclaredField(str).get(Integer.class)).intValue();
            int intValue2 = ((Integer) method.invoke(m44647c(), new Object[]{Integer.valueOf(intValue), Integer.valueOf(i), getPackageName()})).intValue();
            if (intValue2 == 0 || intValue2 == 4) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }
}
