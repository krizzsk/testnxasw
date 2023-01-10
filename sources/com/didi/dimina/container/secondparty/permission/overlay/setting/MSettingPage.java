package com.didi.dimina.container.secondparty.permission.overlay.setting;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.secondparty.permission.source.Source;

public class MSettingPage {

    /* renamed from: a */
    private static final String f19272a = Dimina.getConfig().getAdapterConfig().getWsgService().getBrand((Context) null).toLowerCase();

    /* renamed from: b */
    private final Source f19273b;

    public MSettingPage(Source source) {
        this.f19273b = source;
    }

    public void start(int i) {
        Intent intent;
        if (f19272a.contains("meizu")) {
            intent = m16366c(this.f19273b.getContext());
        } else {
            intent = m16365b(this.f19273b.getContext());
        }
        try {
            this.f19273b.startActivityForResult(intent, i);
        } catch (Exception unused) {
            this.f19273b.startActivityForResult(m16363a(this.f19273b.getContext()), i);
        }
    }

    /* renamed from: a */
    private static Intent m16363a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context), (String) null));
        return intent;
    }

    /* renamed from: b */
    private static Intent m16365b(Context context) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.fromParts("package", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context), (String) null));
        if (m16364a(context, intent)) {
            return intent;
        }
        return m16363a(context);
    }

    /* renamed from: c */
    private static Intent m16366c(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context));
        intent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        if (m16364a(context, intent)) {
            return intent;
        }
        return m16365b(context);
    }

    /* renamed from: a */
    private static boolean m16364a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
