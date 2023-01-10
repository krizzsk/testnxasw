package com.yanzhenjie.permission.overlay.setting;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.appsflyer.internal.referrer.Payload;
import com.didi.unifylogin.auth.InnerAuthManager;
import com.yanzhenjie.permission.source.Source;

public class LSettingPage {

    /* renamed from: a */
    private static final String f58990a = Build.MANUFACTURER.toLowerCase();

    /* renamed from: b */
    private Source f58991b;

    public LSettingPage(Source source) {
        this.f58991b = source;
    }

    public void start(int i) {
        Intent intent;
        if (f58990a.contains(Payload.SOURCE_HUAWEI)) {
            intent = m44604b(this.f58991b.getContext());
        } else if (f58990a.contains("xiaomi")) {
            intent = m44605c(this.f58991b.getContext());
        } else if (f58990a.contains("oppo")) {
            intent = m44606d(this.f58991b.getContext());
        } else if (f58990a.contains("vivo")) {
            intent = m44607e(this.f58991b.getContext());
        } else if (f58990a.contains("meizu")) {
            intent = m44608f(this.f58991b.getContext());
        } else {
            intent = m44602a(this.f58991b.getContext());
        }
        try {
            this.f58991b.startActivityForResult(intent, i);
        } catch (Exception unused) {
            this.f58991b.startActivityForResult(m44602a(this.f58991b.getContext()), i);
        }
    }

    /* renamed from: a */
    private static Intent m44602a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
        return intent;
    }

    /* renamed from: b */
    private Intent m44604b(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
        if (m44603a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
        if (m44603a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity");
        if (m44603a(context, intent)) {
            return intent;
        }
        return m44602a(context);
    }

    /* renamed from: c */
    private Intent m44605c(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (m44603a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        if (m44603a(context, intent)) {
            return intent;
        }
        return m44602a(context);
    }

    /* renamed from: d */
    private Intent m44606d(Context context) {
        Intent intent = new Intent();
        intent.putExtra("packageName", context.getPackageName());
        intent.setClassName("com.color.safecenter", "com.color.safecenter.permission.floatwindow.FloatWindowListActivity");
        if (m44603a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity");
        if (m44603a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionAppListActivity");
        if (m44603a(context, intent)) {
            return intent;
        }
        return m44602a(context);
    }

    /* renamed from: e */
    private Intent m44607e(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.FloatWindowManager");
        intent.putExtra(InnerAuthManager.PACKAGE_NAME_QUERY, context.getPackageName());
        if (m44603a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity");
        if (m44603a(context, intent)) {
            return intent;
        }
        return m44602a(context);
    }

    /* renamed from: f */
    private Intent m44608f(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", context.getPackageName());
        intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        if (m44603a(context, intent)) {
            return intent;
        }
        return m44602a(context);
    }

    /* renamed from: a */
    private static boolean m44603a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
