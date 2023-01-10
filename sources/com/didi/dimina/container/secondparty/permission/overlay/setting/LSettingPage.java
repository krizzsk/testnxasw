package com.didi.dimina.container.secondparty.permission.overlay.setting;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.appsflyer.internal.referrer.Payload;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.secondparty.permission.source.Source;
import com.didi.unifylogin.auth.InnerAuthManager;

public class LSettingPage {

    /* renamed from: a */
    private static final String f19270a = Dimina.getConfig().getAdapterConfig().getWsgService().getBrand((Context) null).toLowerCase();

    /* renamed from: b */
    private final Source f19271b;

    public LSettingPage(Source source) {
        this.f19271b = source;
    }

    public void start(int i) {
        Intent intent;
        if (f19270a.contains(Payload.SOURCE_HUAWEI)) {
            intent = m16358b(this.f19271b.getContext());
        } else if (f19270a.contains("xiaomi")) {
            intent = m16359c(this.f19271b.getContext());
        } else if (f19270a.contains("oppo")) {
            intent = m16360d(this.f19271b.getContext());
        } else if (f19270a.contains("vivo")) {
            intent = m16361e(this.f19271b.getContext());
        } else if (f19270a.contains("meizu")) {
            intent = m16362f(this.f19271b.getContext());
        } else {
            intent = m16356a(this.f19271b.getContext());
        }
        try {
            this.f19271b.startActivityForResult(intent, i);
        } catch (Exception unused) {
            this.f19271b.startActivityForResult(m16356a(this.f19271b.getContext()), i);
        }
    }

    /* renamed from: a */
    private static Intent m16356a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context), (String) null));
        return intent;
    }

    /* renamed from: b */
    private Intent m16358b(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
        if (m16357a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
        if (m16357a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity");
        if (m16357a(context, intent)) {
            return intent;
        }
        return m16356a(context);
    }

    /* renamed from: c */
    private Intent m16359c(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context));
        if (m16357a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        if (m16357a(context, intent)) {
            return intent;
        }
        return m16356a(context);
    }

    /* renamed from: d */
    private Intent m16360d(Context context) {
        Intent intent = new Intent();
        intent.putExtra("packageName", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context));
        intent.setClassName("com.color.safecenter", "com.color.safecenter.permission.floatwindow.FloatWindowListActivity");
        if (m16357a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity");
        if (m16357a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionAppListActivity");
        if (m16357a(context, intent)) {
            return intent;
        }
        return m16356a(context);
    }

    /* renamed from: e */
    private Intent m16361e(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.FloatWindowManager");
        intent.putExtra(InnerAuthManager.PACKAGE_NAME_QUERY, Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context));
        if (m16357a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity");
        if (m16357a(context, intent)) {
            return intent;
        }
        return m16356a(context);
    }

    /* renamed from: f */
    private Intent m16362f(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context));
        intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        if (m16357a(context, intent)) {
            return intent;
        }
        return m16356a(context);
    }

    /* renamed from: a */
    private static boolean m16357a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
