package com.didi.dimina.container.secondparty.permission.source;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import com.didi.dimina.container.Dimina;
import java.lang.reflect.Method;

public abstract class Source {

    /* renamed from: a */
    private static final int f19303a = 4;

    /* renamed from: b */
    private static final String f19304b = "checkOpNoThrow";

    /* renamed from: c */
    private static final String f19305c = "OP_REQUEST_INSTALL_PACKAGES";

    /* renamed from: d */
    private static final String f19306d = "OP_SYSTEM_ALERT_WINDOW";

    /* renamed from: e */
    private static final String f19307e = "OP_POST_NOTIFICATION";

    /* renamed from: f */
    private static final String f19308f = "OP_ACCESS_NOTIFICATIONS";

    /* renamed from: g */
    private static final String f19309g = "OP_WRITE_SETTINGS";

    /* renamed from: h */
    private int f19310h;

    /* renamed from: i */
    private String f19311i;

    /* renamed from: j */
    private PackageManager f19312j;

    /* renamed from: k */
    private AppOpsManager f19313k;

    /* renamed from: l */
    private NotificationManager f19314l;

    public abstract Context getContext();

    public abstract boolean isShowRationalePermission(String str);

    public abstract void startActivity(Intent intent);

    public abstract void startActivityForResult(Intent intent, int i);

    /* renamed from: a */
    private int m16399a() {
        if (this.f19310h < 14) {
            this.f19310h = getContext().getApplicationInfo().targetSdkVersion;
        }
        return this.f19310h;
    }

    public String getPackageName() {
        if (this.f19311i == null) {
            this.f19311i = Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(getContext().getApplicationContext());
        }
        return this.f19311i;
    }

    /* renamed from: b */
    private PackageManager m16401b() {
        if (this.f19312j == null) {
            this.f19312j = getContext().getPackageManager();
        }
        return this.f19312j;
    }

    /* renamed from: c */
    private AppOpsManager m16402c() {
        if (this.f19313k == null) {
            this.f19313k = (AppOpsManager) getContext().getSystemService("appops");
        }
        return this.f19313k;
    }

    /* renamed from: d */
    private NotificationManager m16403d() {
        if (this.f19314l == null) {
            this.f19314l = (NotificationManager) getContext().getSystemService("notification");
        }
        return this.f19314l;
    }

    public final boolean canRequestPackageInstalls() {
        if (Build.VERSION.SDK_INT < 23 || Build.VERSION.SDK_INT < 26) {
            return true;
        }
        if (m16399a() < 26) {
            return m16400a(f19305c);
        }
        return m16401b().canRequestPackageInstalls();
    }

    public final boolean canDrawOverlays() {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        Context context = getContext();
        if (m16399a() >= 23) {
            return Settings.canDrawOverlays(context);
        }
        return m16400a(f19306d);
    }

    public final boolean canNotify() {
        if (Build.VERSION.SDK_INT >= 24) {
            return m16403d().areNotificationsEnabled();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return m16400a(f19307e);
        }
        return true;
    }

    public final boolean canListenerNotification() {
        if (Build.VERSION.SDK_INT >= 19) {
            return m16400a(f19308f);
        }
        String string = Settings.Secure.getString(getContext().getContentResolver(), "enabled_notification_listeners");
        return string != null && string.contains(getPackageName());
    }

    public final boolean canWriteSetting() {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        Context context = getContext();
        if (m16399a() >= 23) {
            return Settings.System.canWrite(context);
        }
        return m16400a(f19309g);
    }

    /* renamed from: a */
    private boolean m16400a(String str) {
        int i = getContext().getApplicationInfo().uid;
        Class<AppOpsManager> cls = AppOpsManager.class;
        try {
            Method method = cls.getMethod(f19304b, new Class[]{Integer.TYPE, Integer.TYPE, String.class});
            int intValue = ((Integer) cls.getDeclaredField(str).get(Integer.class)).intValue();
            int intValue2 = ((Integer) method.invoke(m16402c(), new Object[]{Integer.valueOf(intValue), Integer.valueOf(i), getPackageName()})).intValue();
            if (intValue2 == 0 || intValue2 == 4) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }
}
