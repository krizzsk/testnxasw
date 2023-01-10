package com.yanzhenjie.permission.overlay.setting;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.yanzhenjie.permission.source.Source;

public class MSettingPage {

    /* renamed from: a */
    private static final String f58992a = Build.MANUFACTURER.toLowerCase();

    /* renamed from: b */
    private Source f58993b;

    public MSettingPage(Source source) {
        this.f58993b = source;
    }

    public void start(int i) {
        Intent intent;
        if (f58992a.contains("meizu")) {
            intent = m44612c(this.f58993b.getContext());
        } else {
            intent = m44611b(this.f58993b.getContext());
        }
        try {
            this.f58993b.startActivityForResult(intent, i);
        } catch (Exception unused) {
            this.f58993b.startActivityForResult(m44609a(this.f58993b.getContext()), i);
        }
    }

    /* renamed from: a */
    private static Intent m44609a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
        return intent;
    }

    /* renamed from: b */
    private static Intent m44611b(Context context) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
        if (m44610a(context, intent)) {
            return intent;
        }
        return m44609a(context);
    }

    /* renamed from: c */
    private static Intent m44612c(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", context.getPackageName());
        intent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        if (m44610a(context, intent)) {
            return intent;
        }
        return m44611b(context);
    }

    /* renamed from: a */
    private static boolean m44610a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
