package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;

/* renamed from: com.google.android.play.core.splitinstall.r */
final class C20209r implements C20194d {

    /* renamed from: a */
    final /* synthetic */ SplitInstallSessionState f56273a;

    /* renamed from: b */
    final /* synthetic */ Intent f56274b;

    /* renamed from: c */
    final /* synthetic */ Context f56275c;

    /* renamed from: d */
    final /* synthetic */ C20211t f56276d;

    C20209r(C20211t tVar, SplitInstallSessionState splitInstallSessionState, Intent intent, Context context) {
        this.f56276d = tVar;
        this.f56273a = splitInstallSessionState;
        this.f56274b = intent;
        this.f56275c = context;
    }

    /* renamed from: a */
    public final void mo164508a() {
        this.f56276d.f56282d.post(new C20210s(this.f56276d, this.f56273a, 5, 0));
    }

    /* renamed from: a */
    public final void mo164509a(int i) {
        this.f56276d.f56282d.post(new C20210s(this.f56276d, this.f56273a, 6, i));
    }

    /* renamed from: b */
    public final void mo164510b() {
        if (!this.f56274b.getBooleanExtra("triggered_from_app_after_verification", false)) {
            this.f56274b.putExtra("triggered_from_app_after_verification", true);
            this.f56275c.sendBroadcast(this.f56274b);
            return;
        }
        this.f56276d.f56129a.mo164269b("Splits copied and verified more than once.", new Object[0]);
    }
}
