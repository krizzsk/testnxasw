package p218io.flutter.plugins.urllauncher;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/* renamed from: io.flutter.plugins.urllauncher.UrlLauncher */
class UrlLauncher {

    /* renamed from: a */
    private final Context f60677a;

    /* renamed from: b */
    private Activity f60678b;

    /* renamed from: io.flutter.plugins.urllauncher.UrlLauncher$LaunchStatus */
    enum LaunchStatus {
        f60679OK,
        NO_ACTIVITY,
        ACTIVITY_NOT_FOUND
    }

    UrlLauncher(Context context, Activity activity) {
        this.f60677a = context;
        this.f60678b = activity;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo182715a(Activity activity) {
        this.f60678b = activity;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo182716a(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        ComponentName resolveActivity = intent.resolveActivity(this.f60677a.getPackageManager());
        return resolveActivity != null && !"{com.android.fallback/com.android.fallback.Fallback}".equals(resolveActivity.toShortString());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public LaunchStatus mo182713a(String str, Bundle bundle, boolean z, boolean z2, boolean z3) {
        Intent intent;
        Activity activity = this.f60678b;
        if (activity == null) {
            return LaunchStatus.NO_ACTIVITY;
        }
        if (z) {
            intent = WebViewActivity.createIntent(activity, str, z2, z3, bundle);
        } else {
            intent = new Intent("android.intent.action.VIEW").setData(Uri.parse(str)).putExtra("com.android.browser.headers", bundle);
        }
        try {
            this.f60678b.startActivity(intent);
            return LaunchStatus.f60679OK;
        } catch (ActivityNotFoundException unused) {
            return LaunchStatus.ACTIVITY_NOT_FOUND;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo182714a() {
        this.f60677a.sendBroadcast(new Intent(WebViewActivity.ACTION_CLOSE));
    }
}
