package com.google.p223ar.core;

import android.content.Context;
import android.os.RemoteException;
import com.didi.sdk.apm.SystemUtils;
import com.google.p223ar.core.ArCoreApk;

/* renamed from: com.google.ar.core.u */
/* compiled from: InstallServiceImpl */
final class C20295u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ArCoreApk.C20243a f56502a;

    /* renamed from: b */
    private final /* synthetic */ Context f56503b;

    /* renamed from: c */
    private final /* synthetic */ C20291p f56504c;

    C20295u(C20291p pVar, Context context, ArCoreApk.C20243a aVar) {
        this.f56504c = pVar;
        this.f56503b = context;
        this.f56502a = aVar;
    }

    public final void run() {
        try {
            this.f56504c.f56493d.mo138988a(this.f56503b.getApplicationInfo().packageName, C20291p.m42684b(), new C20294t(this));
        } catch (RemoteException e) {
            SystemUtils.log(6, "ARCore-InstallService", "requestInfo threw", e, "com.google.ar.core.u", 8);
            this.f56502a.mo164600a(ArCoreApk.Availability.UNKNOWN_ERROR);
        }
    }
}
