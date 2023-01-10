package com.google.p223ar.core;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import com.didi.sdk.apm.SystemUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.ar.core.v */
/* compiled from: InstallServiceImpl */
final class C20296v implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Activity f56505a;

    /* renamed from: b */
    final /* synthetic */ C20293s f56506b;

    /* renamed from: c */
    final /* synthetic */ C20291p f56507c;

    C20296v(C20291p pVar, Activity activity, C20293s sVar) {
        this.f56507c = pVar;
        this.f56505a = activity;
        this.f56506b = sVar;
    }

    public final void run() {
        try {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            this.f56507c.f56493d.mo138989a(this.f56505a.getApplicationInfo().packageName, Collections.singletonList(C20291p.m42684b()), new Bundle(), new C20299y(this, atomicBoolean));
            new Handler().postDelayed(new C20298x(this, atomicBoolean), 3000);
        } catch (RemoteException e) {
            SystemUtils.log(5, "ARCore-InstallService", "requestInstall threw, launching fullscreen.", e, "com.google.ar.core.v", 11);
            C20291p.m42686b(this.f56505a, this.f56506b);
        }
    }
}
