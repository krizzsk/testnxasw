package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.internal.C20030ag;
import com.google.android.play.core.listener.C20137b;

/* renamed from: com.google.android.play.core.splitinstall.t */
public final class C20211t extends C20137b<SplitInstallSessionState> {

    /* renamed from: c */
    private static C20211t f56281c;

    /* renamed from: d */
    private final Handler f56282d = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    private final C20195e f56283e;

    public C20211t(Context context, C20195e eVar) {
        super(new C20030ag("SplitInstallListenerRegistry"), new IntentFilter("com.google.android.play.core.splitinstall.receiver.SplitInstallUpdateIntentService"), context);
        this.f56283e = eVar;
    }

    /* renamed from: a */
    public static synchronized C20211t m42554a(Context context) {
        C20211t tVar;
        synchronized (C20211t.class) {
            if (f56281c == null) {
                f56281c = new C20211t(context, C20202l.f56264a);
            }
            tVar = f56281c;
        }
        return tVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo163986a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("session_state");
        if (bundleExtra != null) {
            SplitInstallSessionState a = SplitInstallSessionState.m42457a(bundleExtra);
            this.f56129a.mo164267a("ListenerRegistryBroadcastReceiver.onReceive: %s", a);
            C20196f a2 = this.f56283e.mo164511a();
            if (a.status() != 3 || a2 == null) {
                mo164405a(a);
            } else {
                a2.mo164283a(a.mo164482c(), new C20209r(this, a, intent, context));
            }
        }
    }
}
