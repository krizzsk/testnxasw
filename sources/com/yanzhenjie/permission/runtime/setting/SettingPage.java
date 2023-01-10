package com.yanzhenjie.permission.runtime.setting;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.appsflyer.internal.referrer.Payload;
import com.didi.unifylogin.auth.InnerAuthManager;
import com.yanzhenjie.permission.source.Source;

public class SettingPage {

    /* renamed from: a */
    private static final String f59012a = Build.MANUFACTURER.toLowerCase();

    /* renamed from: b */
    private Source f59013b;

    public SettingPage(Source source) {
        this.f59013b = source;
    }

    public void start(int i) {
        Intent intent;
        if (f59012a.contains(Payload.SOURCE_HUAWEI)) {
            intent = m44636b(this.f59013b.getContext());
        } else if (f59012a.contains("xiaomi")) {
            intent = m44637c(this.f59013b.getContext());
        } else if (f59012a.contains("oppo")) {
            intent = m44639e(this.f59013b.getContext());
        } else if (f59012a.contains("vivo")) {
            intent = m44638d(this.f59013b.getContext());
        } else if (f59012a.contains("meizu")) {
            intent = m44640f(this.f59013b.getContext());
        } else {
            intent = m44634a(this.f59013b.getContext());
        }
        try {
            this.f59013b.startActivityForResult(intent, i);
        } catch (Exception unused) {
            this.f59013b.startActivityForResult(m44634a(this.f59013b.getContext()), i);
        }
    }

    /* renamed from: a */
    private static Intent m44634a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
        return intent;
    }

    /* renamed from: b */
    private static Intent m44636b(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
        if (m44635a(context, intent)) {
            return intent;
        }
        return m44634a(context);
    }

    /* renamed from: c */
    private static Intent m44637c(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (m44635a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        if (m44635a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        if (m44635a(context, intent)) {
            return intent;
        }
        return m44634a(context);
    }

    /* renamed from: d */
    private static Intent m44638d(Context context) {
        Intent intent = new Intent();
        intent.putExtra(InnerAuthManager.PACKAGE_NAME_QUERY, context.getPackageName());
        intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
        if (m44635a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity");
        if (m44635a(context, intent)) {
            return intent;
        }
        return m44634a(context);
    }

    /* renamed from: e */
    private static Intent m44639e(Context context) {
        Intent intent = new Intent();
        intent.putExtra("packageName", context.getPackageName());
        intent.setClassName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity");
        if (m44635a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionAppListActivity");
        if (m44635a(context, intent)) {
            return intent;
        }
        return m44634a(context);
    }

    /* renamed from: f */
    private static Intent m44640f(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", context.getPackageName());
        intent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        if (m44635a(context, intent)) {
            return intent;
        }
        return m44634a(context);
    }

    /* renamed from: a */
    private static boolean m44635a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
