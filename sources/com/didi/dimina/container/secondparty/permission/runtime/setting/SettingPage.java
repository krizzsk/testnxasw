package com.didi.dimina.container.secondparty.permission.runtime.setting;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.appsflyer.internal.referrer.Payload;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.secondparty.permission.source.Source;
import com.didi.unifylogin.auth.InnerAuthManager;

public class SettingPage {

    /* renamed from: a */
    private static final String f19291a = Dimina.getConfig().getAdapterConfig().getWsgService().getBrand((Context) null).toLowerCase();

    /* renamed from: b */
    private final Source f19292b;

    public SettingPage(Source source) {
        this.f19292b = source;
    }

    public void start(int i) {
        Intent intent;
        if (f19291a.contains(Payload.SOURCE_HUAWEI)) {
            intent = m16391b(this.f19292b.getContext());
        } else if (f19291a.contains("xiaomi")) {
            intent = m16392c(this.f19292b.getContext());
        } else if (f19291a.contains("oppo")) {
            intent = m16394e(this.f19292b.getContext());
        } else if (f19291a.contains("vivo")) {
            intent = m16393d(this.f19292b.getContext());
        } else if (f19291a.contains("meizu")) {
            intent = m16395f(this.f19292b.getContext());
        } else {
            intent = m16388a(this.f19292b.getContext());
        }
        try {
            this.f19292b.startActivityForResult(intent, i);
        } catch (Exception unused) {
            this.f19292b.startActivityForResult(m16388a(this.f19292b.getContext()), i);
        }
    }

    /* renamed from: a */
    private static Intent m16388a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context), (String) null));
        return intent;
    }

    /* renamed from: b */
    private static Intent m16391b(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
        if (m16390a(context, intent)) {
            return intent;
        }
        return m16388a(context);
    }

    /* renamed from: c */
    private static Intent m16392c(Context context) {
        if (m16389a()) {
            return m16388a(context);
        }
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context));
        if (m16390a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        if (m16390a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        if (m16390a(context, intent)) {
            return intent;
        }
        return m16388a(context);
    }

    /* renamed from: a */
    private static boolean m16389a() {
        try {
            String[] split = Build.VERSION.INCREMENTAL.substring(1).split("\\.");
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            if (parseInt > 12) {
                return true;
            }
            return parseInt == 12 && parseInt2 >= 5;
        } catch (Exception unused) {
        }
    }

    /* renamed from: d */
    private static Intent m16393d(Context context) {
        Intent intent = new Intent();
        intent.putExtra(InnerAuthManager.PACKAGE_NAME_QUERY, Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context));
        intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
        if (m16390a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity");
        if (m16390a(context, intent)) {
            return intent;
        }
        return m16388a(context);
    }

    /* renamed from: e */
    private static Intent m16394e(Context context) {
        Intent intent = new Intent();
        intent.putExtra("packageName", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context));
        intent.setClassName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity");
        if (m16390a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionAppListActivity");
        if (m16390a(context, intent)) {
            return intent;
        }
        return m16388a(context);
    }

    /* renamed from: f */
    private static Intent m16395f(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context));
        intent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        if (m16390a(context, intent)) {
            return intent;
        }
        return m16388a(context);
    }

    /* renamed from: a */
    private static boolean m16390a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
