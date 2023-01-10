package com.google.android.play.core.appupdate;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.internal.C20030ag;
import com.google.android.play.core.listener.C20137b;

/* renamed from: com.google.android.play.core.appupdate.a */
public final class C19863a extends C20137b<InstallState> {
    public C19863a(Context context) {
        super(new C20030ag("AppUpdateListenerRegistry"), new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"), context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo163986a(Context context, Intent intent) {
        Intent intent2 = intent;
        if (!context.getPackageName().equals(intent2.getStringExtra("package.name"))) {
            this.f56129a.mo164267a("ListenerRegistryBroadcastReceiver received broadcast for third party app: %s", intent2.getStringExtra("package.name"));
            return;
        }
        this.f56129a.mo164267a("List of extras in received intent:", new Object[0]);
        for (String str : intent.getExtras().keySet()) {
            this.f56129a.mo164267a("Key: %s; value: %s", str, intent.getExtras().get(str));
        }
        C20030ag agVar = this.f56129a;
        agVar.mo164267a("List of extras in received intent needed by fromUpdateIntent:", new Object[0]);
        agVar.mo164267a("Key: %s; value: %s", "install.status", Integer.valueOf(intent2.getIntExtra("install.status", 0)));
        agVar.mo164267a("Key: %s; value: %s", "error.code", Integer.valueOf(intent2.getIntExtra("error.code", 0)));
        InstallState a = InstallState.m42117a(intent2.getIntExtra("install.status", 0), intent2.getLongExtra("bytes.downloaded", 0), intent2.getLongExtra("total.bytes.to.download", 0), intent2.getIntExtra("error.code", 0), intent2.getStringExtra("package.name"));
        this.f56129a.mo164267a("ListenerRegistryBroadcastReceiver.onReceive: %s", a);
        mo164405a(a);
    }
}
